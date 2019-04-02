package proj5;

/**
 *   Update invariant w/ LL:
 *   1. The number of elements in the sequence is stored in the instance variable manyItems.
 *
 *   2. If there’s a current element it’s at the position located by the current
 *   index although there are not legitimate indices.
 *
 *   3. Since we are using a LL, our container is dynamic, it changes as we
 *   add and remove, there's no explicit capacity definition. While with an array
 *   we need to specify the capacity.
 *
 * This is a class for creating a linked list. We will implement this data structure into our
 * sequence class instead of using arrays. A linked list is an ordered set of elements which all
 * connect to one another, each element is called a node.
 *
 */
public class LinkedList<T>{
    private int length;
    private ListNode firstNode;

    public LinkedList(){
        length=0;
        firstNode=null;
    }

    public int getLength()
    {
        return length;
    }

    public void insertAtHead(T data)
    {
        ListNode newnode = new ListNode(data);
        if (getLength() == 0){
            firstNode=newnode;
        }
        else{
            newnode.next = this.firstNode;
            this.firstNode = newnode;
        }
        length++;
    }

    /**
     * This adds a node to a specific location in the linked list. If the index is outside of
     * the range in the linked list, nothing in this method will happen. If something is in the spot
     * of where this node is suppose to be inserted, that node will be moved to maintain the order of the
     * linked list.
     * @param data String which is in the node it is adding.
     * @param index an int which is the spot the node will be added to in the linked list.
     */
    public void insertAtIndex(T data, int index){
        if (index <= this.getLength()){
            if (index == 0){
                this.insertAtHead(data);
            }
            else{
                ListNode<T> nodeToInsert = new ListNode<T>(data);
                ListNode<T> runner = this.accessNode(index-1); // To find node before access
                nodeToInsert.next = runner.next;
                runner.next = nodeToInsert;
                length++;

            }
        }

    }

    /**
     * This method removes a node at a specific location in the linked list. If there is one node in the list,
     * it will just set firstNode to null. If the node to be removed is the last node in the list, you go to the
     * second to last node in the list and set it to null. If the node you want to remove is between two nodes,
     * you set the node before the node you want to remove to the node after it (essentially a bridge) which
     * makes the node you want to remove lost in memory.
     *
     * @param index an int of the location of the node you want to remove.
     */

    public void removeAtIndex(int index){
        if (index <= this.getLength() -1){
            if (this.getLength() > -0){

                // If first node is requested to be removed.
                if (index == 0){
                    if (this.getLength() == 1) {
                        this.firstNode = null;
                    }
                    else{
                        this.firstNode = this.firstNode.next;
                    }
                    length--;
                }
                // If last node is requested to be removed
                else if (index == this.getLength() - 1){
                    ListNode<T> runner = this.accessNode(index -1);
                    runner.next = null;
                    length--;

                }
                // Points the node before the node requested to be removed to the node
                // after the node being removed.
                else{
                    ListNode<T> bridge = this.accessNode(index + 1);
                    ListNode<T> runner = this.accessNode(index-1);
                    runner.next = bridge;
                    length--;
                }

            }
        }
    }

    /**
     * Creates a node from default constructor.
     * @return listnode runner
     */
    private ListNode<T> makeRunnerNode(){
        ListNode runnerNode = this.getFirstNode();
        return runnerNode;
    }

    /**
     * Getter for the first node in the linked list.
     */
    private ListNode<T> getFirstNode(){
        return this.firstNode;
    }



    /**
     * This creates a runner node that is used to access a specific spot in
     * the linked list.
     *
     * @param index Position of the node to be accessed
     *
     * @return List node to be accessed.
     */
    private ListNode<T> accessNode(int index){
        ListNode<T> runner = makeRunnerNode();
        int count = 0;
        while (count < index){
            count = count + 1;
            runner = runner.next;
        }
        return runner;
    }

    /**
     * If the index is outside of the range in the linked list, this method will produce
     * an error message to the console. A valid index or range is from the first position to
     * the last position which is 1 less than the length.
     *
     * @param index int, the location of the node to find.
     * @return string which is inside the node that is being looked for.
     */

    public String findNode(int index){
        if (index < this.getLength()){
            ListNode<T> runner = this.accessNode(index);
            return runner.data.toString();
        }
        else{
            return "ERROR: Index out of range, use valid index";
        }
    }

    public T getData(int index){
        if (index < this.getLength()){
            ListNode<T> runner = this.accessNode(index);
            return runner.data;
        }
        else{
            return null;
        }
    }

    public String toString(){
        String toReturn = "(";
        ListNode runner = firstNode;
        while(runner != null){
            toReturn = toReturn + runner;
            runner = runner.next;
            if(runner != null){
                toReturn = toReturn + ", ";
            }
        }
        toReturn = toReturn + ")";
        return toReturn;
    }

}



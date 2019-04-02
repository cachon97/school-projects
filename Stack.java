package proj5;

/**
 * This class is responsible for the stack ADT which for this program uses a linked
 * list. It's responsible to be able to push and pop from the stack and to peek which is used
 * to retrieve the first element of the stack.
 *
 * @author Quentin Cachon
 * @version v1.0 2/25/19
 */

public class Stack<T> {
    private LinkedList<T> contents;
    private int manyItems = 0;

    public Stack(){
        contents = new LinkedList<T>();
        manyItems = 0;
    }

    public boolean isEmpty() {
        boolean toReturn = true;
        if(this.size() > 0){
            toReturn = false;
        }
        return toReturn;
    }

    public void push(T toPush){
        this.contents.insertAtHead(toPush);
        ++manyItems;

    }

    public T pop(){
        if(this.size() == 0){
            return null;
        }
        else{
            T toReturn = this.contents.getData(0);
            this.contents.removeAtIndex(0);
            --manyItems;
            return toReturn;
        }
    }

    public T peek(){
        if(this.size() == 0){
            return null;
        }
        else{
            return this.contents.getData(0);
        }
    }

    public int size(){
        return manyItems;
    }

    public String toString() {
        String toReturn = "{";

        for(int i = this.size()-1; i >=0; i--){
            String add = this.contents.findNode(i);
            toReturn = toReturn + add;

            if (i > 0){
                toReturn = toReturn + ", ";
            }
        }
        toReturn = toReturn + "}";
        return toReturn;
    }


}



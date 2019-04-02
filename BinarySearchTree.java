package proj5;
/** This is the BST ADT.  It should contain methods that allow it to
 *  insert new nodes, delete nodes, search, etc.  You'll be adding
 *  code to this class for this hwk.
 *
 * @author Quentin Cachon
 * @version v2 March 2019
 *
 * I affirm that I have carried out the attached academic endeavors with full academic honest, in
 * accordance with the Union College Honor Code and the course syllabus. - Quentin Emile Cachon
 */
public class BinarySearchTree <T extends Comparable<T>>
{
    private BSTNode<T> root;

    public BinarySearchTree() {
        root=null;
    }


    //==================================================
    //                    Insert
    //==================================================

    /**
     * inserts recursively.  I include this one so you can
     * make your own trees in your own testing class
     *
     * @param startingNode inserts into subtree rooted at staringNode
     * @param newNode node to insert
     * @return startingNode with newNode already inserted
     */
    private BSTNode<T> insert(BSTNode<T> startingNode, BSTNode<T> newNode) {
        if (startingNode == null) {
            return newNode;
        }
        else if (startingNode.key.compareTo(newNode.key) < 0) {
            startingNode.rlink = insert(startingNode.rlink,newNode);
            return startingNode;
        }
        else {  // startingNode.key bigger than newNode.key, so newNode goes on left
            startingNode.llink = insert(startingNode.llink,newNode);
            return startingNode;
        }
    }
    /**
     * inserts recursively. Use this in your JUnit tests to
     * build a starting tree correctly
     *
     * @param newData String to insert
     */
    public void insert(T newData){
        BSTNode<T> newNode = new BSTNode<>(newData);
        root = this.insert(root, newNode);
    }



    //==================================================
    //                    Search
    //==================================================

    /**
     * Returns true if the target string is in the BST. Otherwise false.
     * @target the string being searched for in the BST.
     */
    public boolean search(T target){
        return searchHelper(target, root);
    }


    /**
     * Helper method for search. Job is to see if the target string is in the the tree.
     *
     * @target the string being searched for in the BST.
     * @node the node to compare to target to see if they are the same. If so,
     * returns true. If the node equals null, return false.
     * @return true if the target is in the tree, otherwise false.
     */
    private boolean searchHelper(T target, BSTNode<T> node){
        if (node == null){
            return false;
        }
        else if(node.key.compareTo(target) == 0){
            return true;
        }
        else if(node.key.compareTo(target) < 0){
            return searchHelper(target, node.rlink);
        }
        else{
            return searchHelper(target, node.llink);
        }
    }


    //==================================================
    //                    ToString
    //==================================================


    /**
     * Turns the BST into a readable string using inorder traversal.
     */
    public String toString(){
        return toStringHelper(root);
    }

    /**
     * Helper method for the toString to turn the BST into a readable string in inorder traversal.
     * @root the node to be turned into a string.
     * @return tree as a string in inorder traversal
     */
    private String toStringHelper(BSTNode<T> root) {
        String stringLeftLink = "";
        String stringRightLink = "";

        if (root != null){
            stringLeftLink = toStringHelper(root.llink);
            stringRightLink = toStringHelper(root.rlink);
            return ("(" + stringLeftLink + "" + root.key + "" + stringRightLink + ")");
        }
        return "";

    }

    /**
     * ToString for the dictionary and index to have the proper format.
     * @return string version of the index or dictionary entry
     */
    public String idToString(){
        return IDToString(root);
    }
    private String IDToString(BSTNode<T> root){
        String toReturn = "";
        if (root != null){
            if(root.llink != null){
                toReturn += IDToString(root.llink);
            }
            toReturn += root.toString();
            toReturn += "\n";
            if(root.rlink != null){
                toReturn += IDToString(root.rlink);
            }
        }
        else{
            toReturn += "";
        }
        return toReturn;
    }


    //==================================================
    //                    Delete
    //==================================================

    /**
     *
     * This method's purpose is to delete a given value from the BST. If
     * the value given is not in the BST, nothing will happen.
     * @param value - value to delete
     */
    public void delete(T value) {
        if (this.search(value)) {
            root = this.delete(value, root);
        }
    }

    /**
     * This is the private recursive call for deleting a value
     * from the Binary Search Tree.
     * @param value The value to be deleted
     * @param node  The node we are currently checking for deletion
     * @return
     */
    private BSTNode<T> delete(T value, BSTNode<T> node) {
        if (node == null) {
            return null;
        }

        // Holds less than what will be deleted. Check deletion in right
        // subtree.
        else if (node.key.compareTo(value) < 0) {
            node.rlink = delete(value, node.rlink);
            return node;
        }

        // Node greater than what will be deleted. Check deletion in left
        // subtree.
        else if (node.key.compareTo(value) > 0) {
            node.llink = delete(value, node.llink);
            return node;
        }

        else {
            if (node.isLeaf()) {
                return null;
            } else if (node.hasLChildOnly()) {
                node = node.llink;

            } else if (node.hasRChildOnly()) {
                node = node.rlink;
            } else {
                node.key = minValue(node.rlink);
                node.rlink = delete(node.key, node.rlink);
            }

            return node;
        }
    }


    //================================
    //            Access
    //================================
    public T getNodeData(T target){
        return getNodeData(target, root);
    }

    private T getNodeData(T target, BSTNode<T> node){

        // The node we are looking for.
        if (node.key.compareTo(target) == 0){
            return node.key;
        }

        // The node we are currently looking at is less than
        // the node we are looking for
        else if(node.key.compareTo(target) < 0){
            return getNodeData(target, node.rlink);
        }

        // The node we are currently looking at is greater than
        // the node we are looking for
        else{
            return getNodeData(target, node.llink);
        }
    }

    /**
     * Returns smallest node in BST
     * @param root - root of BST
     * @return Smallest node's element in BST
     */
    private T minValue(BSTNode<T> root){
        T minVal = root.key;
        while (root.llink != null) {
            minVal = root.llink.key;
            root = root.llink;
        }
        return minVal;
    }




}

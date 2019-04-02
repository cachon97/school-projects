package proj5;
/**
 * BSTNode
 * @author Chris Fernandes & Quentin Cachon
 * @date March 2019
 * @version v1
 * @Description: A very reusable node class.
 */

public class BSTNode<T extends Comparable<T>> {

    public T key;
    public BSTNode<T> llink;
    public BSTNode<T> rlink;

    /**
     * non-default constructor
     * @param newKey string that node will hold
     */
    public BSTNode(T newKey){
        key = newKey;
        llink = null;
        rlink = null;
    }

    /**
     * Checks to see if the node in the BST is a leaf.
     * @return boolean, true if it is a leaf, otherwise false.
     */
    public boolean isLeaf(){
        return this.llink == null && this.rlink == null;
    }

    /**
     * Check to see if the node in the BST only has a right child.
     * @return boolean true if so, otherwise false.
     */
    public boolean hasRChildOnly(){
        //checks to see if the node only has a richt child on the binary
        // search tree.
        return this.llink == null && this.rlink != null;

    }

    /**
     * Check to see if the node in the BST only has a left child.
     * @return boolean true if so, otherwise false.
     */
    public boolean hasLChildOnly(){
        return this.llink != null && this.rlink == null;
    }


    public String toString(){
        return key.toString();
    }

}

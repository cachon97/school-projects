package proj5;
/**
 * Dictionary
 * @author Quentin Cachon
 * @date March 2019
 * @version v1
 * @Description: The dictionary is where we store all words that are not included
 * in the index.
 */

public class Dictionary {
    private BinarySearchTree contents;
    public Dictionary(){
        contents = new BinarySearchTree();
    }

    /**
     * Searches for a target word in the dictionary BST.
     * @target a word
     */
    public boolean search(String target){
        return contents.search(target);
    }

    /**
     * Inserts string into the dictionary
     * @newString string to be inserted
     */
    public void insert(String newString){
        contents.insert(newString);
    }


    public String toString(){
        return contents.idToString();
    }
}

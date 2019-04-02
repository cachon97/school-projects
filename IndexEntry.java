package proj5;

/**
 * IndexEntry
 * @author Quentin Cachon
 * @date March 2019
 * @version v1
 * @Description: IndexEntry is what we are putting into the index. It will not go into the index if the
 * page list is full.
 */

public class IndexEntry implements Comparable<IndexEntry> {
    private Stack<Integer> PageList;
    private String KeyWord;
    private final static int PAGELIST_CAPACITY = 4;

    public IndexEntry() {
        KeyWord = "";
        PageList = new Stack<>();
    }

    public IndexEntry(String word) {
        KeyWord = word;
        PageList = new Stack<>();
    }

    public IndexEntry(String word, int pageNumFound) {
        KeyWord = word;
        PageList = new Stack<>();
        PageList.push(pageNumFound);
    }

    /**
     * Comparing the this node and the other node in order to determine where
     * it should be placed in the BST.
     * @param other the node we are comparing
     * @return a numerical representation of their comparison.
     */
    public int compareTo(IndexEntry other) {

        return this.getKeyWord().compareTo(other.getKeyWord());
    }

    public String getKeyWord(){
        return KeyWord;
    }

    //==========================================
    //	   PageList: Full?, Search & Insert
    //==========================================

    /**
     * Checks to see if the pagelist is full
     * @return true if it is full, otherwise false.
     */
    public boolean isFull() {
        boolean toReturn = false;
        if (PageList.size() >= PAGELIST_CAPACITY) {
            toReturn = true;
        }
        return toReturn;
    }


    /**
     * Looks at the top of the stack. Check whether the latest number put into page list is equal
     * to the number we are looking for, if it is, return true, otherwise return false.
     * @param findNum number being checked
     * @return boolean, true if it is on top of the stack, otherwise false.
     */
    public boolean searchPageList(int findNum){
        boolean toReturn = false;

        Integer LastSeen = PageList.peek();
        if (LastSeen == findNum){
            toReturn = true;
        }

        return toReturn;
    }

    /**
     * Making the assumption that the number we want to insert will always go to the next
     * spot that is available.
     * @param toInsert the page number we want to insert
     */
    public void insertPageNum(int toInsert){
        PageList.push(toInsert);
    }

    //==========================================
    //				String version
    //==========================================

    public String toString(){
        String toReturn = "";
        toReturn += this.getKeyWord();
        toReturn += " ";
        toReturn += PageList.toString();
        return toReturn;
    }


}








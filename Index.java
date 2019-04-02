package proj5;
/**
 * Index
 * @author Quentin Cachon
 * @date March 2019
 * @version v1
 * @Description: Where we store words we want included in the index. Each entry is
 * represented by an index entry which holds the word and the associated page list.
 */

public class Index<T extends Comparable<T>> {
    private BinarySearchTree<IndexEntry> contents;

    public Index(){
        contents = new BinarySearchTree();


    }

    //==========================================
    //             Search and get data
    //==========================================

    /**
     * Searches for a string in the index.
     * @param target the string we are searching for
     * @return true if it is in the index, otherwise false.
     */
    public boolean search(String target){
        IndexEntry toSearch = new IndexEntry(target);
        return contents.search(toSearch);
    }

    /**
     * Responsible for what goes in the index. Has to be a word more than 2 character, word is
     * not in the dictionary, the word is not already in the index, the word's pagelist doesn't
     * yet have the page number it is located on. If the pagelist is full, prints the word and
     * the pagelist of where the word occurs, deletes word from the index, inserts word into
     * the dictionary.
     * @param fileName the file we are reading to determine which words go into dictionary or
     *                 index.
     */
    public void makeIndex(String fileName){
        FileReader fileReader = new FileReader(fileName);
        Dictionary dictionary = new Dictionary();
        Index index = new Index();
        int pageCounter = 1;

        String currentWord = fileReader.nextToken();

        while(currentWord != null){
            if(currentWord.equals("#")){
                pageCounter += 1;
            }
            else if(currentWord.length() > 2 && !dictionary.search(currentWord)){
                if(index.search(currentWord)){
                    IndexEntry currentWordEntry = index.getNodeData(currentWord);
                    if (!currentWordEntry.searchPageList(pageCounter)){
                        if (!currentWordEntry.isFull()){
                            currentWordEntry.insertPageNum(pageCounter);
                        }
                        else{
                            System.out.println("Deleting '" + currentWordEntry.toString() + "' from index");
                            index.delete(currentWord);
                            dictionary.insert(currentWord);
                        }
                    }
                }
                else{
                    IndexEntry toInsert = new IndexEntry(currentWord, pageCounter);
                    index.insert(toInsert);
                }
            }
            currentWord = fileReader.nextToken();
        }

        System.out.println(index.toString());
        System.out.println(dictionary.toString());
    }


    /**
     * Gets the data of the node we are looking at.
     * @param target the node in which we are getting the data from
     * @return the data of the node.
     */
    public IndexEntry getNodeData(String target){
        IndexEntry toGet = new IndexEntry(target);
        IndexEntry hold = contents.getNodeData(toGet);
        return hold;
    }

    //==========================================
    //              Insert & Delete
    //==========================================

    /**
     * Inserts word into the index
     * @param word the word we are inserting
     */
    public void insert(IndexEntry word){
        contents.insert(word);
    }

    /**
     * Deletes the word from the index.
     * @param victim the word we are deleting from the index.
     */
    public void delete(String victim){
        IndexEntry todelete = new IndexEntry(victim);
        contents.delete(todelete);
    }

    //==========================================
    //              String version
    //==========================================

    public String toString(){
        return contents.idToString();
    }

}

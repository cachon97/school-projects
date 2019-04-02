package proj5;

/**
 * makeIndex
 * @author Quentin Cachon
 * @date March 2019
 * @version v1
 * @Description: Creates an index
 */

public class IndexCreate{
    private FileReader fileReader;
    private Dictionary dictionary;
    public Index index;
    private int pageCounter;

    public IndexCreate(String fileName){
        fileReader = new FileReader(fileName);
        dictionary = new Dictionary();
        index = new Index();
        pageCounter = 1;
    }

    /**
     * Creates an index. If the filereader reads a # sign, that is an indicator for a new page.
     * If the word is longer than 2 characters and is not in the dictionary, it checks the index
     * for the word. If the word is in the index, it will create a new entry. If the page list associated with
     * that word is not in the pagelist or the pagelist is not full, then it will insert the page number for the
     * entry word.
     *
     * This method then prints out the string version of the dictonary and index.
     */
    public void makeIndex(){

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
                            System.out.println("Deleting `" + currentWordEntry.toString() + "' from index");
                            index.delete(currentWord);
                            dictionary.insert(currentWord);
                        }
                    }
                }
                else{
                    IndexEntry toinsert = new IndexEntry(currentWord, pageCounter);
                    index.insert(toinsert);
                }

            }

            currentWord = fileReader.nextToken();
        }

        System.out.println(index.toString());
        System.out.println(dictionary.toString());

    }

}




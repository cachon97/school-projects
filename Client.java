package proj5;

/**
 * Driver for the index maker project
 * 
 * @author Quentin Cachon
 * @version v10000000
 */
public class Client
{
    public static void main(String[] args) {

        makeIndex("src/proj5/input.txt");

    }

    /**
     * Makes an index out of fileName. Gradescope needs this function.
     * @param fileName path to text file that you want to index
     */
    public static void makeIndex(String fileName) {
        Index index = new Index();
        index.makeIndex(fileName);

    }




}

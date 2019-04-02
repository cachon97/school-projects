package proj5;

import org.junit.*;
import org.junit.Rule;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;

public class BST_Tester {

    @Rule
    public Timeout timeout = Timeout.millis(100);

    @Test
    public void bstString(){
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert("A");
        tree.insert("B");
        assertEquals("(A(B))", tree.toString());
        assertEquals("A\nB\n", tree.idToString());

    }


    @Test
    public void insertitemBST(){
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert("S");
        assertEquals("(S)", tree.toString());
    }

    @Test
    public void BSTTEST()
    {
        // First test insert one item into BST
        BinarySearchTree<String> testerone = new BinarySearchTree<>();
        String testing = "Hi";
        testerone.insert(testing);

        assertEquals(true, testerone.search(testing));
    }

    //==========================================
    //             Dictionary Tests
    //==========================================

    @Test
    public void dictToStringTest(){
        Dictionary d = new Dictionary();
        d.insert("Q");
        d.insert("U");
        d.insert("E");
        d.insert("N");
        d.insert("T");
        d.insert("I");
        d.insert("N");
        assertEquals("E\n" +
                "I\n" +
                "N\n" +
                "N\n" +
                "Q\n" +
                "T\n" +
                "U\n", d.toString());
    }


    @Test
    public void dictInsertTest(){
        Dictionary d = new Dictionary();
        d.insert("A");
        assertEquals("A\n", d.toString());
    }

    @Test
    public void dictBasicTest(){
        Dictionary d = new Dictionary();
        d.insert("A");
        d.insert("B");
        d.insert("C");
        assertEquals("A\nB\nC\n", d.toString());
    }

    @Test
    public void dictTrueSearchTest(){
        Dictionary d = new Dictionary();
        d.insert("A");
        assertEquals(true, d.search("A"));
    }

    @Test
    public void dictFalseSearchTest(){
        Dictionary d = new Dictionary();
        d.insert("A");
        assertEquals(false, d.search("B"));
    }

    //==========================================
    //             Index Tests
    //==========================================

    @Test
    public void indexFivePageTest(){
        IndexEntry test = new IndexEntry("hi");
        Index index = new Index();
        test.insertPageNum(1);
        test.insertPageNum(2);
        test.insertPageNum(3);
        test.insertPageNum(4);
        test.insertPageNum(5);
        assertEquals(true, test.isFull());
    }

    @Test
    public void indexToStringTest(){
        IndexEntry test = new IndexEntry("happy");
        assertEquals("happy {}", test.toString());
    }

    @Test
    public void indexToStringTestPage(){
        IndexEntry test = new IndexEntry("doggy", 1);
        assertEquals("doggy {1}", test.toString());

    }

    @Test
    public void indexInsertOneTest(){
        Index idx = new Index();
        IndexEntry word = new IndexEntry("A");
        idx.insert(word);
        assertEquals("A {}\n", idx.toString());
    }

    @Test
    public void indexInsertMultipleTest(){
        Index idx = new Index();
        IndexEntry word = new IndexEntry("A");
        IndexEntry word2 = new IndexEntry("B");
        idx.insert(word);
        idx.insert(word2);
        assertEquals("A {}\nB {}\n", idx.toString());
    }

    @Test
    public void pageListSizeOne() {
        Stack s = new Stack<>();
        s.push("happy");
        assertEquals(1, s.size());

    }
    @Test
    public void pageListSizeMultiple() {
        Stack s = new Stack<>();
        s.push("happy");
        s.push("cool");
        s.push("dog");
        assertEquals(3, s.size());

    }

    @Test
    public void indexSearchTest(){
        Index index = new Index();
        IndexEntry entry = new IndexEntry("A");
        index.insert(entry);
        assertEquals(true, index.search("A"));
    }

    @Test
    public void indexSearchTestMultiple(){
        Index index = new Index();
        IndexEntry entry = new IndexEntry("A");
        IndexEntry entry2 = new IndexEntry("B");
        IndexEntry entry3 = new IndexEntry("C");
        index.insert(entry);
        index.insert(entry2);
        index.insert(entry3);
        assertEquals(true, index.search("B"));
    }

    @Test
    public void indexSearchFalseTest(){
        Index index = new Index();
        IndexEntry entry = new IndexEntry("A");
        index.insert(entry);
        assertEquals(false, index.search("Q"));
    }

    @Test
    public void indexDeleteTest(){
        Index index = new Index();
        IndexEntry entry = new IndexEntry("A");
        IndexEntry entry2 = new IndexEntry("B");
        index.insert(entry);
        index.insert(entry2);
        assertEquals("A {}\nB {}\n", index.toString());
        index.delete("A");
        assertEquals("B {}\n", index.toString());
    }


    //==========================================
    // Linked List Tests (From previous project)
    //==========================================

    @Test
    public void emptyListTest(){
        LinkedList l = new LinkedList();
        assertEquals(0, l.getLength());
    }

    @Test
    public void emptyListTest2(){
        LinkedList listEmpty = new LinkedList();
        assertEquals("()", listEmpty.toString());
    }

    @Test
    public void insertHeadLen(){
        LinkedList insertHeadLen = new LinkedList();
        insertHeadLen.insertAtHead("Hi");
        assertEquals("(Hi)", insertHeadLen.toString());
    }


    @Test
    public void testInsertFull(){
        LinkedList testInsertFull = new LinkedList();
        testInsertFull.insertAtHead("A");
        testInsertFull.insertAtHead("B");
        assertEquals("(B, A)", testInsertFull.toString());
    }


    @Test
    public void toStringEmpty(){
        LinkedList toStringEmpty = new LinkedList();
        assertEquals("()", toStringEmpty.toString());
    }


    @Test
    public void toString1Element(){
        LinkedList toString1 = new LinkedList();
        toString1.insertAtHead("A");
        assertEquals("(A)", toString1.toString());
    }


    @Test
    public void toStringManyElements(){
        LinkedList toStringMany = new LinkedList();
        toStringMany.insertAtHead("A");
        toStringMany.insertAtHead("B");
        toStringMany.insertAtHead("C");
        assertEquals("(C, B, A)", toStringMany.toString());
    }

    @Test
    public void testInsertHead(){
        LinkedList testInsertHead = new LinkedList();
        testInsertHead.insertAtHead("A");
        assertEquals("(A)", testInsertHead.toString());
    }

    @Test
    public void insertAtIndexEmpty(){
        LinkedList insertIndexEmpty = new LinkedList();
        insertIndexEmpty.insertAtIndex("A", 0);
        assertEquals("(A)", insertIndexEmpty.toString());
    }

    @Test
    public void insertIndexFull(){
        LinkedList insertIndexFull = new LinkedList();
        insertIndexFull.insertAtHead("A");
        insertIndexFull.insertAtHead("A");
        insertIndexFull.insertAtIndex("B", 1);
        assertEquals("(A, B, A)", insertIndexFull.toString());
    }

    @Test
    public void invalidIndex(){
        LinkedList insertInvalid = new LinkedList();
        insertInvalid.insertAtIndex("A", 2);
        assertEquals("()", insertInvalid.toString());
    }

    @Test
    public void removeMiddle(){
        LinkedList removeMiddle = new LinkedList();
        removeMiddle.insertAtHead("A");
        removeMiddle.insertAtIndex("B", 1);
        removeMiddle.insertAtIndex("C", 2);
        removeMiddle.removeAtIndex(1);
        assertEquals(2, removeMiddle.getLength());
        assertEquals("(A, C)", removeMiddle.toString());
    }

    @Test
    public void insertAtIndexLen(){
        LinkedList insertAtIndexLen = new LinkedList();
        insertAtIndexLen.insertAtHead("A");
        insertAtIndexLen.insertAtHead("B");
        insertAtIndexLen.insertAtHead("D");
        insertAtIndexLen.insertAtIndex("C", 2);
        assertEquals(4, insertAtIndexLen.getLength());
    }

    @Test
    public void removeEmpty(){
        LinkedList removeEmpty = new LinkedList();
        removeEmpty.removeAtIndex(0);
        assertEquals("()", removeEmpty.toString());
    }

    @Test
    public void removeInvalidFill(){
        LinkedList removeInvalidFill = new LinkedList();
        removeInvalidFill.insertAtHead("A");
        removeInvalidFill.insertAtHead("B");
        removeInvalidFill.removeAtIndex(3);
        assertEquals("(B, A)", removeInvalidFill.toString());
    }

    @Test
    public void removeEnd() {
        LinkedList removeEnd = new LinkedList();
        removeEnd.insertAtHead("A");
        removeEnd.insertAtIndex("B", 1);
        removeEnd.insertAtIndex("C", 2);
        removeEnd.removeAtIndex(2);
        assertEquals("(A, B)", removeEnd.toString());
    }

    // Remove from head with nodes after the head
    @Test
    public void removeHeadAfter(){
        LinkedList removeHeadAfter = new LinkedList();
        removeHeadAfter.insertAtHead("A");
        removeHeadAfter.insertAtIndex("B", 1);
        assertEquals("(A, B)", removeHeadAfter.toString());
        removeHeadAfter.removeAtIndex(0);
        assertEquals("(B)", removeHeadAfter.toString());
    }


    //==========================================
    //     Stack Tests (From previous project)
    //==========================================

    private Stack<String> stack;

    @Before
    public void setUp() throws Exception {
        stack = new Stack<String>();
    }

    @After
    public void tearDown() throws Exception {
        stack = null;
    }

    @Test
    public void testStackConstructor_toString () {
        assertEquals ("{}", stack.toString());
    }

    @Test
    public void testStackPushOneOntoEmptyStack () {
        stack.push("A");
        assertEquals ("{A}", stack.toString().replaceAll("[ ]+", ""));
    }

    @Test
    public void testStackPushTwoOntoEmptyStack () {
        stack.push("A");
        stack.push("B");
        assertEquals ("{A,B}", stack.toString().replaceAll("[ ]+", ""));
    }

    @Test
    public void testStackPushThreeOntoEmptyStack () {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals ("{A,B,C}", stack.toString().replaceAll("[ ]+", ""));
    }

    @Test
    public void testStackPopEmpty(){
        assertEquals((Object)null, this.stack.pop());
        assertEquals("{}", this.stack.toString());
        assertEquals(0L, (long)this.stack.size());
    }
    @Test
    public void testStackPopFilled(){
        this.stack.push("Q");
        this.stack.push("C");
        assertEquals("C", this.stack.pop());
        assertEquals("{Q}", this.stack.toString());
        assertEquals(1L, (long)this.stack.size());
    }

    @Test
    public void testStackPeekFilled(){
        this.stack.push("Q");
        this.stack.push("E");
        this.stack.push("C");
        assertEquals("C", this.stack.peek());
    }

    @Test
    public void testStackPeekEmpty(){
        assertEquals((Object)null, this.stack.peek());
    }

    @Test
    public void testStackPushEmpty(){
        this.stack.push("A");
        assertEquals(false, this.stack.isEmpty());
    }

    @Test
    public void testStackPush(){
        this.stack.push("QC");
        this.stack.push("QC");
        this.stack.push("QC");
        this.stack.push("QC");
        assertEquals(4L, (long)this.stack.size());
    }



}

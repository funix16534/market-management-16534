import java.security.PublicKey;

/**

 * Generic version of the LinkedList class.

 *

 */

public class MyList {

    /**

     * Head node, default is null

     */

     Node head;

    /**

     * Tail node, default is null

     */

     Node tail;

    /**

     * Default constructor

     */

    public MyList() {
head=tail=null;
    }

    /**

     * Constructor with head and tail

     *

     * @param head Head node of this list

     * @param tail Tail node of this list

     */

    public MyList(Node head, Node tail) {
        this.head=head;
        this.tail=tail;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    /**

     * Checking if this list is empty

     *

     * @return true if list is empty

     */

    public boolean isEmpty() {
        return (head==null);
    }

    /**

     * Returning the length of this list

     *

     * @return The length of this list

     */

    public int length() {
        int length = 0;
        Node current = this.head;
        while (current!=null) {
            length++;
            current = current.getNext();
        }
        return length;
    }

    public void insertToTail(Product item) {
        Node insert = new Node(item,null);
        if (isEmpty()){
            head=tail=insert;
        } else {
            tail.next=insert;
            tail=insert;
        }
    }



    /**

     * Insert an item at position to this list

     *

     * @param position The position of new item

     * @param item     The item to be inserted

     */

    public void insertAfterPosition(int position, Product item) {
        Node insert = new Node(item);
        Node current = this.getHead();
        int pos = 0;
        while (current!=null){
            current=this.getHead().getNext();
            pos++;
            if (pos==position-1){
                insert.setNext(current.getNext());
                current.setNext(insert);
                break;
            }
        }
    }


    /**

     * Deleting the tail of this list

     */

    public void deleteTail() {
        Node current = this.getHead();
        while (current!=null){
            current=getHead().getNext();
            if (current.getNext()==this.tail){
                setTail(current);
                current.setNext(null);
                break;
            }
        }
    }

    /**

     * Searching and deleting an item from this list by comparing the ID of items

     *

     * @param key The item to be deleted

     */

    void deleteElement(Product key) {
        // Store head node
        Node temp = head, prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.getInfo() == key) {
            head = temp.getNext(); // Changed head
            return;
        }

        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.getInfo() != key) {
            prev = temp;
            temp = temp.getNext();
        }

        // If key was not present in linked list
        if (temp == null)
            return;

        // Unlink the node from linked list
        prev.setNext(temp.getNext());
    }


    //Display list like (info Node head)=>(info Node 1)=>(info Node 2)
    // =>...(info Node tail). I just use to test methods
    public void display() {
        Node current = this.getHead();
        while (current != null) {
            if (current.getNext() == null) {
                System.out.println(current.output());
                break;
            }
            System.out.print(current.output() + " => ");
            current = current.getNext();
        }
        System.out.println("");
    }

    // sortList() will sort nodes of the list in ascending
    // order
    public void sortList() {

        // Node current will point to head
        Node current = head, index = null;

        Product temp;

        if (head == null) {
            return;
        }
        else {
            while (current != null) {
                // Node index will point to node next to
                // current
                index = current.next;

                while (index != null) {
                    // If current node's data is greater
                    // than index's node data, swap the data
                    // between them
                    if (current.info.getBcode().compareTo(index.info.getBcode())>0) {
                        temp = current.info;
                        current.info = index.info;
                        index.info = temp;
                    }

                    index = index.next;
                }
                current = current.next;
            }
        }
    }



    /**

     * Deleting all items in the list

     */

    public void clear() {
        this.head=null;
    }

}

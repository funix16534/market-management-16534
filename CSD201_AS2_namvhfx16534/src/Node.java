
/**

 * Generic version of the Node class.

 *

 */

public class Node {


    /**

     * The info of this node

     */

    Product info;

    /**

     * The next node

     */

    Node next;

    /**

     * Default constructor

     */

    public Node(Product info) {
        this.info=info;
        this.next=null;
    }

    /**

     * Constructor with info and next node

     *

     * @param info The info of this node

     * @param next The next Node of this node

     */

    public Node(Product info, Node next) {
        this.info=info;
        this.next=next;
    }

    //Necessary setters & getters

    public void setInfo(Product info) {
        this.info = info;
    }

    public Product getInfo() {
        return info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    /**

     * Overriding to convert this node to String

     */

    @Override

    public String toString() {
        return String.format("%-10s%-40s%-15s%-15s\n",info.getBcode(),"|"+info.getTitle(),"|"+info.getQuantity(),"|"+info.getPrice());
    }

    public String output(){
        return (info.getBcode()+","+info.getTitle()+","+info.getQuantity()+","+info.getPrice());
    }

}



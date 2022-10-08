


/**

 * Generic version of the Queue class.

 *

 *

 */

class MyQueue {



    /**

     * Head node contains front node in the queue

     */

    private Node head;

    /**

     * Tail node contains last node in the queue

     */

    private Node tail;

    //Necessary setters, getters & method
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

    public MyQueue(){
        head = tail = null;
    }
    public boolean isEmpty() {
        return(head==null);
    }

    public Product front() throws Exception{
        if(isEmpty()) throw new Exception();
        return(head.getInfo());
    }

    public Product dequeue() throws Exception {
        if(isEmpty()) throw new Exception();
        Product x = head.getInfo();
        head=head.getNext();
        if(head==null) {
            tail=null;
        }
        return(x);
    }

    void enqueue(Product x) {
        if(isEmpty()) {
            head = tail = new Node(x);
        }
        else{
            tail.setNext(new Node(x));
            tail = tail.getNext();
        }
    }

}



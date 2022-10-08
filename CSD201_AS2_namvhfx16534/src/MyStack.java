import java.util.EmptyStackException;

/**

 * Generic version of the Stack class.

 *

 *

 */
public class MyStack {
        /**

         * Head node contains front node in the stack

         */
        private Node head;

    public Node getHead() {
        return head;
    }
    //Setters & getters
    public void setHead(Node head) {
        this.head = head;
    }

    public MyStack() {
        head = null;
    }
    //Necessary methods
    public boolean isEmpty() {
        return(head==null);
    }
    public void push(Product x) {
        head = new Node(x,head);
    }

    public Product top() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();
        return(head.getInfo());
    }
    public Product pop() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();
        Product x = head.getInfo();
        head= head.getNext();
        return(x);
    }


    }


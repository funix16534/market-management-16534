import java.util.Scanner;

public class AS2_Main {
    public static OperationProduct r = new OperationProduct();
    public static MyList myList = new MyList();
    public static MyStack myStack = new MyStack();
    public static MyQueue myQueue = new MyQueue();
    public static int choice;
    public static Product debug = new Product("okoko","kpkokok",96,69);
    public static void showMenu() {
        String s = "Choose one of this options:\n" +
                "Product list:\n" +
                "1. Load data from file and display\n" +
                "2. Input & add to the end.\n" +
                "3. Display data\n" +
                "4. Save product list to file.\n" +
                "5. Search by ID\n" +
                "6. Delete by ID\n" +
                "7. Sort by ID.\n" +
                "8. Convert to Binary\n" +
                "9. Load to stack and display\n" +
                "10. Load to queue and display.\n" +
                "0. Exit\n" +
                "You choose: ";
        System.out.print(s);
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();
        s+=choice+"\n";
        r.consoleOutput(s);
        //Method run by user input
        if (choice== 1) {
            r.getAllItemsFromFile("data.txt", myList);
            r.displayAll(myList);
            showMenu();
        } else if (choice==2) {
            r.addLast(myList);
            showMenu();
        } else if (choice==3) {
            r.displayAll(myList);
            showMenu();
        } else if (choice==4) {
            r.writeAllItemsToFile("data.txt", myList);
            showMenu();
        } else if (choice==5) {
            r.searchByCode(myList);
            showMenu();
        } else if (choice==6) {
            r.deleteByCode(myList);
            showMenu();
        } else if (choice==7) {
            myList.sortList();
            System.out.println("Sorted!");
            r.consoleOutput("Sorted!\n");
            showMenu();
        } else if (choice==8) {
            if (myList.getHead()==null){
                String s1 = "There is no product!\n";
                System.out.print(s1);
                r.consoleOutput(s1);
            } else {
                String s2 = "Quantity " + myList.getHead().getInfo().getQuantity() +
                        " transform to binary number is " + r.convertToBinary(myList.getHead().getInfo().getQuantity())+"\n";
                System.out.print(s2);
                r.consoleOutput(s2);
            }
            showMenu();
        } else if (choice==9) {
            r.getAllItemsFromFile("data.txt", myStack);
            r.displayAll(myStack);
            showMenu();
        } else if (choice==10) {
            r.getAllItemsFromFile("data.txt", myQueue);
            r.displayAll(myQueue);
            showMenu();
        //Exit Program
        } else if(choice==0) {
            String s3 = "Thanks for using my product!\n";
            System.out.print(s3);
            r.consoleOutput(s3);
        //Validate choice
        } else {
            String s4 = "Invalid choice. Please choose again!\n";
            System.out.print(s4);
            r.consoleOutput(s4);
            showMenu();
        }
    }

    public static void main(String[] args) {
        showMenu();
    }
}

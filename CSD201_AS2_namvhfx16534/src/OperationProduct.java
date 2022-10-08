import java.io.*;
import java.util.Scanner;

/**

 * This class manages all functions relate to the product

 */

public class OperationProduct {

    //Normal constructor use to operate methods
    public OperationProduct() {
    }

    //I created this method to complete enhancement criterion #2.
    // From now on in this class, all Strings named s, s1, s2, ... are
    // written to console_output.txt
    public void consoleOutput(String s){
        //Create stream
        try{
            //Pathname to current folder
            String basePath = new File("").getAbsolutePath();
            File file =new File(basePath+"\\console_output.txt");
            //Create file if you don't have
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            //This will add a new line to the file content
            pw.println("");
            /* Below statement would add String to the file */
            pw.println(s);
            //Close stream
            pw.close();
            //Notify error if happens
        }catch(IOException ioe){
            System.out.println("Exception occurred:");
            ioe.printStackTrace();
        }
    }
    /**
     * Reading all products from the file and insert them to the list at tail.
     *
     * @param fileName The file name of the file
     * @param list     The Linked List contains all products that read from file
     */

    public void getAllItemsFromFile(String fileName, MyList list) {
        String[] productArr;
        String[] txt = new String[1000];
        String s = "Read from file: ";
        System.out.println(s);
        consoleOutput(s);
        int i = 0;
        try {
            //Step 1: Create stream and link data
            String basePath = new File("").getAbsolutePath();
            File f = new File(basePath+"\\" + fileName);
            FileReader fr = new FileReader(f);
            //Step 2: Read data
            BufferedReader br = new BufferedReader(fr);
            String line=br.readLine();
            while (line != null) {
                txt[i]=line;
                i++;
                line= br.readLine();
            }
            //Step 3: Close stream
            br.close();
            fr.close();
            //Notify error if happen
        } catch (Exception ex) {
            System.out.println("Failed to read file: " + ex);
        }
        //Create array from string in file
        //if list is empty create new list
        if (list.isEmpty()) {
            //In my output file(data.txt), parameters of Product separated by space and "|". I must delete them before create new Product add to new Node.
            productArr = txt[0].split("\\|");
            Product newProduct = new Product(productArr[0].trim(), productArr[1].trim(), Integer.parseInt(productArr[2].trim()), Double.parseDouble(productArr[3].trim ()));
            Node newNode = new Node(newProduct);
            //Set head and tail
            list.setHead(newNode);
            list.setTail(newNode);
            //From now, add each new Node to tail of list
            for (int j = 1; j < txt.length; j++) {
                if (txt[j] == null) {
                    break;
                }
                productArr = txt[j].split("\\|");
                newProduct = new Product(productArr[0].trim(), productArr[1].trim(), Integer.parseInt(productArr[2].trim()), Double.parseDouble(productArr[3].trim()));
                Node current = list.getHead();
                boolean sameBcode = false;
                //ID must unique, same ID can't add to list
                while (current != null) {
                    if (current.getInfo().getBcode().equalsIgnoreCase(newProduct.getBcode())) {
                        sameBcode = true;
                        break;
                    }
                    current = current.getNext();
                }
                if (!sameBcode) {
                    list.insertToTail(newProduct);
                }
            }
            //if list isn't empty, just add to tail each node
        } else {
            for (String value : txt) {
                if (value == null) {
                    break;
                }
                productArr = value.split("\\|");
                Product newProduct = new Product(productArr[0].trim(), productArr[1].trim(), Integer.parseInt(productArr[2].trim()), Double.parseDouble(productArr[3].trim()));
                Node current = list.getHead();
                boolean sameBcode = false;
                while (current != null) {
                    if (current.getInfo().getBcode().equalsIgnoreCase(newProduct.getBcode())) {
                        sameBcode = true;
                        break;
                    }
                    current = current.getNext();
                }
                if (!sameBcode) {
                    list.insertToTail(newProduct);
                }
            }
        }
    }

    /**
     * Reading all products from the file and insert them to the stack.
     *
     * @param fileName The file name of the file
     * @param stack    The Stack contains all products that read from file
     *
     *Same as above method but here is the stack
     */

    public void getAllItemsFromFile(String fileName, MyStack stack) {
        String[] productArr;
        String[] txt = new String[100];
        int i = 0;
        String s = "Read from file: ";
        System.out.println(s);
        consoleOutput(s);
        try {
            //Step 1: Create stream and link data
            String basePath = new File("").getAbsolutePath();
            File f = new File(basePath+"\\" + fileName);
            FileReader fr = new FileReader(f);
            //Step 2: Read data
            BufferedReader br = new BufferedReader(fr);
            String line=br.readLine();
            while (line != null) {
                txt[i]=line;
                i++;
                line= br.readLine();
            }
            //Step 3: Close stream
            br.close();
            fr.close();
            //Notify error if happen
        } catch (Exception ex) {
            System.out.println("Failed to read file: " + ex);
        }
        //Create array from string in file
        if (stack.isEmpty()) {
            productArr = txt[0].split("\\|");
            Product newProduct = new Product(productArr[0].trim(), productArr[1].trim(), Integer.parseInt(productArr[2].trim()), Double.parseDouble(productArr[3].trim ()));
            Node newNode = new Node(newProduct);
            stack.setHead(newNode);
            for (int j = 1; j < txt.length; j++) {
                if (txt[j] == null) {
                    break;
                }
                productArr = txt[j].split("\\|");
                newProduct = new Product(productArr[0].trim(), productArr[1].trim(), Integer.parseInt(productArr[2].trim()), Double.parseDouble(productArr[3].trim()));
                Node current = stack.getHead();
                boolean sameBcode = false;
                while (current != null) {
                    if (current.getInfo().getBcode().equalsIgnoreCase(newProduct.getBcode())) {
                        sameBcode=true;
                        break;
                    }
                    current = current.getNext();
                }
                if (!sameBcode) {
                    // This is stack so I used method push, and add
                    // information in reverse order of reading into stack
                    stack.push(newProduct);
                }
            }
        } else {
            for (String value : txt) {
                if (value == null) {
                    break;
                }
                productArr = value.split("\\|");
                Product newProduct = new Product(productArr[0].trim(), productArr[1].trim(), Integer.parseInt(productArr[2].trim()), Double.parseDouble(productArr[3].trim()));
                Node current = stack.getHead();
                boolean sameBcode = false;
                while (current != null) {
                    if (current.getInfo().getBcode().equalsIgnoreCase(newProduct.getBcode())) {
                        sameBcode = true;
                        break;
                    }
                    current = current.getNext();
                }
                if (!sameBcode) {
                    stack.push(newProduct);
                }
            }
        }
    }


    /**
     * Reading all products from the file and insert them to the queue.
     *
     * @param fileName The file name of the file
     * @param queue    The Queue contains all products that read from file
     *
     *
     *Just same as above method but this is queue
     */

    public void getAllItemsFromFile(String fileName, MyQueue queue) {
        String[] productArr;
        String[] txt = new String[100];
        int i = 0;
        String s = "Read from file: ";
        System.out.println(s);
        consoleOutput(s);
        try {
            //Step 1: Create stream and link data
            String basePath = new File("").getAbsolutePath();
            File f = new File(basePath+"\\" + fileName);
            FileReader fr = new FileReader(f);
            //Step 2: Read data
            BufferedReader br = new BufferedReader(fr);
            String line=br.readLine();
            while (line != null) {
                txt[i]=line;
                i++;
                line= br.readLine();
            }
            //Step 3: Close stream
            br.close();
            fr.close();
            //Notify error if happen
        } catch (Exception ex) {
            System.out.println("Failed to read file: " + ex);
        }
        //Create array from string in file
        if (queue.isEmpty()) {
            productArr = txt[0].split("\\|");
            Product newProduct = new Product(productArr[0].trim(), productArr[1].trim(), Integer.parseInt(productArr[2].trim()), Double.parseDouble(productArr[3].trim ()));
            Node newNode = new Node(newProduct);
            queue.setHead(newNode);
            queue.setTail(newNode);
            for (int j = 1; j < txt.length; j++) {
                if (txt[j] == null) {
                    break;
                }
                productArr = txt[j].split("\\|");
                newProduct = new Product(productArr[0].trim(), productArr[1].trim(), Integer.parseInt(productArr[2].trim()), Double.parseDouble(productArr[3].trim()));
                Node current = queue.getHead();
                boolean sameBcode = false;
                while (current != null) {
                    if (current.getInfo().getBcode().equalsIgnoreCase(newProduct.getBcode())) {
                        sameBcode = true;
                        break;
                    }
                    current = current.getNext();
                }
                if (!sameBcode) {
                    //This is queue so I used method enqueue
                    queue.enqueue(newProduct);
                }
            }
        } else {
            for (String value : txt) {
                if (value == null) {
                    break;
                }
                productArr = value.split("\\|");
                Product newProduct = new Product(productArr[0].trim(), productArr[1].trim(), Integer.parseInt(productArr[2].trim()), Double.parseDouble(productArr[3].trim()));
                Node current = queue.getHead();
                boolean sameBcode = false;
                while (current != null) {
                    if (current.getInfo().getBcode().equalsIgnoreCase(newProduct.getBcode())) {
                        sameBcode = true;
                        break;
                    }
                    current = current.getNext();
                }
                if (!sameBcode) {
                    queue.enqueue(newProduct);
                }
            }
        }
    }


    /**
     * Printing all prodcuts of the list to console screen
     *
     */

    public void displayAll(MyList list) {
        StringBuilder s = new StringBuilder();
        if (!list.isEmpty()) {
            //String format for a clean table, good for eyes of user and mentor
            String s1 = String.format("%-10s%-40s%-15s%-15s\n", "Barcode", "|Title", "|Quantity", "|Price");
            s.append(s1);
            System.out.print(s1);
            Node current = list.getHead();
            //display each info of Node
            while (current != null) {
                s.append(current.getInfo());
                System.out.print(current.getInfo());
                current = current.getNext();
            }
        //If list is empty, notify
        } else {
            System.out.println("Empty!");
            s.append("Empty!\n");
        }
        consoleOutput(s.toString());
    }

    //Same as above, but this is queue
    public void displayAll(MyQueue queue) {
        StringBuilder s = new StringBuilder();
        if (!queue.isEmpty()) {
            String s1 = String.format("%-10s%-40s%-15s%-15s\n", "Barcode", "|Title", "|Quantity", "|Price");
            System.out.print(s1);
            s.append(s1);
            Node current = queue.getHead();
            while (current != null) {
                System.out.print(current.getInfo());
                s.append(current.getInfo());
                current = current.getNext();
            }
        } else {
            System.out.println("Empty!");
            s.append("Empty!\n");
        }
        consoleOutput(s.toString());
    }

    //Same as above but this is stack, display in reverse order of list and queue
    public void displayAll(MyStack stack) {
        StringBuilder s = new StringBuilder();
        if (!stack.isEmpty()) {
            String s1 = String.format("%-10s%-40s%-15s%-15s\n", "Barcode", "|Title", "|Quantity", "|Price");
            System.out.print(s1);
            s.append(s1);
            Node current = stack.getHead();
            while (current != null) {
                System.out.print(current.getInfo());
                s.append(current.getInfo());
                current = current.getNext();
            }
        } else {
            System.out.println("Empty!");
            s.append("Empty!\n");
        }
        consoleOutput(s.toString());
    }


    /**
     * Writing all products from the list to the file
     *
     * @param fileName Input file name
     * @param list     Input Linked list
     */

    public void writeAllItemsToFile(String fileName, MyList list) {
        String s = "";
        Node current = list.getHead();
        StringBuilder write = new StringBuilder();
        while (current != null) {
            write.append(current);
            current = current.getNext();
        }
        try {
            //Step 1: Create stream and link to the data
            String basePath = new File("").getAbsolutePath();
            File f = new File(basePath+"\\" + fileName);
            FileWriter fw = new FileWriter(f);
            //Step 2: Write data for each element in array
            fw.write(write.toString());
            //Step 3: Close stream
            fw.close();
            s += "Successfully!\n";
            System.out.print(s);
            //Notify if have error
        } catch (IOException ex) {
            s += "Error: " + ex;
            System.out.println(s);
        }
        consoleOutput(s);
    }


    /**
     * Searching product by ID input from keyboard.
     *
     */

    public void searchByCode(MyList list) {
        Scanner input = new Scanner(System.in);
        //Inpur search Barcode
        StringBuilder s = new StringBuilder("Input barcode: ");
        System.out.print(s);
        String searchBarcode = input.next();
        s.append(searchBarcode).append("\n");
        Node current = list.getHead();
        int pos = 0;
        while (current != null) {
            //Found
            if (current.getInfo().getBcode().contains(searchBarcode)) {
                String s1 = "Position "+ pos + "\n";
                System.out.print(s1);
                s.append(s1);
                //Display infomation
                String s2 = String.format("%-10s%-40s%-15s%-15s\n", "Barcode", "|Title", "|Quantity", "|Price");
                System.out.print(s2);
                s.append(s2);
                System.out.print(current.getInfo());
                s.append(current.getInfo());
                break;
            //if can't find
            } else if (current.getNext() == null) {
                System.out.println("-1 : Not found!");
                s.append("-1 : Not found!\n");
            }
            pos++;
            current = current.getNext();
        }
        consoleOutput(s.toString());
    }

    /**
     * Deleting first product that has the ID input from keyboard from the list.
     *
     */

    public void deleteByCode(MyList list) {
        Scanner input = new Scanner(System.in);
        //Input delete barocde
        StringBuilder s = new StringBuilder("Input barcode: ");
        System.out.print(s);
        String deleteBarcode = input.next();
        s.append(deleteBarcode).append("\n");
        Node current = list.getHead();
        while (current != null) {
            //Search for this barcode
            if (current.getInfo().getBcode().equals(deleteBarcode)) {
                String s1 = "Delete this product:\n";
                s.append(s1);
                System.out.print(s1);
                String s2 = String.format("%-10s%-40s%-15s%-15s\n", "Barcode", "|Title", "|Quantity", "|Price");
                System.out.print(s2);
                s.append(s2);
                System.out.print(current.getInfo());
                s.append(current.getInfo());
                //Confirm delete or not
                String s3 = "1 to confirm, 0 to cancel: ";
                s.append(s3);
                System.out.print(s3);
                int choice = input.nextInt();
                s.append(choice).append("\n");
                while (choice != 0 && choice != 1) {
                    //Validate choice
                    String s4 = "Invalid choice. Please choose again: ";
                    System.out.print(s4);
                    s.append(s4);
                    choice = input.nextInt();
                    s.append(choice).append("\n");
                }
                //Cancel
                if (choice == 0) {
                    String s5 = "Cancel deletion\n";
                    s.append(s5);
                    System.out.print(s5);
                }
                //Confirm
                if (choice == 1) {
                    list.deleteElement(current.getInfo());
                    s.append("Deleted\n");
                    System.out.println("Deleted");
                }
                break;
            //Not found
            } else if (current.getNext() == null) {
                String s6 = "There is no product with this barcode!\n";
                s.append(s6);
                System.out.print(s6);
            }
            current = current.getNext();
        }
        consoleOutput(s.toString());
    }

    /**

     * Adding new product to tail of Linked List. The info input from keyboard.

     *

     * @param list The linked list

     */

    public void addLast(MyList list) {
        Scanner input = new Scanner(System.in);
        StringBuilder s = new StringBuilder("Input barcode: ");
        System.out.print("Input barcode: ");
        String newBarcode = input.next();
        s.append(newBarcode).append("\n");
        Node current = list.getHead();
        while (current != null) {
            //Validate Barcode, it must unique
            while (current.getInfo().getBcode().equalsIgnoreCase(newBarcode)) {
                String s1 = "Barcode must unique! Please input other barcode: ";
                System.out.print(s1);
                s.append(s1);
                current=list.getHead();
                newBarcode = input.next();
                s.append(newBarcode).append("\n");
            }
            current = current.getNext();
        }
        //Input title, quantity, price
        String s2 = "Input title: ";
        s.append(s2);
        System.out.print(s2);
        String newTitle = input.next();
        s.append(newTitle).append("\n");
        String s3 = "Input quantity: ";
        s.append(s3);
        System.out.print(s3);
        int newQuantity = input.nextInt();
        s.append(newQuantity).append("\n");
        String s4 = "Input price: ";
        s.append(s4);
        System.out.print(s4);
        double newPrice = input.nextDouble();
        s.append(newPrice).append("\n");
        //Create new Product and add
        list.insertToTail(new Product(newBarcode, newTitle, newQuantity, newPrice));
        String s5 = "Successfully!";
        System.out.println(s5);
        s.append(s5);
        consoleOutput(s.toString());
    }



    /**

     * Convert a decimal to a integer number. Example: input i = 18 -> Output = 10010

     * @param i Input decimal number

     * @return a integer numbers

     */

    public int convertToBinary(int i) {
        int j;
        if (i==0){
            return 0;
        } else {
            j=i%2;
        }
        return convertToBinary(i/2)*10+j;
    }

}


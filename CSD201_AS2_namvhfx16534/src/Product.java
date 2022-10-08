/**

 * Product class

 */

public class Product {
    //encapsulation value
    private String bcode;
    private String title;
    private int quantity;
    private double price;
    /**

     * Default constructor

     */

    public Product() {

    }

    /**
     * Constructor method to initialize a product

     *

     * @param bcode    Product's bar code

     * @param title    Product's title

     * @param quantity Product's quantity

     * @param price    Product's price

     */

    public Product(String bcode, String title, Integer quantity, double price) {
        this.bcode=bcode;
        this.title=title;
        this.quantity=quantity;
        this.price=price;
    }

    //Necessary setters & getters

    public String getBcode() {
        return bcode;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    /**

     * Convert this product to String for printing

     */

    @Override

    public String toString() {
        return String.format("%-10s%-40s%-15s%-15s\n",getBcode(),"|"+getTitle(),"|"+getQuantity(),"|"+getPrice());
    }



}



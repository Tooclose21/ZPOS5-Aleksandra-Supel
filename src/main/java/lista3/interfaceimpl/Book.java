package lista3.interfaceimpl;

public class Book implements Product {
    private String name;
    private double price;
    private int amount;
    private int pages;

    /**
     * Initializes the product - book
     * @param name name of the product
     * @param price price of the product
     * @param amount amount of products
     * @param pages how many pages the book has
     * @throws IllegalArgumentException if price is negative or zero, if amount is negative, if number of pages
     * is equal zero or negative
     */
    public Book(String name, double price, int amount, int pages) {
        if (price <= 0){
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        if (amount < 0){
            throw new IllegalArgumentException("Amount cannot be negative number");
        }
        if (pages <= 0){
            throw new IllegalArgumentException("Book has more than 0 pages");
        }
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.pages = pages;
    }

    /**
     * Gets name of the product
     * @return name of the product
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gets price of the product
     * @return price of the product
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Gets amount of products
     * @return amount of the product
     */
    @Override
    public int getAmount() {
        return amount;
    }

    /**
     * Checks if the book is long (over 200 pages)
     * @return true if there are more than 199 pages otherwise false
     */
    public boolean isLong() {
        return pages >= 200;
    }

}

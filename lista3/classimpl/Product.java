package lista3.classimpl;

public abstract class Product {
    protected String name;
    protected double price;
    protected int amount;

    /**
     * Gets name of the product
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets price of the product
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets amount of products
     * @return amount
     */
    public int getAmount() {
        return amount;
    }
}

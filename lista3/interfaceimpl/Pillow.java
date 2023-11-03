package lista3.interfaceimpl;

public class Pillow implements Product{
    private String name;
    private double price;
    private int amount;
    private double height;
    private double width;

    /**
     * Initializes the product - pillow
     * @param name name of the product
     * @param price price of the product
     * @param amount amount of products
     * @param height height of the pillow
     * @param width width of the pillow
     * @throws IllegalArgumentException if price is negative or zero, if amount is negative, if height is less
     * or equals zero, if width is less or equals zero
     */
    public Pillow(String name, double price, int amount, double height, double width) {
        if (price <= 0){
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        if (amount < 0){
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        if (height <= 0){
            throw new IllegalArgumentException("Height must be greater than 0");
        }
        if (width <= 0){
            throw new IllegalArgumentException("Height must be greater than 0");
        }
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.height = height;
        this.width = width;
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
     * Gives measurements of the pillow in format "heightxwidth"
     * @return measurements of the pillow
     */
    public String measurements() {
        return height + "x" + width;
    }
}

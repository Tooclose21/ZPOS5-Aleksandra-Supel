package lista3.classimpl;

public class Game extends Product {
    private int publicationYear;
    private double discount;
    private double clientAge;

    /**
     * Initializes the product - game
     * @param name name of the product
     * @param price price of the product
     * @param amount amount of products
     * @param publicationYear year when the game was published
     * @param discount discount given to certain clients
     * @param clientAge age of the client
     * @throws IllegalArgumentException if price is negative or zero, if amount is negative, if client's age
     * is equal zero or negative
     */
    public Game(String name, double price, int amount, int publicationYear, double clientAge, double discount) {
        if (price <= 0){
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        if (amount < 0){
            throw new IllegalArgumentException("Amount cannot be negative number");
        }
        if (clientAge <= 0){
            throw new IllegalArgumentException("Client's age cannot be negative number or zero");
        }
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.publicationYear = publicationYear;
        this.clientAge = clientAge;
        this.discount = discount;
    }

    /**
     * Checks if the game was published recently
     * @return true if the game was published in 2022 or after, otherwise false
     */
    public boolean recent() {
        return publicationYear >= 2022;
    }

    /**
     * Calculates the price after discount
     * @return price after discount
     */
    public double priceAfterDiscount() {
        if (clientAge <= 15) {
            return price-discount;
        }
        else {
            return price;
        }
    }
}

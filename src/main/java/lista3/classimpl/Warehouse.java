package lista3.classimpl;

import java.util.ArrayList;

public class Warehouse {
    private ArrayList<Product> ourProducts;

    /**
     * Creates list of products as a warehouse
     * @param ourProducts list of products
     */
    public Warehouse(ArrayList<Product> ourProducts) {
        this.ourProducts = ourProducts;
    }

    /**
     * Adds new product to the list
     * @param newProduct name of the new product, that needs to be added to the list
     */
    public void addProduct(Product newProduct) {
        ourProducts.add(newProduct);
    }

    /**
     * Removes old product of the list
     * @param oldProduct name of the old product, that needs to be removed from the list
     */
    public void removeProduct(Product oldProduct) {
        ourProducts.remove(oldProduct);
    }

    /**
     * Prints products with prices to the console
     */
    public void listProducts() {
        for (Product product: ourProducts) {
            System.out.println(product.getName() + ", " + product.getPrice());
        }
    }

    /**
     * Gets product at specified index
     * @param index index od product
     * @return product
     */
    public Product getProduct(int index){
        return ourProducts.get(index);
    }
}

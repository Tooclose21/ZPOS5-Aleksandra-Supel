package lista5;

import lista3.classimpl.Product;

import java.util.ArrayList;
import java.util.Map;

public class Warehouse {
    private final Map<String, Product> ourProducts;

    /**
     * Creates list of products as a warehouse
     * @param ourProducts list of products
     */
    public Warehouse(Map<String, Product> ourProducts) {
        this.ourProducts = ourProducts;
    }

    /**
     * Adds new product to the list
     * @param newProduct name of the new product, that needs to be added to the list
     */
    public void addProduct(String code, Product newProduct) {
        ourProducts.put(code, newProduct);
    }

    /**
     * Removes old product of the list
     * @param code code of the old product, that needs to be removed from the list
     */
    public void removeProduct(String code) {
        ourProducts.remove(code);
    }

    /**
     * Prints products with prices to the console
     */
    public void listProducts() {
        for (Product product: ourProducts.values()) {
            System.out.println(product.getName() + ", " + product.getPrice());
        }
    }

    /**
     * Gets product at specified index
     * @param code code of product
     * @return product
     */
    public Product getProduct(String code){
        return ourProducts.get(code);
    }
}

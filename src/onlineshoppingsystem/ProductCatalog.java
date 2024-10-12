package onlineshoppingsystem;

import java.util.HashMap;
import java.util.Map;

//The ProductCatalog class maintains a catalog of available products.
public class ProductCatalog {
    private Map<Integer, Product> products;

    public ProductCatalog() {
        products = new HashMap<>();
        products.put(1, new Product("Sapiens", 6000, 5));
        products.put(2, new Product("Divergent", 4500, 10));
        products.put(3, new Product("Harry Potter and the Philosopher's Stone", 8000, 20));
        products.put(4, new Product("Fahrenheit 451", 5000, 15));
        products.put(5, new Product("Pride and Prejudice", 3000, 20));
        products.put(6, new Product("Shatter Me", 4000, 20));
        products.put(7, new Product("Mr. Mercedes", 3500, 8));
        products.put(8, new Product("The Maze Runner", 5500, 12));
    }

    /**
     * Searches for a product by its ID.
     * @return The Product if found, otherwise null.
     */
    public Product searchProduct(int productId) {
        return products.get(productId);
    }

    /**
     * Inner class representing a Product.
     */
    public static class Product {
        String name;
        double price;
        int stock;

        Product(String name, double price, int stock) {
            this.name = name;
            this.price = price;
            this.stock = stock;
        }
    }
}
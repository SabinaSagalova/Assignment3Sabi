package onlineshoppingsystem;

// This class manages product inventory
public class InventoryManager {
    private ProductCatalog productCatalog;

    public InventoryManager(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }
    /**
     * Checks the availability of a product in stock.
     * @return true if the product is available, otherwise false.
     */
    public boolean checkAvailability(int productId, int quantity) {
        ProductCatalog.Product product = productCatalog.searchProduct(productId);
        return product != null && product.stock >= quantity;
    }
    //It updates the inventory after a purchase
    public void updateInventory(int productId, int quantity) {
        ProductCatalog.Product product = productCatalog.searchProduct(productId);
        if (product != null) {
            product.stock -= quantity;
            System.out.println("Inventory updated: " + product.name + " now has " + product.stock + " units in stock");
        }
    }
}

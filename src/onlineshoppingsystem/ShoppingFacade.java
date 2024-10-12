package onlineshoppingsystem;

// This class provides a simplified interface to shopping system
public class ShoppingFacade {
    private ProductCatalog productCatalog;
    private PaymentProcessor paymentProcessor;
    private InventoryManager inventoryManager;
    private ShippingService shippingService;

    public ShoppingFacade() {
        productCatalog = new ProductCatalog();
        paymentProcessor = new PaymentProcessor();
        inventoryManager = new InventoryManager(productCatalog);
        shippingService = new ShippingService();
    }

    // This places an order for a specified product and quantity
    public void placeOrder(int productId, int quantity) {
        ProductCatalog.Product product = productCatalog.searchProduct(productId);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        if (!inventoryManager.checkAvailability(productId, quantity)) {
            System.out.println("Insufficient stock for " + product.name + ".");
            return;
        }

        double totalAmount = product.price * quantity;
        try {
            if (paymentProcessor.processPayment(totalAmount)) {
                inventoryManager.updateInventory(productId, quantity);
                double shippingCost = shippingService.calculateShipping(productId);
                System.out.println("Total amount charged: $" + (totalAmount + shippingCost) + " (including shipping).");
                shippingService.shipOrder(product.name);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Payment error: " + e.getMessage());
        }
    }
}
package onlineshoppingsystem;

// This class calculates shipping costs and handles order shipping
public class ShippingService {
    /**
     * Calculates shipping cost based on product ID.
     * @return Shipping cost.
     */
    public double calculateShipping(int productId) {
        return 20.0; // Flat rate for simplicity
    }
    public void shipOrder(String productName) {  // Ships the order
        System.out.println("Order for " + productName + " has been shipped!");
    }
}


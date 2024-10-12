package onlineshoppingsystem;
//The Client class tests the Online Shopping System.

public class Client {
    public static void main(String[] args) {
        System.out.println("Welcome to the Online Book Store!");
        ShoppingFacade shoppingFacade = new ShoppingFacade();

        // Example of a user order
        int productId = 2; // User wants to buy divergent book
        int quantity = 6;  // User wants to buy shatter me book

        shoppingFacade.placeOrder(productId, quantity);

        // Trying to order more than available stock
        int insufficientQuantity = 17; // User wants to buy 17 books (too much that exists in store)
        shoppingFacade.placeOrder(productId, insufficientQuantity);

        // Trying to process a payment with an invalid amount
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        try {
            paymentProcessor.processPayment(-100); // Invalid payment
        } catch (IllegalArgumentException e) {
            System.out.println("Payment error: " + e.getMessage());
        }
    }
}

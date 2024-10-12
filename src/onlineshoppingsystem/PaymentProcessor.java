package onlineshoppingsystem;

//This class handles payment transactions
public class PaymentProcessor {
    /**
     * @return true if payment is successful.
     * @throws IllegalArgumentException if the payment amount is invalid.
     */
    public boolean processPayment(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("You do not have enough money :(");
        }
        System.out.println("Payment of $" + amount + " processed successfully :)");
        return true;
    }
}
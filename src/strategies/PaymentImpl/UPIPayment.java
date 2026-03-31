package strategies.PaymentImpl;

import strategies.PaymentStrategy;

public class UPIPayment implements PaymentStrategy {
    private String upiId;
    public UPIPayment(String upiId){
        this.upiId = upiId;
    }
    @Override
    public boolean processPayment(double amount){
        System.out.println("Processing Rs." + amount + " via UPI: " + upiId);
        return true;
    }
}

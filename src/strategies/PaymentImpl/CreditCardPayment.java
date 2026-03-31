package strategies.PaymentImpl;

import strategies.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    public CreditCardPayment(String cardNumber){
        this.cardNumber = cardNumber;
    }
    @Override
    public boolean processPayment(double amount){
        System.out.println("Processing Rs."+ amount+" via Credit Card");
        return true;
    }
}

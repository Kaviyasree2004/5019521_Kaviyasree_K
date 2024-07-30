public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext paycontext = new PaymentContext();

        PaymentStrategy creditCardPayment = new CreditCardPayment();
        paycontext.setPaymentStrategy(creditCardPayment);
        paycontext.pay(1000);

        PaymentStrategy paypalPayment = new PayPalPayment();
        paycontext.setPaymentStrategy(paypalPayment);
        paycontext.pay(2000);
    }

    interface PaymentStrategy {
        void pay(int amount);
    }

    static class CreditCardPayment implements PaymentStrategy {
        @Override
        public void pay(int amount) {
            System.out.println("The amount of Rs:" + amount + " is paid using Credit Card.");
        }
    }

    static class PayPalPayment implements PaymentStrategy {
        @Override
        public void pay(int amount) {
            System.out.println("The amount of Rs:" + amount + " is paid using PayPal.");
        }
    }

    static class PaymentContext {
        private PaymentStrategy paymentStrategy;

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void pay(int amount) {
            paymentStrategy.pay(amount);
        }
    }
}

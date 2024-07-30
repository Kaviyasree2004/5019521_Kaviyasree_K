interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPal {
    public void sendPayment(double amount) {
        System.out.println("Payment of " + amount + " Rupees through PayPal.");
    }
}

class GPay {
    public void makePayment(double amount) {
        System.out.println("Payment of " + amount + " Rupees through GPay.");
    }
}

class PhonePe {
    public void doPayment(double amount) {
        System.out.println("Payment of " + amount + " Rupees through PhonePe.");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private final PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment(double amount) {
        payPal.sendPayment(amount);
    }
}

class GPayAdapter implements PaymentProcessor {
    private final GPay gpay;

    public GPayAdapter(GPay gpay) {
        this.gpay = gpay;
    }

    @Override
    public void processPayment(double amount) {
        gpay.makePayment(amount);
    }
}

class PhonePeAdapter implements PaymentProcessor {
    private final PhonePe phonePe;

    public PhonePeAdapter(PhonePe phonePe) {
        this.phonePe = phonePe;
    }

    @Override
    public void processPayment(double amount) {
        phonePe.doPayment(amount);
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor payPal = new PayPalAdapter(new PayPal());
        payPal.processPayment(100.00);

        PaymentProcessor gPay = new GPayAdapter(new GPay());
        gPay.processPayment(200.00);

        PaymentProcessor phonePe = new PhonePeAdapter(new PhonePe());
        phonePe.processPayment(300.00);
    }
}

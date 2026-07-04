public class AdapterPatternExample {

    // Target Interface
    interface PaymentProcessor {
        void processPayment(double amount);
    }

    // Adaptee 1
    static class PayPalGateway {
        public void sendPayment(double amount) {
            System.out.println("Payment of Rs. " + amount + " processed using PayPal.");
        }
    }

    // Adaptee 2
    static class StripeGateway {
        public void makePayment(double amount) {
            System.out.println("Payment of Rs. " + amount + " processed using Stripe.");
        }
    }

    // Adapter for PayPal
    static class PayPalAdapter implements PaymentProcessor {
        private PayPalGateway paypal;

        public PayPalAdapter(PayPalGateway paypal) {
            this.paypal = paypal;
        }

        @Override
        public void processPayment(double amount) {
            paypal.sendPayment(amount);
        }
    }

    // Adapter for Stripe
    static class StripeAdapter implements PaymentProcessor {
        private StripeGateway stripe;

        public StripeAdapter(StripeGateway stripe) {
            this.stripe = stripe;
        }

        @Override
        public void processPayment(double amount) {
            stripe.makePayment(amount);
        }
    }

    public static void main(String[] args) {

        PaymentProcessor paypal = new PayPalAdapter(new PayPalGateway());
        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());

        paypal.processPayment(1500);
        stripe.processPayment(2500);
    }
}
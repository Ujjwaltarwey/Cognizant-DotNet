public class DecoratorPatternExample {

    
    interface Notifier {
        void send();
    }

    
    static class EmailNotifier implements Notifier {
        @Override
        public void send() {
            System.out.println("Notification sent via Email.");
        }
    }

    
    static abstract class NotifierDecorator implements Notifier {
        protected Notifier notifier;

        public NotifierDecorator(Notifier notifier) {
            this.notifier = notifier;
        }

        @Override
        public void send() {
            notifier.send();
        }
    }

   
    static class SMSNotifierDecorator extends NotifierDecorator {

        public SMSNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        @Override
        public void send() {
            super.send();
            System.out.println("Notification sent via SMS.");
        }
    }

    
    static class SlackNotifierDecorator extends NotifierDecorator {

        public SlackNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        @Override
        public void send() {
            super.send();
            System.out.println("Notification sent via Slack.");
        }
    }

    public static void main(String[] args) {

        System.out.println("Email Notification:");
        Notifier email = new EmailNotifier();
        email.send();

        System.out.println("\nEmail + SMS Notification:");
        Notifier emailSMS = new SMSNotifierDecorator(new EmailNotifier());
        emailSMS.send();

        System.out.println("\nEmail + SMS + Slack Notification:");
        Notifier allNotifications =
                new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier()));

        allNotifications.send();
    }
}


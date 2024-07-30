// File: DecoratorPatternExample.java
public class DecoratorPatternExample {
    public static void main(String[] args) {
        Notifier notify = new EmailNotifier();
        notify = new SMSNotifierDecorator(notify);
        notify = new SlackNotifierDecorator(notify);
        notify.send();
    }
}

interface Notifier {
    void send();
}

class EmailNotifier implements Notifier {
    @Override
    public void send() {
        System.out.println("This is Email Notification");
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send() {
        wrappedNotifier.send();
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send() {
        wrappedNotifier.send();
        System.out.println("This is SMS Notification");
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send() {
        wrappedNotifier.send();
        System.out.println("This is Slack Notification");
    }
}
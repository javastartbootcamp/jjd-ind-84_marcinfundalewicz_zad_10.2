package pl.javastart.task;

public abstract class MobileOperatorContract {
    public abstract boolean possibleToSendSms();

    public abstract boolean possibleToSendMms();

    public abstract void sendSms();

    public abstract void sendMms();

    public abstract double remainingBalance();

    public abstract int makeCall(int seconds);

    public abstract String accountInfo();
}

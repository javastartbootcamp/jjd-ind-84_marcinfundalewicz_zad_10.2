package pl.javastart.task;

public abstract class MobileOperatorContract {

    public abstract boolean sendSms();

    public abstract boolean sendMms();

    public abstract double remainingBalance();

    public abstract int makeCall(int seconds);

    public abstract String accountInfo();
}

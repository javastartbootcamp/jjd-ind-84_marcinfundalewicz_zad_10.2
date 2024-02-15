package pl.javastart.task.utils;

abstract class MobileOperatorContract {

    abstract boolean sendSms();

    abstract boolean sendMms();

    abstract double remainingBalance();

    abstract int makeCall(int seconds);

    abstract String accountInfo();
}

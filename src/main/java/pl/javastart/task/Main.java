package pl.javastart.task;

public class Main {

    public static void main(String[] args) {
        Phone phone = new Phone(new CardContract(10, 0.1, 0.2, 1));
        phone.printAccountState();
        phone.sendSms();
        phone.sendMms();
        phone.printAccountState();
        phone.sendSms();
        phone.printAccountState();
        phone.sendSms();
        phone.printAccountState();
    }
}

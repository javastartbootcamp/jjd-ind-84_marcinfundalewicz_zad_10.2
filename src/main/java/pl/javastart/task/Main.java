package pl.javastart.task;

import pl.javastart.task.utils.CardContract;
import pl.javastart.task.utils.MixContract;
import pl.javastart.task.utils.Phone;

public class Main {

    public static void main(String[] args) {
        Phone phone = new Phone(new MixContract(1, 0.1, 0.2, 1, 5, 5, 0));
        phone.printAccountState();
        phone.call(60);
        phone.printAccountState();
        phone.sendMms();
        phone.printAccountState();
        phone.sendSms();
        phone.printAccountState();
        phone.sendSms();
        phone.printAccountState();
    }
}

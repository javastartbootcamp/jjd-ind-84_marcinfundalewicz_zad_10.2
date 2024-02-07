package pl.javastart.task;

interface MobileOperator {

    void sendSms();

    void call(int seconds);

    void sendMms();

    void printAccountState();
}

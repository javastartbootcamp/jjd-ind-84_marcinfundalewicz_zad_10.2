package pl.javastart.task;

class Phone {
    MobileOperator mobileOperator;

    Phone(MobileOperator mobileOperator) {
        this.mobileOperator = mobileOperator;
    }

    void sendSms() {
        mobileOperator.sendSms();

    }

    void call(int seconds) {
        mobileOperator.call(seconds);
    }

    void sendMms() {
        mobileOperator.sendMms();
    }

    void printAccountState() {
        mobileOperator.printAccountState();
    }
}

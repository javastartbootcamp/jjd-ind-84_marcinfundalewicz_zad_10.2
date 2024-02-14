package pl.javastart.task.utils;

public class AbonamentContract extends MobileOperatorContract {
    private double abonamentPrice;

    public AbonamentContract(double abonamentPrice) {
        this.abonamentPrice = abonamentPrice;
    }

    @Override
    boolean sendSms() {
        return true;
    }

    @Override
    boolean sendMms() {
        return true;
    }

    @Override
    int makeCall(int seconds) {
        return seconds;
    }

    @Override
    String accountInfo() {
        return "SMSy / MMSy / rozmowy w cenie abonamentu";
    }

    @Override
    double remainingBalance() {
        return 0;
    }

    double getAbonamentPrice() {
        return abonamentPrice;
    }

    void setAbonamentPrice(double abonamentPrice) {
        this.abonamentPrice = abonamentPrice;
    }
}


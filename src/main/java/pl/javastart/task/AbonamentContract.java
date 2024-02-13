package pl.javastart.task;

public class AbonamentContract extends MobileOperatorContract {
    private double abonamentPrice;

    public AbonamentContract(double abonamentPrice) {
        this.abonamentPrice = abonamentPrice;
    }

    @Override
    public boolean sendSms() {
        return true;
    }

    @Override
    public boolean sendMms() {
        return true;
    }

    @Override
    public int makeCall(int seconds) {
        return seconds;
    }

    @Override
    public String accountInfo() {
        return "SMSy / MMSy / rozmowy w cenie abonamentu";
    }

    @Override
    public double remainingBalance() {
        return 0;
    }

    public double getAbonamentPrice() {
        return abonamentPrice;
    }

    public void setAbonamentPrice(double abonamentPrice) {
        this.abonamentPrice = abonamentPrice;
    }
}


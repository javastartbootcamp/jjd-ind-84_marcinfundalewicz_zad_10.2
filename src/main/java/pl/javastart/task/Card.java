package pl.javastart.task;

class Card implements MobileOperator {
    double accountBalance;
    double smsCost;
    double mmsCost;
    double callingCostPerMinute;
    int smsCounter;
    int mmsCounter;
    int secondsCounter;

    public Card(double accountBalance, double smsCost, double mmsCost, double callingCostPerMinute) {
        this.accountBalance = accountBalance;
        this.smsCost = smsCost;
        this.mmsCost = mmsCost;
        this.callingCostPerMinute = callingCostPerMinute;
    }

    @Override
    public void sendSms() {
        if (smsCost <= accountBalance) {
            accountBalance -= smsCost;
            smsCounter++;
            System.out.println("SMS wysłany");
        } else {
            System.out.println("SMS niewysłany");
        }
    }

    @Override
    public void sendMms() {
        if (mmsCost <= accountBalance) {
            accountBalance -= mmsCost;
            mmsCounter++;
            System.out.println("MMS wysłany");
        } else {
            System.out.println("MMS niewysłany");
        }
    }

    @Override
    public void call(int seconds) {
        if (callingCostPerMinute <= accountBalance) {
            accountBalance -= (callingCostPerMinute / 60) * seconds;
            secondsCounter = seconds;
        }
    }

    @Override
    public void printAccountState() {
        System.out.println();
        System.out.println("=== STAN KONTA ===");
        System.out.println("Wysłanych SMSów: " + smsCounter);
        System.out.println("Wysłanych MMSów: " + mmsCounter);
        System.out.println("Liczba sekund rozmowy: " + secondsCounter);
        System.out.printf("Na koncie zostało: " + "%.2f", accountBalance);
        System.out.println();
        System.out.println();

    }
}

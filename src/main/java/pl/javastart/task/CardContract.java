package pl.javastart.task;

class CardContract extends MobileOperatorContract {
    protected double accountBalance;
    protected double smsCost;
    protected double mmsCost;
    protected double callingCostPerMinute;

    public CardContract(double accountBalance, double smsCost, double mmsCost, double callingCostPerMinute) {
        this.accountBalance = accountBalance;
        this.smsCost = smsCost;
        this.mmsCost = mmsCost;
        this.callingCostPerMinute = callingCostPerMinute;
    }

    @Override
    public boolean possibleToSendMms() {
        return mmsCost <= accountBalance;
    }

    @Override
    public boolean possibleToSendSms() {
        return smsCost <= accountBalance;
    }

    @Override
    public void sendSms() {
        accountBalance -= smsCost;
    }

    @Override
    public void sendMms() {
        accountBalance -= mmsCost;
    }

    @Override
    public String accountInfo() {
        return String.format("%.2f", accountBalance);
    }

    @Override
    public int makeCall(int seconds) {
        double leftSeconds = accountBalance / callingCostPerMinute * 60;
        if (seconds <= leftSeconds) {
            accountBalance -= seconds * callingCostPerMinute / 60;
            return seconds;
        } else {
            int leftSeconds2 = (int) leftSeconds;
            accountBalance = 0;
            return leftSeconds2;
        }
    }

    @Override
    public double remainingBalance() {
        return accountBalance;
    }
}


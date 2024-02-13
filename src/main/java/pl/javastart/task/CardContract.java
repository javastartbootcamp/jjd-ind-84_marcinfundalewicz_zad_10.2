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
    public boolean sendSms() {
        if (accountBalance >= smsCost) {
            accountBalance -= smsCost;
            return true;
        }
        return false;
    }

    @Override
    public boolean sendMms() {
        if (accountBalance >= mmsCost) {
            accountBalance -= mmsCost;
            return true;
        }
        return false;
    }

    @Override
    public String accountInfo() {
        return String.format("%.2f", accountBalance);
    }

    @Override
    public int makeCall(int seconds) {
        double secondsPossible = accountBalance / callingCostPerMinute * 60;
        if (secondsPossible >= seconds) {
            accountBalance -= seconds * callingCostPerMinute / 60;
            return seconds;
        } else {
            int secondsPossible2 = (int) secondsPossible;
            accountBalance = 0;
            return secondsPossible2;
        }
    }

    @Override
    public double remainingBalance() {
        return accountBalance;
    }
}


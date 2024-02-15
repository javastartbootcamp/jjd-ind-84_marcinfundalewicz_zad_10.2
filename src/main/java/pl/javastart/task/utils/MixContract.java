package pl.javastart.task.utils;

public class MixContract extends CardContract {
    private int remainingSms;
    private int remainingMms;
    private double remainingCallMinutes;

    public MixContract(double accountBalance, double smsCost, double mmsCost, double callingCostPerMinute,
                       int remainingSms, int remainingMms, double remainingCallMinutes) {
        super(accountBalance, smsCost, mmsCost, callingCostPerMinute);
        this.remainingSms = remainingSms;
        this.remainingMms = remainingMms;
        this.remainingCallMinutes = remainingCallMinutes;
    }

    @Override
    protected boolean sendSms() {
        if (remainingSms > 0) {
            remainingSms--;
            return true;
        }
        return super.sendSms();
    }

    @Override
    protected boolean sendMms() {
        if (remainingMms > 0) {
            remainingMms--;
            return true;
        }
        return super.sendMms();
    }

    @Override
    protected String accountInfo() {
        return String.format("Pozostałe SMSy: %d\nPozostałe MMSy: %d\nPozostałe sekundy: %.1f\nPozostały stan konta: %.1f zł",
                remainingSms, remainingMms, remainingCallMinutes * 60, accountBalance);
    }

    @Override
    protected int makeCall(int seconds) {
        double remainingCallSeconds = remainingCallMinutes * 60;
        if (remainingCallSeconds >= seconds) {
            remainingCallMinutes -= seconds / 60.;
            return seconds;
        }
        if (remainingCallSeconds > 0) {
            int remainingSecondsToPay = seconds - (int) remainingCallSeconds;
            remainingCallMinutes = 0;
            return (int) remainingCallSeconds + super.makeCall(remainingSecondsToPay);
        }
        return super.makeCall(seconds);
    }

    @Override
    public double remainingBalance() {
        return super.remainingBalance();
    }

    public int getRemainingSms() {
        return remainingSms;
    }

    public void setRemainingSms(int remainingSms) {
        this.remainingSms = remainingSms;
    }

    public int getRemainingMms() {
        return remainingMms;
    }

    public void setRemainingMms(int remainingMms) {
        this.remainingMms = remainingMms;
    }

    public double getRemainingCallMinutes() {
        return remainingCallMinutes;
    }

    public void setRemainingCallMinutes(double remainingCallMinutes) {
        this.remainingCallMinutes = remainingCallMinutes;
    }
}



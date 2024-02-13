package pl.javastart.task;

public class MixContract extends CardContract {
    private int smsLimit;
    private int mmsLimit;
    private double callLimit;
    private int remainingSms;
    private int remainingMms;
    private double remainingCallMinutes;

    public MixContract(double accountBalance, double smsCost, double mmsCost, double callingCostPerMinute, int smsLimit, int mmsLimit, double callLimit) {
        super(accountBalance, smsCost, mmsCost, callingCostPerMinute);
        this.smsLimit = smsLimit;
        this.mmsLimit = mmsLimit;
        this.callLimit = callLimit;
        this.remainingSms = smsLimit;
        this.remainingMms = mmsLimit;
        this.remainingCallMinutes = callLimit;
    }

    @Override
    public boolean sendSms() {
        if (remainingSms > 0) {
            remainingSms--;
            return true;
        }
        return super.sendSms();
    }

    @Override
    public boolean sendMms() {
        if (remainingMms > 0) {
            remainingMms--;
            return true;
        }
        return super.sendMms();
    }

    @Override
    public String accountInfo() {
        return "Pozostałe SMSy: " + remainingSms
                + "\n" + "Pozostałe MMSy: " + remainingMms
                + "\n" + "Pozostałe sekundy: " + callLimit * 60
                + "\n" + "Pozostały stan konta: " + accountBalance + "\n";
    }

    @Override
    public int makeCall(int seconds) {
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

    public int getSmsLimit() {
        return smsLimit;
    }

    public void setSmsLimit(int smsLimit) {
        this.smsLimit = smsLimit;
    }

    public int getMmsLimit() {
        return mmsLimit;
    }

    public void setMmsLimit(int mmsLimit) {
        this.mmsLimit = mmsLimit;
    }

    public double getCallLimit() {
        return callLimit;
    }

    public void setCallLimit(double callLimit) {
        this.callLimit = callLimit;
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



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
    public boolean possibleToSendMms() {
        return remainingMms > 0 || mmsCost <= accountBalance;
    }

    @Override
    public boolean possibleToSendSms() {
        return remainingSms > 0 || smsCost <= accountBalance;
    }

    @Override
    public void sendSms() {
        if (remainingSms > 0) {
            remainingSms--;
        } else if (accountBalance >= smsCost) {
            accountBalance -= smsCost;
        }
    }

    @Override
    public void sendMms() {
        if (remainingMms > 0) {
            remainingMms--;
        } else if (accountBalance >= mmsCost) {
            accountBalance -= mmsCost;
        }
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
        double secondsToCall = remainingCallMinutes * 60;
        double secondsFromLimit;
        double secondsFromBalance;
        if (secondsToCall < seconds) {
            secondsFromLimit = secondsToCall;
            if (seconds > secondsToCall) {
                secondsFromBalance = seconds - secondsToCall;
            } else {
                secondsFromBalance = 0;
            }
        } else {
            secondsFromLimit = seconds;
            secondsFromBalance = 0;
        }
        if (secondsToCall >= secondsFromLimit) {
            remainingCallMinutes -= secondsFromLimit / 60;
        } else {
            remainingCallMinutes = 0;
        }
        double costFromBalance = secondsFromBalance * callingCostPerMinute / 60;
        if (costFromBalance <= accountBalance) {
            accountBalance -= costFromBalance;
        } else {
            if (accountBalance / callingCostPerMinute < secondsFromBalance) {
                secondsFromBalance = accountBalance / callingCostPerMinute;
            }
            accountBalance = 0;
        }
        return (int) (secondsFromLimit + secondsFromBalance);
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



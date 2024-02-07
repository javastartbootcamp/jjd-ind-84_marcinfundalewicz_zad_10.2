package pl.javastart.task;

class Mix implements MobileOperator {
    public static final double SMS_COST = 0.1;
    public static final double MMS_COST = 0.2;
    public static final double CALLING_COST_PER_MINUTE = 0.5;
    double smsAmount;
    double mmsAmount;
    double secondsAmount;
    double otherFounds;

    public Mix(double smsAmount, double mmsAmount, double secondsAmount, double otherFounds) {
        this.smsAmount = smsAmount;
        this.mmsAmount = mmsAmount;
        this.secondsAmount = secondsAmount;
        this.otherFounds = otherFounds;
    }

    @Override
    public void sendSms() {
        if (smsAmount > 0) {
            smsAmount--;
            System.out.println("SMS wysłany");
        } else if (otherFounds > 0) {
            otherFounds -= SMS_COST;
            System.out.println("SMS wysłany z dodatkowych środków");
        } else {
            System.out.println("SMS niewysłany");
        }
    }

    @Override
    public void sendMms() {
        if (mmsAmount > 0) {
            mmsAmount--;
            System.out.println("MMS wysłany");
        } else if (otherFounds > 0) {
            otherFounds -= MMS_COST;
            System.out.println("MMS wysłany z dodatkowych środków");
        } else {
            System.out.println("MMS niewysłany");
        }
    }

    @Override
    public void call(int seconds) {
        if (secondsAmount > 0) {
            secondsAmount -= seconds;
        } else if (otherFounds > 0) {
            otherFounds -= (CALLING_COST_PER_MINUTE / 60 * seconds);
        } else {
            System.out.println("Nie możesz już dzwonić, wykorzystałeś wszystkie środki");
        }
    }

    @Override
    public void printAccountState() {
        System.out.println("=== MIX ===");
        System.out.println("Pozostało Ci jeszcze: " + smsAmount + " SMSów");
        System.out.println("Pozostało Ci jeszcze: " + mmsAmount + " MMSów");
        System.out.println("Pozostało Ci jeszcze: " + secondsAmount + " sekund rozmowy");
        System.out.println("Pozostałe środki do wydania: " + otherFounds);
    }
}

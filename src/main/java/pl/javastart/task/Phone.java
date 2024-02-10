package pl.javastart.task;

class Phone {
    private MobileOperatorContract mobileOperatorContract;
    private int smsCounter = 0;
    private int mmsCounter = 0;
    private int callCounter = 0;

    public Phone(MobileOperatorContract mobileOperatorContract) {
        this.mobileOperatorContract = mobileOperatorContract;
    }

    public void sendSms() {
        if (mobileOperatorContract.possibleToSendSms()) {
            smsCounter++;
            mobileOperatorContract.sendSms();
            System.out.println("SMS wysłany");
            System.out.println();
        } else {
            System.out.println("SMS niewysłany");
        }
    }

    public void call(int seconds) {
        int callSeconds = mobileOperatorContract.makeCall(seconds);
        if (callSeconds == seconds) {
            callCounter += seconds;
            System.out.println("Rozmowa trwała " + seconds + " sekund");
        } else if (callSeconds > 0) {
            callCounter += callSeconds;
            System.out.println("Rozmowa przerwana po " + callSeconds + " sekundach");
        } else {
            System.out.println("Nie można zadzwonić");
        }
    }

    public void sendMms() {
        if (mobileOperatorContract.possibleToSendMms()) {
            mmsCounter++;
            mobileOperatorContract.sendMms();
            System.out.println("MMS wysłany");
        } else {
            System.out.println("MMS niewysłany");
        }
    }

    public void printAccountState() {
        System.out.println();
        System.out.println("=== STAN KONTA ===");
        System.out.println("Wysłanych SMSów: " + smsCounter);
        System.out.println("Wysłanych MMSów: " + mmsCounter);
        System.out.println("Liczba sekund rozmów: " + callCounter);
        System.out.println(mobileOperatorContract.accountInfo());

    }

    public MobileOperatorContract getMobileOperatorContract() {
        return mobileOperatorContract;
    }

    public void setMobileOperatorContract(MobileOperatorContract mobileOperatorContract) {
        this.mobileOperatorContract = mobileOperatorContract;
    }

    public int getSmsCounter() {
        return smsCounter;
    }

    public void setSmsCounter(int smsCounter) {
        this.smsCounter = smsCounter;
    }

    public int getMmsCounter() {
        return mmsCounter;
    }

    public void setMmsCounter(int mmsCounter) {
        this.mmsCounter = mmsCounter;
    }

    public int getCallCounter() {
        return callCounter;
    }

    public void setCallCounter(int callCounter) {
        this.callCounter = callCounter;
    }
}

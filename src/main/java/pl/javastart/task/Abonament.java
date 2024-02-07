package pl.javastart.task;

class Abonament implements MobileOperator {
    double abonamentPrice;

    Abonament(double abonamentPrice) {
        this.abonamentPrice = abonamentPrice;
    }

    @Override
    public void sendMms() {
        System.out.println("=== ABONAMENT NO LIMIT ===");
        System.out.println("Korzystaj do woli");
        System.out.println();
    }

    @Override
    public void sendSms() {
        System.out.println("=== ABONAMENT NO LIMIT===");
        System.out.println("Korzystaj do woli");
        System.out.println();
    }

    @Override
    public void call(int seconds) {
        System.out.println("=== ABONAMENT NO LIMIT===");
        System.out.println("Korzystaj do woli");
        System.out.println();
    }

    @Override
    public void printAccountState() {
        System.out.println("=== ABONAMENT NO LIMIT===");
        System.out.println("Kwota do zaplaty: " + abonamentPrice);
        System.out.println();
    }
}

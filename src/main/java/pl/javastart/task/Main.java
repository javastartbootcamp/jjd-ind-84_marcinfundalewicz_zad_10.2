package pl.javastart.task;

public class Main {

    public static void main(String[] args) {
        //pytanie dotyczace tego zadania:
        //zastosowalem tutaj interfes MobileOperator, poniewaz mam w nim zdefiniowane tylko metody
        //normalnie zrobilbym klase abstrakcyjna MobileOperator oraz klasy Card, Abonament oraz Mix, ktore po niej dziedzicza
        //wtedy w klasie Phone stworzylbym pole MobileOperator mobileOperator
        //i w konstruktorze Phone poprzez polimorfizm stworzylbym np new Card, new Abonament lub new Mix
        //czy w przypadku interfejsu dziala to tak samo ? jezeli klasy Card, Abonament oraz Mix implementuja interfejs MobileOperator to tez po
        //nim dziedzicza jak w przypadku klas abstrakcyjnych i w konstruktorze Phone moge rowniez stworzyc new Card, new Abonament lub new Mix ? ?
        Phone phone = new Phone(new Card(50, 0.1, 0.2, 0.5));
        phone.printAccountState();
        phone.call(30);
        phone.printAccountState();
        phone.sendSms();
        phone.sendMms();
        phone.printAccountState();
        phone.sendSms();
        phone.printAccountState();
        phone.sendSms();
        phone.printAccountState();
    }
}

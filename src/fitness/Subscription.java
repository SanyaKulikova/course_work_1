package fitness;

import java.time.LocalDate;
import java.util.Random;

public class Subscription {

    private SubscriptionType type;
    private LocalDate dateOfRegistration;
    private LocalDate dateOfEndingRegistration;
    private Customer client;

    public Subscription(SubscriptionType type, LocalDate dateOfRegistration, Customer client) {
        this.type = type;
        this.dateOfRegistration = dateOfRegistration;
        if ( type == SubscriptionType.ONETIME) {
            setDateOfEndingRegistration(dateOfRegistration.plusDays(1));
        } else {
            setDateOfEndingRegistration(dateOfRegistration.plusMonths(6)); //  считаю, что все абонименты
            // этого фитнес зала полугодовые
        }
        this.client = client;
    }

    public SubscriptionType getType() {
        return type;
    }

    public void setType(SubscriptionType type) {
        this.type = type;
    }

    public LocalDate getDateOfRegistrationAndDateOfEndingRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(LocalDate dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public LocalDate getDateOfEndingRegistration() {
        return dateOfEndingRegistration;
    }

    private void setDateOfEndingRegistration(LocalDate dateOfEndingRegistration) {
        this.dateOfEndingRegistration = dateOfEndingRegistration;
    }

    public Customer getClient() {
        return client;
    }

    public void setClient(Customer client) {
        this.client = client;
    }

    /*public void setDurationOfSubscription(SubscriptionType type) {
        //  я хочу чтобы метод задавал дату конца регистрации на основании типа абонимента
        if ( type == SubscriptionType.ONETIME) {
            setDateOfEndingRegistration(dateOfRegistration.plusDays(1));
        } else {
            setDateOfEndingRegistration(dateOfRegistration.plusMonths(6)); //  считаю, что все абонименты
            // этого фитнес зала полугодовые
        }
    }*/

    public static Subscription generateAboniment(){
        Random random = new Random();
        String[] names = {"Мария", "Лиана", "Дарья", "Вероника", "Елена", "Адель", "Кристина", "Валерия", "Лидия"};
        // это будет женский фитнес клуб
        String[] surnames = {"Балконская", "Ростова", "Обломова", "Ильинская", "Ульянова", "Базарова", "Троцкая", "Мурина", "Раскольникова", "Остин"};
        int typesCount = SubscriptionType.values().length;
        Subscription aboniment = new Subscription(SubscriptionType.getSubscriptionType(random.nextInt(typesCount)),
                LocalDate.now().minusDays(random.nextInt(200)),
                new Customer(names[random.nextInt(names.length)], surnames[random.nextInt(surnames.length)],
                        random.nextInt(2004 - 1950) + 1950));
        return aboniment;
    }




    @Override
    public String toString() {
        return "fitness.Subscription{" +
                "type=" + type +
                ", dateOfRegistration=" + dateOfRegistration +
                ", dateOfEndingRegistration=" + dateOfEndingRegistration +
                ", client=" + client +
                '}';
    }
}


package fitness;

import java.time.LocalDate;
import java.util.Objects;
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


    public static Subscription generateAboniment(){
        Random random = new Random();
        String[] names = {"Мария", "Лиана", "Дарья", "Вероника", "Елена", "Адель", "Кристина", "Валерия", "Лидия"};
        // это будет женский фитнес клуб
        String[] surnames = {"Балконская", "Ростова", "Обломова", "Ильинская", "Ульянова", "Базарова", "Троцкая", "Мурина", "Раскольникова", "Остин"};
        int typesCount = SubscriptionType.values().length;
        Subscription aboniment = new Subscription(SubscriptionType.getSubscriptionType(random.nextInt(typesCount)),
                LocalDate.now().minusDays(random.nextInt(184)),
                new Customer(names[random.nextInt(names.length)], surnames[random.nextInt(surnames.length)],
                        random.nextInt(2004 - 1950) + 1950));
        return aboniment;
    }

    // переопределение метода equals, так как они не сравниваются через =
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscription that = (Subscription) o;

        if (type != that.type) return false;
        if (!Objects.equals(dateOfRegistration, that.dateOfRegistration))
            return false;
        if (!Objects.equals(dateOfEndingRegistration, that.dateOfEndingRegistration))
            return false;
        return Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (dateOfRegistration != null ? dateOfRegistration.hashCode() : 0);
        result = 31 * result + (dateOfEndingRegistration != null ? dateOfEndingRegistration.hashCode() : 0);
        result = 31 * result + (client != null ? client.hashCode() : 0);
        return result;
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


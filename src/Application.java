import fitness.Customer;
import fitness.Fitness;
import fitness.Subscription;
import fitness.SubscriptionType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class Application {
    public static void main(String[] args) {

        Subscription aboniment01 = Subscription.generateAboniment();
        Subscription aboniment02 = Subscription.generateAboniment();
        Subscription aboniment03 = Subscription.generateAboniment();
        Subscription aboniment04 = Subscription.generateAboniment();
        Subscription aboniment05 = Subscription.generateAboniment();
        Subscription aboniment06 = Subscription.generateAboniment();
        Subscription aboniment07 = Subscription.generateAboniment();
        Subscription aboniment08 = Subscription.generateAboniment();
        Subscription aboniment09 = Subscription.generateAboniment();
        Subscription aboniment10 = Subscription.generateAboniment();
        Subscription aboniment11 = Subscription.generateAboniment();
        Subscription aboniment12 = Subscription.generateAboniment();
        Subscription aboniment13 = Subscription.generateAboniment();
        Subscription aboniment14 = Subscription.generateAboniment();
        Subscription aboniment15 = Subscription.generateAboniment();
        Subscription aboniment16 = Subscription.generateAboniment();
        Subscription aboniment17 = Subscription.generateAboniment();
        Subscription aboniment18 = Subscription.generateAboniment();
        Subscription aboniment19 = Subscription.generateAboniment();
        Subscription aboniment20 = Subscription.generateAboniment();
        Subscription aboniment21 = Subscription.generateAboniment();
        Subscription aboniment22 = Subscription.generateAboniment();
        Subscription aboniment23 = Subscription.generateAboniment();
        Subscription aboniment24 = Subscription.generateAboniment();
        Subscription aboniment25 = Subscription.generateAboniment();
        Subscription aboniment26 = Subscription.generateAboniment();
        Subscription aboniment27 = Subscription.generateAboniment();
        Subscription aboniment28 = Subscription.generateAboniment();
        Subscription aboniment29 = Subscription.generateAboniment();
        Subscription aboniment30 = Subscription.generateAboniment();

        LocalDateTime testTime01 = LocalDateTime.of(2022, Month.OCTOBER, 20, 15, 45);
        LocalDateTime testTime02 = LocalDateTime.now();
        String strWithDate01 = "2022-05-14T23:10:00";
        LocalDateTime testTime03 = LocalDateTime.parse(strWithDate01);
        String strWithDate02 =  "22 декабря 2022 в 16 30";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy в HH mm");
        LocalDateTime testTime04 = LocalDateTime.parse(strWithDate02, dtf);

        Fitness fitness = new Fitness();
        System.out.println(fitness);

        System.out.println(aboniment01);
        fitness.registerInGroupWorkouts(testTime02,aboniment01);
        System.out.println(aboniment02);
        fitness.registerInGroupWorkouts(testTime01, aboniment02);
        fitness.registerInGym(testTime01, aboniment02);
        System.out.println(aboniment03);
        fitness.registerInSwimmingPool(testTime04,aboniment03);
        System.out.println(aboniment04);
        fitness.registerInSwimmingPool(testTime04,aboniment04);
        System.out.println(aboniment05);
        fitness.registerInSwimmingPool(testTime04,aboniment05);
        System.out.println(aboniment06);
        fitness.registerInSwimmingPool(testTime04,aboniment06);
        System.out.println(aboniment07);
        fitness.registerInSwimmingPool(testTime04,aboniment07);
        System.out.println(aboniment08);
        fitness.registerInGym(testTime04, aboniment08);
        System.out.println(fitness);










    }
}

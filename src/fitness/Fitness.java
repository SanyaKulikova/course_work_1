package fitness;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Fitness {

    private Subscription[] registeredInGym = new Subscription[20];
    private Subscription[] registeredInSwimmingPull = new Subscription[20];
    private Subscription[] registeredInGroupWorkouts = new Subscription[20];


    public Subscription[] getRegisteredInGym() {
        return registeredInGym;
    }

    public void setRegisteredInGym(Subscription[] registeredInGym) {
        this.registeredInGym = registeredInGym;
    }

    public Subscription[] getRegisteredInSwimmingPull() {
        return registeredInSwimmingPull;
    }

    public void setRegisteredInSwimmingPull(Subscription[] registeredInSwimmingPull) {
        this.registeredInSwimmingPull = registeredInSwimmingPull;
    }

    public Subscription[] getRegisteredInGroupWorkouts() {
        return registeredInGroupWorkouts;
    }

    public void setRegisteredInGroupWorkouts(Subscription[] registeredInGroupWorkouts) {
        this.registeredInGroupWorkouts = registeredInGroupWorkouts;
    }

    // TODO написать методы добовления в массивы -  зоны
    //  Должны принмать на вход дату-время (после 22 до 8  - пустой массив)
    //  если абонемент просрочен,
    //  если он пытается пройти в зону, которая не разрешена по его абонементу,
    //  если в зоне нет свободных мест
    //  (если в такой абонимент уже зарегестрирован в другой зоне)

    // в тренажорный зал попасть могут все, только в дневном абонименте ограничение по времени
    public void registerInGym(LocalDateTime time, Subscription aboniment){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy в HH:mm");
        String dateTimeToStr = formatter.format(time);

        if (!this.isOpen(time)) {
            System.out.println("Фитнес зал работает с 8 утра и до 22 вечера");
            return;
        } else if (time.toLocalDate().isAfter(aboniment.getDateOfEndingRegistration())) {
            System.out.println("Ваш абонимент просрочен");
        } else if (aboniment.getType() == SubscriptionType.NOONTIME && time.getHour() >= 16) {
            System.out.println("По вашему абонименту тренажорный зал можно посещать только до 16 часов");
        } else {
            int test = 0;
            for (int j = 0; j < registeredInSwimmingPull.length; j++) {
                if (registeredInSwimmingPull[j] == aboniment) {
                    System.out.println("Вы не можете одновременно заниматься в нескольких местах");
                    test++;
                } else if (registeredInGroupWorkouts[j] == aboniment) {
                    System.out.println("Вы не можете одновременно заниматься в нескольких местах");
                    test++;
                }
            }
            if (test == 0) {
                for (int i = 0; i < registeredInGym.length; i++) {
                    if (registeredInGym[i] == null) {
                        registeredInGym[i] = aboniment;
                        System.out.println(aboniment.getClient().getSurname() + " " + aboniment.getClient().getName()
                                + " Посещение тренажорного зала " + dateTimeToStr);
                        return;
                    }
                }
                System.out.println("Вы не можете пройти в данную зону, так как все места заняты");
            }
        }
    }

    // только разовый и полный
    public void registerInSwimmingPool(LocalDateTime time, Subscription aboniment) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy в HH:mm");
        String dateTimeToStr = formatter.format(time);

        if (!this.isOpen(time)) {
            System.out.println("Фитнес зал работает с 8 утра и до 22 вечера");
            return;
        } else if (time.toLocalDate().isAfter(aboniment.getDateOfEndingRegistration())) {
            System.out.println("Ваш абонимент просрочен");
        } else if (aboniment.getType() == SubscriptionType.NOONTIME) {
            System.out.println("По вашему абонименту нельзя посещать бассейн");
        } else {
            int test = 0;
            for (int j = 0; j < registeredInGym.length; j++) {
                if (registeredInGym[j] == aboniment) {
                    System.out.println("Вы не можете одновременно заниматься в нескольких местах");
                    test++;
                } else if (registeredInGroupWorkouts[j] == aboniment) {
                    System.out.println("Вы не можете одновременно заниматься в нескольких местах");
                    test++;
                }
            }
            if (test == 0) {
                for (int i = 0; i < registeredInSwimmingPull.length; i++) {
                    if (registeredInSwimmingPull[i] == null) {
                        registeredInSwimmingPull[i] = aboniment;
                        System.out.println(aboniment.getClient().getSurname() + " " + aboniment.getClient().getName()
                                + " Посещение бассейна " + dateTimeToStr);
                        return;
                    }
                }
                System.out.println("Вы не можете пройти в данную зону, так как все места заняты");
            }
        }
    }

    // полный и дневной до 16
    public void registerInGroupWorkouts(LocalDateTime time, Subscription aboniment) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy в HH:mm");
        String dateTimeToStr = formatter.format(time);

        if (!this.isOpen(time)) {
            System.out.println("Фитнес зал работает с 8 утра и до 22 вечера");
            return;
        } else if (time.toLocalDate().isAfter(aboniment.getDateOfEndingRegistration())) {
            System.out.println("Ваш абонимент просрочен");
        } else if (aboniment.getType() == SubscriptionType.NOONTIME && time.getHour() >= 16) {
            System.out.println("По вашему абонименту тренажорный зал можно посещать только до 16 часов");
        } else if (aboniment.getType() == SubscriptionType.ONETIME) {
            System.out.println("По вашему абонименту нельзя посетить групповые занятия");
        } else {
            int test = 0;
            for (int j = 0; j < registeredInSwimmingPull.length; j++) {
                if (registeredInSwimmingPull[j] == aboniment) {
                    System.out.println("Вы не можете одновременно заниматься в нескольких местах");
                    test++;
                } else if (registeredInGym[j] == aboniment) {
                    System.out.println("Вы не можете одновременно заниматься в нескольких местах");
                    test++;
                }
            }
            if (test == 0) {
                for (int i = 0; i < registeredInGroupWorkouts.length; i++) {
                    if (registeredInGroupWorkouts[i] == null) {
                        registeredInGroupWorkouts[i] = aboniment;
                        System.out.println(aboniment.getClient().getSurname() + " " + aboniment.getClient().getName()
                                + " Посещение групповых занятий " + dateTimeToStr);
                        return;
                    }
                }
                System.out.println("Вы не можете пройти в данную зону, так как все места заняты");
            }
        }
    }

    public boolean isOpen(LocalDateTime time) {
        if (time.getHour() >= 22 ||  time.getHour() < 8) {
            registeredInGym = new Subscription[20];
            registeredInSwimmingPull = new Subscription[20];
            registeredInGroupWorkouts = new Subscription[20];
            System.out.println(this);
            return false;
        } else return true;
    }


    // Реализовать возможность вывода информации о посетителях:
    // сначала посетителях тренажерного зала, потом бассейна, потом групповых занятий.
    // Это оно?
    @Override
    public String toString() {
        return "fitness.Fitness{" +
                "registeredInGym=" + Arrays.toString(registeredInGym) +
                ", registeredInSwimmingPull=" + Arrays.toString(registeredInSwimmingPull) +
                ", registeredInGroupWorkouts=" + Arrays.toString(registeredInGroupWorkouts) +
                '}';
    }






}

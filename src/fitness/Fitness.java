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


    public void registerInZone(LocalDateTime time, Zone zone, Subscription aboniment) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy в HH:mm");
        String dateTimeToStr = formatter.format(time);

        if (!this.isOpen(time)) {
            System.out.println("Фитнес зал работает с 8 утра и до 22 вечера");
            return; // если мы делаем таК: то не else if а полноценный новый if
        }
        if (time.toLocalDate().isAfter(aboniment.getDateOfEndingRegistration())) {
            System.out.println("Ваш абонимент просрочен");
            return;
        }
        if (time.getHour() >= aboniment.getType().getTimeOfEndWork().getHour()) {
            System.out.println("Проход по вашему абонименту не доступен после " + aboniment.getType().getTimeOfEndWork().getHour()
                    + " часов");
            return;
        }
        switch (zone) {
            case GYM -> {
                if (!isAlreadyRegistered(aboniment, registeredInGym) && isZoneValid(zone, aboniment)) addToMassive(aboniment, zone, time);
                else System.out.println("Вы не можете одновременно заниматься в нескольких местах");
            }
            case SWIMMINGPOOL -> {
                if (!isAlreadyRegistered(aboniment, registeredInSwimmingPull) && isZoneValid(zone, aboniment)) addToMassive(aboniment, zone, time);
                else System.out.println("Вы не можете одновременно заниматься в нескольких местах");
            }
            case GROUPWORKOUTS -> {
                if (!isAlreadyRegistered(aboniment, registeredInGroupWorkouts) && isZoneValid(zone, aboniment)) addToMassive(aboniment, zone, time);
                else System.out.println("Вы не можете одновременно заниматься в нескольких местах");
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


    // private - так как импоьзуется только в классе Fitness
    private void addToMassive(Subscription aboniment, Zone zone, LocalDateTime time){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy в HH:mm");
        String dateTimeToStr = formatter.format(time);
        if (zone.equals(Zone.GYM)) {
            for (int i = 0; i < registeredInGym.length; i++) {
                if (registeredInGym[i] == null) {
                    registeredInGym[i] = aboniment;
                    System.out.println(aboniment.getClient().getSurname() + " " + aboniment.getClient().getName()
                           + " Посещение тренажорного зала " + dateTimeToStr);
                    return;
                }
            }
            System.out.println("Вы не можете пройти в данную зону, так как все места заняты");
        } else if (zone.equals(Zone.SWIMMINGPOOL)) {
            for (int i = 0; i < registeredInSwimmingPull.length; i++) {
                if (registeredInSwimmingPull[i] == null) {
                    registeredInSwimmingPull[i] = aboniment;
                    System.out.println(aboniment.getClient().getSurname() + " " + aboniment.getClient().getName()
                            + " Посещение бассейна " + dateTimeToStr);
                    return;
                }
            }
            System.out.println("Вы не можете пройти в данную зону, так как все места заняты");
        } else if (zone.equals(Zone.GROUPWORKOUTS)) {
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

    private boolean isAlreadyRegistered(Subscription aboniment, Subscription[] Subscriptions){
        for (Subscription subscription: Subscriptions) {
            if (subscription.equals(aboniment)) return true;
        }
        return false;
    }

    /* private boolean isAlreadyRegistered(Subscription aboniment) {
        boolean result = false;
        for (int j = 0; j < registeredInSwimmingPull.length; j++) {
            if (registeredInSwimmingPull.equals(aboniment)) {// сравнивала registeredInSwimmingPull[j] == aboniment
                // нужно через equals (и переопределит его для начала))
                result = true;
            } else if (registeredInGym[j].equals(aboniment)) {
                result = true;
            } else if (registeredInGroupWorkouts[j].equals(aboniment)) {
                result = true;
            }
        }
        return result;
    }*/


    public boolean isZoneValid(Zone zone, Subscription aboniment){
        for (Zone isZone: aboniment.getType().getZones()) {
            if (zone.equals(isZone)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Fitness{" +
                "registeredInGym=" + Arrays.toString(registeredInGym) +
                ", registeredInSwimmingPull=" + Arrays.toString(registeredInSwimmingPull) +
                ", registeredInGroupWorkouts=" + Arrays.toString(registeredInGroupWorkouts) +
                '}';
    }




}

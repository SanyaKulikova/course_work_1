package fitness;

import java.time.LocalTime;

public enum SubscriptionType {
ONETIME(new Zone[]{Zone.GYM, Zone.SWIMMINGPOOL}, LocalTime.of(22, 00)),
NOONTIME(new Zone[]{Zone.GYM, Zone.GROUPWORKOUTS}, LocalTime.of(16,00)),
FULL(new Zone[]{Zone.GYM, Zone.SWIMMINGPOOL, Zone.GROUPWORKOUTS}, LocalTime.of(22,00));

private Zone[] zones;
private LocalTime timeOfEndWork;

SubscriptionType(Zone[] zones, LocalTime timeOfEndWork){
    this.zones = zones;
    this.timeOfEndWork = timeOfEndWork;
}

    public Zone[] getZones() {
        return zones;
    }

    public void setZones(Zone[] zones) {
        this.zones = zones;
    }

    public LocalTime getTimeOfEndWork() {
        return timeOfEndWork;
    }

    public void setTimeOfEndWork(LocalTime timeOfEndWork) {
        this.timeOfEndWork = timeOfEndWork;
    }

    public static SubscriptionType getSubscriptionType (int ord){
        for (SubscriptionType st: values()){ // то есть идет пербор массива
            if (ord == st.ordinal()) { // если то , что передали равно индексу в массиве
                return st;
            }
        }
        throw new AssertionError("Wrong ordinal: " + ord);
    }
}

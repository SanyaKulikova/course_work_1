package fitness;

public enum SubscriptionType {
ONETIME, NOONTIME, FULL;

public static SubscriptionType getSubscriptionType (int ord){
        for (SubscriptionType st: values()){ // то есть идет пербор массива
            if (ord == st.ordinal()) { // если то , что передали равно индексу в массиве
                return st;
            }
        }
        throw new AssertionError("Wrong ordinal: " + ord);
    }
}

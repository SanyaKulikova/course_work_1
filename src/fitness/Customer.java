package fitness;

public class Customer {

    private String name;
    private String surname;
    private int yearOfBirth;

    public Customer(String name, String surname, int yearOfBirth) {
        setName(name);
        setSurname(surname);
        setYearOfBirth(yearOfBirth);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) throw new IllegalArgumentException("Введите имя");
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null) throw new IllegalArgumentException("Введите фамилию");
        this.surname = surname;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        if (yearOfBirth == 0 || yearOfBirth < 0) throw new IllegalArgumentException("Введите год рождения");
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "fitness.Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
}

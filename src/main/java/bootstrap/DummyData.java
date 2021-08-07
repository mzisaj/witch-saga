package bootstrap;

import model.Person;

import java.util.List;

public class DummyData {

    public static List<Integer> getAllKills() {
        return List.of(1, 1, 2, 3, 5);
    }

    public static List<Person> getPeople() {
        return List.of(createPerson("Person A", 10, 12),
                createPerson("Person B", 13, 17));
    }

    private static Person createPerson(String name, int ageOfDeath, int yearOfDeath) {
        Person person = new Person();
        person.setName(name);
        person.setAgeOfDeath(ageOfDeath);
        person.setYearOfDeath(yearOfDeath);

        return person;
    }
}

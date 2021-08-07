package service;

import model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.PersonRepository;

import java.util.List;

public class PersonService {

    private final PersonRepository personRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    private int calculateKills(List<Person> people, List<Integer> yearKills) {
        int sum = 0;
        for (Person person : people) {
            int bornYear = calculateBornYear(person);
            int killsPerYear = calculateKillsPerYear(yearKills, bornYear);
            //Throw exception if bornYear is bigger than years that the witch has shown
            if (bornYear > yearKills.size()) {
                throw new IllegalArgumentException("Invalid value! Born year shouldn't be bigger than the years .");
            }
            LOGGER.info(person.getName() + " born on Year: "
                    + bornYear + ", number of people killed on year " + bornYear + " is " + killsPerYear);
            sum += killsPerYear;
        }
        return sum;
    }

    private int calculateKillsPerYear(List<Integer> kills, int specificYear) {
        return kills.stream().limit(specificYear).mapToInt(Integer::intValue).sum();
    }

    private int calculateBornYear(Person person) {
        int bornYear = person.getYearOfDeath() - person.getAgeOfDeath();
        if (bornYear < 1) {
            throw new IllegalArgumentException("Born year can't be less than 1.");
        }
        return bornYear;
    }

    public double getAllKills(List<Person> people, List<Integer> kills) {
        int totalKills = calculateKills(people, kills);
        double averageKills = personRepository.calculateAverageKills(totalKills, people.size());
        LOGGER.info("Average kills: " + averageKills);
        return averageKills;
    }
}

package service;

import model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.PersonRepositoryImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class PersonServiceTest {

    private Person person;
    private List<Integer> kills;
    private PersonRepositoryImpl personRepository;

    @BeforeEach
    void setUp() {
        person = new Person();
        person.setName("Test");
        kills = List.of(4);
        personRepository = getPersonRepositoryImpl();
    }

    @Test
    void calculateKillsIsIllegal() {
        person.setYearOfDeath(15);
        person.setAgeOfDeath(12);
        List<Person> people = createPeopleList(person);
        PersonService personService = new PersonService(personRepository);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> personService.getAllKills(people, kills));
        assertEquals("Invalid value! Born year shouldn't be bigger than the years .", exception.getMessage());
    }

    @Test
    void bornYearIsIllegal() {
        person.setYearOfDeath(10);
        person.setAgeOfDeath(12);
        List<Person> people = createPeopleList(person);
        PersonService personService = new PersonService(personRepository);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> personService.getAllKills(people, kills));
        assertEquals("Born year can't be less than 1.", exception.getMessage());
    }

    @Test
    void getAllKills() {
        person.setYearOfDeath(13);
        person.setAgeOfDeath(12);
        List<Person> people = createPeopleList(person);
        PersonService personService = new PersonService(personRepository);
        double average = personService.getAllKills(people, kills);
        assertEquals(4, average);
        verify(personRepository, times(1)).calculateAverageKills(anyInt(), anyInt());
    }

    private List<Person> createPeopleList(Person person) {
        return List.of(person);
    }

    private PersonRepositoryImpl getPersonRepositoryImpl() {
        PersonRepositoryImpl personRepository = mock(PersonRepositoryImpl.class);
        when(personRepository.calculateAverageKills(anyInt(), anyInt())).thenReturn((double) 4);
        return personRepository;
    }
}
package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonTest {

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @Test
    void setYearOfDeathPositiveNumber() {
        person.setYearOfDeath(1);
        assertEquals(1, person.getYearOfDeath());
    }

    @Test
    void setYearOfDeathNegativeNumber() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> person.setYearOfDeath(-1));
        assertEquals("Negative numbers are not allowed. Field: yearOfDeath", exception.getMessage());
    }

    @Test
    void setAgeOfDeathPositiveNumber() {
        person.setAgeOfDeath(3);
        assertEquals(3, person.getAgeOfDeath());
    }

    @Test
    void setAgeOfDeath() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> person.setAgeOfDeath(-3));
        assertEquals("Negative numbers are not allowed. Field: ageOfDeath", exception.getMessage());
    }
}
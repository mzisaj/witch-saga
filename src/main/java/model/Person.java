package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;
    private int ageOfDeath;
    private int yearOfDeath;

    public void setName(String name) {
        this.name = name;
    }

    public void setAgeOfDeath(int ageOfDeath){
        //Control if the field has negative value
        checkNegativeValues(ageOfDeath, "ageOfDeath");
        this.ageOfDeath = ageOfDeath;
    }

    public void setYearOfDeath(int yearOfDeath){
        //Control if the field has negative value
        checkNegativeValues(yearOfDeath, "yearOfDeath");
        this.yearOfDeath = yearOfDeath;
    }

    private void checkNegativeValues(int value, String fieldName) {
        if (value < 0) {
            try {
                throw new IllegalArgumentException("Negative numbers are not allowed. Field: " + Person.class.getDeclaredField(fieldName).getName());
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }
}

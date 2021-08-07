import bootstrap.DummyData;
import model.Person;
import repository.PersonRepositoryImpl;
import service.PersonService;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        PersonService personService = new PersonService(new PersonRepositoryImpl());
        List<Integer> list = DummyData.getAllKills();
        List<Person> people = DummyData.getPeople();
        personService.getAllKills(people, list);
    }
}

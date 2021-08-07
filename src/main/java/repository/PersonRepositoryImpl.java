package repository;

public class PersonRepositoryImpl implements PersonRepository {

    @Override
    public double calculateAverageKills(int totalKills, int numberOfPeople) {
        return (double) totalKills / numberOfPeople;
    }
}

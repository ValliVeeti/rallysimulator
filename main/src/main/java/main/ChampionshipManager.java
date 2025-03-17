package main;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ChampionshipManager {

    private static ChampionshipManager instance;
    static List<Driver> drivers = new ArrayList<>();
    static List<Object> races = new ArrayList<>();
    static int totalDrivers;
    static int totalRaces;

    static Driver leadDriver;

    static List<Map.Entry<String,String>> participatingCars = new ArrayList<>();
  

    private ChampionshipManager(){
        createCars();
    }

    public static ChampionshipManager getInstance(){
        if(instance==null){
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public static void createCars(){
        participatingCars.add(new AbstractMap.SimpleEntry<>("Toyota", "Yaris"));
        participatingCars.add(new AbstractMap.SimpleEntry<>("Subaru", "Impreza"));
        participatingCars.add(new AbstractMap.SimpleEntry<>("Mitsubishi", "Lancer"));
        participatingCars.add(new AbstractMap.SimpleEntry<>("Lancia", "Integrale"));
    }

    void registerDriver(Driver driver){
        drivers.add(driver);
        totalDrivers++;
    }

    void addRaceResult(RallyRaceResult rallyresult){
        races.add(rallyresult.getResults());
    }

    void getDriverStandings(){
//https://medium.com/@shivamtyagicool/java-object-sorting-techniques-comparator-and-modern-java-features-309e4390a7ca

        System.out.println("\n=== Championship Standings ===");
        drivers.sort(Comparator.comparingInt(Driver::getPoints).reversed());

        leadDriver = drivers.get(0);

        for (Driver driver : drivers) {
            System.out.println(driver.getName()+": "+ driver.getPoints());
        }

    }

    Driver getLeadingDriver(){
        return leadDriver;
    }

    int getTotalChampionshipPoints(){
        int totalPoints = 0;
        for (Driver driver : drivers) {
            totalPoints += driver.getPoints();
        };
        return totalPoints;
    }

    void startRace(String race, String location){
        RallyRaceResult rs = new RallyRaceResult(race, location, null, participatingCars);
        rs.startRace(drivers, races, participatingCars);
        races.add(rs.getResults());
    }

    void getRaceResults() {
        System.out.println("\n=== RACE RESULTS ===");
        for (Object race : races) {
            List<Object[]> results = (List<Object[]>) race;
            for (Object[] driverResult : results) {
                System.out.println("Race: "+driverResult[0]+" "+ driverResult[1] + ": " + driverResult[3] + " points, in a " + driverResult[4]);
            }

        }
    }
}

package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RallyRaceResult implements RaceResult{
    private String raceName;
    private String location;
    private List<Object> raceResults = new ArrayList<>();
    public RallyRaceResult(String raceName, String location, Object raceResults, List<Map.Entry<String,String>> participatingCars){
        this.raceName = raceName;
        this.location = location;
    }
    
    //ended up not using this
    @Override
    public int getDriverPoints(Driver driver) {
        return 0;
    }

    //Simulate the race
    public void startRace(List<Driver> drivers, List<Object> races, List<Map.Entry<String,String>> participatingCars) {
        Random random = new Random();

        //assign random cars to drivers, randomise horsepower and suspensiontravel/downforce in given ranges for some randomness
        for (Driver driver : drivers) {
            Map.Entry<String, String> randomCar = participatingCars.get(random.nextInt(participatingCars.size()));
            driver.setCar(new AsphaltCar(randomCar.getKey(), randomCar.getValue() , random.nextInt(450, 600), random.nextInt(10)));
        }

        //calculate success with an algorithm from the car and assign points accordingly
        for (Driver driver : drivers){
            int points = driver.getCar().calculatePerformance();
            recordResult(driver, 0, points);
        }

    }

    public String getLocation() {
        return location;
    }

    public String getRaceName() {
        return raceName;
    }

    @Override
    public List getResults() {
        return raceResults;
    }

    //Record the result of the races
    @Override
    public void recordResult(Driver driver, int position, int points) {
        raceResults.add(new Object[]{raceName, driver.getName(), position, points, driver.getCar().getMake()});
        driver.addPoints(points);
    }
}
package main;

import java.util.Random;

public class GravelCar extends RallyCar {
    private double suspensionTravel;
    public GravelCar(String make, String model, int horsepower, double suspensionTravel){
        super(make, model, horsepower);
        this.suspensionTravel=suspensionTravel;
    }

    //made a random function for calculating performance and implementing some randomness into the results. 
    @Override
    int calculatePerformance() {
        Random random = new Random();
        double performance = (this.getHorsepower() / 50) + (suspensionTravel * 2) + random.nextInt(0,10);
        return (int)Math.round(performance);
    }
}

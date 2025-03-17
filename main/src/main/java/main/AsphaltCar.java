package main;

import java.util.Random;

public class AsphaltCar extends RallyCar {
    private double downForce;
    public AsphaltCar(String make, String model, int horsepower, double downForce){
        super(make, model, horsepower);
        this.downForce=downForce;
    }

    //made a random function for calculating performance and implementing some randomness into the results. 
    @Override
    int calculatePerformance() {
        Random random = new Random();
        double performance = (this.getHorsepower() / 50) + (downForce * 2) + random.nextInt(0,10);
        return (int)Math.round(performance);
    }
}

package main;

public class AsphaltCar extends RallyCar {
    private double downForce;
    public AsphaltCar(String make, String model, int horsepower, double downForce){
        super(make, model, horsepower);
        this.downForce=downForce;
    }

    @Override
    double calculatePerformance() {
        // TODO Auto-generated method stub
        return 0;
    }
}

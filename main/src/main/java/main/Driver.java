package main;

//self explanatory no need for comments
public class Driver {
    String name;
    String country;
    int points;
    RallyCar car;

    public Driver (String name, String country, RallyCar car){
        this.name = name;
        this.country = country;
        this.car = car;
    }

    public String getName() {
        return name;
    }
    public String getCountry() {
        return country;
    }
    public int getPoints() {
        return points;
    }
    public RallyCar getCar() {
        return car;
    }


    public void setCountry(String country) {
        this.country = country;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCar(RallyCar car) {
        this.car = car;
    }
    public void addPoints(int points) {
        this.points += points;
    }
}

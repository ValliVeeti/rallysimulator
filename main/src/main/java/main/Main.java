package main;

public class Main {
    public static void main(String[] args) {
        ChampionshipManager cm = ChampionshipManager.getInstance();

        //Generate drivers
        Driver driver1 = new Driver("Sebastian", "France", null);
        Driver driver2 = new Driver("Kalle", "Finland", null);
        Driver driver3 = new Driver("Ott", "Estonia", null);

        //append drivers to the list
        cm.registerDriver(driver1);
        cm.registerDriver(driver2);
        cm.registerDriver(driver3);


        //run races
        cm.startRace("Monte Carlo", "Monaco");
        cm.startRace("Skinnarila Circuit", "Finland");

        //get race results
        cm.getRaceResults();


        //print the final requirements
        cm.getDriverStandings();

        System.out.println("Leader: " + cm.getLeadingDriver().getName());

        System.out.println("Total points: " + cm.getTotalChampionshipPoints());
    }
}
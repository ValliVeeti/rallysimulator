package main;

import java.util.List;

public class ChampionshipManager {

    private static ChampionshipManager instance;
    List<Driver> drivers;
    List<RallyRaceResult> races;
    static int totalDrivers;
    static int totalRaces;

    static Driver leadDriver;
    private ChampionshipManager(){


    }

    public static ChampionshipManager getInstance(){
        if(instance==null){
            instance = new ChampionshipManager();
        }
        return instance;
    }

    void registerDriver(Driver driver){

    }

    void addRaceResult(RallyRaceResult rallyresult){

    }

    void getDriverStandings(){

    }

    static Driver getLeadingDriver(){
        return leadDriver;
    }

    static int getTotalChampionshipPoints(){
        return 1;
    }
}

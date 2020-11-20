import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PremierLeagueManager implements LeagueManager {

    private final int noOfClubs = 2;

    private List<FootballClub> footballLeague = new ArrayList<>();

    @Override
    public void addClub(FootballClub club) {
        if(footballLeague.size() == noOfClubs) {
            System.out.println("The league is full.Can't add a another club");
        }

        if(footballLeague.contains(club.getName())){
            System.out.println("This club is already in the league");
        }
        else {
            footballLeague.add(club);
            System.out.println("Added to the League Successfully!!!");
            System.out.println(footballLeague);
        }
    }

    @Override
    public void deleteClub(String name) {

        boolean clubName = false;

        for(FootballClub club : footballLeague) {
            if(club.getName().equals(name)){
                footballLeague.remove(club);
                clubName = true;
                System.out.println("Club "+ club.getName()+" Deleted from League Successfully!!!");
                break;
            }
        }
        if (!clubName) {
            System.out.println("Please Check Again.No club like that in League");
        }
    }

    @Override
    public void displayStatistics(String name) {

        boolean clubName = false;

        for (FootballClub club : footballLeague) {
            if(club.getName().equals(name)){
                System.out.println("----------Club Statistics-----------");
                System.out.println("Club Name : " + club.getName());
                System.out.println("Club Location : "  + club.getLocation());
                System.out.println("Number of matches Won : " + club.getWins());
                System.out.println("Number of matches Draws : " + club.getWins());
                System.out.println("Number of matches Defeats : " + club.getWins());
                System.out.println("Number of Scored Goals : " + club.getWins());
                System.out.println("Number of Received Goals : " + club.getWins());
                System.out.println("Number of Points : " + club.getWins());
                System.out.println("Number of matches Played : " + club.getWins());
                clubName = true;
            }
        }
        if (!clubName) {
            System.out.println("Please Check Again.No club like '" + name + "' in League");
        }
    }

    @Override
    public void displayLeagueTable() {
        Collections.sort(footballLeague, new PointComparator());
        for(FootballClub club : footballLeague) {
            System.out.println("Club: " + club.getName()+" Points: "+ club.getNoOfPoints()+" goal difference: "+ (club.getNoOfScoredGoals()-club.getNoOfReceivedGoals()));
        }
    }
}


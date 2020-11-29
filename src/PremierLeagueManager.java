import java.io.*;
import java.util.*;

public class PremierLeagueManager implements LeagueManager {

    private List<FootballClub> footballLeague = new ArrayList<>();
    private List<Match> matchDetails = new ArrayList<>();

    @Override
    public void addClub(FootballClub club) {

        boolean clubName = false;

        for (FootballClub newClub : footballLeague) {
            if (newClub.getName().equalsIgnoreCase(club.getName())) {
                System.out.println("This club is already in the league");
                clubName = true;
                break;
            }
        }
        if (!clubName) {
            footballLeague.add(club);
            System.out.println("Club " + club.getName() + " added to the League Successfully!!!");
        }
    }

    @Override
    public void deleteClub(String name) {

        boolean clubName = false;

        for (FootballClub club : footballLeague) {
            if (club.getName().equalsIgnoreCase(name)) {
                footballLeague.remove(club);
                clubName = true;
                System.out.println("Club " + club.getName() + " Deleted from League Successfully!!!");
                break;
            }
        }
        if (!clubName) {
            System.out.println("Please Check Again.No club like '" + name + "' in League");
        }
    }

    @Override
    public void displayStatistics(String name) {

        boolean clubName = false;

        for (FootballClub club : footballLeague) {
            if (club.getName().equalsIgnoreCase(name)) {
                System.out.println("----------Club Statistics-----------");
                System.out.println("Club Name : " + club.getName());
                System.out.println("Club Location : " + club.getLocation());
                System.out.println("Number of matches Won : " + club.getWins());
                System.out.println("Number of matches Draws : " + club.getDraws());
                System.out.println("Number of matches Defeats : " + club.getDefeats());
                System.out.println("Number of Scored Goals : " + club.getNoOfScoredGoals());
                System.out.println("Number of Received Goals : " + club.getNoOfReceivedGoals());
                System.out.println("Number of Points : " + club.getNoOfPoints());
                System.out.println("Number of matches Played : " + club.getNoOfMatchesPlayed());
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
        for (FootballClub club : footballLeague) {
            System.out.println("Club: " + club.getName() + "  Points: " + club.getNoOfPoints()
                    + "  Wins: " + club.getWins() + "  Defeats: " + club.getDefeats() + "  Draws:  " + club.getDraws());
        }
    }

    @Override
    public void addPlayedMatch() {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("-------Enter the match details-------");
            System.out.println("Enter Day (dd): ");
            int day = sc.nextInt();

            System.out.println("Enter month (mm): ");
            int month = sc.nextInt();

            System.out.println("Enter year (yyyy): ");
            int year = sc.nextInt();

            Date matchDate = new Date(day, month, year);

            System.out.println("Enter the Club 01 Name: ");
            String club1Name = sc.next();
            FootballClub club1 = null;
            for (FootballClub club : footballLeague) {
                if (club.getName().equalsIgnoreCase(club1Name))
                    club1 = club;
            }
            if (club1 == null) {
                System.out.println("Please Check Again.No club like '" + club1Name + "' in League");
                return;
            }

            System.out.println("Enter the Club 02 Name: ");
            String club2Name = sc.next();
            FootballClub club2 = null;
            for (FootballClub club : footballLeague) {
                if (club.getName().equalsIgnoreCase(club2Name))
                    club2 = club;
            }
            if (club2 == null) {
                System.out.println("Please Check Again.No club like '" + club2Name + "' in League");
                return;
            }

            System.out.println("Enter club1 team goals: ");
            int club1Score = sc.nextInt();
            if (club1Score < 0) {
                System.out.println("Please Input a correct Score.");
                return;
            }

            System.out.println("Enter club2 team goals: ");
            int club2Score = sc.nextInt();
            if (club2Score < 0) {
                System.out.println("Please Input a correct Score.");
                return;
            }

            Match match = new Match(club1, club2, club1Score, club2Score, matchDate);
            matchDetails.add(match);
            System.out.println("Match Details Added to the League Successfully!!!");

            club1.setNoOfScoredGoals(club1.getNoOfScoredGoals() + club1Score);
            club2.setNoOfScoredGoals(club2.getNoOfScoredGoals() + club2Score);
            club1.setNoOfReceivedGoals(club1.getNoOfReceivedGoals() + club2Score);
            club2.setNoOfReceivedGoals(club2.getNoOfReceivedGoals() + club1Score);
            club1.setNoOfMatchesPlayed(club1.getNoOfMatchesPlayed() + 1);
            club2.setNoOfMatchesPlayed(club2.getNoOfMatchesPlayed() + 1);

            if (club1Score > club2Score) {
                club1.setNoOfPoints(club1.getNoOfPoints() + 2);
                club1.setWins(club1.getWins() + 1);
                club2.setDefeats(club2.getDefeats() + 1);
            } else if (club1Score < club2Score) {
                club2.setNoOfPoints(club2.getNoOfPoints() + 2);
                club2.setWins(club2.getWins() + 1);
                club1.setDefeats(club1.getDefeats() + 1);
            } else {
                club1.setNoOfPoints(club1.getNoOfPoints() + 1);
                club2.setNoOfPoints(club2.getNoOfPoints() + 1);
                club1.setDraws(club1.getDraws() + 1);
                club2.setDraws(club2.getDraws() + 1);
            }
        } catch (InputMismatchException e) {
            System.out.println("Please Enter a valid Input !!! \n");
        }
    }

    @Override
    public void saveDetails() {
        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream("League_Details.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(footballLeague);
            objectOutputStream.close();
            fileOutputStream.close();

            FileOutputStream fileOutputStream2 = new FileOutputStream("Match_Details.txt");
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream2);
            objectOutputStream2.writeObject(matchDetails);
            objectOutputStream2.close();
            fileOutputStream2.close();

            System.out.println("Save the details Successfully!!!");
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    @Override
    public void loadDetails() {
        try
        {
            FileInputStream fileInputStream = new FileInputStream("League_Details.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            footballLeague = (ArrayList) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

            FileInputStream fileInputStream2 = new FileInputStream("Match_Details.txt");
            ObjectInputStream objectInputStream2 = new ObjectInputStream(fileInputStream2);

            matchDetails = (ArrayList) objectInputStream2.readObject();

            objectInputStream2.close();
            fileInputStream2.close();

            System.out.println("Loaded the details Successfully!!!");

        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("File cannot find");
            c.printStackTrace();
            return;
        }

        //Verify list data
        for (FootballClub club : footballLeague) {
            System.out.println(club);
        }
        System.out.println(" ");

        for (Match club : matchDetails) {
            System.out.println(club);
        }
    }
}


import javafx.application.Application;
import javafx.stage.Stage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleApplication extends Application {

    private static final LeagueManager premierLeagueManager = new PremierLeagueManager();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // load the previous details
        premierLeagueManager.loadDetails();
        mainMenu();
    }

    public static void mainMenu() {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("------------- Premier League 2020 -------------");
            System.out.println("----------------- Main Menu -------------------");
            System.out.println("Press 1 : Add new club to the League ");
            System.out.println("Press 2 : Delete existing club from League");
            System.out.println("Press 3 : Display Statistics for the club");
            System.out.println("Press 4 : Display the Premier League Table");
            System.out.println("Press 5 : Add a played match");
            System.out.println("Press 6 : Open GUI");
            System.out.println("Press 7 : Quit");

            System.out.println("Please Enter your choice : ");
            String option = sc.nextLine();

            int userChoice = 0;
            try {
                userChoice = Integer.parseInt(option);
            } catch (NumberFormatException e) {
                System.out.println("This is invalid");
            }

            switch (userChoice) {
                case 1:
                    addClub();
                    break;
                case 2:
                    deleteClub();
                    break;
                case 3:
                    displayStatistics();
                    break;
                case 4:
                    displayLeagueTable();
                    break;
                case 5:
                    addPlayedMatch();
                    break;
                case 6:
                    viewGUI();
                    break;
                case 7:
                    System.out.println("Thank you for joined with us.\nHope to see you again!!!");
                    System.exit(0);
                default:
                    System.out.println("Please Enter valid option !!! \n");
            }

            // save the program's details
            premierLeagueManager.saveDetails();

        }
    }

    private static void addClub() {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter the Name of the Club :");
            String name = sc.nextLine();

            System.out.println("Enter the Location of the Club :");
            String location = sc.nextLine();

            System.out.println("Enter the Number of Wins :");
            int wins = sc.nextInt();

            System.out.println("Enter the Number of Draws :");
            int draws = sc.nextInt();

            System.out.println("Enter the Number of Defeats :");
            int defeats = sc.nextInt();

            System.out.println("Enter the Number of Scored Goals :");
            int noOfScoredGoals = sc.nextInt();

            System.out.println("Enter the Number of ReceivedGoals :");
            int noOfReceivedGoals = sc.nextInt();

            System.out.println("Enter the Number of Points :");
            int noOfPoints = sc.nextInt();

            System.out.println("Enter the Number of Matches Played :");
            int noOfMatchesPlayed = sc.nextInt();

            FootballClub club = new FootballClub(name, location, wins, draws, defeats, noOfScoredGoals, noOfReceivedGoals, noOfPoints, noOfMatchesPlayed);
            premierLeagueManager.addClub(club);
            System.out.println(" ");

        } catch (InputMismatchException e) {
            System.out.println("Please Enter a valid Input !!! \n");
        }
    }

    private static void deleteClub() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Name of the Club to Delete : ");
        String name = sc.nextLine();
        premierLeagueManager.deleteClub(name);
        System.out.println(" ");
    }

    private static void displayStatistics() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Name of the Club to Display Statistics : ");
        String name = sc.nextLine();
        premierLeagueManager.displayStatistics(name);
        System.out.println(" ");
    }

    private static void displayLeagueTable() {
        premierLeagueManager.displayLeagueTable();
        System.out.println(" ");
    }

    private static void addPlayedMatch() {
        premierLeagueManager.addPlayedMatch();
        System.out.println(" ");
    }

    private static void viewGUI() {
        premierLeagueManager.viewGUI();
    }

}

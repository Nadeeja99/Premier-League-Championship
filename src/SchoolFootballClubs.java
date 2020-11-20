public class SchoolFootballClubs extends FootballClub {

    private String schName;

    public SchoolFootballClubs(String clubName, String location, int wins,
                               int draws, int defeats, int noOfScoredGoals, int noOfReceivedGoals,
                               int noOfPoints, int noOfMatchesPlayed, String schName) {

        super(clubName, location, wins, draws, defeats, noOfScoredGoals,
                noOfReceivedGoals, noOfPoints, noOfMatchesPlayed);
        this.schName = schName;
    }

    public String getSchName() {
        return schName;
    }

    public void setSchName(String schName) {
        this.schName = schName;
    }

    @Override
    public String toString() {
        return super.toString() + " School Name: " + schName;
    }
}

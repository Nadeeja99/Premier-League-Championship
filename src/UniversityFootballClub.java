public class UniversityFootballClub extends FootballClub {

    private String uniName;

    public UniversityFootballClub(String clubName, String location, int wins,
                                  int draws, int defeats, int noOfScoredGoals, int noOfReceivedGoals,
                                  int noOfPoints, int noOfMatchesPlayed, String uniName) {

        super(clubName, location, wins, draws, defeats, noOfScoredGoals,
                noOfReceivedGoals, noOfPoints, noOfMatchesPlayed);
        this.uniName = uniName;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    @Override
    public String toString() {
        return super.toString() + " University Name: " + uniName;
    }
}

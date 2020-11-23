public class FootballClub extends SportsClub {

    private int wins;
    private int draws;
    private int defeats;
    private int noOfScoredGoals;
    private int noOfReceivedGoals;
    private int noOfPoints;
    private int noOfMatchesPlayed;

    public FootballClub(String name, String location, int wins, int draws,
                        int defeats, int noOfScoredGoals, int noOfReceivedGoals,
                        int noOfPoints, int noOfMatchesPlayed) {
        super(name, location);
        this.wins = wins;
        this.draws = draws;
        this.defeats = defeats;
        this.noOfScoredGoals = noOfScoredGoals;
        this.noOfReceivedGoals = noOfReceivedGoals;
        this.noOfPoints = noOfPoints;
        this.noOfMatchesPlayed = noOfMatchesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public int getNoOfScoredGoals() {
        return noOfScoredGoals;
    }

    public int getNoOfReceivedGoals() {
        return noOfReceivedGoals;
    }

    public int getNoOfPoints() {
        return noOfPoints;
    }

    public int getNoOfMatchesPlayed() {
        return noOfMatchesPlayed;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public void setNoOfScoredGoals(int noOfScoredGoals) {
        this.noOfScoredGoals = noOfScoredGoals;
    }

    public void setNoOfReceivedGoals(int noOfReceivedGoals) {
        this.noOfReceivedGoals = noOfReceivedGoals;
    }

    public void setNoOfPoints(int noOfPoints) {
        this.noOfPoints = noOfPoints;
    }

    public void setNoOfMatchesPlayed(int noOfMatchesPlayed) {
        this.noOfMatchesPlayed = noOfMatchesPlayed;
    }

    @Override
    public String toString() {
        return "Football Club[" + super.toString() + ", noOfWins: " + wins + ", noOfDraws: " + draws
                + ", noOfDefeats: " + defeats + ", noOfScoredGoals: " + noOfScoredGoals + ", noOfReceivedGoals: " + noOfReceivedGoals
                + ", noOfPoints: " + noOfPoints + ", noOfMatchesPlayed: " + noOfMatchesPlayed + "]";
    }
}

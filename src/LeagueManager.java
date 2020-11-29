public interface LeagueManager {

    void addClub(FootballClub club);
    void deleteClub(String name);
    void displayStatistics(String name);
    void displayLeagueTable();
    void addPlayedMatch();
    void saveDetails();
    void loadDetails();
}

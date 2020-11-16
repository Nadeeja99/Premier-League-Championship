public class Match {

    private FootballClub team01;
    private FootballClub team02;
    private int team01Score;
    private int team02Score;
    private Date date;

    public Match(FootballClub team01, FootballClub team02, int team01Score, int team02Score, Date date){
        this.team01 = team01;
        this.team02 = team02;
        this.team01Score = team01Score;
        this.team02Score = team02Score;
        this.date = date;
    }

    public FootballClub getTeam01() {
        return team01;
    }

    public FootballClub getTeam02() {
        return team02;
    }

    public int getTeam01Score(){
        return team01Score;
    }

    public int getTeam02Score(){
        return team02Score;
    }

    public Date getDate() {
        return date;
    }

    public void setTeam01(FootballClub team01) {
        this.team01 = team01;
    }

    public void setTeam02(FootballClub team02) {
        this.team02 = team02;
    }

    public void setTeam01Score(int team01Score) {
        this.team01Score = team01Score;
    }

    public void setTeam02Score(int team02Score) {
        this.team02Score = team02Score;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

import java.io.Serializable;

public class Match implements Serializable {

    private String club1;
    private String club2;
    private int club1Score;
    private int club2Score;
    private Date date;

    public Match(String club1, String club2, int club1Score, int club2Score, Date date){
        this.club1 = club1;
        this.club2 = club2;
        this.club1Score = club1Score;
        this.club2Score = club2Score;
        this.date = date;
    }

    public Match(){

    }

    public String getClub1() {
        return club1;
    }

    public String getClub2() {
        return club2;
    }

    public int getClub1Score(){
        return club1Score;
    }

    public int getClub2Score(){
        return club2Score;
    }

    public Date getDate() {
        return date;
    }

    public void setClub1(String club1) {
        this.club1 = club1;
    }

    public void setClub2(String club2) {
        this.club2 = club2;
    }

    public void setClub1Score(int club1Score) {
        this.club1Score = club1Score;
    }

    public void setClub2Score(int club2Score) {
        this.club2Score = club2Score;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String toString(){
        return "Match[" + date + ", Club 01: " + club1 + ", Club 02: " + club2
                + ", Club 01 Score: " + club1Score + ", Club 02 Score: " + club2Score + "]";
    }
}

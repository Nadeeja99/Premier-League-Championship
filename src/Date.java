import java.io.Serializable;

public class Date implements Comparable<Date>,Serializable {

    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return year + "/" + month + "/" + day ;
    }

    private int toMinute(){
        return this.year * 365*24*60 + this.month * 30 * 24 * 60 + this.day * 24 *60;
    }

    @Override
    public int compareTo(Date o) {
        return this.toMinute() - o.toMinute();
    }
}

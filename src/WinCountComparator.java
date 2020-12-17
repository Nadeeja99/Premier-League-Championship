import java.util.Comparator;

public class WinCountComparator implements Comparator<FootballClub> {

    @Override
    public int compare(FootballClub club1, FootballClub club2) {

        if (club1.getWins() > club2.getWins())
            return -1;

        else if (club1.getWins() < club2.getWins())
            return 1;

        // if both club has same win count then it checks goal difference
        else {
            int goalDiff1 = club1.getNoOfScoredGoals() - club1.getNoOfReceivedGoals();
            int goalDiff2 = club2.getNoOfScoredGoals() - club2.getNoOfReceivedGoals();
            if (goalDiff1 > goalDiff2)
                return -1;
            else if (goalDiff1 < goalDiff2)
                return 1;
            else return 0;
        }
    }
}


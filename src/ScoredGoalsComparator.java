import java.util.Comparator;

public class ScoredGoalsComparator implements Comparator<FootballClub> {

    @Override
    public int compare(FootballClub club1, FootballClub club2) {

        if (club1.getNoOfScoredGoals() > club2.getNoOfScoredGoals())
            return -1;

        else if (club1.getNoOfScoredGoals() < club2.getNoOfScoredGoals())
            return 1;

        // if both club has same NoOfScoredGoals then it checks goal difference
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

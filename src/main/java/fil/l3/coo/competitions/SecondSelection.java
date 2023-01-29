package fil.l3.coo.competitions;

import fil.l3.coo.competitors.Competitor;
import fil.l3.coo.exceptions.NotPowerOfTwoException;
import fil.l3.coo.exceptions.NumberOfCompetitorsException;
import java.util.Comparator;
import java.util.List;


public class SecondSelection extends FirstSelection implements Selection {

    public SecondSelection(int nbCompetitors, int nbPoules, int lignes) {
        super(nbCompetitors, nbPoules, lignes);
    }

    public List<Competitor> selection(List<List<Competitor>> l) throws NotPowerOfTwoException, NumberOfCompetitorsException {

        List<Competitor> result = super.selection(l);
        result.sort(Comparator.comparingInt(Competitor::getNbPoints));
        int i=result.size();
        while (! isPowerOfTwo(i)){
            result.remove(i-1);
            i--;
        }
        return result ;
    }

    public boolean isPowerOfTwo(int i){
        return ( i > 0) && (i & (i-1) )== 0;
    }
}
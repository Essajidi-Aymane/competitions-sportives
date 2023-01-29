package fil.l3.coo.competitions;

import java.util.List;
import fil.l3.coo.competitors.*;
import fil.l3.coo.exceptions.NotPowerOfTwoException;
import fil.l3.coo.exceptions.NumberOfCompetitorsException;

public interface Selection {


    /**
     * method for selection of finalist for second stage
     * @param l group of competitors in group stage**/
    List<Competitor> selection(List<List<Competitor>> l ) throws NotPowerOfTwoException, NumberOfCompetitorsException;

    //int getNbLignes();
    int getNbPoules();
    int getNbCompetitor();

}

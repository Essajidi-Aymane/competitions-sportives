package fil.l3.coo;

import fil.l3.coo.competitions.Competition;
import fil.l3.coo.competitions.Selection;
import fil.l3.coo.competitions.Tournament;
import fil.l3.coo.competitions.Master;
import fil.l3.coo.exceptions.NotPowerOfTwoException;
import fil.l3.coo.exceptions.NumberOfCompetitorsException;
import static org.junit.jupiter.api.Assertions.*;
import fil.l3.coo.competitions.FirstSelection;
import  fil.l3.coo.competitions.SecondSelection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MasterTest extends CompetitionTest {
      Selection s1= new FirstSelection(8,2,2);
      Selection s2=new SecondSelection(8,2,2);
    Master m =  new Master(this.competitors, 2, this.s1.getNbPoules(), this.s1);
    Master m2 = new Master(this.competitors,2,this.s2.getNbPoules(),this.s2);
    protected Competition createCompetition() {
        return new Master(this.competitors, 2, 8, this.s1);
    }

    @Test
    public void playTest() throws NotPowerOfTwoException, NumberOfCompetitorsException {
        int beforesize = this.competitors.size();
        m.play();
        int afterMaster = Tournament.getWinnersList().size();
        assertFalse(beforesize == afterMaster );






    }


}

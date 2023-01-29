package fil.l3.coo;
import fil.l3.coo.competitions.*;
import fil.l3.coo.competitors.Competitor;

import fil.l3.coo.exceptions.NumberOfCompetitorsException;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LeagueTest extends CompetitionTest{
    League l = new League(this.competitors);

    protected Competition createCompetition(){
        return new League(this.competitors);
    }


    @Test
    public void playLeagueTest() throws NumberOfCompetitorsException {

        l.play(this.competitors);
        Map<Competitor,Integer> mapr= l.ranking();
        List<Competitor> list = new ArrayList<>(mapr.keySet());
        assertTrue(list.get(0).getNbPoints() >= list.get(1).getNbPoints());
        assertFalse(list.get(0).getNbPoints() <= list.get(7).getNbPoints());
        assertTrue(list.get(2).getNbPoints() >=list.get(3).getNbPoints() );
    }
    @Test
    public void playMatchTest(){
        Competitor c1 =new Competitor("Pablo");
        Competitor c2 = new Competitor("Cesar");
        Competitor c3 = new Competitor("Gregor");
        Competitor c4 = new Competitor("Imad");
        assertEquals(c1.getNbPoints(),c2.getNbPoints());
        assertEquals(c3.getNbPoints(),c4.getNbPoints());
        l.playMatch(c1,c2);
        l.playMatch(c3,c4);
        assertTrue(c1.getNbPoints() != c2.getNbPoints());
        assertTrue(c3.getNbPoints() == c4.getNbPoints());
    }

}

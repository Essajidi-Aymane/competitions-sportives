package fil.l3.coo;

import fil.l3.coo.competitions.League;
import fil.l3.coo.competitors.Competitor;
import fil.l3.coo.exceptions.NumberOfCompetitorsException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PoulesTest {

    @Test
    public void playPoulesTest() throws NumberOfCompetitorsException {
        List<Competitor> poule = new ArrayList<>();
        poule.add(new Competitor("billy"));
        poule.add((new Competitor("miky")));
        poule.add(new Competitor("petter"));
        poule.add(new Competitor("alexis"));
        int sizeBefore = poule.size();
        System.out.println(poule);
        League l = new League(poule);
        l.play(poule);
        assertTrue(poule.get(0).getNbPoints() != poule.get(2).getNbPoints());
        assertEquals(sizeBefore,poule.size());
    }


    @Test
    public void playPoulesThrowsNumberOfTwoException() throws NumberOfCompetitorsException {
        List<Competitor> poule = new ArrayList<>();
        poule.add(new Competitor("jack"));
        League l = new League(poule);
        assertThrows(NumberOfCompetitorsException.class, () -> {
            l.play(poule);
        });
    }


}

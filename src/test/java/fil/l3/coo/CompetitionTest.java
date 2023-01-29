package fil.l3.coo;

import fil.l3.coo.competitions.Competition;
import fil.l3.coo.competitors.Competitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import fil.l3.coo.competitions.*;


public abstract class CompetitionTest {
    protected  Competition comp;
    public List<Competitor> competitors = new ArrayList<Competitor>();
  ;
    Selection s1;
    Selection s2;

    protected abstract Competition createCompetition();

    @BeforeEach
    public void init() {
        this.comp = this.createCompetition();
        this.s1= new FirstSelection(8,2,2);
        this.s2=new SecondSelection(8,2,2);
        Competitor c1 = new Competitor("Carlos");
        Competitor c2 = new Competitor("Rodrigo");
        Competitor c3 = new Competitor("Aymane");
        Competitor c4 = new Competitor("Amine");
        Competitor c5 = new Competitor("Pablo");
        Competitor c6 = new Competitor("Dominique");
        Competitor c7 = new Competitor("Alfredo");
        Competitor c8 = new Competitor("Alaa");
        /***************************************************/

        competitors.add(c1);
        competitors.add(c2);
        competitors.add(c3);
        competitors.add(c4);
        competitors.add(c5);
        competitors.add(c6);
        competitors.add(c7);
        competitors.add(c8);

    }

    @Test
    public void getCompetitorsTest() {
        assertEquals(comp.getCompetitors(), this.competitors);

    }
    @Test
    public void playMatchTest() {
        Competitor c1 = competitors.get(0);
        Competitor c2 = competitors.get(1);
        Competitor result = comp.playMatch(c1, c2);
        assertNotNull(result);
        assertTrue(Arrays.asList(c1, c2).contains(result));
    }

    @Test
    public void isPowerOfTwoTest() {
        assertTrue(comp.isPowerOfTwo(comp.getCompetitors().size()));
    }


}

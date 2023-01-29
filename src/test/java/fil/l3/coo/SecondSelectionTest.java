package fil.l3.coo;

import fil.l3.coo.competitions.FirstSelection;
import fil.l3.coo.competitions.Poules;
import fil.l3.coo.competitions.SecondSelection;
import fil.l3.coo.competitions.Selection;
import fil.l3.coo.competitors.Competitor;
import fil.l3.coo.exceptions.NotPowerOfTwoException;
import fil.l3.coo.exceptions.NumberOfCompetitorsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SecondSelectionTest {
        private final List<Competitor> competitors= new ArrayList<>();

    @BeforeEach
        public void init(){
            Competitor c1 = new Competitor("Carlos");
            Competitor c2 = new Competitor("Rodrigo");
            Competitor c3 = new Competitor("Aymane");
            Competitor c4 = new Competitor("Amine");
            Competitor c5 = new Competitor("Pablo");
            Competitor c6 = new Competitor("Dominique");
            Competitor c7 = new Competitor("Alfredo");
            Competitor c8 = new Competitor("Alaa");
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
        public void selectionTest() throws NotPowerOfTwoException, NumberOfCompetitorsException {
            Poules p = new Poules(competitors,2,8);
            Selection s = new SecondSelection(8,2,2);
            List<List<Competitor>> groupstage = p.getPoules();
            List<Competitor> result = s.selection(groupstage);
            assertEquals(8, competitors.size());
            assertNotEquals(competitors.size(), result.size());



        }

}

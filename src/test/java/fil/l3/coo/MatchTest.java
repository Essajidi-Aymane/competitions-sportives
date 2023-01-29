package fil.l3.coo;

import fil.l3.coo.competitors.Competitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import fil.l3.coo.competitions.Match;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MatchTest {


    List<Competitor> competitors = new ArrayList<>();



    @Test
    public void winnerOfMatchTest(){
        Competitor c1 = new Competitor("alex ");
        Competitor c2 = new Competitor("Alice ");
        Match match = new Match(c1, c2) ;
        Competitor result = match.winnerOfTheMatch(c1, c2);
        assertNotNull(result);
        assertTrue(Arrays.asList(c1, c2).contains(result));

    }

}

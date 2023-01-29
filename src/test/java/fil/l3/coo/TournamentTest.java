package fil.l3.coo;

import fil.l3.coo.competitions.Competition;
import fil.l3.coo.competitions.Tournament;
import fil.l3.coo.competitors.Competitor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class TournamentTest extends CompetitionTest{
    protected Competition createCompetition(){
        return new Tournament(competitors);
    }

    @Test
    public void playMatchTest(){
        int x = (int)(Math.random() * 2 + 1);
        System.out.println(x);
        Competitor c1 = competitors.get(0);
        System.out.println(c1);
        Competitor c2 = competitors.get(1);
        System.out.println(c2);
        if(x==1){
            assertSame(c1,comp.playMatch(c1,c2));
        }
        else{
            assertSame(c2,comp.playMatch(c1,c2));
        }
    }


}


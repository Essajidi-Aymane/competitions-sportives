package fil.l3.coo.competitions;

import fil.l3.coo.competitors.Competitor;
import fil.l3.coo.exceptions.NotPowerOfTwoException;
import fil.l3.coo.exceptions.NumberOfCompetitorsException;

import java.util.List;
import java.util.ArrayList;
public class Master extends Competition {
    private List<Competitor> competitors;

    private Selection s ;

    public Master(List<Competitor> comp,int nbPoules, int nbCompetitors,Selection s ) {
        super(comp);
        this.s = s;

    }

    /**
     * this method unrolls master
     * @param comp list of competitors
     */

    public void play(List<Competitor> comp) throws NotPowerOfTwoException, NumberOfCompetitorsException {
    Tournament t =new Tournament(comp);
    Poules p = new Poules(comp,s.getNbPoules(),s.getNbCompetitor());
    List<List<Competitor>> l = p.playPoule();
    List<Competitor> c = s.selection(l);
        System.out.println(c.get(0).getName() +"has"+c.get(0).getNbPoints());
        System.out.println(c.get(1).getName() +"has"+c.get(1).getNbPoints());
        for( Competitor competitor: c ){
            competitor.setNbPoints(0);
        }
        System.out.println(c.get(0).getName() +"has"+c.get(0).getNbPoints());
        System.out.println(c.get(1).getName() +"has"+c.get(1).getNbPoints());
    t.play(c);

    }

    /**
     * this method displays the winner of the master
     */
    public void displayWinner(){
        Tournament t = new Tournament(this.competitors);
        Competitor winner = t.getWinner();
        System.out.println("********* WINNER *******");
        System.out.println("winner is "+winner.getName()) ;


    }



}

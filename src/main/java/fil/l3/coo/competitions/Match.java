package fil.l3.coo.competitions;
import java.util.*;
import fil.l3.coo.competitors.Competitor;

public class Match {
    private Competitor comp1;
    private Competitor comp2 ;
    private Competitor winner;


    public Match (Competitor c1,Competitor c2){
        this.comp1=c1;
        this.comp2=c2;

    }


    public Competitor winnerOfTheMatch(Competitor c1, Competitor c2) {
        Random random = new Random();
        int alea = random.nextInt(2);
        if (alea == 0) {
            this.winner = c1;
            return c1;
        }
        else {
            this.winner = c2;
            return c2;
        }
    }
    public void displayWinnerOfMatch(Competitor c1,Competitor c2,Competitor winner){
        System.out.println(c1.getName()+" vs "+c2.getName()+"-----> winner of the match  "+winner.getName());
    }
    public Competitor getComp1(){
        return  this.comp1;
    }
    public Competitor getComp2(){
        return this.comp2;
    }
    public Competitor getWinner(){
        return this.winner;
    }


}

package fil.l3.coo.competitions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fil.l3.coo.competitors.Competitor;
import fil.l3.coo.exceptions.NotPowerOfTwoException;
import fil.l3.coo.exceptions.NumberOfCompetitorsException;

//constructor
public class League extends Competition{

    protected Map<Competitor,Integer> map ;
    protected static Competitor WINNER ;

    public League  (List<Competitor> competitors){
        super(competitors);

    }


    /**
     * this method manages the progress of the league
     * @param c list of the competitors in this league */
    public void play(List<Competitor>c ) throws NumberOfCompetitorsException {
        if( c.size()==1){
            throw new NumberOfCompetitorsException("le nombre saisie n'est correct");
        }
    	for (Competitor p : c ) {
    		for (Competitor x : c) {
    			if(!(p.equals(x))){
                    Competitor winner= playMatch(p,x);
                    winner.addOnePoint();
                    p.addOneMatch();
                    x.addOneMatch();
                }
            }
    		}
        Map<Competitor,Integer> map=this.ranking();
        super.displayRanking(map);
        //this.displayWinner();
        


    }













    /**
     * this method return the winner of the league
     * @return the first element of the ranking (the winner)
     * */
    public Competitor winnerOfTheLeague() {
        Map<Competitor, Integer> mapr = this.ranking();
        Competitor c=mapr.keySet().iterator().next();

    return c;
    }


    /**
     * this method displays the winner of the league */
    public void displayWinner(){
        Competitor winner=this.winnerOfTheLeague();
        System.out.println("\n******************THE WINNER *******************");  
        System.out.println("The winner of the league is "+winner.getName()+" with "+winner.getNbPoints()+"points");
        System.out.println("*************STATISTIQUES************");
        System.out.println("Matches joues : ");
        winner.diplayNumberOfMatchs();
        System.out.println("Matches gagnes :");
        winner.displayNbMatchGagne();;
    
    }


}









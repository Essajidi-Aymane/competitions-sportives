package fil.l3.coo.competitions;

import fil.l3.coo.competitors.Competitor;
import fil.l3.coo.exceptions.NotPowerOfTwoException;
import fil.l3.coo.exceptions.NumberOfCompetitorsException;
import fil.l3.coo.exceptions.NumberOfCompetitorsException;

import java.util.List;

public class Tournament extends Competition {
    private static  Competitor WINNER ;
    private static  List<Competitor > WINNERSLIST;
    private int match = 1;

    public Tournament(List<Competitor> competitors) {
        super(competitors);
    }

    /**
     * this method runs the entire tournament
     * @throws :  NotPowerOfTwoException
     */
    public void play(List<Competitor> c) throws NotPowerOfTwoException {
        if (!isPowerOfTwo(c.size())) {
            throw new NotPowerOfTwoException();

        }
        int i = 0;
        int roundNumber = 1;
        int roundsMatchs = c.size() / 2;
        int competitorsSize = c.size();
        while (c.size() > 1) {
            if (c.size() == competitorsSize){
                System.out.println("\n          TOUR " + roundNumber );
                competitorsSize = competitorsSize / 2;
            }
            Competitor win = playMatch(c.get(i), c.get(i + 1));
            if (c.get(i).equals(win)) {
                c.remove(i + 1);
            }
            else {
                c.remove(i);
            }
            i += 1;
            if (c.size() == roundsMatchs){
                roundNumber++;
                match = 1;
                roundsMatchs = c.size() / 2;
            }
            else
                match++;
            i = i % c.size();
        }
        Tournament.WINNERSLIST=c;
        match = 1;
        Tournament.WINNER= c.get(0);



    }

    /**
     * this method displays the winner of the tournament
     */
    public void displayTheWinnerOfTheTournament(){
        System.out.println("\nThe winner of this tournament is : " + Tournament.WINNER);
    }

    /**
     * this method manages the process of a tournament
     * @throws NotPowerOfTwoException
     * @throws NumberOfCompetitorsException
     */
    public void play() throws NotPowerOfTwoException, NumberOfCompetitorsException {
        super.play();
        this.play(competitors);
    }

    /**
     * this method displays the winner of a tournament
     */
    public void displayWinner(){
        System.out.println("\n********* THE WINNER **********");
        this.displayTheWinnerOfTheTournament();
    }

    /**
     * this method returns the winner of a tournament
     * @return the winner of tournament
     */
     public static Competitor getWinner(){
        return Tournament.WINNER;
     }
     public static List<Competitor> getWinnersList(){
         return  Tournament.WINNERSLIST;
     }

}




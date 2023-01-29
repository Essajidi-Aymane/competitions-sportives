package fil.l3.coo.competitions;

import fil.l3.coo.competitors.Competitor;
import fil.l3.coo.observer.CompetitionsEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import fil.l3.coo.competitions.Match;
import fil.l3.coo.observer.CoteGen;
import fil.l3.coo.observer.MatchListener;
import fil.l3.coo.exceptions.NotPowerOfTwoException;
import fil.l3.coo.exceptions.NumberOfCompetitorsException;
import fil.l3.coo.observer.ScoreCommentator;
import fil.l3.coo.sortingmap.MapUtil;
public abstract class Competition {
    protected List<Competitor> competitors;
    protected List<MatchListener> competitionListener ;





    public Competition(List<Competitor> c) {

        this.competitors = c;
        this.competitionListener=new ArrayList<>();
        ScoreCommentator scc = new ScoreCommentator() ;
        CoteGen cote = new CoteGen();
        this.addCompetitionsObservableListener(scc);
        this.addCompetitionsObservableListener(cote);



    }
public void play() throws NotPowerOfTwoException, NumberOfCompetitorsException {
        this.play(this.competitors);
        this.displayWinner();
        this.displayCotes();


}

    /**
     * this method returns the list of competitors
     * @return competitors
     */
    public List<Competitor> getCompetitors(){
        return this.competitors;
    }
    /**this method plays a match between two competitors
     * @param comp1  first competitor
     * @param comp2  second competitor
     **/
    public final Competitor playMatch(Competitor comp1, Competitor comp2){
       Match match = new Match(comp1,comp2);
       Competitor winner= match.winnerOfTheMatch(comp1,comp2);
        match.displayWinnerOfMatch(comp1, comp2, winner);
        this.matchCommentsAndCotes(match);
        return winner ;


    }


        /**
         * this method returns the ranking sorted by points
         * @return ranking sorted
         */
    public Map<Competitor,Integer> ranking(){
        Map <Competitor,Integer> mapr= new HashMap<>();
        for ( Competitor c : this.getCompetitors()){
            mapr.put(c,c.getNbPoints());
        }
        mapr=MapUtil.sortByDescendingValue(mapr);
        return mapr ; 
    }
    /**
     * this method displays the ranking
     * @param rank map of each competitor with the points that he accumulated
     */
    public void displayRanking(Map<Competitor,Integer> rank ){
        System.out.println(" ***\nRanking of the Compitition: ");
        for( Competitor k : rank.keySet()){
            System.out.println(k+"  -   "+rank.get(k));

        }

    }

    public abstract void play(List<Competitor> c) throws NotPowerOfTwoException, NumberOfCompetitorsException;

    /**
     * @param x : the int to check if it's a power of two
     * @return true if x is a power of two
     */
    public final boolean isPowerOfTwo(int x){
        return ( x > 0) && (x & (x-1) )== 0;
    }

    public void displayCotes() {
        System.out.println("\nAffichage de cotes : \n");
        for(Competitor c : this.competitors) {
            System.out.println(c.getName()+" a : "+ c.getCote()+" cotes.");
        }
    }


    public synchronized void addCompetitionsObservableListener(MatchListener c) {
        if(this.getCompetitionsListener().contains(c)) {
            return;
        }
        this.getCompetitionsListener().add(c);
    }

    public synchronized void removeCompetitionsObservableListener(MatchListener c) {
        if(this.getCompetitionsListener().contains(c)) {
            this.getCompetitionsListener().remove(c);
        }
        return;
    }

    public void matchCommentsAndCotes(Match match) {
        if(this.getCompetitionsListener().isEmpty()) {
            return;
        }
        CompetitionsEvent event = new CompetitionsEvent(match);
        for(MatchListener cl : this.getCompetitionsListener()) {
            cl.reactToMatch(event);
        }
    }


    public List<MatchListener> getCompetitionsListener() {
        return competitionListener;
    }


    /**
     * abstract method in which we display the winner of a tournament or league*/
    public abstract  void displayWinner();




}

package fil.l3.coo.observer;


import fil.l3.coo.competitors.Competitor;

public class ScoreCommentator implements MatchListener {


    public void reactToMatch(CompetitionsEvent ce) {
        Competitor c1 = ce.getMatch().getComp1();
        Competitor c2 = ce.getMatch().getComp2();
        Competitor gagnant = ce.getMatch().getWinner();

        if(gagnant.equals(c1)) {
            System.out.println("-->Reporters : ADSport : "+gagnant.getName()+" won the match against "+c2.getName());
        }
        else {
            System.out.println("-->Reporters: ADSport : "+gagnant.getName()+" won the match against "+c1.getName());
        }

    }

}

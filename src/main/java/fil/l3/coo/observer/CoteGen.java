package fil.l3.coo.observer;
import fil.l3.coo.competitors.Competitor;

    public class CoteGen implements MatchListener {

        public void reactToMatch(CompetitionsEvent ce) {
            Competitor comp1 = ce.getMatch().getComp1();
            Competitor comp2 = ce.getMatch().getComp2();
            Competitor gagnant = ce.getMatch().getWinner();

            if(gagnant.equals(comp1)) {
                System.out.println("-->Bookmaker : Victoire "+comp1.getName()+"avec cote < "+comp1.getCote()+" >face à "+comp2.getName()+" avec cote <"+comp2.getCote()+">.");
                gagnant.setCote(-1);
                comp2.setCote(1);
                System.out.println(">La cote de "+comp1.getName()+" passe à <"+comp1.getCote()+">,tandis que  celle de "+comp2.getName()+" à <"+comp2.getCote()+">\n");
            }
            else {
                System.out.println("-->Bookmaker : Victoire de "+comp2.getName()+"avec cote <"+comp2.getCote()+"> face à "+comp1.getName()+"avec cote <"+comp1.getCote()+">.");
                gagnant.setCote(-1);
                comp1.setCote(1);
                System.out.println(">La cote de "+comp2.getName()+" passe à <"+comp2.getCote()+">, tandis que celle de "+comp1.getName()+" à <"+comp1.getCote()+">\n");
            }


        }

    }

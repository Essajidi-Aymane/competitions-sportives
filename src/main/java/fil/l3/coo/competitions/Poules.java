package fil.l3.coo.competitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fil.l3.coo.competitors.*;
import fil.l3.coo.exceptions.NotPowerOfTwoException;
import fil.l3.coo.exceptions.NumberOfCompetitorsException;


public class Poules {

    private List<List<Competitor>> groupStage;
    private List<Competitor> competitors;

    public Poules(List<Competitor> c, int nbPoule, int nbCompetitor) {
        this.groupStage = new ArrayList<>();
        this.competitors = c;
        int cpt= 0;
        for(int i = 0; i<nbPoule;i++){
            List<Competitor> l =new ArrayList<>();
            this.groupStage.add(l);
        }
        while(cpt<c.size()) {
            for (int i = 0; i < nbPoule; i++) {
                this.groupStage.get(i).add(c.get(cpt));
                i = i % nbPoule;
                cpt++;
            }
        }
    }

    /**
     * this method plays the group stages and extract the list of competitors sorted by score
     * @return list of competitors of each group stage sorted
     * @throws NotPowerOfTwoException
     * @throws NumberOfCompetitorsException
     */
    public List<List<Competitor>> playPoule() throws NotPowerOfTwoException, NumberOfCompetitorsException {


        List<List<Competitor>> comp=new ArrayList<>();
        int i = 0;
        System.out.println("\n*** Phase de poules ***");
        for( List<Competitor> p : this.getPoules() ){
            List<Competitor> li = new ArrayList<>();
            League l =new League(p);
            System.out.println("\nPoule "+ i);
            l.play();
            Map<Competitor,Integer> rank = l.ranking();
            for(Map.Entry<Competitor,Integer> entry : rank.entrySet()){
                Competitor key = entry.getKey();
                li.add(key);
            }
            comp.add(li);
            i++;


        }
        return comp;

}

    /**
     * this methode is a getter for group stages
     * @return group stage
     */
    public List<List<Competitor>> getPoules(){
        return this.groupStage;
}



















}
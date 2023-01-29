package fil.l3.coo.competitions;

import fil.l3.coo.competitors.Competitor;

import fil.l3.coo.exceptions.NotPowerOfTwoException;
import fil.l3.coo.exceptions.NumberOfCompetitorsException;


import java.util.ArrayList;
import java.util.List;


public class FirstSelection implements Selection {

    protected int nbPoules;
    protected int nbLignes ;
    protected int nbCompetitors;


    public FirstSelection(int nbCompetitors, int nbPoules, int lignes ) {
        this.nbPoules= nbPoules;
        this.nbLignes=lignes;
        this.nbCompetitors=nbCompetitors;



    }

    public List<Competitor> selection(List<List<Competitor>> l ) throws NotPowerOfTwoException, NumberOfCompetitorsException {
        List<Competitor> result = new ArrayList<>();
        for( int i=0;i<this.nbLignes;i++){
        for( List<Competitor> gr : l ){
             result.add(gr.get(i));
        }
        }
        return result;
    }
    public int getNbLignes(){
        return this.nbLignes;
    }
    public int getNbCompetitor(){
        return this.nbCompetitors;
    }
    public int getNbPoules(){
        return this.nbPoules;
    }

}

package fil.l3.coo.competitors;

public class Competitor {
    private String name;
    private int nbPoints = 0;
    private int nbMatchJoue = 0;
    private int nbMatchGagne = 0;

    private int cote;

    /* constructor

     */
    public Competitor(String name) {
        this.name = name;

    }

    /**
     * this method returns the name of a competitor
     *
     * @return the name of the competitor
     */
    public String getName() {
        return this.name;
    }

    /**
     * this method returns the points of a competitor
     *
     * @return points accumulated by a competitor
     */
    public int getNbPoints() {
        return this.nbPoints;
    }

    /**
     * this method adds a point to a competitor and increment the number of won matchs
     */
    public void addOnePoint( ){
        this.nbPoints= this.getNbPoints()+1;
        this.nbMatchGagne=this.getNbMatchGagne()+1;

    }
    public void setNbPoints(int points){
        this.nbPoints=points ;
    }

    /**
     * this method adds a point to a competitor
     */

    public String toString() {
        return this.getName();
    }

    /**
     * this method returns number of matches played by this competitor
     */
    public int getNbMatchJoue() {
        return this.nbMatchJoue;
    }

    /**
     * this method adds a match to the number of matches played
     */
    public void addOneMatch() {
        this.nbMatchJoue = this.getNbMatchJoue() + 1;

    }

    public void diplayNumberOfMatchs() {
        System.out.println(this.name + " played " + this.nbMatchJoue);
    }

    public int getNbMatchGagne() {
        return this.nbMatchGagne;
    }



    public void displayNbMatchGagne() {
        System.out.println(this.name + " a gagne " + this.nbMatchGagne);
    }

    public int getCote(){
        return this.cote;
    }

    public void setCote(int cote1 ){
        this.cote += cote1;
    }
    public boolean equals(Object o) {
        if (o instanceof Competitor) {
            Competitor other = (Competitor) o;
            return this.name.equals(other.name);
        } else return false;
    }
}




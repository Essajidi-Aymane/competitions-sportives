package fil.l3.coo.observer;
import java.util.EventObject;
import fil.l3.coo.competitions.Match;




public class CompetitionsEvent extends EventObject {

    private Match match;

    public CompetitionsEvent(Match m) {
        super(m);
        this.match = m;
    }

    public Match getMatch() {
        return match;
    }

}

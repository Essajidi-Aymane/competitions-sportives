package fil.l3.coo.observer;


import java.util.EventListener;

public interface MatchListener extends EventListener {

    public void reactToMatch(CompetitionsEvent ce);

}

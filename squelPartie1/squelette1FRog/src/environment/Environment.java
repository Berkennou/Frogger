package environment;

import gameCommons.Game;
import gameCommons.IEnvironment;
import util.Case;
import util.Direction;
import java.util.ArrayList;

public class Environment implements IEnvironment {
    private ArrayList<Lane> lesVois ;
    private Game game;

    public Environment(Game game){
        this.game=game;
        this.lesVois = new ArrayList<>();
        this.lesVois.add(new Lane(game,0,0.0));
        this.lesVois.add(new Lane(game,game.height-1,0.0));
        for(int i=1;i< game.height-1;i++){
            this.lesVois.add(new Lane(game,i, game.defaultDensity));
        }


    }



    public boolean isSafe(Case c) {
        boolean b=false;
        for(Lane e : this.lesVois){
            if(e.getOrd()==c.ord){
                b=e.isSafe(c);
            }
        }
        return b;
        }



    public boolean isWinningPosition(Case c) {
        if(c.ord==this.game.height-1){
            return true;
        }
        else{
            return false;
        }
    }


    public void update() {
        for(Lane e : this.lesVois){
            e.update();
        }

    }
}

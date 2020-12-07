package frog;


import environment.Inenvironment;
import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class Infrog implements IFrog {

    private Game game;
    private Case maPosition;
    private boolean fin;
    private Direction dernierMouvement;


    public Infrog(Game game){
        this.game=game;
        this.maPosition = new Case(game.width/2, 0);
        this.fin=false;
        this.dernierMouvement=Direction.down;


    }



    /**
     * Donne la position actuelle de la grenouille
     * @return
     */

    public Case getPosition(){
        return this.maPosition;

    }


    /**
     * Donne la direction de la grenouille, c'est � dire de son dernier mouvement
     * @return
     */

    public Direction getDirection(){
        return this.dernierMouvement;
    }



    /**
     * D�place la grenouille dans la direction donn�e et teste la fin de partie
     * @param key
     */

    public void move(Direction key){
        //todo
        if (key == Direction.right && this.maPosition.absc== game.width-1){
            this.maPosition.absc = this.maPosition.absc;
            this.dernierMouvement=Direction.right;

        }

        else if(key == Direction.right){
            this.maPosition.absc = this.maPosition.absc+1;
            this.dernierMouvement=Direction.right;
        }
        if (key == Direction.left && this.maPosition.absc==0 ){
            this.maPosition.absc = this.maPosition.absc;
            this.dernierMouvement=Direction.left;
        }
        else if(key == Direction.left){
            this.maPosition.absc = this.maPosition.absc-1;
            this.dernierMouvement=Direction.left;

        }

         if(key == Direction.up){
            this.dernierMouvement=Direction.up;
            Inenvironment.infinity();

        }
         if(key == Direction.down){
            this.dernierMouvement=Direction.down;
             Inenvironment.infinity();

        }

    }


}


package environment;
import java.util.Random;
import gameCommons.Game;
import graphicalElements.Element;
import util.Case;

import java.awt.*;

public class Car {
	private Game game;
	private Case leftPosition;
	private boolean leftToRight;
	private int length;
	private final Color colorLtR = Color.BLACK;

	private final Color colorRtL = Color.BLUE;

	//TODO Constructeur(s)
	public Car(Game game,Case Position,boolean leftToRight){
		this.game=game;
		this.leftPosition=Position;
		this.leftToRight=leftToRight;
		Random r =new Random();
		this.length=r.nextInt(3)+1;
		if(leftToRight){
			this.leftPosition=new Case(Position.absc-this.length,Position.ord);
		}
		else{
			this.leftPosition=new Case(Position.absc,Position.ord);

		}
	}




	//TODO : ajout de methodes
	public void bougerCar(boolean yes){
		if(yes){
			if(this.leftToRight){
				this.leftPosition = new Case(this.leftPosition.absc+1,this.leftPosition.ord);
			}
			else{
				this.leftPosition = new Case(this.leftPosition.absc-1,this.leftPosition.ord);
			}

		}
		this.addToGraphics();

	}

	public boolean apparait(){
		if(this.leftPosition.absc+this.length >0 || this.leftPosition.absc<this.game.width){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean coversCase(Case pos) {
		if (pos.ord != this.leftPosition.ord) {
			return false;
		}
		else {
			return pos.absc >= this.leftPosition.absc && pos.absc < this.leftPosition.absc + this.length;
		}
	}




	
	
	/* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/
	private void addToGraphics() {
		for (int i = 0; i < length; i++) {
			Color color = colorRtL;
			if (this.leftToRight){
				color = colorLtR;
			}
			game.getGraphic()
					.add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}

}

package environment;

import gameCommons.Game;
import util.Case;

import java.lang.reflect.Array;
import java.net.CacheRequest;
import java.util.ArrayList;
import java.util.Random;
public class Lane {
	private Game game;
	private int ord;
	private int speed;
	private ArrayList<Car> cars = new ArrayList<>();
	private boolean leftToRight;
	private double density;
	private int timer;

	// TODO : Constructeur(s)
	public Lane(Game game,int ord,double density){
		this.game = game;
		this.ord = ord;
		this.density = density;
		Random r =new Random();
		this.speed = r.nextInt(game.minSpeedInTimerLoops)-1;
		this.leftToRight = r.nextBoolean();
		/*for(int i = 0; i <4* game.width; ++i) {
			this.moveCars(true);
			this.mayAddCar();
		}*/

		}

   public int getOrd(){
		return this.ord;
   }


	public void update() {

		// TODO

		// Toutes les voitures se d�placent d'une case au bout d'un nombre "tic
		// d'horloge" �gal � leur vitesse
		// Notez que cette m�thode est appel�e � chaque tic d'horloge

		// Les voitures doivent etre ajoutes a l interface graphique meme quand
		// elle ne bougent pas

		// A chaque tic d'horloge, une voiture peut �tre ajout�e
		this.timer++;
		if (this.timer >=this.speed) {
			this.moveCars(true);
			this.mayAddCar();
			this.timer = 0;

		}
	}
	// TODO : ajout de methodes
		public void moveCars(boolean bool){
			if (bool){
				for(Car e : this.cars){
					e.bougerCar(true);
				}
			}
			removeOldCars();

		}

		public void removeOldCars(){

		for(Car el : this.cars){
			if(!el.apparait()){
				this.cars.remove(el);
			}
		}

	}

	   public boolean isSafe(Case posi){
		for(Car e : this.cars){
			if(e.coversCase(posi)){
				return false;
			}
		}
		return true;


	   }



	/*
	 * Fourni : mayAddCar(), getFirstCase() et getBeforeFirstCase() 
	 */

	/**
	 * Ajoute une voiture au d�but de la voie avec probabilit� �gale � la
	 * densit�, si la premi�re case de la voie est vide
	 */
	private void mayAddCar() {
		if (isSafe(getFirstCase()) && isSafe(getBeforeFirstCase())) {
			if (game.randomGen.nextDouble() < density) {
				cars.add(new Car(game, getBeforeFirstCase(), leftToRight));
			}
		}
	}

	private Case getFirstCase() {
		if (leftToRight) {
			return new Case(0, ord);
		} else
			return new Case(game.width - 1, ord);
	}

	private Case getBeforeFirstCase() {
		if (leftToRight) {
			return new Case(-1, ord);
		} else
			return new Case(game.width, ord);
	}

}

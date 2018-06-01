package garrettPokemonTraining;

import guiTeacher.components.Action;
import startGame.PokeStart;

public class Move {

	private String name;
	private Type type;
	private int power;
	private int accuracy;
	private int currentAccuracy;
	private int pp;
	private int currentPp;
	private boolean isSpecial;
	private int stat;
	private int change;
	private PokemonAction action;
	
	
	public static Move BITE = new Move("Bite","Dark",60,100,25,false,-1,0);
	public static Move GROWL = new Move("Growl","Normal",0,100,40,false,PokemonAction.ATTACK,1);
	public static Move SCRATCH = new Move("Scratch","Normal",40,100,35,false,-1,0);
	public static Move EMBER = new Move("Ember","Fire",40,100,25,true,-1,0);
	public static Move SCARYFACE = new Move("Scary Face","Normal",0,100,10,false,PokemonAction.SPEED,2);
	public static Move LEER = new Move("Leer","Normal",0,100,30,false,PokemonAction.DEFENSE,1);
	public static Move TACKLE = new Move("Tackle","Normal",40,100,35,false,-1,0);
	public static Move FLAMEWHEEL = new Move("Flame Wheel","Fire",60,100,25,false,-1,0);
	public static Move FURYSWIPES = new Move("Fury Swipes","Normal",18,80,15,false,-1,0);
	public static Move RAZORLEAF = new Move("Razor Leaf","Grass",55,95,25,false,-1,0);
	public static Move POUND = new Move("Pound","Normal",40,100,35,false,-1,0);
	public static Move QUICKATTACK = new Move("Quick Attack", "Normal", 40, 100, 30, false,-1,0);
	public static Move VINEWHIP = new Move("Vine Whip","Grass",45,100,25,false,-1,0);
	public static Move WRAP = new Move("Wrap","Normal",15,90,20,false,-1,0);
	public static Move WATERGUN = new Move("Water Gun","Water",40,100,25,true,-1,0);
	public static Move AQUAJET = new Move("Aqua Jet","Water",40,100,20,true,-1,0);
	public static Move BUBBLE = new Move("Bubble","Water",40,100,30,true,-1,0);
	public static Move MUDSLAP = new Move("Mud-Slap","Ground",20,100,10,true,-1,0);
	public static Move EXTRASENSORY = new Move("Extrasensory","Psychic",80,100,20,true,-1,0);
	public static Move FIREBLAST = new Move("Fire Blast","Fire",110,85,5,true,-1,0);
	public static Move SACREDFIRE = new Move("Sacred Fire","Fire",100,95,5,false,-1,0);
	public static Move BLIZZARD = new Move("Blizzard","Ice",110,70,5,true,-1,0);
	public static Move AURORABEAM = new Move("Aurora Beam","Ice",65,100,20,true,-1,0);
	public static Move HYDROPUMP = new Move("Hydro Pump","Water",110,80,5,true,-1,0);
	public static Move THUNDER = new Move("Thunder","Electric",110,70,10,true,-1,0);
	public static Move CRUNCH = new Move("Crunch","Dark",80,100,15,false,-1,0);
	public static Move DISCHARGE = new Move("Discharge","Electric",80,100,15,true,-1,0);
	

	public Move(String name, String type, int power, int accuracy, int pp, boolean isSpecial, int stat, int change) {
		this.name = name;
		this.type = new Type(type);
		setPower(power);
		setAccuracy(accuracy);
		setPp(pp);
		this.isSpecial = isSpecial;
		this.stat = stat;
		this.change = change;
		this.action = PokemonAction.createAction(stat,change);
	}

	public String getName() {
		return name;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getPp() {
		return pp;
	}

	public void setPp(int pp) {
		this.pp = pp;
	}

	public Type getType() {
		return type;
	}

	public boolean isSpecial() {
		return isSpecial;
	}

	public String toString() {
		return name + "," + type + "," + power + "," + accuracy + "," + pp + "," + isSpecial + "," + stat + "," + change;
	}

	public int getCurrentPp() {
		return currentPp;
	}

	public void setCurrentPp(int currentPp) {
		this.currentPp = currentPp;
	}

	public int getCurrentAccuracy() {
		return currentAccuracy;
	}

	public void setCurrentAccuracy(int currentAccuracy) {
		this.currentAccuracy = currentAccuracy;
	}

	public void attack(Pokemon target, Pokemon user) {
		if(stat >= 0) {
			action.setTarget(target);
			action.act();
		}else {
			if((int)(Math.random() * 100) < accuracy) {
				if(isSpecial) {
					target.setCurrentHp(target.getCurrentHp() - (this.power *(user.getsAtk()/target.getsDef())+1));
				}else {
					target.setCurrentHp(target.getCurrentHp() - (this.power *(user.getAtk()/target.getDef())+1));
				}
				PokeStart.battleScreen.setInfoText(user.getName() + " used " + this.name + ".");
			}else {
				PokeStart.battleScreen.setInfoText(user.getName() + " used " + this.name + " but missed.");
				}
			}
	}
}
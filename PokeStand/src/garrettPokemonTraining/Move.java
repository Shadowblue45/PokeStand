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
	public static Move FLAMEBURST = new Move("Flame Burst","Fire",70,100,15,true,-1,0);
	public static Move SLASH = new Move("Slash","Normal",70,100,20,false,-1,0);
	public static Move FLAMETHROWER = new Move("Flamethrower","Fire",90,100,15,true,-1,0);
	public static Move FLAMECHARGE = new Move("Flame Charge","Fire",50,100,20,false,-1,0);
	public static Move LAVAPLUME = new Move("Lava Plume","Fire",80,100,15,true,-1,0);
	public static Move MACHPUNCH = new Move("Mach Punch","Fighting",40,100,30,false,-1,0);
	public static Move CLOSECOMBAT = new Move("Close Combat","Fighting",120,100,5,false,-1,0);
	public static Move FLAREBLITZ = new Move("Flare Blitz","Fire",120,100,15,false,-1,0);
	public static Move ENERGYBALL = new Move("Energy Ball","Grass",90,100,10,true,-1,0);
	public static Move LEAFSTORM = new Move("Leaf Storm","Grass",130,90,5,true,-1,0);
	public static Move EARTHQUAKE = new Move("Earthquake","Ground",100,100,10,false,-1,0);
	public static Move LEAFBLADE = new Move("Leaf Blade","Grass",90,100,15,false,-1,0);
	public static Move SLAM = new Move("Slam","Normal",80,75,20,false,-1,0);
	public static Move SCREECH = new Move("Screech","Normal",0,85,40,false,PokemonAction.DEFENSE,2);
	public static Move BUBBLEBEAM = new Move("Bubble Beam","Water",65,100,20,true,-1,0);
	public static Move HYPERVOICE = new Move("Hyper Voice","Normal",90,100,10,true,-1,0);
	public static Move SPARKLINGARIA = new Move("Sparkling Aria","Water",90,100,10,true,-1,0);
	public static Move MOONBLAST = new Move("Moonblast","Fairy",95,100,15,true,-1,0);
	public static Move WATERPULSE = new Move("Water Pulse","Water",60,100,20,true,-1,0);
	public static Move ROUND = new Move("Round","Normal",60,100,15,true,-1,0);
	public static Move MUDSHOT = new Move("Mud Shot","Ground",55,95,15,true,-1,0);
	public static Move MUDBOMB = new Move("Mud Bomb","Ground",65,85,10,true,-1,0);
	public static Move MUDDYWATER = new Move("Muddy Water","Water",90,85,10,true,-1,0);
	public static Move ERUPTION = new Move("Eruption","Fire",150,100,5,true,-1,0);
	public static Move LEAFTORNADO = new Move("Leaf Tornado","Grass",65,90,10,true,-1,0);
	

	public Move(String name, String type, int power, int accuracy, int pp, boolean isSpecial, int stat, int change) {
		this.name = name;
		this.type = new Type(type);
		setPower(power);
		setAccuracy(accuracy);
		setPp(pp);
		setCurrentPp(getPp());
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
		return name + "," + type.getTypeName() + "," + power + "," + accuracy + "," + pp + "," + isSpecial + "," + stat + "," + change;
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
			PokeStart.battleScreen.setInfoText(user.getName() + " used " + this.name + ".");
			
		}else {
			if((int)(Math.random() * 100) < accuracy) {
				if(target.getType1().getWeaknesses() != null) {
					for(int i = 0; i < target.getType1().getWeaknesses().length;i++) {
						if(this.type.getType() == target.getType1().getWeaknesses()[i]) {
							target.setTypeMultiplerIndex(target.getTypeMultiplerIndex() + 1);
						}
					}
				}
				if(target.getType2().getWeaknesses() != null) {
					for(int i = 0; i < target.getType2().getWeaknesses().length;i++) {
						if(this.type.getType() == target.getType2().getWeaknesses()[i]) {
							target.setTypeMultiplerIndex(target.getTypeMultiplerIndex() + 1);
						}
					}
				}if(target.getType1().getResistances() != null) {
					for(int i = 0; i < target.getType1().getResistances().length;i++) {
						if(this.type.getType() == target.getType1().getResistances()[i]) {
							target.setTypeMultiplerIndex(target.getTypeMultiplerIndex() - 1);
						}
					}
				}if(target.getType2().getResistances() != null) {
					for(int i = 0; i < target.getType2().getResistances().length;i++) {
						if(this.type.getType() == target.getType2().getResistances()[i]) {
						target.setTypeMultiplerIndex(target.getTypeMultiplerIndex() - 1);
						}
					}
				}if(target.getType1().getImmunities() != null) {
					for(int i = 0; i < target.getType1().getImmunities().length;i++) {
						if(this.type.getType() == target.getType1().getImmunities()[i]) {
							target.setTypeMultiplerIndex(0);
						}
					}
				}if(target.getType2().getImmunities() != null) {
					for(int i = 0; i < target.getType2().getImmunities().length;i++) {
						if(this.type.getType() == target.getType2().getImmunities()[i]) {
							target.setTypeMultiplerIndex(0);
						}
					}
				}
				if(isSpecial) {
					target.setCurrentHp((int)(target.getTypeMultipliers()[target.getTypeMultiplerIndex()]) * target.getCurrentHp() - (this.power *(user.getsAtk()*(int)(user.getMultipliers()[user.getStagesAtk()])/target.getsDef() *(int)(target.getMultipliers()[target.getStagesDef()]))+1));
				}else {
					target.setCurrentHp((int)(target.getTypeMultipliers()[target.getTypeMultiplerIndex()]) * target.getCurrentHp() - (this.power *(user.getAtk()*(int)(user.getMultipliers()[user.getStageAtk()])/target.getDef() *(int)(target.getMultipliers()[target.getStageDef()]))+1));
				}
				if(target.getTypeMultiplerIndex() == 0) {
					PokeStart.battleScreen.setInfoText(user.getName() + " used " + this.name + ", but " + target.getName() + " is immune!");
				}else if(target.getTypeMultiplerIndex() < 3) {
					PokeStart.battleScreen.setInfoText(user.getName() + " used " + this.name + ", but it wasn't very effective!");
				}else if(target.getTypeMultiplerIndex() > 3) {
					PokeStart.battleScreen.setInfoText(user.getName() + " used " + this.name + " and it was super effective!");
				}else {
				PokeStart.battleScreen.setInfoText(user.getName() + " used " + this.name + ".");
				}
			}else {
				System.out.println(user + " " +this.name + " was used");
				PokeStart.battleScreen.setInfoText(user.getName() + " used " + this.name + " but missed.");
				}
			}
	}
}
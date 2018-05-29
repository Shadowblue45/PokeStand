package garrettPokemonTraining;

import java.util.Arrays;

import fahadStartupandMenuScreen.CustomRect;
import startGame.PokeStart;

import java.util.ArrayList;

public class Pokemon {

	private String name;
	private String type1;
	private String type2;
	private int hp;
	private int currentHp;
	private int atk;
	private int stageAtk;
	private int def;
	private int stageDef;
	private int sAtk;
	private int stagesAtk;
	private int sDef;
	private int stagesDef;
	private int spd;
	private int stageSpd;
	private double[] multipliers = {1, .66, .5, .4, .33, .28, .25};
	private String image;
	public ArrayList<Move> moves;
	private String[] twoTypePokemon = {"Torterra","Charizard","Monferno","Primarina","Greninja","Marshtomp"};
	private String[] secondTypes = {"Ground","Flying","Fighting","Fairy","Dark","Ground"};
	private CustomRect hpBar;
	private boolean alive;
	//private String[] grassPokemon = {"Snivy","Servine","Serperior","Turtwig","Grotle","Torterra","Treecko","Grovyle","Sceptile"};
	//private String[] firePokemon = {"Charmander","Charmeleon","Charizard","Cyndaquil","Quilava","Typhlosion","Chimchar","Monferno","Infernape"};
	//private String[] waterPokemon = {"Popplio","Brionne","Primarina","Froakie","Frogadier","Greninja","Mudkip","Marshtomp","Swampert"};

	public Pokemon(String name, String type1, String type2, int hp, int atk, int def, int sAtk, int sDef, int spd, String url) {
		setName(name);
		setType1(type1);
		setType2(type2);
		setHp(hp);
		setAtk(atk);
		setDef(def);
		setsAtk(sAtk);
		setsDef(sDef);
		setSpd(spd);
		setImage(url);
		setMoves();
		stageAtk = 0;
		stageDef = 0;
		stagesAtk = 0;
		stagesDef = 0;
		stageSpd = 0;
		setAlive(true);
	}

	public void setImage(String s) {
		image = s;
	}

	public String getImage() {
		return image;
	}

	public void evolve() {
		String[] pokemonNames = PokeStart.inventory.getNames();
		System.out.println(Arrays.toString(pokemonNames));
		System.out.println(type1);
		if(PokeStart.inventory.getNameIndex() < 2) {
			for(int i = 0; i < twoTypePokemon.length; i++) {
				if(pokemonNames[PokeStart.inventory.getNameIndex() + 1].equals(twoTypePokemon[i])) {
					setType2(secondTypes[i]);
				}
			}
			increaseStats();
			PokeStart.inventory.pokemonIndex++;
			setName(pokemonNames[PokeStart.inventory.getNameIndex() + 1]);
		}
		setImage(PokeStart.inventory.getPokemonImages()[PokeStart.inventory.getNameIndex()]);
		System.out.println(type1);
	}

	public void increaseStats() {
		setHp(getHp() + 10);
		setAtk(getAtk() + 5);
		setDef(getDef() + 5);
		setsAtk(getsAtk() + 5);
		setsDef(getsDef() + 5);
		setSpd(getSpd() + 5);
	}

	public void trainStat(String s) {
		setHp(getHp() + 1);
		if(s.equals("atk")) {
			setAtk(getAtk() + 3);
		}
		if(s.equals("def")) {
			setDef(getDef() + 3);
		}
		if(s.equals("sAtk")) {
			setsAtk(getsAtk() + 3);
		}
		if(s.equals("sDef")) {
			setsDef(getsDef() + 3);
		}
		if(s.equals("spd")) {
			setSpd(getSpd() + 3);
		}
	}

	public void setMoves() {
		moves = new ArrayList<Move>();
		if(name.equals("Charmander")) {
			moves.add(new Move("Growl","Normal",0,100,40,false,PokemonAction.ATTACK,1));
			moves.add(new Move("Scratch","Normal",40,100,35,false,-1,0));
			moves.add(new Move("Ember","Fire",40,100,25,true,-1,0));
			moves.add(new Move("Scary Face","Normal",0,100,10,false,PokemonAction.SPEED,2));
		}
		if(name.equals("Cyndaquil")) {
			moves.add(new Move("Leer","Normal",0,100,30,false,PokemonAction.DEFENSE,1));
			moves.add(new Move("Tackle","Normal",40,100,35,false,-1,0));
			moves.add(new Move("Ember","Fire",40,100,25,true,-1,0));
			moves.add(new Move("Flame Wheel","Fire",60,100,25,false,-1,0));
		}
		if(name.equals("Chimchar")) {
			moves.add(new Move("Leer","Normal",0,100,30,false,PokemonAction.DEFENSE,1));
			moves.add(new Move("Scratch","Normal",40,100,35,false,-1,0));
			moves.add(new Move("Ember","Fire",40,100,25,true,-1,0));
			moves.add(new Move("Fury Swipes","Normal",18,80,15,false,-1,0));
		}
		if(name.equals("Turtwig")) {
			moves.add(new Move("Bite","Dark",60,100,25,false,-1,0));
			moves.add(new Move("Tackle","Normal",40,100,35,false,-1,0));
			moves.add(new Move("Absorb","Grass",20,100,25,true,-1,0));
			moves.add(new Move("Razor Leaf","Grass",55,95,25,false,-1,0));
		}
		if(name.equals("Treecko")) {
			moves.add(new Move("Leer","Normal",0,100,30,false,PokemonAction.DEFENSE,1));
			moves.add(new Move("Pound","Normal",40,100,35,false,-1,0));
			moves.add(new Move("Absorb","Grass",20,100,25,true,-1,0));
			moves.add(new Move("Quick Attack", "Normal", 40, 100, 30, false,-1,0));
		}
		if(name.equals("Snivy")) {
			moves.add(new Move("Leer","Normal",0,100,30,false,PokemonAction.DEFENSE,1));
			moves.add(new Move("Tackle","Normal",40,100,40,false,-1,0));
			moves.add(new Move("Vine Whip","Grass",45,100,25,false,-1,0));
			moves.add(new Move("Wrap","Normal",15,90,20,false,-1,0));
		}
		if(name.equals("Popplio")) {
			moves.add(new Move("Growl","Normal",0,100,40,false,PokemonAction.ATTACK,1));
			moves.add(new Move("Pound","Normal",40,100,35,false,-1,0));
			moves.add(new Move("Water Gun","Water",40,100,25,true,-1,0));
			moves.add(new Move("Aqua Jet","Water",40,100,20,true,-1,0));
		}
		if(name.equals("Froakie")) {
			moves.add(new Move("Growl","Normal",0,100,40,false,PokemonAction.ATTACK,1));
			moves.add(new Move("Pound","Normal",40,100,35,false,-1,0));
			moves.add(new Move("Bubble","Water",40,100,30,true,-1,0));
			moves.add(new Move("Quick Attack", "Normal", 40, 100, 30, false,-1,0));
		}
		if(name.equals("Mudkip")) {
			moves.add(new Move("Growl","Normal",0,100,40,false,PokemonAction.ATTACK,1));
			moves.add(new Move("Tackle","Normal",40,100,40,false,-1,0));
			moves.add(new Move("Water Gun","Water",40,100,25,true,-1,0));
			moves.add(new Move("Mud-Slap","Ground",20,100,10,true,-1,0));
		}
		if(name.equals("Entei")) {
			moves.add(new Move("Extrasensory","Psychic",80,100,20,true,-1,0));
			moves.add(new Move("Fire Blast","Fire",110,85,5,true,-1,0));
			moves.add(new Move("Bite","Dark",60,100,25,false,-1,0));
			moves.add(new Move("Sacred Fire","Fire",100,95,5,false,-1,0));
		}
		if(name.equals("Suicune")) {
			moves.add(new Move("Extrasensory","Psychic",80,100,20,true,-1,0));
			moves.add(new Move("Blizzard","Ice",110,70,5,true,-1,0));
			moves.add(new Move("Aurora Beam","Ice",65,100,20,true,-1,0));
			moves.add(new Move("Hydro Pump","Water",110,80,5,true,-1,0));
		}
		if(name.equals("Raikou")) {
			moves.add(new Move("Thunder","Electric",110,70,10,true,-1,0));
			moves.add(new Move("Crunch","Dark",80,100,15,false,-1,0));
			moves.add(new Move("Discharge","Electric",80,100,15,true,-1,0));
			moves.add(new Move("Extrasensory","Psychic",80,100,20,true,-1,0));
		}
	}

	public ArrayList<Move> getMoves(){
		return moves;
	}

	public void replaceMove(int i, Move move) {
		moves.set(i, move);
	}

	public void emptyMoves() {
		moves = new ArrayList<Move>();
		System.out.println(moves);
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getsAtk() {
		return sAtk;
	}

	public void setsAtk(int sAtk) {
		this.sAtk = sAtk;
	}

	public int getsDef() {
		return sDef;
	}

	public void setsDef(int sDef) {
		this.sDef = sDef;
	}

	public int getSpd() {
		return spd;
	}

	public void setSpd(int spd) {
		this.spd = spd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public int getCurrentHp() {
		return currentHp;
	}

	public void setCurrentHp(int currentHp) {
		this.currentHp = currentHp;
		if(hpBar != null) {
			double divide = ((double)this.getCurrentHp()/this.getHp());
			System.out.println("The " + this.name + " has an Hp ratio of: " + divide);
			if(divide <= 0) {
				System.out.println(this.name + " has fainted.");
				this.alive = false;
				this.hpBar = null;
			}
			else {
				System.out.println(this.name +"currentHp: " + this.getCurrentHp());
				int HpSize = (int) (260*divide);
				hpBar.setDimensions(HpSize, 20);
			}
		}
	}

	public int getStageAtk() {
		return stageAtk;
	}

	public void setStageAtk(int stageAtk) {
		this.stageAtk = stageAtk;
	}

	public int getStageDef() {
		return stageDef;
	}

	public void setStageDef(int stageDef) {
		this.stageDef = stageDef;
	}

	public int getStagesAtk() {
		return stagesAtk;
	}

	public void setStagesAtk(int stagesAtk) {
		this.stagesAtk = stagesAtk;
	}

	public int getStagesDef() {
		return stagesDef;
	}

	public void setStagesDef(int stagesDef) {
		this.stagesDef = stagesDef;
	}

	public int getStageSpd() {
		return stageSpd;
	}

	public void setStageSpd(int stageSpd) {
		this.stageSpd = stageSpd;
	}
	
	public double[] getMultipliers() {
		return multipliers;
	}

	public CustomRect getHpBar() {
		return hpBar;
	}

	public void setHpBar(CustomRect hpBar) {
		this.hpBar = hpBar;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}

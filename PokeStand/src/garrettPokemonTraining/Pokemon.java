package garrettPokemonTraining;

import java.util.Arrays;

import fahadStartupandMenuScreen.CustomRect;
import startGame.PokeStart;

import java.util.ArrayList;

public class Pokemon {

	private String name;
	private Type type1;
	private Type type2;
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
	private int level;
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
		setLevel(5);
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
			moves.add(Move.GROWL);
			moves.add(Move.SCRATCH);
			moves.add(Move.EMBER);
			moves.add(Move.SCARYFACE);
		}
		if(name.equals("Cyndaquil")) {
			moves.add(Move.LEER);
			moves.add(Move.TACKLE);
			moves.add(Move.EMBER);
			moves.add(Move.FLAMEWHEEL);
		}
		if(name.equals("Chimchar")) {
			moves.add(Move.LEER);
			moves.add(Move.SCRATCH);
			moves.add(Move.EMBER);
			moves.add(Move.FURYSWIPES);
		}
		if(name.equals("Turtwig")) {
			moves.add(Move.BITE);
			moves.add(Move.TACKLE);
			moves.add(Move.ABSORB);
			moves.add(Move.RAZORLEAF);
		}
		if(name.equals("Treecko")) {
			moves.add(Move.LEER);
			moves.add(Move.POUND);
			moves.add(Move.ABSORB);
			moves.add(Move.QUICKATTACK);
		}
		if(name.equals("Snivy")) {
			moves.add(Move.LEER);
			moves.add(Move.TACKLE);
			moves.add(Move.VINEWHIP);
			moves.add(Move.WRAP);
		}
		if(name.equals("Popplio")) {
			moves.add(Move.GROWL);
			moves.add(Move.POUND);
			moves.add(Move.WATERGUN);
			moves.add(Move.AQUAJET);
		}
		if(name.equals("Froakie")) {
			moves.add(Move.GROWL);
			moves.add(Move.POUND);
			moves.add(Move.BUBBLE);
			moves.add(Move.QUICKATTACK);
		}
		if(name.equals("Mudkip")) {
			moves.add(Move.GROWL);
			moves.add(Move.TACKLE);
			moves.add(Move.WATERGUN);
			moves.add(Move.MUDSLAP);
		}
		if(name.equals("Entei")) {
			moves.add(Move.EXTRASENSORY);
			moves.add(Move.FIREBLAST);
			moves.add(Move.BITE);
			moves.add(Move.SACREDFIRE);
		}
		if(name.equals("Suicune")) {
			moves.add(Move.EXTRASENSORY);
			moves.add(Move.BLIZZARD);
			moves.add(Move.AURORABEAM);
			moves.add(Move.HYDROPUMP);
		}
		if(name.equals("Raikou")) {
			moves.add(Move.THUNDER);
			moves.add(Move.CRUNCH);
			moves.add(Move.DISCHARGE);
			moves.add(Move.EXTRASENSORY);
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

	public Type getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = new Type("type2");
	}

	public Type getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = new Type("type1");
	}

	public int getCurrentHp() {
		return currentHp;
	}

	public void setCurrentHp(int currentHp) {
		this.currentHp = currentHp;
		if(hpBar != null) {
			double divide = ((double)this.getCurrentHp()/this.getHp());
			if(divide <= 0) {
				this.alive = false;
			}
			else {
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}

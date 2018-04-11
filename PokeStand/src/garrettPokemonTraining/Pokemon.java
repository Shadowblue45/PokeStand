package garrettPokemonTraining;

import java.util.Arrays;

import startGame.PokeStart;

import java.util.ArrayList;

public class Pokemon {

	private String name;
	private String type1;
	private String type2;
	private int hp;
	private int atk;
	private int def;
	private int sAtk;
	private int sDef;
	private int spd;
	private String image;
	private ArrayList<Move> moves;
	private String[] twoTypePokemon = {"Torterra","Charizard","Monferno","Primarina","Greninja","Marshtomp"};
	private String[] secondTypes = {"Ground","Flying","Fighting","Fairy","Dark","Ground"};
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
		setMoves();
		setImage(url);
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
		if(PokeStart.inventory.getNameIndex() < 2) {
			for(int i = 0; i < twoTypePokemon.length; i++) {
				if(pokemonNames[PokeStart.inventory.getNameIndex() + 1].equals(twoTypePokemon[i])) {
					setType2(secondTypes[i]);
				}
			}
			increaseStats();
			setName(pokemonNames[PokeStart.inventory.getNameIndex() + 1]);
		}
		setImage(PokeStart.inventory.getPokemonImages()[PokeStart.inventory.getNameIndex()]);
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
			moves.add(new Move("Growl","Normal",0,100,40,false));
			moves.add(new Move("Scratch","Normal",40,100,35,false));
			moves.add(new Move("Ember","Fire",40,100,25,true));
			moves.add(new Move("Smokescreen","Normal",0,100,20,false));
		}
		if(name.equals("Cyndaquil")) {
			moves.add(new Move("Leer","Normal",0,100,30,false));
			moves.add(new Move("Tackle","Normal",40,100,35,false));
			moves.add(new Move("Ember","Fire",40,100,25,true));
			moves.add(new Move("Smokescreen","Normal",0,100,20,false));
		}
		if(name.equals("Chimchar")) {
			moves.add(new Move("Leer","Normal",0,100,30,false));
			moves.add(new Move("Scratch","Normal",40,100,35,false));
			moves.add(new Move("Ember","Fire",40,100,25,true));
			moves.add(new Move("Taunt","Dark",0,100,20,false));
		}
		if(name.equals("Turtwig")) {
			moves.add(new Move("Withdraw","Water",0,101,40,false));
			moves.add(new Move("Tackle","Normal",40,100,35,false));
			moves.add(new Move("Absorb","Grass",20,100,25,true));
		}
		if(name.equals("Treecko")) {
			moves.add(new Move("Leer","Normal",0,100,30,false));
			moves.add(new Move("Pound","Normal",40,100,35,false));
			moves.add(new Move("Absorb","Grass",20,100,25,true));
			moves.add(new Move("Quick Attack", "Normal", 40, 100, 30, false));
		}
		if(name.equals("Snivy")) {
			moves.add(new Move("Leer","Normal",0,100,30,false));
			moves.add(new Move("Tackle","Normal",40,100,40,false));
			moves.add(new Move("Vine Whip","Grass",45,100,25,false));
			moves.add(new Move("Wrap","Normal",15,90,20,false));
		}
		if(name.equals("Popplio")) {
			moves.add(new Move("Growl","Normal",0,100,40,false));
			moves.add(new Move("Pound","Normal",40,100,35,false));
			moves.add(new Move("Water Gun","Water",40,100,25,true));
			moves.add(new Move("Disarming Voice","Fairy",40,101,15,true));
		}
		if(name.equals("Froakie")) {
			moves.add(new Move("Growl","Normal",0,100,40,false));
			moves.add(new Move("Pound","Normal",40,100,35,false));
			moves.add(new Move("Bubble","Water",40,100,30,true));
			moves.add(new Move("Quick Attack", "Normal", 40, 100, 30, false));
		}
		if(name.equals("Mudkip")) {
			moves.add(new Move("Growl","Normal",0,100,40,false));
			moves.add(new Move("Tackle","Normal",40,100,40,false));
			moves.add(new Move("Water Gun","Water",40,100,25,true));
			moves.add(new Move("Mud-Slap","Ground",20,100,10,true));
		}
	}

	public ArrayList<Move> getMoves(){
		return moves;
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

}

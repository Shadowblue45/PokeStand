package garrettPokemonTraining;

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
	private ArrayList<Move> moves;
	private String[] twoTypePokemon = {"Torterra","Charizard","Monferno","Primarina","Greninja","Marshtomp"};
	private String[] secondTypes = {"Ground","Flying","Fighting","Fairy","Dark","Ground"};
//	private String[] grassPokemon = {"Snivy","Servine","Serperior","Turtwig","Grotle","Torterra","Treecko","Grovyle","Sceptile"};
//	private String[] firePokemon = {"Charmander","Charmeleon","Charizard","Cyndaquil","Quilava","Typhlosion","Chimchar","Monferno","Infernape"};
//	private String[] waterPokemon = {"Popplio","Brionne","Primarina","Froakie","Frogadier","Greninja","Mudkip","Marshtomp","Swampert"};

	public Pokemon(String name, String type1, String type2, int hp, int atk, int def, int sAtk, int sDef, int spd) {
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
	}

	public void evolve() {
		String[] pokemonNames = PokemonTest.inventory.getNames();
		if(PokemonTest.inventory.getNameIndex() < 2) {
			for(int i = 0; i < twoTypePokemon.length; i++) {
				if(pokemonNames[PokemonTest.inventory.getNameIndex() + 1].equals(twoTypePokemon[i])) {
					setType2(secondTypes[i]);
				}
			}
			setName(pokemonNames[PokemonTest.inventory.getNameIndex() + 1]);
		}
	}

	private void setMoves() {
		moves = new ArrayList<Move>();
		for(int i = 0; i < 4; i++) {
			moves.add(new Move("Tackle","Normal",50,100,30,false));
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

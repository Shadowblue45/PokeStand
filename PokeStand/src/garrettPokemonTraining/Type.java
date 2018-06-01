package garrettPokemonTraining;

public class Type {
	
	private String name;
	private int[] weaknesses;
	private int[] resistances;
	private int[] immunities;
	public static int FIRE = 0;
	public static int WATER = 1;
	public static int GRASS = 2;
	public static int ELECTRIC = 3;
	public static int GROUND = 4;
	public static int ICE = 5;
	public static int FLYING = 6;
	public static int FAIRY = 7;
	public static int FIGHTING = 8;
	public static int DARK = 9;
	public static int PSYCHIC = 10;
	public static int ROCK = 11;
	public static int NORMAL = 12;
	
	public Type(String name) {
		this.name = name;
		if(name.equals("Fire")) {
			weaknesses = new int[] {WATER,ROCK,GROUND};
			resistances = new int[] {FIRE,GRASS,ICE,FAIRY};
			immunities = null;
		}else if(name.equals("Water")) {
			weaknesses = new int[] {ELECTRIC,GRASS};
			resistances = new int[] {FIRE,WATER,ICE};
			immunities = null;
		}else if(name.equals("Grass")) {
			weaknesses = new int[] {FLYING,FIRE,GRASS};
			resistances = new int[] {GROUND,WATER,GRASS,ELECTRIC};
			immunities = null;
		}else if(name.equals("Electric")) {
			weaknesses = new int[] {GROUND};
			resistances = new int[] {FLYING,ELECTRIC};
			immunities = null;
		}else if(name.equals("Ground")) {
			weaknesses = new int[] {WATER,GRASS,ICE};
			resistances = new int[] {ROCK};
			immunities = new int[] {ELECTRIC};
		}else if(name.equals("Ice")) {
			weaknesses = new int[] {FIGHTING,ROCK,FIRE};
			immunities = null;
			resistances = new int[] {ICE};
		}else if(name.equals("Flying")) {
			weaknesses = new int[] {ROCK,ELECTRIC,ICE};
			resistances = new int[] {FIGHTING,GRASS};
			immunities = new int[] {GROUND};
		}else if(name.equals("Fairy")) {
			weaknesses = null;
			resistances = new int[] {FIGHTING,DARK};
			immunities = null;
		}else if(name.equals("Fighting")) {
			weaknesses = new int[] {FLYING,PSYCHIC,FAIRY};
			resistances = new int[] {ROCK,DARK};
			immunities = null;
		}else if(name.equals("Dark")) {
			weaknesses = new int[] {FIGHTING,FAIRY};
			resistances = new int[] {DARK};
			immunities = new int[] {PSYCHIC};
		}else if(name.equals("Psychic")) {
			weaknesses = new int[] {DARK};
			resistances = new int[] {FIGHTING,PSYCHIC};
			immunities = null;
		}else if(name.equals("Rock")) {
			weaknesses = new int[] {FIGHTING,GROUND,WATER,GRASS};
			resistances = new int[] {NORMAL,FLYING,FIRE};
			immunities = null;
		}else if(name.equals("Normal")) {
			weaknesses = new int[] {FIGHTING};
			resistances = null;
			immunities = null;
		}
		
	}
	
	public String getTypeName() {
		return name;
	}

}

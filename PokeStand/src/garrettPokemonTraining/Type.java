package garrettPokemonTraining;

public class Type {
	
	private String name;
	private int type;
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
		if(name == null) {
			setImmunities(null);
			setResistances(null);
			setWeaknesses(null);
		}else if(name.equals("Fire")) {
			setType(FIRE);
			setWeaknesses(new int[] {WATER,ROCK,GROUND});
			setResistances(new int[] {FIRE,GRASS,ICE,FAIRY});
			setImmunities(null);
		}else if(name.equals("Water")) {
			setType(WATER);
			setWeaknesses(new int[] {ELECTRIC,GRASS});
			setResistances(new int[] {FIRE,WATER,ICE});
			setImmunities(null);
		}else if(name.equals("Grass")) {
			setType(GRASS);
			setWeaknesses(new int[] {FLYING,FIRE,GRASS});
			setResistances(new int[] {GROUND,WATER,GRASS,ELECTRIC});
			setImmunities(null);
		}else if(name.equals("Electric")) {
			setType(ELECTRIC);
			setWeaknesses(new int[] {GROUND});
			setResistances(new int[] {FLYING,ELECTRIC});
			setImmunities(null);
		}else if(name.equals("Ground")) {
			setType(GROUND);
			setWeaknesses(new int[] {WATER,GRASS,ICE});
			setResistances(new int[] {ROCK});
			setImmunities(new int[] {ELECTRIC});
		}else if(name.equals("Ice")) {
			setType(ICE);
			setWeaknesses(new int[] {FIGHTING,ROCK,FIRE});
			setImmunities(null);
			setResistances(new int[] {ICE});
		}else if(name.equals("Flying")) {
			setType(FLYING);
			setWeaknesses(new int[] {ROCK,ELECTRIC,ICE});
			setResistances(new int[] {FIGHTING,GRASS});
			setImmunities(new int[] {GROUND});
		}else if(name.equals("Fairy")) {
			setType(FAIRY);
			setWeaknesses(null);
			setResistances(new int[] {FIGHTING,DARK});
			setImmunities(null);
		}else if(name.equals("Fighting")) {
			setType(FIGHTING);
			setWeaknesses(new int[] {FLYING,PSYCHIC,FAIRY});
			setResistances(new int[] {ROCK,DARK});
			setImmunities(null);
		}else if(name.equals("Dark")) {
			setType(DARK);
			setWeaknesses(new int[] {FIGHTING,FAIRY});
			setResistances(new int[] {DARK});
			setImmunities(new int[] {PSYCHIC});
		}else if(name.equals("Psychic")) {
			setType(PSYCHIC);
			setWeaknesses(new int[] {DARK});
			setResistances(new int[] {FIGHTING,PSYCHIC});
			setImmunities(null);
		}else if(name.equals("Rock")) {
			setType(ROCK);
			setWeaknesses(new int[] {FIGHTING,GROUND,WATER,GRASS});
			setResistances(new int[] {NORMAL,FLYING,FIRE});
			setImmunities(null);
		}else if(name.equals("Normal")) {
			setType(NORMAL);
			setWeaknesses(new int[] {FIGHTING});
			setResistances(null);
			setImmunities(null);
		}
		
	}
	
	public String getTypeName() {
		return name;
	}

	public int[] getWeaknesses() {
		return weaknesses;
	}

	public void setWeaknesses(int[] weaknesses) {
		this.weaknesses = weaknesses;
	}

	public int[] getResistances() {
		return resistances;
	}

	public void setResistances(int[] resistances) {
		this.resistances = resistances;
	}

	public int[] getImmunities() {
		return immunities;
	}

	public void setImmunities(int[] immunities) {
		this.immunities = immunities;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}

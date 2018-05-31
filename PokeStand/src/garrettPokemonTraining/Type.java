package garrettPokemonTraining;

public class Type {
	
	private String name;
	private Type[] weaknesses;
	private Type[] resistances;
	private Type[] immunities;
	
	public Type(String name) {
		this.name = name;
		if(name.equals("Fire")) {
			weaknesses = new Type[] {new Type("Water"),new Type("Rock"),new Type("Ground")};
			resistances = new Type[] {new Type("Fire"),new Type("Grass"),new Type("Bug"),new Type("Ice"),new Type("Steel"),new Type("Fairy")};
		}
		if(name.equals("Water")) {
			weaknesses = new Type[] {new Type("Electric"),new Type("Grass")};
			resistances = new Type[] {new Type("Fire"),new Type("Water"),new Type("Ice"),new Type("Steel")};
		}
		if(name.equals("Grass")) {
			weaknesses = new Type[] {new Type("Ground"),new Type("Rock"),new Type("Water")};
			resistances = new Type[] {new Type("Ground"),new Type("Water"),new Type("Grass"),new Type("Electric")};
		}
		if(name.equals("Electric")) {
			weaknesses = new Type[] {new Type("Flying"),new Type("Water")};
			resistances = new Type[] {new Type("Flying"),new Type("Steel"),new Type("Electric")};
		}
		if(name.equals("Ground")) {
			weaknesses = new Type[] {new Type("Poison"),new Type("Rock"),new Type("Steel"),new Type("Fire"),new Type("Electric")};
			resistances = new Type[] {new Type("Poison"),new Type("Rock")};
			immunities = new Type[] {new Type("Electric")};
		}
	}
	
	public String getName() {
		return name;
	}

}

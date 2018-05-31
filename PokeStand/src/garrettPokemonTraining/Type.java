package garrettPokemonTraining;

public class Type {
	
	private String name;
	private Type[] weaknesses;
	private Type[] resistances;
	
	public Type(String name) {
		this.name = name;
		if(name.equals("Fire")) {
			weaknesses = new Type[] {new Type("Water"),new Type("Rock"),new Type("Ground")};
			resistances = new Type[] {new Type("Fire"),new Type("Grass"),new Type("Ice"),new Type("Ice"),new Type("Steel"),new Type("Fairy")};
		}
		if(name.equals("Water")) {
			
		}
	}
	

}

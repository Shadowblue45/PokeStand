package garrettPokemonTraining;

public class PokemonSDefense extends PokemonAction {

	private int sDefense;
	
	public PokemonSDefense(int sDefense) {
		this.sDefense = sDefense;
	}

	@Override
	public void act() {
		getTarget().setCurrentsDef(getTarget().getCurrentsDef() - 10 * sDefense);
	}

}

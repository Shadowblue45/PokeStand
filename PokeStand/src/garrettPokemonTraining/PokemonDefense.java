package garrettPokemonTraining;

public class PokemonDefense extends PokemonAction {
	
	private int defense;
	
	public PokemonDefense(int defense) {
		this.defense = defense;
	}

	@Override
	public void act() {
		getTarget().setCurrentDef(getTarget().getCurrentDef() - 10 * defense);
	}

}

package garrettPokemonTraining;

public class PokemonDefense extends PokemonAction {

	@Override
	public void act() {
		getTarget().setCurrentDef(getTarget().getCurrentDef()-10);
	}

}

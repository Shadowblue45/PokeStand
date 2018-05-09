package garrettPokemonTraining;

public class PokemonSDefense extends PokemonAction {

	private int sDefense;

	public PokemonSDefense(int sDefense) {
		this.sDefense = sDefense;
	}

	@Override
	public void act() {
		if(getTarget().getStagesDef() + sDefense >= 6) {
			getTarget().setStagesDef(6);
		}else {
			getTarget().setStagesDef(getTarget().getStagesDef() + sDefense);
		}
	}

}

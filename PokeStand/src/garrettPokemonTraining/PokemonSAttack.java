package garrettPokemonTraining;

public class PokemonSAttack extends PokemonAction {

	private int sAttack;

	public PokemonSAttack(int sAttack) {
		this.sAttack = sAttack;
	}

	@Override
	public void act() {
		getTarget().setCurrentsAtk(getTarget().getCurrentsAtk() - 10 *sAttack);
	}

}

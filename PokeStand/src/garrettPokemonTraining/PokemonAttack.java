package garrettPokemonTraining;

public class PokemonAttack extends PokemonAction {
	
	private int attack;

	public PokemonAttack(int attack) {
		this.attack = attack;
	}

	@Override
	public void act() {
		getTarget().setCurrentAtk(getTarget().getCurrentAtk() - 10 * attack);
	}

}

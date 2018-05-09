package garrettPokemonTraining;

public class PokemonAttack extends PokemonAction {

	private int attack;

	public PokemonAttack(int attack) {
		this.attack = attack;
	}

	@Override
	public void act() {
		if(getTarget().getStageAtk() + attack >= 6) {
			getTarget().setStageAtk(6);
		}else {
			getTarget().setStageAtk(getTarget().getStageAtk() + attack);
		}
	}

}

package garrettPokemonTraining;

public class PokemonSAttack extends PokemonAction {

	private int sAttack;

	public PokemonSAttack(int sAttack) {
		this.sAttack = sAttack;
	}

	@Override
	public void act() {
		if(getTarget().getStagesAtk() + sAttack >= 6) {
			getTarget().setStagesAtk(6);
		}else {
			getTarget().setStagesAtk(getTarget().getStagesAtk() + sAttack);
		}
	}

}

package garrettPokemonTraining;

public class PokemonSpeed extends PokemonAction {

	private int speed;

	public PokemonSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public void act() {
		if(getTarget().getStageSpd() + speed >= 6) {
			getTarget().setStageSpd(6);
		}else {
			getTarget().setStageSpd(getTarget().getStageSpd() + speed);
		}
	}

}

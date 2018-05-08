package garrettPokemonTraining;

public class PokemonSpeed extends PokemonAction {
	
	private int speed;
	
	public PokemonSpeed(int speed) {
		this.speed = speed;
	}
	
	@Override
	public void act() {
		getTarget().setCurrentSpd(getTarget().getCurrentSpd() - 10 * speed);
	}

}

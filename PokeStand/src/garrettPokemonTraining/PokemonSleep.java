package garrettPokemonTraining;

public class PokemonSleep extends PokemonAction {

	
	private int strenghth;
	
	public PokemonSleep(int strength) {
		this.strenghth = strength;
	}
	
	
	@Override
	public void act() {
		getTarget().setCurrentHp(getTarget().getCurrentHp()-10*strenghth);
		
	}

}

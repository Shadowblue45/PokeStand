package garrettPokemonTraining;

public class PokemonDefense extends PokemonAction {

	private int defense;

	public PokemonDefense(int defense) {
		this.defense = defense;
	}

	@Override
	public void act() {
		if(getTarget().getStageDef() + defense >= 6) {
			getTarget().setStageDef(6);
		}else {
			getTarget().setStageDef(getTarget().getStageDef() + defense);
		}
	}

}

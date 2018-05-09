package garrettPokemonTraining;

import guiTeacher.components.Action;

public abstract class PokemonAction implements Action {

	public static final int ATTACK = 0;
	public static final int DEFENSE = 1;
	public static final int SATTACK = 2;
	public static final int SDEFENSE = 3;
	public static final int SPEED = 4;


	private Pokemon target;
	private Action actionOnTarget;


	public PokemonAction() {
		// TODO Auto-generated constructor stub
	}


	public static PokemonAction createAction(int name, int str) {
		switch(name) {
		case ATTACK:
			return new PokemonAttack(str);
		case DEFENSE:
			return new PokemonDefense(str);
		case SATTACK:
			return new PokemonSAttack(str);
		case SDEFENSE:
			return new PokemonSDefense(str);
		case SPEED:
			return new PokemonSpeed(str);
		}
		return null;
	}


	public Pokemon getTarget() {
		return target;
	}



	public void setTarget(Pokemon target) {
		this.target = target;
	}


}

package garrettPokemonTraining;

import guiTeacher.components.Action;

public abstract class PokemonAction implements Action {

	public static final int TACKLE = 0;
	public static final int HARDEN = 1;
	
	
	private Pokemon target;
	private Action actionOnTarget;
	

	public PokemonAction() {
		// TODO Auto-generated constructor stub
	}


	public static PokemonAction createAction(int name, int str) {
		switch(name) {
		case TACKLE:
			return new PokemonSleep(str);
		case HARDEN:
			return new PokemonDefense();
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

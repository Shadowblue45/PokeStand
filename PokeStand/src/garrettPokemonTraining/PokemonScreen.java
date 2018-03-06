package garrettPokemonTraining;

import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class PokemonScreen extends FullFunctionScreen {

	public PokemonScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic poke = new Graphic(125, 105, 300, 300,"resources/fire/Charizard.png");
		viewObjects.add(poke);
	}

}

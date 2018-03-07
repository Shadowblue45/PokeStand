package garrettPokemonTraining;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class PokemonScreen extends FullFunctionScreen {
	
	private Button evolveButton;
	private TextLabel info;

	public PokemonScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		Graphic poke = new Graphic(125, 105, 300, 300,"resources/fire/Charizard.png");
		viewObjects.add(poke);
		info = new TextLabel(200,200,200,100,"Name: " + PokemonTest.inventory.getPokemon().getName());
		viewObjects.add(info);
		evolveButton = new Button(100,100,50,50,"Evolve", new Action() {

			@Override
			public void act() {
				PokemonTest.inventory.getPokemon().evolve();
				info.setText("Name: " + PokemonTest.inventory.getPokemon().getName());
				
			}
			
		});
		viewObjects.add(evolveButton);
		
	}

}

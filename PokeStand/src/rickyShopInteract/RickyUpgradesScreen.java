package rickyShopInteract;

import java.util.ArrayList;
import java.util.List;

import garrettPokemonTraining.Move;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import startGame.PokeStart;

public class RickyUpgradesScreen extends FullFunctionScreen {

	public ArrayList<Move> movesArray;
	
	public RickyUpgradesScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		movesArray = PokeStart.inventory.getPokemon().getMoves();
		Graphic background = new Graphic(getHeight(),getWidth(),0,0,"resources/upgradeBackground.jpg");
		viewObjects.add(background);
	}

}

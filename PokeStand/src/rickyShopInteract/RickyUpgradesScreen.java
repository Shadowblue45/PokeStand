package rickyShopInteract;

import java.util.ArrayList;
import java.util.List;

import garrettPokemonTraining.Move;
import garrettPokemonTraining.Pokemon;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import startGame.PokeStart;

public class RickyUpgradesScreen extends FullFunctionScreen {

	public ArrayList<Move> movesArray;
	private Pokemon p;
	
	public RickyUpgradesScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		Pokemon p = PokeStart.inventory.getPokemon();
		movesArray = p.getMoves();
		addBackground(viewObjects);
	}
	
	public void addBackground(List<Visible> viewObjects) {
		Graphic background = new Graphic(getHeight(),getWidth(),0,0,"resources/upgradebackground.jpg");
		viewObjects.add(background);
	}
	
//	public void addMoves() {
//		if(movesArray.size() == 3) {
//			movesArray.add(p.getMovesToLearn(0));
//		}
//	
//	}
	
//	public void

}

package fahadStartupandMenuScreen;

import java.util.ArrayList;
import java.util.List;

import garrettPokemonTraining.Pokemon;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import startGame.PokeStart;

public class BattleItemScreen extends FullFunctionScreen {

	private Pokemon userPokemon;

	public BattleItemScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		userPokemon = PokeStart.inventory.pokemon;
		createButtons(viewObjects);
		update();
	}

	public void createButtons(List<Visible> viewObjects) {
		ArrayList<String> tempImages = PokeStart.shopScreen.itemsInShop;
		for(int i = 0; i < tempImages.size(); i++) {
			Button button = new Button(60, 50 + i*50, 50, 50,"Use",new Action() {

				@Override
				public void act() {
					
				}

			});
			Graphic a = new Graphic(60, 50 + i*50, 50, 50, tempImages.get(i));

			viewObjects.add(a); 
			viewObjects.add(button);
			update();
		}
	}
	
	public void updateHealth(int hp) {
		userPokemon.setHp(hp + userPokemon.getHp());
		userPokemon.setCurrentHp(userPokemon.getHp());
	}
	
	public void updatePP(int pp) {
		
	}

}

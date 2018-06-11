package Credits;

import java.awt.Color;  
import java.util.List;

import fahadStartupandMenuScreen.CustomRect;
import fahadStartupandMenuScreen.LoadScreen;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import startGame.PokeStart;

public class CreditsScreen extends FullFunctionScreen {

	public CreditsScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	
	public void initAllObjects(List<Visible> viewObjects) {
		PokeStart.setPokemonFont(24f);
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/Dogs.jpg");
		CustomRect rect = new CustomRect(40, 60, 1200, 600);
		TextArea credit = new TextArea(40, 60, 1200, 600, "Selection,Rest & Ability Screen: \n David Li \n\nStart, Load & Menu Screen: \n Fahadullah Asif \n\nInventory & Training Screen: \n Garrett Chen \n\nShop, Interact & Upgrade Screen: \n Ricky Pong \n\nBattle Screen: \n David Yashayev");
		Button backButton = new Button(20,600,200,100,"Back", new Action() {

			@Override
			public void act() {
				PokeStart.loadScreen = new LoadScreen(getWidth(), getHeight());
				PokeStart.start.setScreen(PokeStart.loadScreen);
			}

		});
		viewObjects.add(background);
		viewObjects.add(rect);
		viewObjects.add(credit);
		viewObjects.add(backButton);
		credit.setCustomTextColor(Color.white);
		credit.update();
	}

}

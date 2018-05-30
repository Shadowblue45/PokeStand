package Credits;

import java.awt.Color;  
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.List;

import audioPlayer.AudioTest;
import fahadStartupandMenuScreen.CustomRect;
import fahadStartupandMenuScreen.LoadScreen;
import fahadStartupandMenuScreen.MainMenuScreen;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Component;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import selectionScreen.SelectionScreen;
import startGame.PokeStart;

public class CreditsScreen extends FullFunctionScreen {

	public CreditsScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	
	public void initAllObjects(List<Visible> viewObjects) {
		PokeStart.setPokemonFont(24f);
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/Dogs.jpg");
		CustomRect rect = new CustomRect(240, 160, 800, 400);
		TextArea credit = new TextArea(240, 160, 800, 400, "Selection & Ability Screen: \n David Li \n\nStart, Load & Menu Screen: \n Fahadullah Asif \n\n Snape Dies in Infinity War");
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

package startupandMenuScreen;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;

import audioPlayer.AudioTest;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import startGame.PokeStart;

public class StartScreen extends FullFunctionScreen{
	private TextArea title;
	private TextArea titleBorder;
	
	

	public StartScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	
	public void initAllObjects(List<Visible> viewObjects) {
		PokeStart.setPokemonHollowFont(100f);
		String txt = "Pokemon Rivalry";
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/open field.jpg");
		titleBorder = new TextArea(190,75,900,400,txt);
		titleBorder.setCustomTextColor(new Color(59, 76, 202));
		PokeStart.setPokemonFont(100f);
		title = new TextArea(190,75,1000,400,txt);
		title.setCustomTextColor(new Color(255, 222, 0));
		PokeStart.setPokemonTextFont(32f);
	
		viewObjects.add(background);
		viewObjects.add(title);
		viewObjects.add(titleBorder);
		Button startGameButton = new Button(0, 0, getWidth(), getHeight(), "",new Action() {
			
			public void act() {
				PokeStart.start.setScreen(PokeStart.loadScreen);
				AudioTest.playSound("resources/Pokemon.wav");
			}
		});
		viewObjects.add(startGameButton);
	}

}

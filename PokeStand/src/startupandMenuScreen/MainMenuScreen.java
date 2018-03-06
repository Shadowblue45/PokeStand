package startupandMenuScreen;

import java.lang.reflect.Array;
import java.util.List;

import audioPlayer.AudioTest;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.CustomImageButton;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.userInterfaces.Screen;
import startGame.PokeStart;

public class MainMenuScreen extends FullFunctionScreen {
	
	private int xCord;
	private int yCord;
	private int forLoopPos;

	public MainMenuScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		resetCoordinates();
		Screen[] screens = {PokeStart.loadScreen, PokeStart.loadScreen};
		String[] resourceLinks = {"resources/fire/Charizard.png", "resources/fire/Charizard.png"};
		String[] names = {"Charizard", "Charizard"};
		resetCoordinates();
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/Pokemon Arena.jpg");
		viewObjects.add(background);
		initImages(resourceLinks,viewObjects);
		resetCoordinates();
		initButtons(names, viewObjects, screens);
	}

	public void resetCoordinates() {
		xCord = 40;
		yCord = 450;
		forLoopPos = 0;
	}
	
	public void initImages(String[] resourceLinks, List<Visible> viewObjects) {
		for(int i = 0; i < resourceLinks.length; i++) {
			Graphic icon = new Graphic(xCord, yCord, 250,250,resourceLinks[i]);
			xCord = xCord + 270;
			viewObjects.add(icon);
		}
	}

	public void initButtons(String[] names, List<Visible> viewObjects, Screen[] screens) {
		for(int i = 0; i < names.length; i++) {
			Screen temp = screens[i];
			Button button = new Button (xCord, yCord, 250,250,names[i],new Action() {
				
				public void act() {
					PokeStart.start.setScreen(temp);
				}
			});
			xCord = xCord + 270;
			viewObjects.add(button);
		}
	}

}

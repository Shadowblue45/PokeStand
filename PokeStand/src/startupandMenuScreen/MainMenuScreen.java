package startupandMenuScreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.File;
import java.lang.reflect.Array;
import java.util.List;

import audioPlayer.AudioTest;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.CustomImageButton;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.userInterfaces.Screen;
import startGame.PokeStart;

public class MainMenuScreen extends FullFunctionScreen {
	
	private int xCord;
	private int yCord;
	private int forLoopPos;
	private Graphics2D g;

	public MainMenuScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		resetCoordinates();
		StyledComponent.setButtonOutline(true);
		StyledComponent.setActiveBorderColor(Color.white);
		Screen[] screens = {PokeStart.loadScreen, PokeStart.loadScreen};
		String[] resourceLinks = {"resources/fire/Charizard.png", "resources/fire/Charizard.png"};
		String[] names = {"Training", "Interact", "Rest", "Abilities", "Upgrades", "Shop"};
		resetCoordinates();
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/Pokemon Arena.jpg");
		PokeStart.setPokemonGBFont(100f);
		TextArea daysNum = new TextArea(1050,40, 500, 300, "30");
		PokeStart.setPokemonTextFont(32f);
		TextArea daysRemaining = new TextArea(1000,140, 500, 300, "Days Left");
//		Button blackBkgd = new Button(0, 570, getWidth(), 150, "",null);
//		viewObjects.add(blackBkgd);
//		blackBkgd.setEnabled(false);
//		blackBkgd.setBackground(new Color(0,0,0,140));
//		blackBkgd.update();
//		daysNum.setCustomTextColor(Color.yellow);
		CustomRect rect = new CustomRect(0,yCord-20,getWidth(),120);
		viewObjects.add(background);
		viewObjects.add(rect);
		viewObjects.add(daysNum);
		viewObjects.add(daysRemaining);
		daysNum.setCustomTextColor(Color.white);
		daysRemaining.setCustomTextColor(Color.white);
		setMenuButtons(names, viewObjects, screens, resourceLinks);
	}

	public void drawRect(Graphics2D g) {
		
	}
	
	public void setMenuButtons(String[] names, List<Visible> viewObjects, Screen[] screens, String[] resourceLinks) {
		PokeStart.setPokemonTextFont(24f);
		initButtons(names, viewObjects, screens);
		resetCoordinates();
		//initImages(resourceLinks,viewObjects);
		resetCoordinates();
		initButtons2(names, viewObjects, screens);
		PokeStart.setPokemonTextFont(32f);
	}

	public void resetCoordinates() {
		xCord = 10;
		yCord = 600;
		forLoopPos = 0;
	}
	
	public void initImages(String[] resourceLinks, List<Visible> viewObjects) {
		for(int i = 0; i < resourceLinks.length; i++) {
			Graphic icon = new Graphic(xCord, yCord, 250,250,resourceLinks[i]);
			xCord += 120;
			viewObjects.add(icon);
		}
	}

	public void initButtons(String[] names, List<Visible> viewObjects, Screen[] screens) {
		for(int i = 0; i < names.length; i++) {
			//Screen temp = screens[i];
			Button button = new Button (xCord, yCord, 200,70,"",new Action() {
				
				public void act() {
					//PokeStart.start.setScreen(temp);
				}
			});
			xCord += 210;
			viewObjects.add(button);
			button.setBackground(new Color(0,0,0,140));
			button.update();
		}
	}

	public void initButtons2(String[] names, List<Visible> viewObjects, Screen[] screens) {
		for(int i = 0; i < names.length; i++) {
			//Screen temp = screens[i];
			Button button = new Button (xCord, yCord, 200,70,names[i],new Action() {
				
				public void act() {
					//PokeStart.start.setScreen(temp);
				}
			});
			xCord += 210;
			viewObjects.add(button);
			button.setForeground(Color.white);
		}
	}

}

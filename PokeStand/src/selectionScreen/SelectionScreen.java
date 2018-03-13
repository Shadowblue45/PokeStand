package selectionScreen;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;

import audioPlayer.AudioTest;
import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.userInterfaces.Screen;
import startGame.PokeStart;

public class SelectionScreen extends FullFunctionScreen {
	
	AnimatedComponent charmander;
	AnimatedComponent chimchar;
	AnimatedComponent cyndaquil;
	AnimatedComponent froakie;
	AnimatedComponent mudkip;
	AnimatedComponent popplio;
	AnimatedComponent snivy;
	AnimatedComponent treecko;
	AnimatedComponent turtwig;

	public SelectionScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/selectionbgrnd.jpg");
		viewObjects.add(background);
		
		setPokemon();
		
		TextArea title = new TextArea(350,10,600,50,"CHOOSE YOUR STARTER");
		title.setCustomTextColor(Color.WHITE);
		viewObjects.add(title);
		
		
		charmander = new AnimatedComponent(150, 165, 100, 100);
		charmander.addSequence("resources/spritesheetsTrans/charmander sprite.png", 150, 0, 0, 40, 39, 3);
		Thread run = new Thread(charmander);
		run.start();
		viewObjects.add(charmander);
		
		chimchar = new AnimatedComponent(150, 365, 100, 100);
		chimchar.addSequence("resources/spritesheetsTrans/chimchar sprite.png", 150, 11,54, 56, 49, 10);
		Thread run2 = new Thread(chimchar);
		run2.start();
		viewObjects.add(chimchar);
		
		cyndaquil = new AnimatedComponent(150, 565, 100, 100);
		cyndaquil.addSequence("resources/spritesheetsTrans/cyndaquil sprite.png", 150, 0, 0,49, 38, 10);
		Thread run3 = new Thread(cyndaquil);
		run3.start();
		viewObjects.add(cyndaquil);
		
		froakie = new AnimatedComponent(950, 165, 100, 100);
		froakie.addSequence("resources/spritesheetsTrans/froakie sprite sheet.png", 150, 8, 25, 62, 41, 4);
		Thread run4 = new Thread(froakie);
		run4.start();
		viewObjects.add(froakie);
		
		popplio = new AnimatedComponent(950, 365, 100, 100);
		popplio.addSequence("resources/spritesheetsTrans/popplio sprite.png", 150, 2,3, 62, 50, 4);
		Thread run5= new Thread(popplio);
		run5.start();
		viewObjects.add(popplio);
		
		mudkip = new AnimatedComponent(950, 565, 100, 100);
		mudkip.addSequence("resources/spritesheetsTrans/mudkip sprite.png", 150, 0, 115,38, 36, 5);
		Thread run6 = new Thread(mudkip);
		run6.start();
		viewObjects.add(mudkip);
		
		snivy = new AnimatedComponent(550, 165, 100, 100);
		snivy.addSequence("resources/spritesheetsTrans/sinvvy sprite.png", 150, 2, 98, 48, 49, 9);
		Thread run7 = new Thread(snivy);
		run7.start();
		viewObjects.add(snivy);
		
		treecko = new AnimatedComponent(550, 365, 100, 100);
		treecko.addSequence("resources/spritesheetsTrans/treecko spriteN.png", 150, 92,7, 26,23, 4);
		Thread run8= new Thread(treecko);
		run8.start();
		viewObjects.add(treecko);
		
		turtwig = new AnimatedComponent(550, 565, 100, 100);
		turtwig.addSequence("resources/spritesheetsTrans/turtwig spriteN.png", 150, 5, 4,25, 26, 4);
		Thread run9 = new Thread(turtwig);
		run9.start();
		viewObjects.add(turtwig);
		
		
		Button button = new Button (150, 165, 100,100,"",new Action() {
			
			public void act() {
				AudioTest.playSound("resources/pokemonSounds/252 - Treecko.wav");
				
			}
		});
		viewObjects.add(button);
		
		
		
	}

	public void initButtons(String[] names, List<Visible> viewObjects, Screen[] screens) {
		for(int i = 0; i < names.length; i++) {
			//Screen temp = ;
			Button button = new Button (0, 0, 250,250,"",new Action() {
				
				public void act() {
				}
			});
			viewObjects.add(button);
			button.setBackground(new Color(0,0,0,140));
			button.update();
		}
	}
	
	public void setPokemon() {
		try {
		File fontFile = new File("resources/Pokemon Text.ttf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
		Font baseFont=font.deriveFont(35f);
		StyledComponent.setBaseFont(baseFont);
	} catch (Exception e) {
		e.printStackTrace();
		}
	}
}

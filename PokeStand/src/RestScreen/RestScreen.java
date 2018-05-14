package RestScreen;

import java.awt.Color;
import java.util.List;
import java.util.concurrent.TimeUnit;

import audioPlayer.AudioTest;
import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import startGame.PokeStart;

public class RestScreen extends FullFunctionScreen {

	Graphic background;
	AnimatedComponent pokeball;
	 TextArea infoBox;

	public RestScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		//String[] pokeNames = PokeStart.inventory.getNames(); 
		//String[] pokePic = PokeStart.inventory.getPokemonImages(); 
		//int pIndex = PokeStart.inventory.pokemonIndex;
		
		
	    background = new Graphic(0, 0, getWidth(),getHeight(), "resources/HealAnimation/0.jpg");
		viewObjects.add(background);		
		pokeball = new AnimatedComponent(325, 250, 50, 50);
		pokeball.addSequence("resources/trans pokeball.png", 150, 160, 8, 16, 17, 11);
	
		Graphic textB = new Graphic(500,500, 575, 350, "resources/text box.png");
		viewObjects.add(textB);
		
		PokeStart.setPokemonGBFont(25f);
		
		  infoBox = new TextArea(535, 560, 550, 300, "Would you like to heal "+"Typlosion fully?");
		 infoBox.setCustomTextColor(Color.black);
		 viewObjects.add(infoBox);
		
		
		Button test = new Button(175,200,100,100,"Yes",new Action() {
			
			@Override
			public void act() {
				AudioTest.playSound("resources/Music/rest.wav");
				Thread run = new Thread(pokeball);
				run.start();
				viewObjects.add(pokeball);
	
	
				
	
			}
		});
		viewObjects.add(test);		
		
		
	Button end = new Button(400,200,100,100,"end",new Action() {
			
			@Override
			public void act() {
				viewObjects.remove(pokeball);
				
			}
		});
		viewObjects.add(end);		
		

		
	}

	public static void pause(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	


	

}

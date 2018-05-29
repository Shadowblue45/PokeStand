package RestScreen;

import java.awt.Color;
import java.util.List;
import java.util.concurrent.TimeUnit;

import audioPlayer.AudioTest;
import fahadStartupandMenuScreen.MainMenuScreen;
import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import startGame.PokeStart;

public class RestScreen extends FullFunctionScreen {

	Graphic background;
	Graphic pokemon;
	Graphic textB;
	Graphic textR;
	Graphic confirmationB;
	AnimatedComponent pokeball;
	TextArea infoBox;
	Thread run;

	Button yes;
	Button no;
	Button back;
	public RestScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		
		
		String[] pokeNames = PokeStart.inventory.getNames(); 
		String[] pokePic = PokeStart.inventory.getPokemonImages(); 
		int pIndex = PokeStart.inventory.pokemonIndex;
		
		
	    background = new Graphic(0, 0, getWidth(),getHeight(), "resources/HealAnimation/0.jpg");
		viewObjects.add(background);
		pokemon = new Graphic(0, 0, 40,40, "resources/fire/Cyndaquil.png");
		viewObjects.add(background);	
		pokeball = new AnimatedComponent(325, 250, 50, 50);
		pokeball.addSequence("resources/trans pokeball.png", 150, 160, 8, 16, 17, 11);
		pokeball.setRepeat(false);
	
		 textB = new Graphic(375,500, 575, 350, "resources/text box.png");
		viewObjects.add(textB);
		
		 confirmationB = new Graphic(925,400, 300, 700, "resources/pokecon.png");
		viewObjects.add(confirmationB);
		
		
		PokeStart.setPokemonGBFont(25f);
		
		  infoBox = new TextArea(400, 560, 550, 300, "Would you like to heal "+pokeNames[pIndex]+" fully?[Costs 1 day & restores fatigue bar fully...]");
		 infoBox.setCustomTextColor(Color.black);
		 viewObjects.add(infoBox);
		
		 PokeStart.setPokemonGBFont(20f);
		 yes = new Button(970,420,60,40,"Yes",new Action() {
			
			@Override
			public void act() {
				AudioTest.playSound("resources/Music/rest.wav");
				run = new Thread(pokeball);
				run.start();
				viewObjects.add(pokeball);
				yes.setVisible(false);
				no.setVisible(false);
				back.setVisible(true);
				PokeStart.inventory.fatigue=0;
				if(PokeStart.inventory.daysLeft-1<=0) {
					PokeStart.inventory.daysLeft=0;
				}else {
					PokeStart.inventory.daysLeft-=1;
				}
				PokeStart.mainMenuScreen = new MainMenuScreen(getWidth(), getHeight());
				update();
				infoBox.setText("Pokemon has rested..."
						+ "See you again!");

	
			}

		});
		viewObjects.add(yes);		
		
		
	   no = new Button(970,460,60,40,"No",new Action() {
			
			@Override
			public void act() {
				PokeStart.start.setScreen(PokeStart.mainMenuScreen);	
					
				
				
			}
		});
		viewObjects.add(no);		
		
		 back = new Button(970,420,100,40,"Back",new Action() {
				
				@Override
				public void act() {
					viewObjects.remove(pokeball);
					yes.setVisible(true);
					no.setVisible(true);
					back.setVisible(false);
					PokeStart.start.setScreen(PokeStart.mainMenuScreen);		
					
					
				}
			});
			viewObjects.add(back);	
			back.setVisible(false);
		

		
	}


	
	


	

}


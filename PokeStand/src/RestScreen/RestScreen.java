package RestScreen;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

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
	AnimatedComponent anim;
	
	ArrayList<Graphic> frames;

	Button yes;
	Button no;
	Button back;
	public RestScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		//AudioTest.playSound("resources/Music/pokecenter.wav");
		String[] pokeNames = PokeStart.inventory.getNames(); 
		String[] pokePic = PokeStart.inventory.getPokemonImages(); 
		int pIndex = PokeStart.inventory.pokemonIndex;
		
		
	    background = new Graphic(0, 0, getWidth(),getHeight(), "resources/HealAnimation/0.jpg");
		viewObjects.add(background);
		
		anim = new AnimatedComponent(0, 0, 1280, 720);
		anim.setRepeat(false);
		for(int i = 0; i <= 46; i++){
			anim.addSequence("resources/HealAnimation/"+i+".jpg", 100, 0, 0, 1280, 720,1);
		}
		viewObjects.add(anim);

		pokemon = new Graphic(750, 70, 100,100, pokePic[pIndex]);
		viewObjects.add(pokemon);
		pokeball = new AnimatedComponent(325, 250, 50, 50);
		pokeball.addSequence("resources/trans pokeball.png", 150, 160, 8, 16, 17, 11);
		pokeball.setRepeat(false);
		
	
		 textB = new Graphic(375,500, 575, 350, "resources/text box.png");
		viewObjects.add(textB);
		
		 confirmationB = new Graphic(925,400, 300, 700, "resources/pokecon.png");
		viewObjects.add(confirmationB);
		
		  
		
		PokeStart.setPokemonGBFont(25f);
		
		  infoBox = new TextArea(400, 560, 550, 300, "Would you like to heal "+pokeNames[pIndex]+" fully?   [Costs 1 day]");
		 infoBox.setCustomTextColor(Color.black);
		 viewObjects.add(infoBox);
		
		 PokeStart.setPokemonGBFont(20f);
		 yes = new Button(970,420,60,40,"Yes",new Action() {
			
			@Override
			public void act() {
				AudioTest.playSound("resources/Music/rest.wav");
				viewObjects.remove(background);
				yes.setVisible(false);
				no.setVisible(false);
				textB.setVisible(false);
				confirmationB.setVisible(false);
				pokemon.setVisible(false);
				infoBox.setVisible(false);
				/*
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
				infoBox.setText(pokeNames[pIndex]+" has rested..."
						+ "See you again!");
						*/
				Thread loop= new Thread(anim);
				loop.start();
				viewObjects.add(anim);
				
				Thread run = new Thread(new Runnable() {
					
					@Override
					public void run() {
						

						try {
							Thread.sleep(5000);
							System.out.println("check");
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						PokeStart.inventory.fatigue=0;
						if(PokeStart.inventory.daysLeft-1<=0) {
							PokeStart.inventory.daysLeft=0;
						}else {
							PokeStart.inventory.daysLeft-=1;
						}
						PokeStart.mainMenuScreen = new MainMenuScreen(getWidth(), getHeight());
						update();
						PokeStart.start.setScreen(PokeStart.mainMenuScreen);
						
					}
				});
				run.start();
	
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
					pokemon.setVisible(true);
					back.setVisible(false);
					PokeStart.start.setScreen(PokeStart.mainMenuScreen);		
					
					
				}
			});
			viewObjects.add(back);	
			back.setVisible(false);
		

		
	}



	


	

}


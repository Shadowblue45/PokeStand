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
import startupandMenuScreen.CustomRect;

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
	
	Button buttonF1;
	Button buttonF2;
	Button buttonF3;
	Button buttonG1;
	Button buttonG2;
	Button buttonG3;
	Button buttonW1;
	Button buttonW2;
	Button buttonW3;
	
	

	public SelectionScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/selectionbgrnd.jpg");
		viewObjects.add(background);
		
		CustomRect rect = new CustomRect(0, 0, getWidth(), getHeight(), new Color(0,0,0,100));
		viewObjects.add(rect);
		
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
		cyndaquil.addSequence("resources/spritesheetsTrans/cyndaquil sprite.png", 150, 2, 0,49, 38, 10);
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
		mudkip.addSequence("resources/spritesheets/mudkip sprite sheet.png", 150, 1, 115,38, 36, 5);
		Thread run6 = new Thread(mudkip);
		run6.start();
		viewObjects.add(mudkip);
		
		snivy = new AnimatedComponent(550, 165, 100, 100);
		snivy.addSequence("resources/spritesheetsTrans/sinvvy sprite.png", 150, 2, 98, 48, 49, 9);
		Thread run7 = new Thread(snivy);
		run7.start();
		viewObjects.add(snivy);
		
		treecko = new AnimatedComponent(550, 365, 100, 100);
		treecko.addSequence("resources/spritesheetsTrans/treecko spriteN.png", 150, 94,7, 26,23, 4);
		Thread run8= new Thread(treecko);
		run8.start();
		viewObjects.add(treecko);
		
		turtwig = new AnimatedComponent(550, 565, 100, 100);
		turtwig.addSequence("resources/spritesheetsTrans/turtwig spriteN.png", 150, 5, 4,25, 26, 4);
		Thread run9 = new Thread(turtwig);
		run9.start();
		viewObjects.add(turtwig);
		
		
	//FIRE POKEMON	
		
		  buttonF1 = new Button (150, 165, 100,100,"",new Action() {
			
			public void act() {
				AudioTest.playSound("resources/pokemonSounds/004 - Charmander.wav");
				CustomRect rect = new CustomRect(0, 0, getWidth(), getHeight(), new Color(0,0,0,150));
				viewObjects.add(rect);
				viewObjects.remove(charmander);
				viewObjects.add(charmander);
				
				buttonF1.setEnabled(false);
				setPokemonGB();
				
				Graphic background = new Graphic(250,165, 300, 400, "resources/text box.png");
				viewObjects.add(background);
				
				
				TextArea infoBox = new TextArea(275, 180, 300, 400, "Are you sure you want Charmander to be your pokemon?");
				infoBox.setCustomTextColor(Color.black);
				viewObjects.add(infoBox);
				
				
				Button buttonY = new Button(275,200,100,100,"Yes", new Action() {
					
					@Override
					public void act() {
						System.out.println("YES");
						
						
						
					}
				});
				
				Button buttonN = new Button(375,200,100,100,"No", new Action() {
					
					
					public void act() {
						System.out.println("No");
						
					}
				});
				viewObjects.add(buttonY);
				viewObjects.add(buttonN);
				
				
			}
		});
		viewObjects.add(buttonF1);
		
		 buttonF2 = new Button (150, 365, 100,100,"",new Action() {
			
			public void act() {
				AudioTest.playSound("resources/pokemonSounds/390 - Chimchar.wav");
				//sets selectetd pokemon to starter pokemon
				
			}
		});
		viewObjects.add(buttonF2);
		
		
		 buttonF3 = new Button (150,565, 100,100,"",new Action() {
			
			public void act() {
				AudioTest.playSound("resources/pokemonSounds/155 - Cyndaquil.wav");
				//sets selectetd pokemon to starter pokemon
				
			}
		});
		viewObjects.add(buttonF3);
		////////////////////////////////////////////////////////////////////////////////////////
		
		//GRASS POKEMON
		
		 buttonG1 = new Button (550, 165, 100,100,"",new Action() {
			
			public void act() {
				AudioTest.playSound("resources/pokemonSounds/495 - Snivy.wav");
				//sets selectetd pokemon to starter pokemon
				
			}
		});
		viewObjects.add(buttonG1);
		
		 buttonG2 = new Button (550, 365, 100,100,"",new Action() {
			
			public void act() {
				AudioTest.playSound("resources/pokemonSounds/252 - Treecko.wav");
				//sets selectetd pokemon to starter pokemon
				
			}
		});
		viewObjects.add(buttonG2);
		
		
		 buttonG3 = new Button (550,565, 100,100,"",new Action() {
			
			public void act() {
				AudioTest.playSound("resources/pokemonSounds/387 - Turtwig.wav");
				//sets selectetd pokemon to starter pokemon
				
			}
		});
		viewObjects.add(buttonG3);
		
		////////////////////////////////////////////////////////////////////////////////////////
		
		//WATER POKEMON
		
		 buttonW1 = new Button (950, 165, 100,100,"",new Action() {
			
			public void act() {
				AudioTest.playSound("resources/pokemonSounds/656 - Froakie.wav");
				//sets selectetd pokemon to starter pokemon
				
			}
		});
		viewObjects.add(buttonW1);
		
		 buttonW2 = new Button (950, 365, 100,100,"",new Action() {
			
			public void act() {
				AudioTest.playSound("resources/pokemonSounds/728 - Popplio.wav");
				//sets selectetd pokemon to starter pokemon
				
			}
		});
		viewObjects.add(buttonW2);
		
		 buttonW3 = new Button (950, 565, 100,100,"",new Action() {
			
			public void act() {
				AudioTest.playSound("resources/pokemonSounds/258 - Mudkip.wav");
				//sets selectetd pokemon to starter pokemon
				
			}
		});
		viewObjects.add(buttonW3);
		
		
	
	    
		
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
	
	public void setPokemonGB() {
		try {
		File fontFile = new File("resources/Pokemon GB.ttf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
		Font baseFont=font.deriveFont(12f);
		StyledComponent.setBaseFont(baseFont);
	} catch (Exception e) {
		e.printStackTrace();
		}
	}
}

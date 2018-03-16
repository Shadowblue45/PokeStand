package selectionScreen;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;

import audioPlayer.AudioTest;
import garrettPokemonTraining.Inventory;
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
	
	Button buttonYF1;
	Button buttonYF2;
	Button buttonYF3;
	Button buttonYG1;
	Button buttonYG2;
	Button buttonYG3;
	Button buttonYW1;
	Button buttonYW2;
	Button buttonYW3;
	
	Button buttonNF1;
	Button buttonNF2;
	Button buttonNF3;
	Button buttonNG1;
	Button buttonNG2;
	Button buttonNG3;
	Button buttonNW1;
	Button buttonNW2;
	Button buttonNW3;
	
	Graphic textB;
	TextArea infoBox;
	CustomRect rectT;
	
	

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
		
		//CONFIRMATION BUTTONS FOR EACH POKEMON [ WILL MAKE FOR LOOP FUNCTION FOR IT AFTER PROJECT IS COMPLETE ]
		
		setPokemonGB();
		
		//FIRE POKEMON CONFIRMATION BUTTONS
		buttonYF1 = new Button(275,200,100,100,"Yes", new Action() {
			
			@Override
			public void act() {
				System.out.println("YES");
			
				
			
				
				
			}
		});
		
		 buttonNF1 = new Button(375,200,100,100,"No", new Action() {
			
			
			public void act() {
				System.out.println("No");
				viewObjects.remove(rectT);
				viewObjects.remove(textB);
				viewObjects.remove(infoBox);
				buttonNF1.setVisible(false);
				buttonYF1.setVisible(false);
				buttonF1.setEnabled(true);
			
				
			}
		});
		viewObjects.add(buttonYF1);
		viewObjects.add(buttonNF1);
		buttonYF1.setVisible(false);
		buttonNF1.setVisible(false);
		
		buttonYF2 = new Button(275,400,100,100,"Yes", new Action() {
			
			@Override
			public void act() {
				System.out.println("YES");

				
			
				
				
			}
		});
		
		 buttonNF2 = new Button(375,400,100,100,"No", new Action() {
			
			
			public void act() {
				System.out.println("No");
				viewObjects.remove(rectT);
				viewObjects.remove(textB);
				viewObjects.remove(infoBox);
				buttonNF2.setVisible(false);
				buttonYF2.setVisible(false);
				buttonF2.setEnabled(true);
			
				
			}
		});
		viewObjects.add(buttonYF2);
		viewObjects.add(buttonNF2);
		buttonYF2.setVisible(false);
		buttonNF2.setVisible(false);
		
		buttonYF3 = new Button(275,600,100,100,"Yes", new Action() {
			
			@Override
			public void act() {
				System.out.println("YES");

				
			
				
				
			}
		});
		
		 buttonNF3 = new Button(375,600,100,100,"No", new Action() {
			
			
			public void act() {
				System.out.println("No");
				viewObjects.remove(rectT);
				viewObjects.remove(textB);
				viewObjects.remove(infoBox);
				buttonNF3.setVisible(false);
				buttonYF3.setVisible(false);
				buttonF3.setEnabled(true);
			
				
			}
		});
		viewObjects.add(buttonYF3);
		viewObjects.add(buttonNF3);
		buttonYF3.setVisible(false);
		buttonNF3.setVisible(false);
	
		//WATER POKEMON CONFIRMATION BUTTONS
	buttonYW1 = new Button(275,200,100,100,"Yes", new Action() {
			
			@Override
			public void act() {
				System.out.println("YES");

				
			
				
				
			}
		});
		
		 buttonNW1 = new Button(375,200,100,100,"No", new Action() {
			
			
			public void act() {
				System.out.println("No");
				viewObjects.remove(rectT);
				viewObjects.remove(textB);
				viewObjects.remove(infoBox);
				buttonNW1.setVisible(false);
				buttonYW1.setVisible(false);
				buttonW1.setEnabled(true);
			
				
			}
		});
		viewObjects.add(buttonYW1);
		viewObjects.add(buttonNW1);
		buttonYW1.setVisible(false);
		buttonNW1.setVisible(false);
		
		buttonYW2 = new Button(275,200,100,100,"Yes", new Action() {
			
			@Override
			public void act() {
				System.out.println("YES");

				
			
				
				
			}
		});
		
		 buttonNW2 = new Button(375,200,100,100,"No", new Action() {
			
			
			public void act() {
				System.out.println("No");
				viewObjects.remove(rectT);
				viewObjects.remove(textB);
				viewObjects.remove(infoBox);
				buttonNW2.setVisible(false);
				buttonYW2.setVisible(false);
				buttonW2.setEnabled(true);
			
				
			}
		});
		viewObjects.add(buttonYW2);
		viewObjects.add(buttonNW2);
		buttonYW2.setVisible(false);
		buttonNW2.setVisible(false);
		
		buttonYW3 = new Button(275,200,100,100,"Yes", new Action() {
			
			@Override
			public void act() {
				System.out.println("YES");

				
			
				
				
			}
		});
		
		 buttonNW3 = new Button(375,200,100,100,"No", new Action() {
			
			
			public void act() {
				System.out.println("No");
				viewObjects.remove(rectT);
				viewObjects.remove(textB);
				viewObjects.remove(infoBox);
				buttonNW3.setVisible(false);
				buttonYW3.setVisible(false);
				buttonW3.setEnabled(true);
			
				
			}
		});
		viewObjects.add(buttonYW3);
		viewObjects.add(buttonNW3);
		buttonYW3.setVisible(false);
		buttonNW3.setVisible(false);
		
		//GRASS POKEMON CONFIRMATION BUTTONS
	buttonYG1 = new Button(675,200,100,100,"Yes", new Action() {
			
			@Override
			public void act() {
				System.out.println("YES");

				
			
				
				
			}
		});
		
		 buttonNG1 = new Button(775,200,100,100,"No", new Action() {
			
			
			public void act() {
				System.out.println("No");
				viewObjects.remove(rectT);
				viewObjects.remove(textB);
				viewObjects.remove(infoBox);
				buttonNG1.setVisible(false);
				buttonYG1.setVisible(false);
				buttonG1.setEnabled(true);
			
				
			}
		});
		viewObjects.add(buttonYG1);
		viewObjects.add(buttonNG1);
		buttonYG1.setVisible(false);
		buttonNG1.setVisible(false);
		
		buttonYG2 = new Button(675,400,100,100,"Yes", new Action() {
			
			@Override
			public void act() {
				System.out.println("YES");

				
			
				
				
			}
		});
		
		 buttonNG2 = new Button(775,400,100,100,"No", new Action() {
			
			
			public void act() {
				System.out.println("No");
				viewObjects.remove(rectT);
				viewObjects.remove(textB);
				viewObjects.remove(infoBox);
				buttonNG2.setVisible(false);
				buttonYG2.setVisible(false);
				buttonG2.setEnabled(true);
			
				
			}
		});
		viewObjects.add(buttonYG2);
		viewObjects.add(buttonNG2);
		buttonYG2.setVisible(false);
		buttonNG2.setVisible(false);
		
		buttonYG3 = new Button(675,600,100,100,"Yes", new Action() {
			
			@Override
			public void act() {
				System.out.println("YES");

				
			
				
				
			}
		});
		
		 buttonNG3 = new Button(775,600,100,100,"No", new Action() {
			
			
			public void act() {
				System.out.println("No");
				viewObjects.remove(rectT);
				viewObjects.remove(textB);
				viewObjects.remove(infoBox);
				buttonNG3.setVisible(false);
				buttonYG3.setVisible(false);
				buttonG3.setEnabled(true);
			
				
			}
		});
		viewObjects.add(buttonYG3);
		viewObjects.add(buttonNG3);
		buttonYG3.setVisible(false);
		buttonNG3.setVisible(false);

		
		
	//FIRE POKEMON	
		//275 200
		  buttonF1 = new Button (150, 165, 100,100,"",new Action() {
			
			public void act() {
				AudioTest.playSound("resources/pokemonSounds/004 - Charmander.wav");
				rectT = new CustomRect(0, 0, getWidth(), getHeight(), new Color(0,0,0,150));
				viewObjects.add(rectT);
				viewObjects.remove(charmander);
				viewObjects.add(charmander);
				
				buttonF1.setEnabled(false);
				setPokemonGB();
				
				textB = new Graphic(250,165, 300, 400, "resources/text box.png");
				viewObjects.add(textB);
				
				
			    infoBox = new TextArea(275, 180, 300, 400, "Are you sure you want Charmander to be your pokemon?");
				infoBox.setCustomTextColor(Color.black);
				viewObjects.add(infoBox);
				
	
				
				viewObjects.remove(buttonYF1);
				viewObjects.add(buttonYF1);
				buttonYF1.setVisible(true);
				
				viewObjects.remove(buttonNF1);
				viewObjects.add(buttonNF1);
				buttonNF1.setVisible(true);

				
				
			}
		});
		viewObjects.add(buttonF1);
		// 275 400
		//+125 + 35
		 buttonF2 = new Button (150, 365, 100,100,"",new Action() {
			
			public void act() {
				AudioTest.playSound("resources/pokemonSounds/390 - Chimchar.wav");
				rectT = new CustomRect(0, 0, getWidth(), getHeight(), new Color(0,0,0,150));
				viewObjects.add(rectT);
				viewObjects.remove(chimchar);
				viewObjects.add(chimchar);
				
				buttonF2.setEnabled(false);
				setPokemonGB();
				
				textB = new Graphic(250,365, 300, 400, "resources/text box.png");
				viewObjects.add(textB);
				
				
			    infoBox = new TextArea(275, 380, 300, 400, "Are you sure you want Chimchar to be your pokemon?");
				infoBox.setCustomTextColor(Color.black);
				viewObjects.add(infoBox);
				
	
				
				viewObjects.remove(buttonYF2);
				viewObjects.add(buttonYF2);
				buttonYF2.setVisible(true);
				
				viewObjects.remove(buttonNF2);
				viewObjects.add(buttonNF2);
				buttonNF2.setVisible(true);
				
			}
		});
		viewObjects.add(buttonF2);
		
		
		 buttonF3 = new Button (150,565, 100,100,"",new Action() {
			
			public void act() {
				AudioTest.playSound("resources/pokemonSounds/155 - Cyndaquil.wav");
				rectT = new CustomRect(0, 0, getWidth(), getHeight(), new Color(0,0,0,150));
				viewObjects.add(rectT);
				viewObjects.remove(cyndaquil);
				viewObjects.add(cyndaquil);
				
				buttonF3.setEnabled(false);
				setPokemonGB();
				
				textB = new Graphic(250,565, 300, 400, "resources/text box.png");
				viewObjects.add(textB);
				
				
			    infoBox = new TextArea(275, 580, 300, 400, "Are you sure you want Cyndaquil to be your pokemon?");
				infoBox.setCustomTextColor(Color.black);
				viewObjects.add(infoBox);
				
	
				
				viewObjects.remove(buttonYF3);
				viewObjects.add(buttonYF3);
				buttonYF3.setVisible(true);
				
				viewObjects.remove(buttonNF3);
				viewObjects.add(buttonNF3);
				buttonNF3.setVisible(true);
				
			}
		});
		viewObjects.add(buttonF3);
		////////////////////////////////////////////////////////////////////////////////////////
		
		//GRASS POKEMON
		
		 buttonG1 = new Button (550, 165, 100,100,"",new Action() {
			
			public void act() {
				AudioTest.playSound("resources/pokemonSounds/495 - Snivy.wav");
				rectT = new CustomRect(0, 0, getWidth(), getHeight(), new Color(0,0,0,150));
				viewObjects.add(rectT);
				viewObjects.remove(snivy);
				viewObjects.add(snivy);
				
				buttonF3.setEnabled(false);
				setPokemonGB();
				
				textB = new Graphic(650,165, 300, 400, "resources/text box.png");
				viewObjects.add(textB);
				
				
			    infoBox = new TextArea(675, 180, 300, 400, "Are you sure you want Snivy to be your pokemon?");
				infoBox.setCustomTextColor(Color.black);
				viewObjects.add(infoBox);
				
	
				
				viewObjects.remove(buttonYG1);
				viewObjects.add(buttonYG1);
				buttonYG1.setVisible(true);
				
				viewObjects.remove(buttonNG1);
				viewObjects.add(buttonNG1);
				buttonNG1.setVisible(true);
				
			}
		});
		viewObjects.add(buttonG1);
		
		 buttonG2 = new Button (550, 365, 100,100,"",new Action() {
			
			public void act() {
				AudioTest.playSound("resources/pokemonSounds/252 - Treecko.wav");
				rectT = new CustomRect(0, 0, getWidth(), getHeight(), new Color(0,0,0,150));
				viewObjects.add(rectT);
				viewObjects.remove(treecko);
				viewObjects.add(treecko);
				
				buttonG2.setEnabled(false);
				setPokemonGB();
				
				textB = new Graphic(650,365, 300, 400, "resources/text box.png");
				viewObjects.add(textB);
				
				
			    infoBox = new TextArea(675, 380, 300, 400, "Are you sure you want Treecko to be your pokemon?");
				infoBox.setCustomTextColor(Color.black);
				viewObjects.add(infoBox);
				
	
				
				viewObjects.remove(buttonYG2);
				viewObjects.add(buttonYG2);
				buttonYG2.setVisible(true);
				
				viewObjects.remove(buttonNG2);
				viewObjects.add(buttonNG2);
				buttonNG2.setVisible(true);
				
			}
		});
		viewObjects.add(buttonG2);
		
		
		 buttonG3 = new Button (550,565, 100,100,"",new Action() {
			
			public void act() {
				AudioTest.playSound("resources/pokemonSounds/387 - Turtwig.wav");
				rectT = new CustomRect(0, 0, getWidth(), getHeight(), new Color(0,0,0,150));
				viewObjects.add(rectT);
				viewObjects.remove(turtwig);
				viewObjects.add(turtwig);
				
				buttonG3.setEnabled(false);
				setPokemonGB();
				
				textB = new Graphic(650,565, 300, 400, "resources/text box.png");
				viewObjects.add(textB);
				
				
			    infoBox = new TextArea(676, 580, 300, 400, "Are you sure you want Turtwig to be your pokemon?");
				infoBox.setCustomTextColor(Color.black);
				viewObjects.add(infoBox);
				
	
				
				viewObjects.remove(buttonYG3);
				viewObjects.add(buttonYG3);
				buttonYG3.setVisible(true);
				
				viewObjects.remove(buttonNG3);
				viewObjects.add(buttonNG3);
				buttonNG3.setVisible(true);
				
			}
		});
		viewObjects.add(buttonG3);
		
		////////////////////////////////////////////////////////////////////////////////////////
		
		//WATER POKEMON
		
		 buttonW1 = new Button (950, 165, 100,100,"",new Action() {
			
			public void act() {
				AudioTest.playSound("resources/pokemonSounds/656 - Froakie.wav");
				rectT = new CustomRect(0, 0, getWidth(), getHeight(), new Color(0,0,0,150));
				viewObjects.add(froakie);
				viewObjects.remove(froakie);
				viewObjects.add(froakie);
				
				buttonW3.setEnabled(false);
				setPokemonGB();
				
				textB = new Graphic(1050,165, 300, 400, "resources/text box.png");
				viewObjects.add(textB);
				
				
			    infoBox = new TextArea(1075, 180, 300, 400, "Are you sure you want Froakie to be your pokemon?");
				infoBox.setCustomTextColor(Color.black);
				viewObjects.add(infoBox);
				
	
				
				viewObjects.remove(buttonYW1);
				viewObjects.add(buttonYW1);
				buttonYW1.setVisible(true);
				
				viewObjects.remove(buttonNW1);
				viewObjects.add(buttonNW1);
				buttonNW1.setVisible(true);
				
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

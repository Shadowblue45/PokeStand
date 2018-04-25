package selectionScreen;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;

import audioPlayer.AudioTest;
import garrettPokemonTraining.Inventory;
import garrettPokemonTraining.Pokemon;
import garrettPokemonTraining.StatTrainingScreen;
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
import startupandMenuScreen.MainMenuScreen;
import startupandMenuScreen.TrainingScreen;

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

		StyledComponent.setButtonOutline(false);
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/selectionbgrnd.jpg");
		viewObjects.add(background);
		
		CustomRect rect = new CustomRect(0, 0, getWidth(), getHeight(), new Color(0,0,0,100));
		viewObjects.add(rect);
		
		setPokemon();
		
		TextArea title = new TextArea(350,10,600,50,"CHOOSE YOUR STARTER");
		title.setCustomTextColor(Color.WHITE);
		viewObjects.add(title);
		
		
		charmander = new AnimatedComponent(50, 165, 100, 100);
		charmander.addSequence("resources/spritesheetsTrans/charmander sprite.png", 150, 0, 0, 40, 39, 3);
		Thread run = new Thread(charmander);
		run.start();
		viewObjects.add(charmander);
		
		chimchar = new AnimatedComponent(50, 365, 100, 100);
		chimchar.addSequence("resources/spritesheetsTrans/chimchar sprite.png", 150, 11,54, 56, 49, 10);
		Thread run2 = new Thread(chimchar);
		run2.start();
		viewObjects.add(chimchar);
		
		cyndaquil = new AnimatedComponent(50, 565, 100, 100);
		cyndaquil.addSequence("resources/spritesheetsTrans/cyndaquil sprite.png", 150, 2, 0,49, 38, 10);
		Thread run3 = new Thread(cyndaquil);
		run3.start();
		viewObjects.add(cyndaquil);
		
		froakie = new AnimatedComponent(850, 165, 100, 100);
		froakie.addSequence("resources/spritesheetsTrans/froakie sprite sheet.png", 150, 8, 25, 62, 41, 4);
		Thread run4 = new Thread(froakie);
		run4.start();
		viewObjects.add(froakie);
		
		popplio = new AnimatedComponent(850, 365, 100, 100);
		popplio.addSequence("resources/spritesheetsTrans/popplio sprite.png", 150, 2,3, 62, 50, 4);
		Thread run5= new Thread(popplio);
		run5.start();
		viewObjects.add(popplio);
		
		mudkip = new AnimatedComponent(850, 565, 100, 100);
		mudkip.addSequence("resources/spritesheets/mudkip sprite sheet.png", 150, 1, 115,38, 36, 5);
		Thread run6 = new Thread(mudkip);
		run6.start();
		viewObjects.add(mudkip);
		
		snivy = new AnimatedComponent(450, 165, 100, 100);
		snivy.addSequence("resources/spritesheetsTrans/sinvvy sprite.png", 150, 2, 98, 48, 49, 9);
		Thread run7 = new Thread(snivy);
		run7.start();
		viewObjects.add(snivy);
		
		treecko = new AnimatedComponent(450, 365, 100, 100);
		treecko.addSequence("resources/spritesheetsTrans/treecko spriteN.png", 150, 94,7, 26,23, 4);
		Thread run8= new Thread(treecko);
		run8.start();
		viewObjects.add(treecko);
		
		turtwig = new AnimatedComponent(450, 565, 100, 100);
		turtwig.addSequence("resources/spritesheetsTrans/turtwig spriteN.png", 150, 5, 4,25, 26, 4);
		Thread run9 = new Thread(turtwig);
		run9.start();
		viewObjects.add(turtwig);
		
		//CONFIRMATION BUTTONS FOR EACH POKEMON [ WILL MAKE FOR LOOP FUNCTION FOR IT AFTER PROJECT IS COMPLETE ]
		
		setPokemonGB();
		
		//FIRE POKEMON CONFIRMATION BUTTONS
		buttonYF1 = new Button(175,200,100,100,"Yes", new Action() {
			
			@Override
			public void act() {
				//System.out.println("YES");
				PokeStart.inventory.setPokemon("Charmander", "Fire", "", 30, 23, 14, 54, 21, 2333, "resources/fire/Charmander.png");
				String[] F1= {"Charmander","Charmeleon","Charizard"};
				String[] FP1 = {"resources/fire/Charmander.png","resources/fire/Charmeleon.png","resources/fire/Charizard.png"};
				PokeStart.inventory.setImages(FP1);
				PokeStart.inventory.setNames(F1);
//				System.out.println(PokeStart.inventory.pokemonImages[0]);
				MainMenuScreen.name.setText(F1[0]);
				MainMenuScreen.pokemon.loadImages(FP1[0], 400, 400);
				Pokemon p = PokeStart.inventory.getPokemon();
				System.out.println(p.getType1());
				MainMenuScreen.info.setText("Type1: " + p.getType1() + "\n" +
						"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
						"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
						"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
						"Spd: " + p.getSpd() + "\n");
				StatTrainingScreen.updatePokemon();
				StatTrainingScreen.info.setText("Name: " + p.getName() + "\n" + "Type1: " + p.getType1() + "\n" +
						"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
						"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
						"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
						"Spd: " + p.getSpd() + "\n");
				StatTrainingScreen.poke.loadImages(FP1[0],300,300);
				//TrainingScreen.name.setText(F1[0]);
				//TrainingScreen.pokemon.loadImages(FP1[0], 400, 400);
				update();
				PokeStart.inventory.save();
				PokeStart.start.setScreen(PokeStart.mainMenuScreen);
			}
		});
		
		 buttonNF1 = new Button(275,200,100,100,"No", new Action() {
			
			
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
		
		buttonYF2 = new Button(175,400,100,100,"Yes", new Action() {
			
			@Override
			public void act() {
				System.out.println("YES");
				PokeStart.inventory.setPokemon("Chimchar", "Fire", "", 30, 23, 14, 54, 21, 23, "resources/fire/Chimchar.png");
				String[] F1= {"Chimchar","Monferno","Infernape"};
				String[] FP1 = {"resources/fire/Chimchar.png","resources/fire/Monferno.png","resources/fire/Infernape.png"};
				PokeStart.inventory.setImages(FP1);
				PokeStart.inventory.setNames(F1);
				MainMenuScreen.name.setText(F1[0]);
				MainMenuScreen.pokemon.loadImages(FP1[0], 400, 400);
				Pokemon p = PokeStart.inventory.getPokemon();
				System.out.println(p.getType1());
				MainMenuScreen.info.setText("Type1: " + p.getType1() + "\n" +
						"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
						"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
						"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
						"Spd: " + p.getSpd() + "\n");
				StatTrainingScreen.updatePokemon();
				StatTrainingScreen.info.setText("Name: " + p.getName() + "\n" + "Type1: " + p.getType1() + "\n" +
						"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
						"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
						"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
						"Spd: " + p.getSpd() + "\n");
				StatTrainingScreen.poke.loadImages(FP1[0],300,300);
				//TrainingScreen.name.setText(F1[0]);
				//TrainingScreen.pokemon.loadImages(FP1[0], 400, 400);
				update();
				PokeStart.inventory.save();
				PokeStart.start.setScreen(PokeStart.mainMenuScreen);
				
				
			}
		});
		
		 buttonNF2 = new Button(275,400,100,100,"No", new Action() {
			
			
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
		
		buttonYF3 = new Button(175,600,100,100,"Yes", new Action() {
			
			@Override
			public void act() {
				System.out.println("YES");
				PokeStart.inventory.setPokemon("Cyndaquil", "Fire", "", 30, 23, 14, 54, 21, 13, "resources/fire/Cyndaquil.png");
				String[] F1= {"Cyndaquil","Quilava","Typhlosion"};
				String[] FP1 = {"resources/fire/Cyndaquil.png","resources/fire/Quilava.png","resources/fire/Typhlosion.png"};
				PokeStart.inventory.setImages(FP1);
				PokeStart.inventory.setNames(F1);
				MainMenuScreen.name.setText(F1[0]);
				MainMenuScreen.pokemon.loadImages(FP1[0], 400, 400);
				Pokemon p = PokeStart.inventory.getPokemon();
				System.out.println(p.getType1());
				MainMenuScreen.info.setText("Type1: " + p.getType1() + "\n" +
						"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
						"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
						"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
						"Spd: " + p.getSpd() + "\n");
				StatTrainingScreen.updatePokemon();
				StatTrainingScreen.info.setText("Name: " + p.getName() + "\n" + "Type1: " + p.getType1() + "\n" +
						"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
						"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
						"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
						"Spd: " + p.getSpd() + "\n");
				StatTrainingScreen.poke.loadImages(FP1[0],300,300);
				//TrainingScreen.name.setText(F1[0]);
				//TrainingScreen.pokemon.loadImages(FP1[0], 400, 400);
				update();
				PokeStart.inventory.save();
				PokeStart.start.setScreen(PokeStart.mainMenuScreen);
				
				
			}
		});
		
		 buttonNF3 = new Button(275,600,100,100,"No", new Action() {
			
			
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
		//1075, 180
	buttonYW1 = new Button(975,200,100,100,"Yes", new Action() {
			
			@Override
			public void act() {
				System.out.println("YES");
				PokeStart.inventory.setPokemon("Froakie", "Water", "", 30, 23, 14, 54, 21, 22, "resources/water/Froakie.png");
				String[] F1= {"Froakie","Frogadier","Greninja"};
				String[] FP1 = {"resources/water/Froakie.png","resources/water/Frogadier.png","resources/water/Greninja.png"};
				PokeStart.inventory.setImages(FP1);
				PokeStart.inventory.setNames(F1);
				MainMenuScreen.name.setText(F1[0]);
				MainMenuScreen.pokemon.loadImages(FP1[0], 400, 400);
				Pokemon p = PokeStart.inventory.getPokemon();
				System.out.println(p.getType1());
				MainMenuScreen.info.setText("Type1: " + p.getType1() + "\n" +
						"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
						"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
						"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
						"Spd: " + p.getSpd() + "\n");
				StatTrainingScreen.updatePokemon();
				StatTrainingScreen.info.setText("Name: " + p.getName() + "\n" + "Type1: " + p.getType1() + "\n" +
						"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
						"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
						"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
						"Spd: " + p.getSpd() + "\n");
				StatTrainingScreen.poke.loadImages(FP1[0],300,300);
				//TrainingScreen.name.setText(F1[0]);
				//TrainingScreen.pokemon.loadImages(FP1[0], 400, 400);
				update();
				PokeStart.inventory.save();
				PokeStart.start.setScreen(PokeStart.mainMenuScreen);
				
			
				
				
			}
		});

		 buttonNW1 = new Button(1075,200,100,100,"No", new Action() {
			
			
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
		
		buttonYW2 = new Button(975,400,100,100,"Yes", new Action() {
			
			@Override
			public void act() {
				System.out.println("YES");
				PokeStart.inventory.setPokemon("Popplio", "Water", "", 30, 23, 14, 54, 21, 24, "resources/water/Popplio.png");
				String[] F1= {"Popplio","Brionne","Primarina"};
				String[] FP1 = {"resources/water/Popplio.png","resources/water/Brionne.png","resources/water/Primarina.png"};
				PokeStart.inventory.setImages(FP1);
				PokeStart.inventory.setNames(F1);
				MainMenuScreen.name.setText(F1[0]);
				MainMenuScreen.pokemon.loadImages(FP1[0], 400, 400);
				Pokemon p = PokeStart.inventory.getPokemon();
				System.out.println(p.getType1());
				MainMenuScreen.info.setText("Type1: " + p.getType1() + "\n" +
						"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
						"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
						"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
						"Spd: " + p.getSpd() + "\n");
				StatTrainingScreen.updatePokemon();
				StatTrainingScreen.info.setText("Name: " + p.getName() + "\n" + "Type1: " + p.getType1() + "\n" +
						"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
						"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
						"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
						"Spd: " + p.getSpd() + "\n");
				StatTrainingScreen.poke.loadImages(FP1[0],300,300);
				//TrainingScreen.name.setText(F1[0]);
				//TrainingScreen.pokemon.loadImages(FP1[0], 400, 400);
				update();
				PokeStart.inventory.save();
				PokeStart.start.setScreen(PokeStart.mainMenuScreen);
			
				
				
			}
		});
		
		 buttonNW2 = new Button(1075,400,100,100,"No", new Action() {
			
			
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
		
		buttonYW3 = new Button(975,600,100,100,"Yes", new Action() {
			
			@Override
			public void act() {
				System.out.println("YES");
				PokeStart.inventory.setPokemon("Mudkip", "Water", "", 30, 23, 14, 54, 21, 22, "resources/water/Mudkip.png");
				String[] F1= {"Mudkip","Marshtomp","Swampert"};
				String[] FP1 = {"resources/water/Mudkip.png","resources/water/Marshtomp.png","resources/water/Swampert.png"};
				PokeStart.inventory.setImages(FP1);
				PokeStart.inventory.setNames(F1);
				MainMenuScreen.name.setText(F1[0]);
				MainMenuScreen.pokemon.loadImages(FP1[0], 400, 400);
				Pokemon p = PokeStart.inventory.getPokemon();
				System.out.println(p.getType1());
				MainMenuScreen.info.setText("Type1: " + p.getType1() + "\n" +
						"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
						"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
						"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
						"Spd: " + p.getSpd() + "\n");
				StatTrainingScreen.updatePokemon();
				StatTrainingScreen.info.setText("Name: " + p.getName() + "\n" + "Type1: " + p.getType1() + "\n" +
						"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
						"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
						"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
						"Spd: " + p.getSpd() + "\n");
				StatTrainingScreen.poke.loadImages(FP1[0],300,300);
				//TrainingScreen.name.setText(F1[0]);
				//TrainingScreen.pokemon.loadImages(FP1[0], 400, 400);
				update();
				PokeStart.inventory.save();
				PokeStart.start.setScreen(PokeStart.mainMenuScreen);
				
			
				
				
			}
		});
		
		 buttonNW3 = new Button(1075,600,100,100,"No", new Action() {
			
			
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
	buttonYG1 = new Button(575,200,100,100,"Yes", new Action() {
			
			@Override
			public void act() {
				System.out.println("YES");
				PokeStart.inventory.setPokemon("Snivy", "Grass", "", 30, 23, 14, 54, 21, 2333, "resources/grass/Snivy.png");
				String[] F1= {"Snivy","Servine","Serperior"};
				String[] FP1 = {"resources/grass/Snivy.png","resources/grass/Servine.png","resources/grass/Serperior.png"};
				PokeStart.inventory.setImages(FP1);
				PokeStart.inventory.setNames(F1);
				MainMenuScreen.name.setText(F1[0]);
				MainMenuScreen.pokemon.loadImages(FP1[0], 400, 400);
				Pokemon p = PokeStart.inventory.getPokemon();
				System.out.println(p.getType1());
				MainMenuScreen.info.setText("Type1: " + p.getType1() + "\n" +
						"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
						"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
						"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
						"Spd: " + p.getSpd() + "\n");
				StatTrainingScreen.updatePokemon();
				StatTrainingScreen.info.setText("Name: " + p.getName() + "\n" + "Type1: " + p.getType1() + "\n" +
						"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
						"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
						"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
						"Spd: " + p.getSpd() + "\n");
				StatTrainingScreen.poke.loadImages(FP1[0],300,300);
				//TrainingScreen.name.setText(F1[0]);
				//TrainingScreen.pokemon.loadImages(FP1[0], 400, 400);
				update();
				PokeStart.inventory.save();
				PokeStart.start.setScreen(PokeStart.mainMenuScreen);
				
			
				
				
			}
		});
		
		 buttonNG1 = new Button(675,200,100,100,"No", new Action() {
			
			
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
		
		buttonYG2 = new Button(575,400,100,100,"Yes", new Action() {
			
			@Override
			public void act() {
				System.out.println("YES");
				PokeStart.inventory.setPokemon("Treecko", "Grass", "", 30, 23, 14, 54, 21, 2333, "resources/grass/Treecko.png");
				String[] F1= {"Treecko","Grovyle","Sceptile"};
				String[] FP1 = {"resources/grass/Treecko.png","resources/grass/Grovyle.png","resources/grass/Sceptile.png"};
				PokeStart.inventory.setImages(FP1);
				PokeStart.inventory.setNames(F1);
				MainMenuScreen.name.setText(F1[0]);
				MainMenuScreen.pokemon.loadImages(FP1[0], 400, 400);
				Pokemon p = PokeStart.inventory.getPokemon();
				System.out.println(p.getType1());
				MainMenuScreen.info.setText("Type1: " + p.getType1() + "\n" +
						"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
						"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
						"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
						"Spd: " + p.getSpd() + "\n");
				StatTrainingScreen.updatePokemon();
				StatTrainingScreen.info.setText("Name: " + p.getName() + "\n" + "Type1: " + p.getType1() + "\n" +
						"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
						"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
						"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
						"Spd: " + p.getSpd() + "\n");
				StatTrainingScreen.poke.loadImages(FP1[0],300,300);
				//TrainingScreen.name.setText(F1[0]);
				//TrainingScreen.pokemon.loadImages(FP1[0], 400, 400);
				update();
				PokeStart.inventory.save();
				PokeStart.start.setScreen(PokeStart.mainMenuScreen);
				
			
				
				
			}
		});
		
		 buttonNG2 = new Button(675,400,100,100,"No", new Action() {
			
			
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
		
		buttonYG3 = new Button(575,600,100,100,"Yes", new Action() {
			
			@Override
			public void act() {
				System.out.println("YES");
				PokeStart.inventory.setPokemon("Turtwig", "Grass", "", 30, 23, 14, 54, 21, 2333, "resources/grass/Turtwig.png");
				String[] F1= {"Turtwig","Grotle","Torterra"};
				String[] FP1 = {"resources/grass/Turtwig.png","resources/grass/Grotle.png","resources/grass/Torterra.png"};
				PokeStart.inventory.setImages(FP1);
				PokeStart.inventory.setNames(F1);
				MainMenuScreen.name.setText(F1[0]);
				MainMenuScreen.pokemon.loadImages(FP1[0], 400, 400);
				Pokemon p = PokeStart.inventory.getPokemon();
				System.out.println(p.getType1());
				MainMenuScreen.info.setText("Type1: " + p.getType1() + "\n" +
						"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
						"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
						"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
						"Spd: " + p.getSpd() + "\n");
				StatTrainingScreen.updatePokemon();
				StatTrainingScreen.info.setText("Name: " + p.getName() + "\n" + "Type1: " + p.getType1() + "\n" +
						"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
						"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
						"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
						"Spd: " + p.getSpd() + "\n");
				StatTrainingScreen.poke.loadImages(FP1[0],300,300);
				//TrainingScreen.name.setText(F1[0]);
				//TrainingScreen.pokemon.loadImages(FP1[0], 400, 400);
				update();
				PokeStart.inventory.save();
				PokeStart.start.setScreen(PokeStart.mainMenuScreen);
				
				
			
				
				
			}
		});
		
		 buttonNG3 = new Button(675,600,100,100,"No", new Action() {
			
			
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
		  buttonF1 = new Button (50, 165, 100,100,"",new Action() {
			
			public void act() {
				StyledComponent.setButtonOutline(false);
				AudioTest.playSound("resources/pokemonSounds/004 - Charmander.wav");
				rectT = new CustomRect(0, 0, getWidth(), getHeight(), new Color(0,0,0,150));
				viewObjects.add(rectT);
				viewObjects.remove(charmander);
				viewObjects.add(charmander);
				
				buttonF1.setEnabled(false);
				setPokemonGB();
				
				textB = new Graphic(150,165, 275, 400, "resources/text box.png");
				viewObjects.add(textB);
				
				
			    infoBox = new TextArea(175, 180, 300, 400, "Are you sure you want Charmander to be your pokemon?");
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
		 buttonF2 = new Button (50, 365, 100,100,"",new Action() {
			
			public void act() {
				StyledComponent.setButtonOutline(false);
				AudioTest.playSound("resources/pokemonSounds/390 - Chimchar.wav");
				rectT = new CustomRect(0, 0, getWidth(), getHeight(), new Color(0,0,0,150));
				viewObjects.add(rectT);
				viewObjects.remove(chimchar);
				viewObjects.add(chimchar);
				
				buttonF2.setEnabled(false);
				setPokemonGB();
				
				textB = new Graphic(150,365, 275, 400, "resources/text box.png");
				viewObjects.add(textB);
				
				
			    infoBox = new TextArea(175, 380, 300, 400, "Are you sure you want Chimchar to be your pokemon?");
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
		
		
		 buttonF3 = new Button (50,565, 100,100,"",new Action() {
			
			public void act() {
				StyledComponent.setButtonOutline(false);
				AudioTest.playSound("resources/pokemonSounds/155 - Cyndaquil.wav");
				rectT = new CustomRect(0, 0, getWidth(), getHeight(), new Color(0,0,0,150));
				viewObjects.add(rectT);
				viewObjects.remove(cyndaquil);
				viewObjects.add(cyndaquil);
				
				buttonF3.setEnabled(false);
				setPokemonGB();
				
				textB = new Graphic(150,565, 300, 400, "resources/text box.png");
				viewObjects.add(textB);
				
				
			    infoBox = new TextArea(175, 580, 300, 400, "Are you sure you want Cyndaquil to be your pokemon?");
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
		
		 buttonG1 = new Button (450, 165, 100,100,"",new Action() {
			
			public void act() {
				StyledComponent.setButtonOutline(false);
				AudioTest.playSound("resources/pokemonSounds/495 - Snivy.wav");
				rectT = new CustomRect(0, 0, getWidth(), getHeight(), new Color(0,0,0,150));
				viewObjects.add(rectT);
				viewObjects.remove(snivy);
				viewObjects.add(snivy);
				
				buttonG1.setEnabled(false);
				setPokemonGB();
				
				textB = new Graphic(550,165, 275, 400, "resources/text box.png");
				viewObjects.add(textB);
				
				
			    infoBox = new TextArea(575, 180, 275, 400, "Are you sure you want Snivy to be your pokemon?");
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
		
		 buttonG2 = new Button (450, 365, 100,100,"",new Action() {
			
			public void act() {
				StyledComponent.setButtonOutline(false);
				AudioTest.playSound("resources/pokemonSounds/252 - Treecko.wav");
				rectT = new CustomRect(0, 0, getWidth(), getHeight(), new Color(0,0,0,150));
				viewObjects.add(rectT);
				viewObjects.remove(treecko);
				viewObjects.add(treecko);
				
				buttonG2.setEnabled(false);
				setPokemonGB();
				
				textB = new Graphic(550,365, 275, 400, "resources/text box.png");
				viewObjects.add(textB);
				
				
			    infoBox = new TextArea(575, 380, 275, 400, "Are you sure you want Treecko to be your pokemon?");
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
		
		
		 buttonG3 = new Button (450,565, 100,100,"",new Action() {
			
			public void act() {
				StyledComponent.setButtonOutline(false);
				AudioTest.playSound("resources/pokemonSounds/387 - Turtwig.wav");
				rectT = new CustomRect(0, 0, getWidth(), getHeight(), new Color(0,0,0,150));
				viewObjects.add(rectT);
				viewObjects.remove(turtwig);
				viewObjects.add(turtwig);
				
				buttonG3.setEnabled(false);
				setPokemonGB();
				
				textB = new Graphic(550,565, 275, 400, "resources/text box.png");
				viewObjects.add(textB);
				
				
			    infoBox = new TextArea(576, 580, 275, 400, "Are you sure you want Turtwig to be your pokemon?");
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
		
		 buttonW1 = new Button (850, 165, 100,100,"",new Action() {
			
			public void act() {
				StyledComponent.setButtonOutline(false);
				AudioTest.playSound("resources/pokemonSounds/656 - Froakie.wav");
				rectT = new CustomRect(0, 0, getWidth(), getHeight(), new Color(0,0,0,150));
				viewObjects.add(rectT);
				viewObjects.remove(froakie);
				viewObjects.add(froakie);
				
				buttonW1.setEnabled(false);
				setPokemonGB();
				
				textB = new Graphic(950,165, 275, 400, "resources/text box.png");
				viewObjects.add(textB);
				
				
			    infoBox = new TextArea(975, 180, 275, 400, "Are you sure you want Froakie to be your pokemon?");
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
		
		 buttonW2 = new Button (850, 365, 100,100,"",new Action() {
			
			public void act() {
				StyledComponent.setButtonOutline(false);
				AudioTest.playSound("resources/pokemonSounds/728 - Popplio.wav");
				rectT = new CustomRect(0, 0, getWidth(), getHeight(), new Color(0,0,0,150));
				viewObjects.add(rectT);
				viewObjects.remove(popplio);
				viewObjects.add(popplio);
				
				buttonW2.setEnabled(false);
				setPokemonGB();
				
				textB = new Graphic(950,365, 275, 400, "resources/text box.png");
				viewObjects.add(textB);
				
				
			    infoBox = new TextArea(975, 380, 275, 400, "Are you sure you want Popplio to be your pokemon?");
				infoBox.setCustomTextColor(Color.black);
				viewObjects.add(infoBox);
				
	
				
				viewObjects.remove(buttonYW2);
				viewObjects.add(buttonYW2);
				buttonYW2.setVisible(true);
				
				viewObjects.remove(buttonNW2);
				viewObjects.add(buttonNW2);
				buttonNW2.setVisible(true);
				
			}
		});
		viewObjects.add(buttonW2);
		
		 buttonW3 = new Button (850, 565, 100,100,"",new Action() {
			
			public void act() {
				StyledComponent.setButtonOutline(false);
				AudioTest.playSound("resources/pokemonSounds/258 - Mudkip.wav");
				rectT = new CustomRect(0, 0, getWidth(), getHeight(), new Color(0,0,0,150));
				viewObjects.add(rectT);
				viewObjects.remove(mudkip);
				viewObjects.add(mudkip);
				
				buttonW3.setEnabled(false);
				setPokemonGB();
				
				textB = new Graphic(950,565, 275, 400, "resources/text box.png");
				viewObjects.add(textB);
				
				
			    infoBox = new TextArea(975, 580, 275, 400, "Are you sure you want Mudkip to be your pokemon?");
				infoBox.setCustomTextColor(Color.black);
				viewObjects.add(infoBox);
				
	
				
				viewObjects.remove(buttonYW3);
				viewObjects.add(buttonYW3);
				buttonYW3.setVisible(true);
				
				viewObjects.remove(buttonNW3);
				viewObjects.add(buttonNW3);
				buttonNW3.setVisible(true);
				
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
		Font baseFont=font.deriveFont(11f);
		StyledComponent.setBaseFont(baseFont);
	} catch (Exception e) {
		e.printStackTrace();
		}
	}
}

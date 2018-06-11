package garrettPokemonTraining;

import java.awt.Color;
import java.util.List;

import audioPlayer.AudioTest;
import fahadStartupandMenuScreen.CustomRect;
import fahadStartupandMenuScreen.MainMenuScreen;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import startGame.PokeStart;

public class StatTrainingScreen extends FullFunctionScreen {

	public static Graphic target;
	private Button saveButton;
	private Button backButton;
	public static TextArea info;
	public static Graphic poke;
	private static Pokemon p;
	public static CustomRect fatigue;
	public static CustomRect rect;
	private Button attack;
	private Button defense;
	private Button sAttack;
	private Button sDefense;
	private Button speed;

	public StatTrainingScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		StyledComponent.setButtonOutline(false);
		PokeStart.setPokemonSunFont(16f);
		Graphic battle = new Graphic(0,0,getWidth(),getHeight(),"resources/poketraining.jpg");
		viewObjects.add(battle);

		String[] pokeNames = PokeStart.inventory.getNames();
		String[] pokeLink = PokeStart.inventory.getPokemonImages();

		target = new Graphic(880, 115, 200, 200,"resources/Sandbag.png");
		viewObjects.add(target);
		p = PokeStart.inventory.getPokemon();
		int index = PokeStart.inventory.pokemonIndex;
		System.out.println(pokeNames[index]);
		poke = new Graphic(150,270,getWidth()/2,getHeight()/2,"resources/pokebacks/"+ pokeNames[index] +" back.png");
		viewObjects.add(poke);
		Graphic box = new Graphic(0,500,getWidth(),500,"resources/Box.jpg");
		viewObjects.add(box);
		CustomRect test = new CustomRect(200,50,300,180,Color.gray);
		viewObjects.add(test);
		info = new TextArea(200,50,300,180,"Name: " + p.getName() + "\n" + "Type1: " + p.getType1().getTypeName() + "\n" +
				"Type2: " + p.getType2().getTypeName() + "\n" + "Level: " + p.getLevel() + "\n" + "HP  " + p.getHp() + " ; Spd  " + p.getSpd() + "\n" + 
				"Atk  " + p.getAtk() + " ; Sp. Atk  " + p.getsAtk() +  "\n" + "Def  " + p.getDef() +" ; Sp. Def  " + p.getsDef() +"\n");
		viewObjects.add(info);
		fatigueBarDesign(viewObjects);
		saveButton = new Button(100,300,100,50,"Save", new Action() {

			@Override
			public void act() {
				PokeStart.inventory.save();
			}

		});
		viewObjects.add(saveButton);
		backButton = new Button(25,25,100,50,"Back", new Action() {

			@Override
			public void act() {
				AudioTest.stopSound(AudioTest.sound);
				PokeStart.mainMenuScreen = new MainMenuScreen(getWidth(), getHeight());
				PokeStart.start.setScreen(PokeStart.mainMenuScreen);
			}

		});
		backButton.setBackground(Color.YELLOW);
		backButton.update();
		viewObjects.add(backButton);
		attack = new Button(100,600,125,50,"Attack",new Action() {

			@Override
			public void act() {
				if(PokeStart.inventory.fatigue < 100 && PokeStart.inventory.daysLeft > 0) {
					setTrainedInfoStat("atk", viewObjects);
				}
			}

		});
		attack.setBackground(Color.CYAN);
		attack.update();
		viewObjects.add(attack);
		defense = new Button(350,600,150,50,"Defense",new Action() {

			@Override
			public void act() {
				if(PokeStart.inventory.fatigue < 100 && PokeStart.inventory.daysLeft > 0) {
					setTrainedInfoStat("def", viewObjects);
				}
			}

		});
		defense.setBackground(Color.CYAN);
		defense.update();
		viewObjects.add(defense);
		sAttack = new Button(600,600,125,50,"Sp. Atk",new Action() {

			@Override
			public void act() {
				if(PokeStart.inventory.fatigue < 100 && PokeStart.inventory.daysLeft > 0) {
					setTrainedInfoStat("sAtk", viewObjects);
				}
			}

		});
		sAttack.setBackground(Color.CYAN);
		sAttack.update();
		viewObjects.add(sAttack);
		sDefense = new Button(850,600,125,50,"Sp. Def",new Action() {

			@Override
			public void act() {
				if(PokeStart.inventory.fatigue < 100 && PokeStart.inventory.daysLeft > 0) {
					setTrainedInfoStat("sDef", viewObjects);
				}
			}

		});
		sDefense.setBackground(Color.CYAN);
		sDefense.update();
		viewObjects.add(sDefense);
		speed = new Button(1100,600,125,50,"Speed",new Action() {

			@Override
			public void act() {
				if(PokeStart.inventory.fatigue < 100 && PokeStart.inventory.daysLeft > 0) {
					setTrainedInfoStat("spd", viewObjects);
				}
			}

		});
		speed.setBackground(Color.CYAN);
		speed.update();
		viewObjects.add(speed);
		TextLabel message = new TextLabel(400,550,750,100,"You can only train once per day");
		viewObjects.add(message);
	}

	public void fatigueBarDesign(List<Visible> viewObjects) {
		rect = new CustomRect(865,397,331,31,Color.white);
		fatigue = new CustomRect(865,397,(int)((100-PokeStart.inventory.fatigue)*3.31 + 1),31,Color.green);
		viewObjects.add(rect);
		viewObjects.add(fatigue);
		TextLabel fatigueName = new TextLabel(740,400,125,50,"Fatigue: ");
		viewObjects.add(fatigueName);
	}

	public void updateFatigue(List<Visible> viewObjects) {
		viewObjects.remove(fatigue);
		fatigue = new CustomRect(865,397,(int)((100-PokeStart.inventory.fatigue)*3.31 + 1),31,Color.green);
		viewObjects.add(fatigue);
	}

	public void setInfoText() {
		int index = PokeStart.inventory.pokemonIndex;
		String[] pokeNames = PokeStart.inventory.getNames();
		updatePokemon();
		info.setText("Name: " + p.getName() + "\n" + "Type1: " + p.getType1().getTypeName() + "\n" +
				"Type2: " + p.getType2().getTypeName() + "\n" + "Level: " + p.getLevel() + "\n" + "HP  " + p.getHp() + " ; Spd  " + p.getSpd() + "\n" + 
				"Atk  " + p.getAtk() + " ; Sp. Atk  " + p.getsAtk() +  "\n" + "Def  " + p.getDef() +" ; Sp. Def  " + p.getsDef() +"\n");
		poke.loadImages("resources/pokebacks/"+ pokeNames[index] +" back.png", getWidth()/2,getHeight()/2);
	}

	public static void updatePokemon() {
		p = PokeStart.inventory.getPokemon();
	}

	public void setTrainedInfoStat(String s, List<Visible> viewObjects) {
		Thread train = new Thread(new Runnable() {

			@Override
			public void run() {
				attack.setEnabled(false);
				defense.setEnabled(false);
				sAttack.setEnabled(false);
				sDefense.setEnabled(false);
				speed.setEnabled(false);
				saveButton.setEnabled(false);
				backButton.setEnabled(false);
				for(int i = 0; i < 3; i++) {
					Graphic pow = new Graphic((int)(Math.random()*100) + 800,(int)(Math.random()*100) + 100,200,200,"resources/bam.png");
					viewObjects.add(pow);
					try {
						Thread.sleep(250);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					viewObjects.remove(pow);
				}
				for(int i = 0; i < 3; i++) {
					viewObjects.remove(target);
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					viewObjects.add(target);
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(s.equals("atk")) {
					info.setText("Name: " + p.getName() + "\n" + "Type1: " + p.getType1().getTypeName() + "\n" +
							"Type2: " + p.getType2().getTypeName() + "\n" + "Level: " + p.getLevel() + " +2\n" + "HP  " + p.getHp() + " +1; Spd  " + p.getSpd() + " +1\n" + 
							"Atk  " + p.getAtk() + " +4; Sp. Atk  " + p.getsAtk() +  " +2\n" + "Def  " + p.getDef() +" ; Sp. Def  " + p.getsDef() +"\n");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					p.trainStat("atk");
				}
				if(s.equals("def")) {
					info.setText("Name: " + p.getName() + "\n" + "Type1: " + p.getType1().getTypeName() + "\n" +
							"Type2: " + p.getType2().getTypeName() + "\n" + "Level: " + p.getLevel() + " +2\n" + "HP  " + p.getHp() + " +1; Spd  " + p.getSpd() + " +1\n" + 
							"Atk  " + p.getAtk() + " ; Sp. Atk  " + p.getsAtk() +  "\n" + "Def  " + p.getDef() +" +4; Sp. Def  " + p.getsDef() + " +2\n");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					p.trainStat("def");
				}
				if(s.equals("sAtk")) {
					info.setText("Name: " + p.getName() + "\n" + "Type1: " + p.getType1().getTypeName() + "\n" +
							"Type2: " + p.getType2().getTypeName() + "\n" + "Level: " + p.getLevel() + " +2\n" + "HP  " + p.getHp() + " +1; Spd  " + p.getSpd() + " +1\n" + 
							"Atk  " + p.getAtk() + " +2 ; Sp. Atk  " + p.getsAtk() +  " +4\n" + "Def  " + p.getDef() +" ; Sp. Def  " + p.getsDef() + "\n");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					p.trainStat("sAtk");
				}
				if(s.equals("sDef")) {
					info.setText("Name: " + p.getName() + "\n" + "Type1: " + p.getType1().getTypeName() + "\n" +
							"Type2: " + p.getType2().getTypeName() + "\n" + "Level: " + p.getLevel() + " +2\n" + "HP  " + p.getHp() + " +1; Spd  " + p.getSpd() + " +1\n" + 
							"Atk  " + p.getAtk() + " ; Sp. Atk  " + p.getsAtk() +  "\n" + "Def  " + p.getDef() +" +2; Sp. Def  " + p.getsDef() + " +4\n");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					p.trainStat("sDef");
				}
				if(s.equals("spd")) {
					info.setText("Name: " + p.getName() + "\n" + "Type1: " + p.getType1().getTypeName() + "\n" +
							"Type2: " + p.getType2().getTypeName() + "\n" + "Level: " + p.getLevel() + " +2\n" + "HP  " + p.getHp() + " +1; Spd  " + p.getSpd() + " +4\n" + 
							"Atk  " + p.getAtk() + " +1; Sp. Atk  " + p.getsAtk() +  " +1\n" + "Def  " + p.getDef() +" +1; Sp. Def  " + p.getsDef() +" +1\n");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					p.trainStat("spd");
				}
				p.setLevel(p.getLevel() + 2);
				if(p.getLevel() == 15 || p.getLevel() == 45) {
					updatePokemon();
					p.evolve();
				}
				setInfoText();
				saveButton.setEnabled(true);
				backButton.setEnabled(true);
				PokeStart.inventory.uPoints += 5;
				PokeStart.inventory.fatigue += 5;
				PokeStart.shopScreen.setDollars(PokeStart.shopScreen.getDollars() + 250);
				System.out.println(PokeStart.inventory.fatigue);
				System.out.println(PokeStart.inventory.uPoints);
				updateFatigue(viewObjects);
				if(PokeStart.inventory.daysLeft > 0) {
					PokeStart.inventory.daysLeft--;
				}
			}

		});
		train.start();
	}

}

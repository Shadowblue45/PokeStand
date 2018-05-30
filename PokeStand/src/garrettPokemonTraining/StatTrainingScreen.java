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
		poke = new Graphic(150,250,getWidth()/2,getHeight()/2,"resources/pokebacks/"+ pokeNames[index] +" back.png");
		viewObjects.add(poke);
		Graphic box = new Graphic(0,500,getWidth(),500,"resources/Box.jpg");
		viewObjects.add(box);
		info = new TextArea(500,200,200,500,"Name: " + p.getName() + "\n" + "Type1: " + p.getType1() + "\n" +
				"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
				"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
				"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
				"Spd: " + p.getSpd() + "\n" + "Level: " + p.getLevel() + "\n");
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
		viewObjects.add(backButton);
		attack = new Button(100,600,125,50,"Attack",new Action() {

			@Override
			public void act() {
				if(PokeStart.inventory.fatigue < 100) {
					setTrainedInfoStat("atk", viewObjects);
				}
			}

		});
		viewObjects.add(attack);
		defense = new Button(350,600,150,50,"Defense",new Action() {

			@Override
			public void act() {
				if(PokeStart.inventory.fatigue < 100) {
					setTrainedInfoStat("def", viewObjects);
				}
			}

		});
		viewObjects.add(defense);
		sAttack = new Button(600,600,125,50,"Sp. Atk",new Action() {

			@Override
			public void act() {
				if(PokeStart.inventory.fatigue < 100) {
					setTrainedInfoStat("sAtk", viewObjects);
				}
			}

		});
		viewObjects.add(sAttack);
		sDefense = new Button(850,600,125,50,"Sp. Def",new Action() {

			@Override
			public void act() {
				if(PokeStart.inventory.fatigue < 100) {
					setTrainedInfoStat("sDef", viewObjects);
				}
			}

		});
		viewObjects.add(sDefense);
		speed = new Button(1100,600,125,50,"Speed",new Action() {

			@Override
			public void act() {
				if(PokeStart.inventory.fatigue < 100) {
					setTrainedInfoStat("spd", viewObjects);
				}
			}

		});
		viewObjects.add(speed);
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
		info.setText("Name: " + p.getName() + "\n" + "Type1: " + p.getType1() + "\n" +
				"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
				"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
				"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
				"Spd: " + p.getSpd() + "\n" + "Level: " + p.getLevel() + "\n");
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
				for(int i = 0; i < 5; i++) {
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
				if(s.equals("atk")) {
					info.setText("Name: " + p.getName() + "\n" + "Type1: " + p.getType1() + "\n" +
							"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + " +1\n" + 
							"Atk: " + p.getAtk() + " +3\n" + "Def: " + p.getDef() + "\n" +
							"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
							"Spd: " + p.getSpd() + "\n" + "Level: " + p.getLevel() + "+2\n");
					try {
						Thread.sleep(750);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					p.trainStat("atk");
				}
				if(s.equals("def")) {
					info.setText("Name: " + p.getName() + "\n" + "Type1: " + p.getType1() + "\n" +
							"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + " +1\n" + 
							"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + " +3\n" +
							"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
							"Spd: " + p.getSpd() + "\n" + "Level: " + p.getLevel() + "+2\n");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					p.trainStat("def");
				}
				if(s.equals("sAtk")) {
					info.setText("Name: " + p.getName() + "\n" + "Type1: " + p.getType1() + "\n" +
							"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + " +1\n" + 
							"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
							"Sp. Atk: " + p.getsAtk() + " +3\n" + "Sp. Def: " + p.getsDef() + "\n" +
							"Spd: " + p.getSpd() + "\n" + "Level: " + p.getLevel() + "+2\n");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					p.trainStat("sAtk");
				}
				if(s.equals("sDef")) {
					info.setText("Name: " + p.getName() + "\n" + "Type1: " + p.getType1() + "\n" +
							"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + " +1\n" + 
							"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
							"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + " +3\n" +
							"Spd: " + p.getSpd() + "\n" + "Level: " + p.getLevel() + "+2\n");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					p.trainStat("sDef");
				}
				if(s.equals("spd")) {
					info.setText("Name: " + p.getName() + "\n" + "Type1: " + p.getType1() + "\n" +
							"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + " +1\n" + 
							"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
							"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
							"Spd: " + p.getSpd() + " +3\n" + "Level: " + p.getLevel() + "+2\n");
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

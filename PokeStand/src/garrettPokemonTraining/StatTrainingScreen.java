package garrettPokemonTraining;

import java.awt.Color;
import java.util.List;

import fahadStartupandMenuScreen.CustomRect;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import startGame.PokeStart;

public class StatTrainingScreen extends FullFunctionScreen {

	public static Graphic target;
	private Button start;
	private Button evolveButton;
	private Button saveButton;
	private Button loadButton;
	private Button backButton;
	public static TextArea info;
	public static Graphic poke;
	private static Pokemon p;
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
		PokeStart.setPokemonFont(20);
		CustomRect rect = new CustomRect(0,0,getWidth(),getHeight(),new Color(0,0,0,200));
		Graphic battle = new Graphic(0,0,getWidth(),getHeight(),"resources/pokebattle.jpg");
		viewObjects.add(battle);
		poke = new Graphic(175, 305, 300, 300,"");
		viewObjects.add(poke);
		target = new Graphic(880, 115, 200, 200,"resources/Sandbag.png");
		viewObjects.add(target);
		viewObjects.add(rect);
		start = new Button(630,390,100,50,"Start",new Action() {

			@Override
			public void act() {
				viewObjects.remove(rect);
				viewObjects.remove(start);
				start.setEnabled(false);
			}

		});
		start.setBackground(Color.WHITE);
		start.update();
		viewObjects.add(start);
		info = new TextArea(500,200,200,500,"");
		viewObjects.add(info);
		evolveButton = new Button(75,200,100,50,"Evolve", new Action() {

			@Override
			public void act() {
				updatePokemon();
				p.evolve();
				setInfoText();
				poke.loadImages(p.getImage(), 300, 300);
			}

		});
		viewObjects.add(evolveButton);
		saveButton = new Button(100,300,50,50,"Save", new Action() {

			@Override
			public void act() {
				PokeStart.inventory.save();
			}

		});
		viewObjects.add(saveButton);
		loadButton = new Button(300,300,50,50,"Load", new Action() {

			@Override
			public void act() {
				System.out.println("Loading...");
				PokeStart.inventory.load();
				setInfoText();
				poke.loadImages(p.getImage(), 300, 300);
			}

		});
		viewObjects.add(loadButton);
		backButton = new Button(25,25,100,50,"Back", new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub
				PokeStart.mainMenuScreen.pokemon.loadImages(p.getImage(),400,400);
				PokeStart.mainMenuScreen.name.setText(p.getName());
				PokeStart.mainMenuScreen.info.setText("Type1: " + p.getType1() + "\n" +
						"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
						"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
						"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
						"Spd: " + p.getSpd() + "\n");
				PokeStart.start.setScreen(PokeStart.mainMenuScreen);
				PokeStart.mainScreen = !PokeStart.mainScreen;
			}

		});
		viewObjects.add(backButton);
		attack = new Button(100,600,100,50,"Attack",new Action() {

			@Override
			public void act() {
				if(PokeStart.inventory.fatigue < 100) {
					setTrainedInfoStat("atk", viewObjects);
				}
			}

		});
		viewObjects.add(attack);
		defense = new Button(350,600,100,50,"Defense",new Action() {

			@Override
			public void act() {
				if(PokeStart.inventory.fatigue < 100) {
					setTrainedInfoStat("def", viewObjects);
				}
			}

		});
		viewObjects.add(defense);
		sAttack = new Button(600,600,100,50,"Sp. Atk",new Action() {

			@Override
			public void act() {
				if(PokeStart.inventory.fatigue < 100) {
					setTrainedInfoStat("sAtk", viewObjects);
				}
			}

		});
		viewObjects.add(sAttack);
		sDefense = new Button(850,600,100,50,"Sp. Def",new Action() {

			@Override
			public void act() {
				if(PokeStart.inventory.fatigue < 100) {
					setTrainedInfoStat("sDef", viewObjects);
				}
			}

		});
		viewObjects.add(sDefense);
		speed = new Button(1100,600,100,50,"Speed",new Action() {

			@Override
			public void act() {
				if(PokeStart.inventory.fatigue < 100) {
					setTrainedInfoStat("spd", viewObjects);
				}
			}

		});
		viewObjects.add(speed);
	}

	public void setInfoText() {
		updatePokemon();
		info.setText("Name: " + p.getName() + "\n" + "Type1: " + p.getType1() + "\n" +
				"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
				"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
				"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
				"Spd: " + p.getSpd() + "\n");
		poke.loadImages(p.getImage(), 300, 300);
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
				loadButton.setEnabled(false);
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
							"Spd: " + p.getSpd() + "\n");
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
							"Spd: " + p.getSpd() + "\n");
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
							"Spd: " + p.getSpd() + "\n");
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
							"Spd: " + p.getSpd() + "\n");
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
							"Spd: " + p.getSpd() + " +3\n");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					p.trainStat("spd");
				}
				setInfoText();
				attack.setEnabled(true);
				defense.setEnabled(true);
				sAttack.setEnabled(true);
				sDefense.setEnabled(true);
				speed.setEnabled(true);
				saveButton.setEnabled(true);
				loadButton.setEnabled(true);
				backButton.setEnabled(true);
				PokeStart.inventory.fatigue += 5;
				System.out.println(PokeStart.inventory.fatigue);
			}

		});
		train.start();
	}

}

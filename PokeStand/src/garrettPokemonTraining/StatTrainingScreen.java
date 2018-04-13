package garrettPokemonTraining;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import startGame.PokeStart;
import startupandMenuScreen.CustomRect;

public class StatTrainingScreen extends FullFunctionScreen {

	private Graphic target;
	private Button start;
	private Button evolveButton;
	private Button saveButton;
	private Button loadButton;
	private TextArea info;
	private Graphic poke;
	private Pokemon p;
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
		PokemonTest.setPokemonFont(20);
		CustomRect rect = new CustomRect(0,0,getWidth(),getHeight(),new Color(0,0,0,200));
		Graphic battle = new Graphic(0,0,getWidth(),getHeight(),"resources/pokebattle.jpg");
		viewObjects.add(battle);
		p = PokeStart.inventory.getPokemon();
		poke = new Graphic(75, 305, 300, 300,p.getImage());
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
		info = new TextArea(400,200,200,500,"Name: " + p.getName() + "\n" + "Type1: " + p.getType1() + "\n" +
				"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
				"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
				"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
				"Spd: " + p.getSpd() + "\n");
		viewObjects.add(info);
		evolveButton = new Button(75,200,100,50,"Evolve", new Action() {

			@Override
			public void act() {
				p.evolve();
				setInfoText();
				poke.loadImages(p.getImage(), 300, 300);
			}
			
		});
		viewObjects.add(evolveButton);
		saveButton = new Button(100,300,50,50,"Save", new Action() {

			@Override
			public void act() {
				PokemonTest.inventory.save();
			}
			
		});
		viewObjects.add(saveButton);
		loadButton = new Button(300,300,50,50,"Load", new Action() {

			@Override
			public void act() {
				System.out.println("Loading...");
				PokemonTest.inventory.load();
				setInfoText();
				poke.loadImages(p.getImage(), 300, 300);
			}
			
		});
		viewObjects.add(loadButton);
		attack = new Button(100,600,100,50,"Attack",new Action() {

			@Override
			public void act() {
				setTrainedInfoStat("atk", viewObjects);
			}
			
		});
		viewObjects.add(attack);
		defense = new Button(300,600,100,50,"Defense",new Action() {

			@Override
			public void act() {
				setTrainedInfoStat("def", viewObjects);
			}
			
		});
		viewObjects.add(defense);
		sAttack = new Button(500,600,100,50,"Sp. Atk",new Action() {

			@Override
			public void act() {
				setTrainedInfoStat("sAtk", viewObjects);
			}
			
		});
		viewObjects.add(sAttack);
		sDefense = new Button(700,600,100,50,"Sp. Def",new Action() {

			@Override
			public void act() {
				setTrainedInfoStat("sDef", viewObjects);
			}
			
		});
		viewObjects.add(sDefense);
		speed = new Button(900,600,100,50,"Speed",new Action() {

			@Override
			public void act() {
				setTrainedInfoStat("spd", viewObjects);
			}
			
		});
		viewObjects.add(speed);
	}
	
	public void setInfoText() {
		info.setText("Name: " + p.getName() + "\n" + "Type1: " + p.getType1() + "\n" +
				"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
				"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
				"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
				"Spd: " + p.getSpd() + "\n");
	}
	
	public void setTrainedInfoStat(String s, List<Visible> viewObjects) {
		Thread train = new Thread(new Runnable() {

			@Override
			public void run() {
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
					setInfoText();
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
					setInfoText();
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
					setInfoText();
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
					setInfoText();
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
					setInfoText();
				}
			}
			
		});
		train.start();
	}

}

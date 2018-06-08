package displayAbilities;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import startGame.PokeStart;

public class AbilityScreen extends FullFunctionScreen {
	
	Graphic pokemon;
	TextArea pokemonN;
	TextArea pokemonL;
	Button back;
	
	TextArea category;
	TextArea power;
	TextArea accuracy;
	
	Button move1;
	Button move2;
	Button move3;
	Button move4;
	
	private ArrayList<Button> actionB;
	
	TextArea nMove1;
	TextArea nMove2;
	TextArea nMove3;
	TextArea nMove4;
	
	private TextArea[] move = {nMove1,nMove2,nMove3,nMove4};
	private ArrayList<TextArea> moveA;
	
	TextArea pp1;
	TextArea pp2;
	TextArea pp3;
	TextArea pp4;
	private ArrayList<TextArea> pp;
	
	Graphic t1;
	Graphic t2;
	Graphic t3;
	Graphic t4;
	private ArrayList<Graphic> graphics;
	
	

	

	public AbilityScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {

		
		
		PokeStart.setPokemonGBFont(35f);
		Graphic background = new Graphic(0, 0, 1280,720, "resources/template.png");
		viewObjects.add(background);
		
		Graphic PA = new Graphic(50, 570, 400,120, "resources/moves.png");
		viewObjects.add(PA);
		
		String[] pokeNames = PokeStart.inventory.getNames(); 
		String[] pokePic = PokeStart.inventory.getPokemonImages(); 
		int pIndex = PokeStart.inventory.pokemonIndex;
		
		
		pokemon = new Graphic(100, 300, 250, 250,pokePic[pIndex]);
		viewObjects.add(pokemon);
		
	
		
		pokemonN = new TextArea(110,125,600,50,pokeNames[pIndex]);
		pokemonN.setCustomTextColor(Color.black);
		viewObjects.add(pokemonN);
		
		pokemonL = new TextArea(115,180,600,50,Integer.toString(PokeStart.inventory.pokemon.getLevel()));
		pokemonL.setCustomTextColor(Color.black);
		viewObjects.add(pokemonL);
		
		PokeStart.setPokemonGBFont(15f);
		category = new TextArea(250,575,300,50,"-");
		category.setCustomTextColor(Color.gray);
		viewObjects.add(category);
		
		power = new TextArea(250,615,600,50,"-");
		power.setCustomTextColor(Color.gray);
		viewObjects.add(power);
		
		accuracy = new TextArea(250,655,600,50,"-");
		accuracy.setCustomTextColor(Color.gray);
		viewObjects.add(accuracy);
		
		PokeStart.setPokemonGBFont(27f);
		StyledComponent.setButtonOutline(false);
		back = new Button(300,10,150,100,"Back",new Action() {
			
			@Override
			public void act() {
				PokeStart.start.setScreen(PokeStart.mainMenuScreen);

				
			}
		});
		back.setForeground(Color.white);
		viewObjects.add(back);
		StyledComponent.setButtonOutline(true);
		/*
		move1 = new Button(612,180,600,120,"",new Action() {
			
			@Override
			public void act() {
				category.setText(PokeStart.inventory.pokemon.getMoves().get(0).getType().getTypeName());
				power.setText(Integer.toString(PokeStart.inventory.pokemon.getMoves().get(0).getPower()));
				accuracy.setText(Integer.toString(PokeStart.inventory.pokemon.getMoves().get(0).getAccuracy()));
			}
		});
	
		move1.setForeground(Color.white);
		viewObjects.add(move1);
		
		move2 = new Button(612,300,600,120,"",new Action() {
			
			@Override
			public void act() {
				category.setText(PokeStart.inventory.pokemon.getMoves().get(1).getType().getTypeName());
				power.setText(Integer.toString(PokeStart.inventory.pokemon.getMoves().get(1).getPower()));
				accuracy.setText(Integer.toString(PokeStart.inventory.pokemon.getMoves().get(1).getAccuracy()));
			}
		});
	
		move2.setForeground(Color.white);
		viewObjects.add(move2);
		
	move3 = new Button(612,420,600,120,"",new Action() {
			
			@Override
			public void act() {
				category.setText(PokeStart.inventory.pokemon.getMoves().get(2).getType().getTypeName());
				power.setText(Integer.toString(PokeStart.inventory.pokemon.getMoves().get(2).getPower()));
				accuracy.setText(Integer.toString(PokeStart.inventory.pokemon.getMoves().get(2).getAccuracy()));
			}
		});
	
		move3.setForeground(Color.white);
		viewObjects.add(move3);
		
		move4 = new Button(612,540,600,120,"",new Action() {
			
			@Override
			public void act() {
				category.setText(PokeStart.inventory.pokemon.getMoves().get(3).getType().getTypeName());
				power.setText(Integer.toString(PokeStart.inventory.pokemon.getMoves().get(3).getPower()));
				accuracy.setText(Integer.toString(PokeStart.inventory.pokemon.getMoves().get(3).getAccuracy()));
			}
		});
	
		move4.setForeground(Color.white);
		viewObjects.add(move4);
		*/
		createButtons();
		for(Button b: actionB) {
			b.setForeground(Color.white);
			b.setEnabled(true);
			viewObjects.add(b);
		}
		createTextAreaM();
		for(TextArea b: moveA) {
			b.setForeground(Color.white);
			viewObjects.add(b);
		}
		createTextAreaPp();
		for(TextArea b: pp) {
			b.setForeground(Color.white);
			viewObjects.add(b);
		}
		createGraphic();
		for(Graphic b: graphics) {
		viewObjects.add(b);
		}
		/*
		nMove1 = new TextArea(780,200,600,120,PokeStart.inventory.pokemon.getMoves().get(0).getName());
		nMove1.setForeground(Color.WHITE);
		viewObjects.add(nMove1);
		
		nMove2 = new TextArea(780,320,600,120,PokeStart.inventory.pokemon.getMoves().get(1).getName());
		nMove2.setForeground(Color.WHITE);
		viewObjects.add(nMove2);
		
		nMove3 = new TextArea(780,440,600,120,PokeStart.inventory.pokemon.getMoves().get(2).getName());
		nMove3.setForeground(Color.WHITE);
		viewObjects.add(nMove3);
		
		nMove4 = new TextArea(780,560,600,120,PokeStart.inventory.pokemon.getMoves().get(3).getName());
		nMove4.setForeground(Color.WHITE);
		viewObjects.add(nMove4);
		
		pp1 = new TextArea(950,250,600,120,Integer.toString(PokeStart.inventory.pokemon.getMoves().get(0).getCurrentPp()) + "/" +Integer.toString(PokeStart.inventory.pokemon.getMoves().get(0).getPp()));
		pp1.setForeground(Color.white);
		viewObjects.add(pp1);
		
		pp2 = new TextArea(950,370,600,120,Integer.toString(PokeStart.inventory.pokemon.getMoves().get(1).getCurrentPp()) + "/" +Integer.toString(PokeStart.inventory.pokemon.getMoves().get(1).getPp()));
		pp1.setForeground(Color.white);
		viewObjects.add(pp2);
		
		pp3 = new TextArea(950,490,600,120,Integer.toString(PokeStart.inventory.pokemon.getMoves().get(2).getCurrentPp()) + "/" +Integer.toString(PokeStart.inventory.pokemon.getMoves().get(2).getPp()));
		pp1.setForeground(Color.white);
		viewObjects.add(pp3);
		
		pp4 = new TextArea(950,610,600,120,Integer.toString(PokeStart.inventory.pokemon.getMoves().get(3).getCurrentPp()) + "/" +Integer.toString(PokeStart.inventory.pokemon.getMoves().get(3).getPp()));
		pp1.setForeground(Color.white);
		viewObjects.add(pp4);
		*/
//		t1 = new Graphic(630,200,100,100, "resources/type/"+PokeStart.inventory.pokemon.getMoves().get(0).getType().getTypeName()+".png");
//		viewObjects.add(t1);
//		
//		t2 = new Graphic(630,320,100,100, "resources/type/"+PokeStart.inventory.pokemon.getMoves().get(1).getType().getTypeName()+".png");
//		viewObjects.add(t2);
//		
//		t3 = new Graphic(630,440,100,100, "resources/type/"+PokeStart.inventory.pokemon.getMoves().get(2).getType().getTypeName()+".png");
//		viewObjects.add(t3);
//		
//		t4 = new Graphic(630,560,100,100, "resources/type/"+PokeStart.inventory.pokemon.getMoves().get(3).getType().getTypeName()+".png");
//		viewObjects.add(t4);


		
		
		
	}
	public void createButtons() {
		actionB = new ArrayList<Button>();
		for(int i=0;i<PokeStart.inventory.pokemon.getMoves().size();i++) {
			int x=i;
			if(PokeStart.inventory.pokemon.getMoves().get(i) != null) {
			Button b = new Button(612,180+(120*i),600,120,"", new Action() {

				@Override
				public void act() {
					actionB.get(x).setEnabled(true);
					category.setText(PokeStart.inventory.pokemon.getMoves().get(x).getType().getTypeName());
					power.setText(Integer.toString(PokeStart.inventory.pokemon.getMoves().get(x).getPower()));
					accuracy.setText(Integer.toString(PokeStart.inventory.pokemon.getMoves().get(x).getAccuracy()));
					
				}

			});
			actionB.add(b);
			}
			else {
				Button b = new Button(612,180+(120*i),600,120,"", null);
				actionB.add(b);
			}
		} 
	}
	
	public void createTextAreaM() {
		moveA = new ArrayList<TextArea>();
		for(int i=0;i<PokeStart.inventory.pokemon.getMoves().size();i++) {
			if(PokeStart.inventory.pokemon.getMoves().get(i) != null) {
			TextArea b =new TextArea(780,200+(120*i),600,120,PokeStart.inventory.pokemon.getMoves().get(i).getName());
			moveA.add(b);
			}
		} 
	}
	
	public void createTextAreaPp() {
		pp = new ArrayList<TextArea>();
		for(int i=0;i<PokeStart.inventory.pokemon.getMoves().size();i++) {
			if(PokeStart.inventory.pokemon.getMoves().get(i) != null) {
			TextArea b =new TextArea(950,250+(120*i),600,120,Integer.toString(PokeStart.inventory.pokemon.getMoves().get(i).getCurrentPp()) + "/" +Integer.toString(PokeStart.inventory.pokemon.getMoves().get(i).getPp()));
			pp.add(b);
			}
		} 
	}
	
	public void createGraphic() {
		graphics = new ArrayList<Graphic>();
		for(int i=0;i<PokeStart.inventory.pokemon.getMoves().size();i++) {
			if(PokeStart.inventory.pokemon.getMoves().get(i)!= null) {
			Graphic b =new Graphic(630,200+(120*i),100,100,"resources/type/"+PokeStart.inventory.pokemon.getMoves().get(i).getType().getTypeName()+".png");
			graphics.add(b);
			}

		} 
	}

}

package displayAbilities;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
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

	

	public AbilityScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		

		setPokemonGB(30f);
		Graphic background = new Graphic(0, 0, 1280,720, "resources/template.png");
		viewObjects.add(background);
		
		Graphic PA = new Graphic(50, 570, 400,120, "resources/moves.png");
		viewObjects.add(PA);
		
		
		pokemon = new Graphic(100, 300, 250, 250,"resources/fire/Charmander.png");
		viewObjects.add(pokemon);
		
	
		
		pokemonN = new TextArea(110,125,600,50,"Charmander");
		pokemonN.setCustomTextColor(Color.black);
		viewObjects.add(pokemonN);
		
		pokemonL = new TextArea(115,185,600,50,"4");
		pokemonL.setCustomTextColor(Color.black);
		viewObjects.add(pokemonL);
		
		setPokemonGB(20f);
		category = new TextArea(250,575,600,50,"FIRE");
		category.setCustomTextColor(Color.gray);
		viewObjects.add(category);
		
		power = new TextArea(250,615,600,50,"65");
		power.setCustomTextColor(Color.gray);
		viewObjects.add(power);
		
		accuracy = new TextArea(250,655,600,50,"90");
		accuracy.setCustomTextColor(Color.gray);
		viewObjects.add(accuracy);
		
		setPokemonGB(30f);
		
		back = new Button(300,10,150,100,"Back",new Action() {
			
			@Override
			public void act() {
				PokeStart.start.setScreen(PokeStart.mainMenuScreen);
				
			}
		});
		back.setForeground(Color.white);
		viewObjects.add(back);
	
		
		move1 = new Button(612,180,600,120,"",new Action() {
			
			@Override
			public void act() {
				PokeStart.start.setScreen(PokeStart.mainMenuScreen);
				
			}
		});
	
		move1.setForeground(Color.white);
		viewObjects.add(move1);
		
		move2 = new Button(612,300,600,120,"",new Action() {
			
			@Override
			public void act() {
				PokeStart.start.setScreen(PokeStart.mainMenuScreen);
				
			}
		});
	
		move2.setForeground(Color.white);
		viewObjects.add(move2);
		
	move3 = new Button(612,420,600,120,"",new Action() {
			
			@Override
			public void act() {
				PokeStart.start.setScreen(PokeStart.mainMenuScreen);
				
			}
		});
	
		move3.setForeground(Color.white);
		viewObjects.add(move3);
		
		move4 = new Button(612,540,600,120,"",new Action() {
			
			@Override
			public void act() {
				PokeStart.start.setScreen(PokeStart.mainMenuScreen);
				
			}
		});
	
		move4.setForeground(Color.white);
		viewObjects.add(move4);
		


		
		
		
	}
	public void setPokemonGB(float f) {
		try {
		File fontFile = new File("resources/Pokemon GB.ttf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
		Font baseFont=font.deriveFont(f);
		StyledComponent.setBaseFont(baseFont);
	} catch (Exception e) {
		e.printStackTrace();
		}
	}

}

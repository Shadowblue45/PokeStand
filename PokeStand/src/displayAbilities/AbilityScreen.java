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
	Button move1;
	

	public AbilityScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		StyledComponent.setButtonOutline(true);
		setPokemonGB();
		Graphic background = new Graphic(0, 0, 1280,720, "resources/template.png");
		viewObjects.add(background);
		
		
		pokemon = new Graphic(100, 300, 400, 400,"resources/fire/Charmander.png");
		viewObjects.add(pokemon);
		
	
		
		pokemonN = new TextArea(110,125,600,50,"Charmander");
		pokemonN.setCustomTextColor(Color.black);
		viewObjects.add(pokemonN);
		
		pokemonL = new TextArea(115,185,600,50,"4");
		pokemonL.setCustomTextColor(Color.black);
		viewObjects.add(pokemonL);
		
		back = new Button(300,10,150,100,"Back",new Action() {
			
			@Override
			public void act() {
				PokeStart.start.setScreen(PokeStart.mainMenuScreen);
				
			}
		});
		back.setForeground(Color.white);
		viewObjects.add(back);
	
		
	move1 = new Button(612,180,600,120,"Scratch",new Action() {
			
			@Override
			public void act() {
				PokeStart.start.setScreen(PokeStart.mainMenuScreen);
				
			}
		});
	
		move1.setForeground(Color.white);
		viewObjects.add(move1);
		
		
		
	}
	public void setPokemonGB() {
		try {
		File fontFile = new File("resources/Pokemon GB.ttf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
		Font baseFont=font.deriveFont(30f);
		StyledComponent.setBaseFont(baseFont);
	} catch (Exception e) {
		e.printStackTrace();
		}
	}

}

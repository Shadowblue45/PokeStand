package displayAbilities;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class AbilityScreen extends FullFunctionScreen {
	
	Graphic pokemon;
	TextArea pokemonN;
	TextArea pokemonL;
	

	public AbilityScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
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

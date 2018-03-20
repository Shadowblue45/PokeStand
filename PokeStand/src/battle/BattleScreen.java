package battle;

import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class BattleScreen extends FullFunctionScreen{

	public BattleScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic battle = new Graphic(0,0,getWidth(),getHeight(),"resources/pokebattle.jpg");
		viewObjects.add(battle);
		Graphic userPokemon = new Graphic(160,500-getHeight()/3,getWidth()/2,getHeight()/2,"resources/infernape back.png");
		viewObjects.add(userPokemon);
		Graphic box = new Graphic(0,500,getWidth(),500-getHeight(),"resources/Box.jpg");
		viewObjects.add(box);
	}

}

package garrettPokemonTraining;

import java.util.List;

import guiTeacher.components.SimpleTable;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class TrainingScreen extends FullFunctionScreen {
	
	private SimpleTable stats;

	public TrainingScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		stats = new SimpleTable(null, 50, 50, 300, 300, null);
		String[] info = {"Name","HP","Attack","Defense","Sp. Atk","Sp. Def","Speed"};
		String[] nums = {"Popplio",Integer.toString(25),Integer.toString(27),Integer.toString(27),Integer.toString(33),Integer.toString(28),Integer.toString(20)};
		stats.addRow(info);
		stats.addRow(nums);
		viewObjects.add(stats);
	}

}

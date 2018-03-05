package garrettPokemonTraining;

public class Move {
	
	private String type;
	private int power;
	private int accuracy;
	private int pp;
	private boolean isSpecial;
	
	public Move(String type, int power, int accuracy, int pp, boolean isSpecial) {
		this.type = type;
		setPower(power);
		setAccuracy(accuracy);
		setPp(pp);
		this.isSpecial = isSpecial;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getPp() {
		return pp;
	}

	public void setPp(int pp) {
		this.pp = pp;
	}

	public String getType() {
		return type;
	}

	public boolean isSpecial() {
		return isSpecial;
	}

}

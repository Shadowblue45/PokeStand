package garrettPokemonTraining;

import guiTeacher.components.Action;

public class Move {

	private String name;
	private String type;
	private int power;
	private int accuracy;
	private int currentAccuracy;
	private int pp;
	private int currentPp;
	private boolean isSpecial;
	private int stat;
	private int change;
	private PokemonAction action;

	public Move(String name, String type, int power, int accuracy, int pp, boolean isSpecial, int stat, int change) {
		this.name = name;
		this.type = type;
		setPower(power);
		setAccuracy(accuracy);
		setPp(pp);
		this.isSpecial = isSpecial;
		this.stat = stat;
		this.change = change;
		this.action = PokemonAction.createAction(stat,change);
	}

	public String getName() {
		return name;
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

	public String toString() {
		return name + "," + type + "," + power + "," + accuracy + "," + pp + "," + isSpecial + "," + stat + "," + change;
	}

	public int getCurrentPp() {
		return currentPp;
	}

	public void setCurrentPp(int currentPp) {
		this.currentPp = currentPp;
	}

	public int getCurrentAccuracy() {
		return currentAccuracy;
	}

	public void setCurrentAccuracy(int currentAccuracy) {
		this.currentAccuracy = currentAccuracy;
	}

	public void attack(Pokemon target, Pokemon user) {
		if(stat >= 0) {
			action.setTarget(target);
			action.act();
		}else {
			if((int)(Math.random() * 100) < accuracy) {
				if(isSpecial) {
					int damage = (user.getsAtk() - target.getsDef());
					target.setHp(target.getHp() - (user.getsAtk() - target.getsDef()));
				}else {
					int damage = (user.getAtk() - target.getDef());
					target.setHp(target.getHp() - (user.getAtk() - target.getDef()));
				}
				if(isSpecial) {
					target.setCurrentHp(target.getCurrentHp() - (this.power *(user.getsAtk()/target.getsDef())+1));
				}else {
					System.out.println("Doh, I missed!");
					target.setCurrentHp(target.getCurrentHp() - (this.power *(user.getAtk()/target.getDef())+1));
				}
			}
			if(!target.isAlive()) {

			}
		}
	}
}
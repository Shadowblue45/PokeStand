package garrettPokemonTraining;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Pokemon {

	private String name;
	private String type1;
	private String type2;
	private int hp;
	private int atk;
	private int def;
	private int sAtk;
	private int sDef;
	private int spd;
	private ArrayList<Move> moves;

	public Pokemon(String name, String type1, String type2, int hp, int atk, int def, int sAtk, int sDef, int spd) {
		setName(name);
		setType1(type1);
		setType2(type2);
		setHp(hp);
		setAtk(atk);
		setDef(def);
		setsAtk(sAtk);
		setsDef(sDef);
		setSpd(spd);
		setMoves();
	}

	private void setMoves() {
		// TODO Auto-generated method stub
		
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getsAtk() {
		return sAtk;
	}

	public void setsAtk(int sAtk) {
		this.sAtk = sAtk;
	}

	public int getsDef() {
		return sDef;
	}

	public void setsDef(int sDef) {
		this.sDef = sDef;
	}

	public int getSpd() {
		return spd;
	}

	public void setSpd(int spd) {
		this.spd = spd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public String getType1() {
		return type1;
	}
	
	public void setType1(String type1) {
		this.type1 = type1;
	}
	
	public void save() {
		try{    
			FileWriter fw=new FileWriter("resources/pokemon.csv");
			fw.write(name+","+ type1 +","+type2+","+Integer.toString(hp)+","+Integer.toString(atk)+","+Integer.toString(def)+","+Integer.toString(sAtk)+","+Integer.toString(sDef)+","+Integer.toString(spd)+"\n");
			for(Move m: moves){
				fw.write(m+"\n");    	
			}

			fw.close();    
			System.out.println("Success! File \"pokemon.csv\" saved!");
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}
	}

	public boolean read(File f) {
		try{
			FileReader fileReader = new FileReader(f);
			String line = "";
			//a BufferedReader enables us to read the file one line at a time
			BufferedReader br = new BufferedReader(fileReader);
			while ((line = br.readLine()) != null) {



				String[] param = line.split(",");
				if(param.length == 9) {
					setName(param[0]);
					setType1(param[1]);
					setType2(param[2]);
					setHp(param[3]);
					setAtk(param[4]);
					setDef(param[5]);
					setsAtk(param[6]);
					setsDef(param[7]);
					setSpd(param[8]);
				}
				else {
					invent.add(new GarrettItem(param[0],param[1],Integer.parseInt(param[2]), Integer.parseInt(param[3]), Integer.parseInt(param[4])));
				}
			}
			br.close();
			return true;
		}catch(Exception e){
			System.out.println("The file name you specified does not exist.");
			return false;
		}
	}

	public void load() {

	}

}

package garrettPokemonTraining;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Inventory {
	
	public static Pokemon pokemon;
	public static String[] pokemonForms = {"Popplio","Brionne","Primarina"};
	public static String[] pokemonImages = {"resources/water/Popplio.png","resources/water/Brionne.png","resources/water/Primarina.png"};
	private int abilityPoints;
	private int fatigue;

	public Inventory() {
		setPokemon("Popplio", "Water", "-", 25,27,27,33,28,20, "resources/water/popplio.png");
	}

	public void save() {
		try{    
			FileWriter fw=new FileWriter("resources/pokemon.csv");
			fw.write(pokemon.getName()+","+ pokemon.getType1() +","+pokemon.getType2()+
					","+Integer.toString(pokemon.getHp())+","+Integer.toString(pokemon.getAtk())+","+Integer.toString(pokemon.getDef())
					+","+Integer.toString(pokemon.getsAtk())+","+Integer.toString(pokemon.getsDef())+","+Integer.toString(pokemon.getSpd())+","+pokemon.getImage()+"\n");
			for(Move m: pokemon.getMoves()){
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
				if(param.length == 10) {
					pokemon.setName(param[0]);
					pokemon.setType1(param[1]);
					pokemon.setType2(param[2]);
					pokemon.setHp(Integer.parseInt(param[3]));
					pokemon.setAtk(Integer.parseInt(param[4]));
					pokemon.setDef(Integer.parseInt(param[5]));
					pokemon.setsAtk(Integer.parseInt(param[6]));
					pokemon.setsDef(Integer.parseInt(param[7]));
					pokemon.setSpd(Integer.parseInt(param[8]));
					pokemon.setImage(param[9]);
				}
				else {
					//PokeStart.inventory.add(new GarrettItem(param[0],param[1],Integer.parseInt(param[2]), Integer.parseInt(param[3]), Integer.parseInt(param[4])));
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
		String fileName = "";
		//empty the catalog to prepare for a new load
		//use this boolean to control the while loop. The user should have multiple chances to enter a correct filename
		boolean opened = false;
		while(!opened){

			fileName = "resources/pokemon.csv";
			opened = read(new File(fileName));

		}
	}

	public String[] getNames() {
		// TODO Auto-generated method stub
		return pokemonForms;
	}
	
	public int getNameIndex() {
		for(int i = 0; i < pokemonForms.length; i++) {
			if(pokemon.getName().equals(pokemonForms[i])) {
				return i;
			}
		}
		return -1;
	}
	
	public Pokemon getPokemon() {
		return pokemon;
	}
	
	public void setPokemon(String name, String type1, String type2, int hp, int atk, int def, int sAtk, int sDef, int spd, String url) {
		pokemon = new Pokemon(name, type1, type2, hp, atk, def, sAtk, sDef, spd, url);
	}
	
	public String[] getPokemonImages() {
		return pokemonImages;
	}
	
	public static void setImages(String[] pics) {
		for(int i = 0; i < pics.length; i++) {
			pokemonImages[i] = pics[i];
		}
	}
	
	public static void setNames(String[] names) {
		for(int i = 0; i < names.length; i++) {
			pokemonForms[i] = names[i];
		}
	}

}

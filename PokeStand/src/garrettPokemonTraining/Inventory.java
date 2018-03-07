package garrettPokemonTraining;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Inventory {
	
	private Pokemon pokemon;
	private String[] pokemonForms = {"Charmander","Charmeleon","Charizard"};
	private String[] pokemonImages;

	public Inventory() {
		pokemon = new Pokemon("Charmander", "Fire", null, 50,50,50,50,50,50);
	}

	public void save() {
		try{    
			FileWriter fw=new FileWriter("resources/pokemon.csv");
			fw.write(PokemonTest.pokemon.getName()+","+ PokemonTest.pokemon.getType1() +","+PokemonTest.pokemon.getType2()+
					","+Integer.toString(PokemonTest.pokemon.getHp())+","+Integer.toString(PokemonTest.pokemon.getAtk())+","+Integer.toString(PokemonTest.pokemon.getDef())
					+","+Integer.toString(PokemonTest.pokemon.getsAtk())+","+Integer.toString(PokemonTest.pokemon.getsDef())+","+Integer.toString(PokemonTest.pokemon.getSpd())+"\n");
			for(Move m: PokemonTest.pokemon.getMoves()){
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
					PokemonTest.pokemon.setName(param[0]);
					PokemonTest.pokemon.setType1(param[1]);
					PokemonTest.pokemon.setType2(param[2]);
					PokemonTest.pokemon.setHp(Integer.parseInt(param[3]));
					PokemonTest.pokemon.setAtk(Integer.parseInt(param[4]));
					PokemonTest.pokemon.setDef(Integer.parseInt(param[5]));
					PokemonTest.pokemon.setsAtk(Integer.parseInt(param[6]));
					PokemonTest.pokemon.setsDef(Integer.parseInt(param[7]));
					PokemonTest.pokemon.setSpd(Integer.parseInt(param[8]));
				}
				else {
					//PokemonTest.inventory.add(new GarrettItem(param[0],param[1],Integer.parseInt(param[2]), Integer.parseInt(param[3]), Integer.parseInt(param[4])));
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
		return 0;
	}
	
	public Pokemon getPokemon() {
		return pokemon;
	}

}

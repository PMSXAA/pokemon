package pokemon.model;

import java.util.List;

public class PokemonModel {
	
	private String name;
	private int id;
	private List<Abilities> abilities;
	private int base_experience;
	private List<String> helditems;
	private List<String> locationAreaEncounters;

	public PokemonModel() {
		
	}
	
	public PokemonModel(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Abilities> getAbilities() {
		return abilities;
	}

	public void setAbilities(List<Abilities> abilities) {
		this.abilities = abilities;
	}

	public int getBase_experience() {
		return base_experience;
	}

	public void setBase_experience(int base_experience) {
		this.base_experience = base_experience;
	}

	public List<String> getHelditems() {
		return helditems;
	}

	public void setHelditems(List<String> helditems) {
		this.helditems = helditems;
	}

	public List<String> getLocationAreaEncounters() {
		return locationAreaEncounters;
	}

	public void setLocationAreaEncounters(List<String> locationAreaEncounters) {
		this.locationAreaEncounters = locationAreaEncounters;
	}

	

	
	

}

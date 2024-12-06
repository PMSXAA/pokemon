package pokemon.service;

import pokemon.model.PokemonModel;


public interface PokemonSearchService {
	
	public PokemonModel searchName(String name);
	public PokemonModel searchId(String name);
	public PokemonModel searchAbilities(String name);
	public PokemonModel searchBaseExperience(String name);
	public PokemonModel searchHeldItems(String name);
	public PokemonModel searchLocationAreaEncounters(String name);
}

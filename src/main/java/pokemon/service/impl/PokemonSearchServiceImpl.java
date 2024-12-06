package pokemon.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pokemon.constants.PokemonConstants;
import pokemon.entity.RequestHistory;
import pokemon.model.Abilities;
import pokemon.model.HeldItems;
import pokemon.model.Pokemon;
import pokemon.model.PokemonLocation;
import pokemon.model.PokemonModel;
import pokemon.service.PokemonSearchService;
import pokemon.utils.Utils;

@Service
public class PokemonSearchServiceImpl implements PokemonSearchService{
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RequestHistoryServiceImpl requestHistoryServiceImpl;
	
	@Override
	public PokemonModel searchName(String name) {
		
		
		PokemonModel pokemonNameModel = new PokemonModel();
		
		ResponseEntity<Pokemon> responsePokemonEntity = doPokemon(name);
		
		if(responsePokemonEntity.getStatusCode().value() == 200) {
			
			Pokemon pokemon = responsePokemonEntity.getBody();
			pokemonNameModel.setName(pokemon.getName());
			saveRequestHistory(PokemonConstants.METHOD_NAME, 0L, name, pokemon.getName());
		}else {
			pokemonNameModel.setName("No se encontro el pokemon");
			saveRequestHistory(PokemonConstants.METHOD_NAME, 0L, name, "No se encontro el pokemon");
		}
		
		return pokemonNameModel;
	}
	
	@Override
	public PokemonModel searchId(String name) {
		
		PokemonModel pokemonNameModel = new PokemonModel();
		
		ResponseEntity<Pokemon> responsePokemonEntity = doPokemon(name);
		
		if(responsePokemonEntity.getStatusCode().value() == 200) {
			Pokemon pokemon = responsePokemonEntity.getBody();
			pokemonNameModel.setId(pokemon.getId());
			saveRequestHistory(PokemonConstants.METHOD_ID, 0L, name, String.valueOf(pokemon.getId()));
		}else {
			pokemonNameModel.setId(-1);
			saveRequestHistory(PokemonConstants.METHOD_ID ,0L, name, "No se encontro el pokemon");
		}
		
		return pokemonNameModel;
	}
	
	@Override
	public PokemonModel searchAbilities(String name) {
		
		PokemonModel pokemonNameModel = new PokemonModel();
		
		ResponseEntity<Pokemon> responsePokemonEntity = doPokemon(name);
		
		if(responsePokemonEntity.getStatusCode().value() == 200) {
			Pokemon pokemon = responsePokemonEntity.getBody();
			List<Abilities> abilities = new ArrayList<>();
			for(Abilities abilitie: pokemon.getAbilities()) {
				abilities.add(abilitie);
			}
			saveRequestHistory(PokemonConstants.METHOD_ABILITIES, 0L, name, pokemon.getAbilities().toString());;
			pokemonNameModel.setAbilities(abilities);
			
		}else {
			pokemonNameModel.setName("No se encontro el pokemon");
		}
		
		return pokemonNameModel;
	}
	
	@Override
	public PokemonModel searchBaseExperience(String name) {
		
		
		PokemonModel pokemonNameModel = new PokemonModel();
		
		ResponseEntity<Pokemon> responsePokemonEntity = doPokemon(name);
		
		if(responsePokemonEntity.getStatusCode().value() == 200) {
			Pokemon pokemon = responsePokemonEntity.getBody();
			pokemonNameModel.setBase_experience(pokemon.getBase_experience());
			saveRequestHistory(PokemonConstants.METHOD_BASE_EXPERIENCE, 0L, name, String.valueOf(pokemon.getBase_experience()));
			
		}else {
			pokemonNameModel.setBase_experience(-1);
		}
		
		return pokemonNameModel;
	}
	
	@Override
	public PokemonModel searchHeldItems(String name) {
		PokemonModel pokemonNameModel = new PokemonModel();
		ResponseEntity<Pokemon> responsePokemonEntity = doPokemon(name);
		if(responsePokemonEntity.getStatusCode().value() == 200) {
			Pokemon pokemon = responsePokemonEntity.getBody();
			List<String> helpItem = new ArrayList<>();
			for(HeldItems heldItems: pokemon.getHeld_items()) {
				helpItem.add(heldItems.getItem().getName());
			}
			saveRequestHistory(PokemonConstants.METHOD_HELD_ITEMS, 0L, name, pokemon.getHeld_items().toString());
			pokemonNameModel.setHelditems(helpItem);
			
		}else {
			pokemonNameModel.setName("No se encontro el pokemon");
		}
		return pokemonNameModel;
	}
	
	@Override
	public PokemonModel searchLocationAreaEncounters(String name) {
		
		
		PokemonModel pokemonNameModel = new PokemonModel();
		ResponseEntity<Pokemon> responsePokemonEntity = doPokemon(name);
		if(responsePokemonEntity.getStatusCode().value() == 200) {
			Pokemon pokemon = responsePokemonEntity.getBody();
			ResponseEntity<PokemonLocation[]> response = doPokemonLocation(pokemon.getId());
			if(response.getStatusCode().value() == 200) {
				PokemonLocation [] pokemonLocations = response.getBody();
				List<String> pokemonLocationList = new ArrayList<>();
				for(PokemonLocation pokemonLocation: pokemonLocations) {
					pokemonLocationList.add(pokemonLocation.getLocation_area().getName());
				}
				saveRequestHistory(PokemonConstants.METHOD_LOCATION_AREA_ENCOUNTES, 0L, name, String.join(" ", pokemonLocationList));
				pokemonNameModel.setLocationAreaEncounters(pokemonLocationList);
			}else {
				pokemonNameModel.setName("No se encontro el pokemon");
			}
		}else {
			pokemonNameModel.setName("No se encontro el pokemon");
		}
		return pokemonNameModel;
	}
	
	public ResponseEntity<Pokemon> doPokemon(String name) {
		String baseUrl = PokemonConstants.ENDPOINT_POKEMON + name;
		ResponseEntity<Pokemon> responsePokemonEntity =
				   restTemplate.getForEntity(baseUrl, Pokemon.class);
		return responsePokemonEntity;
	}
	
	public ResponseEntity<PokemonLocation[]> doPokemonLocation(int id) {
		String baseUrl = PokemonConstants.ENDPOINT_POKEMON_LOCATION_AREA_ENCOUNTES;
		ResponseEntity<PokemonLocation[]> responsePokemonEntity =
				   restTemplate.getForEntity(baseUrl.replace("{id}", String.valueOf(id)), PokemonLocation[].class);
		return responsePokemonEntity;
	}
	
	public void saveRequestHistory(String method, Long timeRequest, String request, String response) {
		String ip = Utils.getIpServer();
		if(response.length() > 255) {
			response = response.substring(0, 255);
		}
		try {
			RequestHistory requestHistory = new RequestHistory(ip, new Date(), method, timeRequest, request, response);
			requestHistoryServiceImpl.save(requestHistory);
		}catch (DataAccessException e) { 
			e.printStackTrace();
		}
	}
	
}
package pokemon.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import pokemon.model.Abilities;
import pokemon.model.PokemonModel;
import pokemon.service.impl.PokemonSearchServiceImpl;
import pokemon.soap.Abilitie;
import pokemon.soap.GetAbilitiesRequest;
import pokemon.soap.GetAbilitiesResponse;
import pokemon.soap.GetBaseExpRequest;
import pokemon.soap.GetBaseExpResponse;
import pokemon.soap.GetHeldItemsRequest;
import pokemon.soap.GetHeldItemsResponse;
import pokemon.soap.GetIdRequest;
import pokemon.soap.GetIdResponse;
import pokemon.soap.GetLocationAreaEncuentersRequest;
import pokemon.soap.GetLocationAreaEncuentersResponse;
import pokemon.soap.GetNameRequest;
import pokemon.soap.GetNameResponse;
import pokemon.soap.HeldItem;
import pokemon.soap.LocationAreaEncuenters;

@Endpoint
public class PokemonEndpoint {
	private static final String NAMESPACE_URI = "http://soap.pokemon/";
	
	
	
	@Autowired
	public PokemonSearchServiceImpl pokemonSearchServiceImpl;
	
	 @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getNameRequest")
	 @ResponsePayload
	 public GetNameResponse getNamePokemon(@RequestPayload GetNameRequest request) {
		 GetNameResponse response = new GetNameResponse();
		 PokemonModel pokemonModel = pokemonSearchServiceImpl.searchName(request.getName());
		 response.setName(pokemonModel.getName());
		 return response;
	 }
	 
	 @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIdRequest")
	 @ResponsePayload
	 public GetIdResponse getIdPokemon(@RequestPayload GetIdRequest request) {
		 GetIdResponse response = new GetIdResponse();
		 PokemonModel pokemonModel = pokemonSearchServiceImpl.searchId(request.getName());
		 response.setId(pokemonModel.getId());
		 return response; 
	 }
	 
	 @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAbilitiesRequest")
	 @ResponsePayload
	 public GetAbilitiesResponse getAbilitiesPokemon(@RequestPayload GetAbilitiesRequest request) {
		 GetAbilitiesResponse response = new GetAbilitiesResponse();
		 PokemonModel pokemonModel = pokemonSearchServiceImpl.searchAbilities(request.getName());
		 List<Abilitie> abilitieSoap = new ArrayList<>();
		 for(Abilities abilities: pokemonModel.getAbilities()) {
			
			 Abilitie abilitie = new Abilitie();
			 abilitie.setAbilitie(abilities.getAbility().getName());
			 abilitieSoap.add(abilitie);
		 }
		 response.getAbilitie().addAll(abilitieSoap);
		 return response; 
	 }
	 
	 @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBaseExpRequest")
	 @ResponsePayload
	 public GetBaseExpResponse getBaseExpPokemon(@RequestPayload GetBaseExpRequest request) {
		 GetBaseExpResponse response = new GetBaseExpResponse();
		 PokemonModel pokemonModel = pokemonSearchServiceImpl.searchBaseExperience(request.getName());
		 response.setBaseExperience(pokemonModel.getBase_experience());
		 return response; 
	 }
	 
	 @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHeldItemsRequest")
	 @ResponsePayload
	 public GetHeldItemsResponse getHeldItemsPokemon(@RequestPayload GetHeldItemsRequest request) {
		 GetHeldItemsResponse response = new GetHeldItemsResponse();
		 PokemonModel pokemonModel = pokemonSearchServiceImpl.searchHeldItems(request.getName());
		 List<HeldItem> heldItemSoap = new ArrayList<>();
		 for(String heldItemName: pokemonModel.getHelditems()) {
			 HeldItem heldItem = new HeldItem();
			 heldItem.setHeldItem(heldItemName);
			 heldItemSoap.add(heldItem);
		 }
		 response.getHeldItem().addAll(heldItemSoap);
		 return response; 
	 }
	 
	 @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLocationAreaEncuentersRequest")
	 @ResponsePayload
	 public GetLocationAreaEncuentersResponse getLocationAreaEncuenters(@RequestPayload GetLocationAreaEncuentersRequest request) {
		 GetLocationAreaEncuentersResponse response = new GetLocationAreaEncuentersResponse();
		 PokemonModel pokemonModel = pokemonSearchServiceImpl.searchLocationAreaEncounters(request.getName());
		 List<LocationAreaEncuenters> locationAreaEncuentersSoap = new ArrayList<>();
		 for(String locationAreaEncounterName: pokemonModel.getLocationAreaEncounters()) {
			 LocationAreaEncuenters locationAreaEncuenters = new LocationAreaEncuenters();
			 locationAreaEncuenters.setLocationAreaEncuenters(locationAreaEncounterName);
			 locationAreaEncuentersSoap.add(locationAreaEncuenters);
		 }
		 response.getLocationAreaEncuenters().addAll(locationAreaEncuentersSoap);
		 return response; 
	 }
	 
}

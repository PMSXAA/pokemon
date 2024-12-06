package pokemon.endpoint;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import pokemon.model.Abilities;
import pokemon.model.Ability;
import pokemon.model.PokemonModel;
import pokemon.service.impl.PokemonSearchServiceImpl;
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

@SpringBootTest
class PokemonEndpointTest {
	@InjectMocks
	private PokemonEndpoint pokemonEndpoint;
	
	@Mock
	private RestTemplate restTemplate;
	
	@Mock
	public PokemonSearchServiceImpl pokemonSearchServiceImpl;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(PokemonEndpointTest.class);
	} 
	
	@Test
	void getNamePokemonTest() {
		
		GetNameRequest request = new GetNameRequest();
		request.setName("pikachu");
		
		PokemonModel pokemonModel = new PokemonModel();
		pokemonModel.setName("pikachu");
		 
		Mockito.when(pokemonSearchServiceImpl.searchName(request.getName())).thenReturn(pokemonModel);
		
		GetNameResponse nameReponse = pokemonEndpoint.getNamePokemon(request);
		
		Assertions.assertEquals("pikachu", nameReponse.getName());
		
	}
	
	@Test
	void getIdPokemonTest() {
		GetIdRequest request = new GetIdRequest();
		request.setName("pikachu");
		
		PokemonModel pokemonModel = new PokemonModel();
		pokemonModel.setName("pikachu");
		pokemonModel.setId(25);
		
		Mockito.when(pokemonSearchServiceImpl.searchId(request.getName())).thenReturn(pokemonModel);
		
		GetIdResponse idReponse = pokemonEndpoint.getIdPokemon(request);
		Assertions.assertEquals(25, idReponse.getId());
		
	}
	
	@Test
	void getAbilitiesPokemonTest() {
		GetAbilitiesRequest request = new GetAbilitiesRequest();
		request.setName("pikachu");
		
		Ability ability = new Ability();
		ability.setName("inner-focus");
		
		Abilities abilities = new Abilities();
		abilities.setAbility(ability);
		
		List<Abilities> abilitiesList = new ArrayList<>();
		abilitiesList.add(abilities);
		
		PokemonModel pokemonModel = new PokemonModel();
		pokemonModel.setName("pikachu");
		pokemonModel.setId(25);
		pokemonModel.setAbilities(abilitiesList);
		
		Mockito.when(pokemonSearchServiceImpl.searchAbilities(request.getName())).thenReturn(pokemonModel);
		GetAbilitiesResponse response = pokemonEndpoint.getAbilitiesPokemon(request);
		
		Assertions.assertNotNull(response.getAbilitie());
		
	
	}
	
	@Test
	void getBaseExpPokemonTest() {
		GetBaseExpRequest request = new GetBaseExpRequest();
		request.setName("pikachu");
		
		PokemonModel pokemonModel = new PokemonModel();
		pokemonModel.setName("pikachu");
		pokemonModel.setId(25);
		pokemonModel.setBase_experience(112);
		
		Mockito.when(pokemonSearchServiceImpl.searchBaseExperience(request.getName())).thenReturn(pokemonModel);
		GetBaseExpResponse response = pokemonEndpoint.getBaseExpPokemon(request);
		Assertions.assertEquals(112, response.getBaseExperience());
	}
	
	@Test
	void getHeldItemsTest() { 
		GetHeldItemsRequest request = new GetHeldItemsRequest();
		request.setName("pikachu");
		
		List<String> helditems = new ArrayList<>();
		helditems.add("oran-berry");
		helditems.add("light-ball");
		
		PokemonModel pokemonModel = new PokemonModel();
		pokemonModel.setName("pikachu");
		pokemonModel.setId(25);
		pokemonModel.setBase_experience(112);
		pokemonModel.setHelditems(helditems);
		
		Mockito.when(pokemonSearchServiceImpl.searchHeldItems(request.getName())).thenReturn(pokemonModel);
		GetHeldItemsResponse response = pokemonEndpoint.getHeldItemsPokemon(request);
		Assertions.assertNotNull(response.getHeldItem());
	}
	
	@Test
	void getLocationAreaEncuentersTest() {
		GetLocationAreaEncuentersRequest request = new GetLocationAreaEncuentersRequest();
		request.setName("pikachu");
		
		List<String> locationAreaEncounters = new ArrayList<>();
		locationAreaEncounters.add("trophy-garden-area");
		locationAreaEncounters.add("pallet-town-area");
		locationAreaEncounters.add("kanto-route-2-south-towards-viridian-city");
		
		PokemonModel pokemonModel = new PokemonModel();
		pokemonModel.setName("pikachu");
		pokemonModel.setId(25);
		pokemonModel.setBase_experience(112);
		pokemonModel.setLocationAreaEncounters(locationAreaEncounters);
		
		Mockito.when(pokemonSearchServiceImpl.searchLocationAreaEncounters(request.getName())).thenReturn(pokemonModel);
		GetLocationAreaEncuentersResponse response = pokemonEndpoint.getLocationAreaEncuenters(request);
		Assertions.assertNotNull(response.getLocationAreaEncuenters());
	}
}


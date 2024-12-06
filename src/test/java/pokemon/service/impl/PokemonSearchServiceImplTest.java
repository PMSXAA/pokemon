package pokemon.service.impl;



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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import pokemon.model.Abilities;
import pokemon.model.Ability;
import pokemon.model.HeldItems;
import pokemon.model.Item;
import pokemon.model.LocationArea;
import pokemon.model.Pokemon;
import pokemon.model.PokemonLocation;
import pokemon.model.PokemonModel;

@SpringBootTest
class PokemonSearchServiceImplTest {
	
	@InjectMocks
	private PokemonSearchServiceImpl pokemonSearchServiceImpl;

	@Mock
	private RequestHistoryServiceImpl requestHistoryServiceImpl;
	
	@Mock
	private RestTemplate restTemplate;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(PokemonSearchServiceImplTest.class);
	} 
	
	@Test
	void searchName() {
		
		Ability ability = new Ability();
		ability.setName("inner-focus");
		
		Abilities abilities = new Abilities();
		abilities.setAbility(ability);
		
		List<Abilities> abilitiesList = new ArrayList<>();
		abilitiesList.add(abilities);
		
		Item item = new Item();
		item.setName("magmarizer");
		
		HeldItems heldItems = new HeldItems();
		heldItems.setItem(item);
		
		List<HeldItems> heldItemsList = new ArrayList<>();
		heldItemsList.add(heldItems);
		
		Pokemon pokemon = new Pokemon();
		pokemon.setName("charmander");
		pokemon.setId(1);
		pokemon.setBase_experience(79);
		pokemon.setAbilities(abilitiesList);
		pokemon.setHeld_items(heldItemsList);
		
		
		ResponseEntity<Pokemon> responsePokemonEntity = new ResponseEntity<Pokemon>(pokemon, HttpStatus.OK);
		Mockito.when(pokemonSearchServiceImpl.doPokemon(pokemon.getName())).thenReturn(responsePokemonEntity);
		PokemonModel pModel = pokemonSearchServiceImpl.searchName(pokemon.getName());
		Assertions.assertEquals("charmander", pModel.getName());
	}
	
	@Test
	void searchNameError() {
		
		Pokemon pokemon = new Pokemon();
		pokemon.setName("No se encontro el pokemon");
		
		ResponseEntity<Pokemon> responsePokemonEntity = new ResponseEntity<Pokemon>(pokemon, HttpStatus.BAD_REQUEST);
		Mockito.when(pokemonSearchServiceImpl.doPokemon(pokemon.getName())).thenReturn(responsePokemonEntity);
		
		PokemonModel pModel = pokemonSearchServiceImpl.searchName(pokemon.getName());
		Assertions.assertEquals("No se encontro el pokemon", pModel.getName());
	}
	
	@Test
	void searchIdSuccess() {
		
		Pokemon pokemon = new Pokemon();
		pokemon.setName("Magmar");
		pokemon.setId(126);
		PokemonModel pokemonModel = new PokemonModel();
		pokemonModel.setId(126);
		Mockito.when(pokemonSearchServiceImpl.doPokemon(pokemon.getName())).thenReturn(new ResponseEntity<Pokemon>(pokemon, HttpStatus.OK));
		PokemonModel pModel = pokemonSearchServiceImpl.searchId(pokemon.getName());
		Assertions.assertEquals(126, pModel.getId());

	}
	
	@Test
	void searchIdError() {
		
		Pokemon pokemon = new Pokemon();
		pokemon.setName("Magmar1");
		PokemonModel pokemonModel = new PokemonModel();
		pokemonModel.setId(126);
		Mockito.when(pokemonSearchServiceImpl.doPokemon(pokemon.getName())).thenReturn(new ResponseEntity<Pokemon>(pokemon, HttpStatus.BAD_REQUEST));
		PokemonModel pModel = pokemonSearchServiceImpl.searchId(pokemon.getName());
		
		Assertions.assertEquals(-1, pModel.getId());

	}
	
	@Test
	void searchAbilitiesSuccess() {
		
		Ability ability = new Ability();
		ability.setName("inner-focus");
		
		Abilities abilities = new Abilities();
		abilities.setAbility(ability);
		
		List<Abilities> abilitiesList = new ArrayList<>();
		abilitiesList.add(abilities);
		
		Pokemon pokemon = new Pokemon();
		pokemon.setName("Magmar");
		pokemon.setAbilities(abilitiesList);
		
		Mockito.when(pokemonSearchServiceImpl.doPokemon(pokemon.getName())).thenReturn(new ResponseEntity<Pokemon>(pokemon, HttpStatus.OK));
		PokemonModel pModel = pokemonSearchServiceImpl.searchAbilities(pokemon.getName());
		Assertions.assertNotNull(pModel.getAbilities());
		
	}
	
	@Test
	void searchAbilitiesError() {
		
		
		
		Pokemon pokemon = new Pokemon();
		pokemon.setName("Magmar");
		
		Mockito.when(pokemonSearchServiceImpl.doPokemon(pokemon.getName())).thenReturn(new ResponseEntity<Pokemon>(pokemon, HttpStatus.BAD_REQUEST));
		PokemonModel pModel = pokemonSearchServiceImpl.searchAbilities(pokemon.getName());
		Assertions.assertNull(pModel.getAbilities());
		
	}
	
	@Test
	void searchBaseExperienceSuccess() {
		
		Pokemon pokemon = new Pokemon();
		pokemon.setName("Dragonite");
		pokemon.setBase_experience(300);
		
		Mockito.when(pokemonSearchServiceImpl.doPokemon(pokemon.getName())).thenReturn(new ResponseEntity<Pokemon>(pokemon, HttpStatus.OK));
		PokemonModel pModel = pokemonSearchServiceImpl.searchBaseExperience(pokemon.getName());
		Assertions.assertEquals(300, pModel.getBase_experience());
		
	}
	
	
	@Test
	void searchBaseExperienceError() {
		
		Pokemon pokemon = new Pokemon();
		pokemon.setName("Dragonite");
		pokemon.setBase_experience(300);
		
		Mockito.when(pokemonSearchServiceImpl.doPokemon(pokemon.getName())).thenReturn(new ResponseEntity<Pokemon>(pokemon, HttpStatus.BAD_REQUEST));
		PokemonModel pModel = pokemonSearchServiceImpl.searchBaseExperience(pokemon.getName());
		Assertions.assertEquals(-1, pModel.getBase_experience());
		
	}
	
	@Test
	void searchHeldItemsSuccess() {
		
		Item item = new Item();
		item.setName("magmarizer");
		
		HeldItems heldItems = new HeldItems();
		heldItems.setItem(item);
		
		List<HeldItems> heldItemsList = new ArrayList<>();
		heldItemsList.add(heldItems);
		
		Pokemon pokemon = new Pokemon();
		pokemon.setName("Dragonite");
		pokemon.setHeld_items(heldItemsList);
		
		
		Mockito.when(pokemonSearchServiceImpl.doPokemon(pokemon.getName())).thenReturn(new ResponseEntity<Pokemon>(pokemon, HttpStatus.OK));
		PokemonModel pModel = pokemonSearchServiceImpl.searchHeldItems(pokemon.getName());
		Assertions.assertNotNull(pModel.getHelditems());
		
	}
	
	@Test
	void searchHeldItemsError() {
		
		
		Pokemon pokemon = new Pokemon();
		pokemon.setName("Dragoniter");
		
		
		Mockito.when(pokemonSearchServiceImpl.doPokemon(pokemon.getName())).thenReturn(new ResponseEntity<Pokemon>(pokemon, HttpStatus.BAD_REQUEST));
		PokemonModel pModel = pokemonSearchServiceImpl.searchHeldItems(pokemon.getName());
		Assertions.assertNull(pModel.getHelditems());
		
	}
	
	@Test
	void searchLocationAreaEncountersSuccess() {
		
		LocationArea locationArea1 = new LocationArea();
		locationArea1.setName("old-chateau-2f-right-room");
		
		LocationArea locationArea2 = new LocationArea();
		locationArea2.setName("thrifty-megamart-abandoned-site");
		
		PokemonLocation pokemonLocation1 = new PokemonLocation();
		pokemonLocation1.setLocation_area(locationArea1);
		
		PokemonLocation pokemonLocation2 = new PokemonLocation();
		pokemonLocation2.setLocation_area(locationArea1);
		
		PokemonLocation[] pokemonLocations = {pokemonLocation1, pokemonLocation2};
		
		
		Pokemon pokemon = new Pokemon();
		pokemon.setId(148);
		pokemon.setName("Dragonite");
		pokemon.setBase_experience(300);
		
		Mockito.when(pokemonSearchServiceImpl.doPokemon(pokemon.getName())).thenReturn(new ResponseEntity<Pokemon>(pokemon, HttpStatus.OK));
		Mockito.when(pokemonSearchServiceImpl.doPokemonLocation(pokemon.getId())).thenReturn(new ResponseEntity<PokemonLocation[]>(pokemonLocations, HttpStatus.OK));
		
		
		PokemonModel pModel = pokemonSearchServiceImpl.searchLocationAreaEncounters(pokemon.getName());
		
		Assertions.assertNotNull(pModel.getLocationAreaEncounters());
	}
	
	@Test
	void searchLocationAreaEncountersErrorLocation() {
		
		
		PokemonLocation[] pokemonLocations = new PokemonLocation[0];
		
		
		Pokemon pokemon = new Pokemon();
		pokemon.setId(148);
		pokemon.setName("Dragonite");
		pokemon.setBase_experience(300);
		
		Mockito.when(pokemonSearchServiceImpl.doPokemon(pokemon.getName())).thenReturn(new ResponseEntity<Pokemon>(pokemon, HttpStatus.OK));
		Mockito.when(pokemonSearchServiceImpl.doPokemonLocation(pokemon.getId())).thenReturn(new ResponseEntity<PokemonLocation[]>(pokemonLocations, HttpStatus.BAD_REQUEST));
		
		
		PokemonModel pModel = pokemonSearchServiceImpl.searchLocationAreaEncounters(pokemon.getName());
		
		Assertions.assertNull(pModel.getLocationAreaEncounters());
	}
	
	
	@Test
	void searchLocationAreaEncountersErrorDoPokemon() {
		
		Pokemon pokemon = new Pokemon();
		pokemon.setId(148);
		pokemon.setName("Dragoniter");
		
		Mockito.when(pokemonSearchServiceImpl.doPokemon(pokemon.getName())).thenReturn(new ResponseEntity<Pokemon>(pokemon, HttpStatus.BAD_REQUEST));
		
		PokemonModel pModel = pokemonSearchServiceImpl.searchLocationAreaEncounters(pokemon.getName());
		
		Assertions.assertNull(pModel.getLocationAreaEncounters());
	}
	
	
	
	


}

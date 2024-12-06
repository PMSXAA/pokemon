package pokemon.model;

import java.io.Serializable;

public class PokemonLocation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private LocationArea location_area;

	public LocationArea getLocation_area() {
		return location_area;
	}

	public void setLocation_area(LocationArea location_area) {
		this.location_area = location_area;
	}

	@Override
	public String toString() {
		return "PokemonLocation [location_area=" + location_area + "]";
	}

	

}

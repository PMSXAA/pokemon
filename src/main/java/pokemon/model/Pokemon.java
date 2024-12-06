package pokemon.model;

import java.io.Serializable;
import java.util.List;

public class Pokemon implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private List<Abilities> abilities;
	private int base_experience;
	private List<HeldItems> held_items;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public List<HeldItems> getHeld_items() {
		return held_items;
	}
	public void setHeld_items(List<HeldItems> held_items) {
		this.held_items = held_items;
	}
	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", abilities=" + abilities + ", base_experience="
				+ base_experience + ", held_items=" + held_items + "]";
	}

}

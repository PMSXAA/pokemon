package pokemon.model;

import java.io.Serializable;

public class Ability implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Ability [name=" + name + "]";
	}

}

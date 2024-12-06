package pokemon.model;

import java.io.Serializable;

public class Abilities implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Ability ability;
	
	public Ability getAbility() {
		return ability;
	}
	public void setAbility(Ability ability) {
		this.ability = ability;
	}
	@Override
	public String toString() {
		return "Abilities [ability=" + ability + "]";
	}
	

}

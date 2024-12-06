package pokemon.model;

import java.io.Serializable;

public class HeldItems implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Item item;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "HeldItems [item=" + item + "]";
	}

}

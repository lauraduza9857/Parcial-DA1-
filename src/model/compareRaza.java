package model;

import java.util.Comparator;

public class compareRaza  implements Comparator<Mascota>{

	@Override
	public int compare(Mascota o1, Mascota o2) {
		// TODO Auto-generated method stub
		return o1.getRaza().compareTo(o2.getRaza());
	}

}

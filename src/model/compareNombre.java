package model;

import java.util.Comparator;

public class compareNombre implements Comparator<Mascota>{

	@Override
	public int compare(Mascota o1, Mascota o2) {
		// TODO Auto-generated method stub
		return o1.getNombre().compareTo(o2.getNombre());
	}

}

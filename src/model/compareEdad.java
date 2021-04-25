package model;

import java.util.Comparator;

public class compareEdad implements Comparator<Mascota>{

	@Override
	public int compare(Mascota o1, Mascota o2) {
		// TODO Auto-generated method stub
		return o1.getEdad()-o2.getEdad();
	}

}


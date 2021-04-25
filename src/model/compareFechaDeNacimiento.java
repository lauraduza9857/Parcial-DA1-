package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class compareFechaDeNacimiento implements Comparator<Mascota>{

	@Override
	public int compare(Mascota o1, Mascota o2) {
		// TODO Auto-generated method stub
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date o1BirthDate = null;
        Date o2BirthDate = null;
        try {
        	o1BirthDate = formatter.parse(o1.getFechaDeNacimiento());
        	o2BirthDate = formatter.parse(o2.getFechaDeNacimiento());
        } catch (ParseException pe) {
            pe.printStackTrace();
        }

        return o1BirthDate.compareTo(o2BirthDate);
	}

}

package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import model.Mascota;
import model.compareEdad;
import model.compareFechaDeNacimiento;
import model.compareNombre;
import model.compareRaza;
import processing.core.PApplet;

public class BaseDeDatosPeludos {

	private PApplet app;
	private File fileUno;
	private File fileDos;
	private String[] lines1;
	private String[] lines2;
	private String fechaActual = "";

	private ArrayList<Mascota> mascotas;

	public BaseDeDatosPeludos(PApplet app) {
		this.app = app;

		fileUno = new File("./data/import/datosUno.txt");// Carga el archivo
		fileDos = new File("./data/import/datosDos.txt");// Carga el archivo

		lines1 = new String[5];
		lines2 = new String[5];

		mascotas = new ArrayList<Mascota>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		fechaActual = sdf.format(new Date());
		
		cargarLaInformacionPeludosUno();
		cargarLaInformacionPeludosDos();
		calcularEdad();
		
		Collections.sort(mascotas);
		ponerEnMinuscula();

	}

	public void cargarLaInformacionPeludosUno() {

		// Lee el primer archivo
		try {
			FileReader reader = new FileReader(fileUno); // Se prepara para la lectura del archivo
			BufferedReader br = new BufferedReader(reader); // Se carga en el buffer para su manipulación
			String line = "";
			int posL1 = 0;
			while ((line = br.readLine()) != null) { // Se leen las lineas hasta el final del documento
				lines1[posL1] = line;
				posL1++;
			}

			br.close(); // Se cierra el buffer

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {

		}

		// Anadir los datos de datosUno a mi arreglo
		for (int i = 0; i < lines1.length; i++) {
			String[] mascota1 = lines1[i].split(","); // separar por comas
			int id = Integer.parseInt(mascota1[0]);
			mascotas.add(new Mascota(app, id, mascota1[1]));
		}

	}

	public void cargarLaInformacionPeludosDos() {
		// Lee el segundo archivo
		try {
			FileReader reader = new FileReader(fileDos); // Se prepara para la lectura del archivo
			BufferedReader br = new BufferedReader(reader); // Se carga en el buffer para su manipulación
			String line = "";
			int posL2 = 0;
			while ((line = br.readLine()) != null) { // Se leen las lineas hasta el final del documento
				lines2[posL2] = line;

				posL2++;
			}

			br.close(); // Se cierra el buffer

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {

		}

		// Anadir los datos de datosUno a mi arreglo
		for (int i = 0; i < lines2.length; i++) {
			String[] mascota1 = lines2[i].split(","); // separar por comas
			int id = Integer.parseInt(mascota1[0]);

			for (int j = 0; j < mascotas.size(); j++) {
				if (id == mascotas.get(j).getId()) {
					mascotas.get(j).setRaza(mascota1[1]);
					mascotas.get(j).setFechaDeNacimiento(mascota1[2]);
				}

			}

		}

	

	}

	public void ordenarPeludosNaturalmente() {
	
		if(app.mouseX>471 && app.mouseX<530 && app.mouseY>500 && app.mouseY<530) {
			Collections.sort(mascotas);
			
			File file = new File ("./data/dataCreada/ordenPorID.txt");//Creación del archivo 
			try {
				FileWriter fw = new FileWriter(file); //Lo cargamos para su escritura
				BufferedWriter bw = new BufferedWriter(fw); //Lo pasamos por buffer para su manipulación
				
				for(int i=0;i<mascotas.size();i++) {
					bw.write(mascotas.get(i).getId()+"  |  "+mascotas.get(i).getNombre()+"  |  "+mascotas.get(i).getEdad()+"  |  "+mascotas.get(i).getRaza()+"  |  "+mascotas.get(i).getFechaDeNacimiento());
					bw.newLine();

				}
			
				bw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	}


	public void ordenarPeludosNombre() {
		
		if(app.mouseX>99 && app.mouseX<159 && app.mouseY>500 && app.mouseY<530) {
			Collections.sort(mascotas, new compareNombre());
			
			File file = new File ("./data/dataCreada/ordenPorNombre.txt");//Creación del archivo 
			try {
				FileWriter fw = new FileWriter(file); //Lo cargamos para su escritura
				BufferedWriter bw = new BufferedWriter(fw); //Lo pasamos por buffer para su manipulación
				
				for(int i=0;i<mascotas.size();i++) {
					bw.write(mascotas.get(i).getId()+"  |  "+mascotas.get(i).getNombre()+"  |  "+mascotas.get(i).getEdad()+"  |  "+mascotas.get(i).getRaza()+"  |  "+mascotas.get(i).getFechaDeNacimiento());
					bw.newLine();

				}
			
				bw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}

	}

	public void ordenarPeludosFechaNacimiento() {

		if(app.mouseX>340 && app.mouseX<452 && app.mouseY>500 && app.mouseY<530) {
			Collections.sort(mascotas, new compareFechaDeNacimiento());
			
			File file = new File ("./data/dataCreada/ordenPorNacimiento.txt");//Creación del archivo 
			try {
				FileWriter fw = new FileWriter(file); //Lo cargamos para su escritura
				BufferedWriter bw = new BufferedWriter(fw); //Lo pasamos por buffer para su manipulación
				
				for(int i=0;i<mascotas.size();i++) {
					bw.write(mascotas.get(i).getId()+"  |  "+mascotas.get(i).getNombre()+"  |  "+mascotas.get(i).getEdad()+"  |  "+mascotas.get(i).getRaza()+"  |  "+mascotas.get(i).getFechaDeNacimiento());
					bw.newLine();

				}
			
				bw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	}

	public void ordenarPeludosRaza() {
		if(app.mouseX>180 && app.mouseX<240 && app.mouseY>500 && app.mouseY<530) {
			Collections.sort(mascotas, new compareRaza());
			
			File file = new File ("./data/dataCreada/ordenPorRaza.txt");//Creación del archivo 
			try {
				FileWriter fw = new FileWriter(file); //Lo cargamos para su escritura
				BufferedWriter bw = new BufferedWriter(fw); //Lo pasamos por buffer para su manipulación
				
				for(int i=0;i<mascotas.size();i++) {
					bw.write(mascotas.get(i).getId()+"  |  "+mascotas.get(i).getNombre()+"  |  "+mascotas.get(i).getEdad()+"  |  "+mascotas.get(i).getRaza()+"  |  "+mascotas.get(i).getFechaDeNacimiento());
					bw.newLine();

				}
			
				bw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	}

	public void ordenarPeludosEdad() {
		if(app.mouseX>260 && app.mouseX<320 && app.mouseY>500 && app.mouseY<530) {
			Collections.sort(mascotas, new compareEdad());
			
			File file = new File ("./data/dataCreada/ordenPorEdad.txt");//Creación del archivo 
			try {
				FileWriter fw = new FileWriter(file); //Lo cargamos para su escritura
				BufferedWriter bw = new BufferedWriter(fw); //Lo pasamos por buffer para su manipulación
				
				for(int i=0;i<mascotas.size();i++) {
					bw.write(mascotas.get(i).getId()+"  |  "+mascotas.get(i).getNombre()+"  |  "+mascotas.get(i).getEdad()+"  |  "+mascotas.get(i).getRaza()+"  |  "+mascotas.get(i).getFechaDeNacimiento());
					bw.newLine();

				}
			
				bw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	}

	public void ponerEnMinuscula() {

		for (int i = 0; i < mascotas.size(); i++) {
		mascotas.get(i).setNombre(mascotas.get(i).getNombre().toLowerCase());
		mascotas.get(i).setRaza(mascotas.get(i).getRaza().toLowerCase());
		}
	}

	public void pintarBaseDeDatos() {
		
		for(int i=0;i<mascotas.size();i++) {
			app.fill(0);
			app.text(mascotas.get(i).getId()+"  |  "+mascotas.get(i).getNombre()+"  |  "+mascotas.get(i).getEdad()+"  |  "+mascotas.get(i).getRaza()+"  |  "+mascotas.get(i).getFechaDeNacimiento()+"  |  ",100,100+(i*20));
		}
		
	}

	public void pintarBotones() {
		app.fill(0);
		app.rect(100,500,60,30);
		app.fill(255);
		app.text("Nombre",110,520);
		
		app.fill(0);
		app.rect(180,500,60,30);
		app.fill(255);
		app.text("Raza",190,520);
		
		app.fill(0);
		app.rect(260,500,60,30);
		app.fill(255);
		app.text("Edad",270,520);
		
		app.fill(0);
		app.rect(340,500,110,30);
		app.fill(255);
		app.text("Fecha de nacido",350,520);
		
		
		app.fill(0);
		app.rect(470,500,60,30);
		app.fill(255);
		app.text("ID",480,520);
		//System.out.println(app.mouseX+"//"+app.mouseY);
	
	}

	public void pintarInstrucciones() {

		app.fill(0);
		app.text("Presiona los botones para organizar la lista de acuerdo a cada atributo",100,20);
		app.text("ID  |  Nombre  |  Edad  |  Raza  |  Fecha De Nacimiento",100,80);

	}
	
	public void calcularEdad() {
		for (int i = 0; i < mascotas.size(); i++) {
			Mascota a = mascotas.get(i);
			String[] añoDeNacimiento = a.getFechaDeNacimiento().split("/");
			a.setEdad((Integer.parseInt(fechaActual))-(Integer.parseInt(añoDeNacimiento[2])));
		}
	}

}

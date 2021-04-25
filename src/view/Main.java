package view;

import controller.BaseDeDatosPeludos;
import processing.core.PApplet;

public class Main extends PApplet{

	
	private BaseDeDatosPeludos baseData; 
	public void settings() {
		size(600, 600);
	}
	
	public void setup() {
		baseData=new BaseDeDatosPeludos(this);
	}
	
	public void draw() {
		background(255);
		baseData.pintarBaseDeDatos();
		baseData.pintarInstrucciones();
		baseData.pintarBotones();
	}
	
	public void mousePressed() {
		baseData.ordenarPeludosNombre();
		baseData.ordenarPeludosFechaNacimiento();
		baseData.ordenarPeludosRaza();
		baseData.ordenarPeludosEdad();
		baseData.ordenarPeludosNaturalmente();
	}
	public static void main(String[] args) {
		PApplet.main("view.Main");
	}

}

package model;

import processing.core.PApplet;

public class Mascota implements Comparable<Mascota> {

	
	private PApplet app;
	private int id;
	private int edad;
	private String nombre;
	private String raza;
	private String fechaDeNacimiento;
	
	public Mascota(PApplet app, int id,String nombre) {
		this.app=app;
		this.id=id;
		this.nombre=nombre;
		this.edad=0;
		raza="";
		fechaDeNacimiento="";
	}
	
	@Override
	public int compareTo(Mascota o) {
		// TODO Auto-generated method stub
		return (int) (id-o.id);
	}
	
	public void pintarMascota() {
		
	}
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getRaza() {
		return raza;
	}



	public void setRaza(String raza) {
		this.raza = raza;
	}



	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}



	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}


	
	
	
}

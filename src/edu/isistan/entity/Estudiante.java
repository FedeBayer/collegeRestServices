package edu.isistan.entity;

import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long libreta_universitaria;
	@Column(nullable = false)
	private String nombre;
	@Column
	private String apellido;
	@Column
	private int edad;
	@Column
	private String genero;
	@Column
	private int documento;
	@Column
	private String ciudad;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "libreta_uni_estudiante")
	private List<Matricula> matriculas;

	public Estudiante() {
		super();
	}

	public Estudiante(String nombre, String apellido, int edad, String genero, int documento, String ciudad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.documento = documento;
		this.ciudad = ciudad;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public long getLibreta_universitaria() {
		return libreta_universitaria;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Estudiante [libreta_universitaria=" + libreta_universitaria + ", nombre=" + nombre + ", apellido="
				+ apellido + ", edad=" + edad + ", documento=" + documento + ", ciudad=" + ciudad + "]\n";
	}

}

package com.example.demo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_matricula;
    @ManyToOne
    @JoinColumn(name = "fk_estudiante")
    @JsonIgnoreProperties("matriculas")
    private Estudiante libreta_uni_estudiante;
    @ManyToOne
    @JoinColumn(name = "fk_carrera")
    @JsonIgnoreProperties("matriculas")
    private Carrera id_carrera;
    @Column
    private int antiguedad; // años
    @Column
    private boolean graduado;
    @Column
    private int anio_cursada;

    public Matricula() {
        super();
    }

    public Matricula(Estudiante libreta_uni_estudiante, Carrera id_carrera, int antiguedad, boolean graduado,
                     int anio_cursada) {
        super();
        this.libreta_uni_estudiante = libreta_uni_estudiante;
        this.id_carrera = id_carrera;
        this.antiguedad = antiguedad;
        this.graduado = graduado;
        this.anio_cursada = anio_cursada;
    }

    public Estudiante getLibreta_uni_estudiante() {
        return libreta_uni_estudiante;
    }

    public void setLibreta_uni_estudiante(Estudiante libreta_uni_estudiante) {
        this.libreta_uni_estudiante = libreta_uni_estudiante;
    }

    public Carrera getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(Carrera id_carrera) {
        this.id_carrera = id_carrera;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public boolean isGraduado() {
        return graduado;
    }

    public void setGraduado(boolean graduado) {
        this.graduado = graduado;
    }

    public int getAnio_cursada() {
        return anio_cursada;
    }

    public void setAnio_cursada(int anio_cursada) {
        this.anio_cursada = anio_cursada;
    }

    @Override
    public String toString() {

        return "Matricula [libreta_uni_estudiante=" + libreta_uni_estudiante.getLibreta_universitaria()
                + ", id_carrera=" + id_carrera.getId() + ", antiguedad=" + antiguedad + ", graduado=" + graduado
                + ", anio_cursada=" + anio_cursada + "]\n";
    }

}

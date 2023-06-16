package com.example.demo.model;

import java.math.BigInteger;

public class ReporteDTO {

    private String carrera;
    private int anio;
    private int inscriptos;
    private BigInteger egresados;

    public ReporteDTO() {
        super();
    }

    public ReporteDTO(String carrera, int anio, int inscriptos, BigInteger egresados) {
        this.carrera = carrera;
        this.anio = anio;
        this.inscriptos = inscriptos;
        this.egresados = egresados;
    }

    public String getCarrera() {
        return carrera;
    }

    public int getAnio() {
        return anio;
    }

    public int getInscriptos() {
        return inscriptos;
    }

    public BigInteger getEgresados() {
        return egresados;
    }

    @Override
    public String toString() {
        return "ReporteDTO [carrera=" + carrera + ", anio=" + anio + ", inscriptos=" + inscriptos + ", egresados="
                + egresados + "]";
    }
}

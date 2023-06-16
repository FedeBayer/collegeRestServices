package com.example.demo.service;

import com.example.demo.model.Carrera;
import com.example.demo.model.Estudiante;
import com.example.demo.model.ReporteDTO;

import java.util.List;
import java.util.Optional;

public interface CarreraService {
    List<Carrera> getAllCarreras();

    Carrera saveCarrera(Carrera c);

    Optional<Carrera> getCarreraById(long id);

    Carrera replaceCarrera(Carrera c, long id);

    void deleteCarreraById(long id);

	List<Carrera> getCarrerasConInscriptos();

	List<ReporteDTO> getReporteDeCarreras();
}

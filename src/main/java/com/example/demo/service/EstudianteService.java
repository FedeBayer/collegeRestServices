package com.example.demo.service;

import com.example.demo.model.Estudiante;

import java.util.List;
import java.util.Optional;

public interface EstudianteService {
    List<Estudiante> getAllEstudiantes();

    List<Estudiante> getEstudiantesOrderByApellido();

    Estudiante saveEstudiante(Estudiante e);

    Optional<Estudiante> getEstudianteById(long id);

    Estudiante replaceEstudiante(Estudiante e, long id);

    void deleteEstudianteById(long id);

	List<Estudiante> findAllByGenero(String genero);

	List<Estudiante> findAllByCarreraByCiudad(long idCarrera, String ciudad);
}

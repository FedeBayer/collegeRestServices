package com.example.demo.repository;

import com.example.demo.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    @Query("SELECT e FROM Estudiante e where e.nombre = :nombre")
    public List<Estudiante> findAllByName(String nombre);

    @Query("SELECT e FROM Estudiante e where e.genero = :genero")
    public List<Estudiante> findAllByGenero(String genero);

    @Query("SELECT e FROM Matricula m JOIN Estudiante e on (e = m.libreta_uni_estudiante) JOIN Carrera c on (m.id_carrera = c) WHERE c.id = :idCarrera AND e.ciudad = :ciudadOrigen")
    public List<Estudiante> findAllByCarreraByCiudad(long idCarrera, String ciudadOrigen);

    @Query("SELECT e FROM Estudiante e ORDER BY e.apellido")
    public List<Estudiante> findAllOrderByApellido();

}

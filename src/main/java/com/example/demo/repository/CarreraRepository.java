package com.example.demo.repository;

import com.example.demo.model.Carrera;
import com.example.demo.model.ReporteDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarreraRepository extends JpaRepository<Carrera, Long> {

    @Query("SELECT c FROM Carrera c where c.nombre = :name")
    public List<Carrera> findAllByName(String name);

    @Query("SELECT c FROM Carrera c where c.cant_estudiantes > 0 ORDER BY c.cant_estudiantes")
    public List<Carrera> findAllWithEstudiantes();

    @Query(value = "SELECT nombre, anio_cursada, cant_estudiantes as inscriptos, 0 as graduados FROM Carrera c INNER JOIN Matricula m ON (c.id = m.fk_carrera) GROUP BY c.id, anio_cursada HAVING anio_cursada != 0 UNION SELECT nombre, anio_cursada, 0 as inscriptos, count(graduado) as graduados FROM Carrera c INNER JOIN Matricula m ON (c.id = m.fk_carrera) GROUP BY c.id, graduado HAVING graduado != 0 ORDER BY nombre, anio_cursada ASC", nativeQuery = true)
    public List<Object[]> generarReporte();
}

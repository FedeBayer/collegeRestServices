package com.example.demo.utils;

import com.example.demo.model.Carrera;
import com.example.demo.model.Estudiante;
import com.example.demo.model.Matricula;
import com.example.demo.repository.CarreraRepository;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.MatriculaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;

@Configuration
@Slf4j
class LoadDatabase {

	/**
	 * Add estudiante postman (POST)
	 * http://localhost:8080/estudiantes
	{
	    "libreta_universitaria":"260851",
	    "nombre":"Roberto",
	    "apellido":"Zansa",
	    "edad":"20",
	    "genero":"Masculino",
	    "documento":"24800200",
	    "ciudad":"Tandil"
	}
	**/

	/**
	 * Add carrera (POST)
	 * http://localhost:8080/carreras
	{
	    "nombre":"TUDAI",
	    "duracion":"2"
	}
	**/

	/**
	{
    "libreta_uni_estudiante":{
        "libreta_universitaria":"260851",
	    "nombre":"Roberto",
	    "apellido":"Zansa",
	    "edad":"20",
	    "genero":"Masculino",
	    "documento":"24800200",
	    "ciudad":"Tandil"
    },
    "id_carrera":{
        "id": "1",
        "nombre":"TUDAI",
	    "duracion":"2",
        "cantEstudiantes": "0"
    },
    "antiguedad": "1",
    "graduado": "false",
    "anio_cursada": "2022"
}
**/

	/**
    @Bean
    CommandLineRunner initDatabase(@Qualifier("estudianteRepository") EstudianteRepository estudianteRepository, @Qualifier("carreraRepository") CarreraRepository carreraRepository, @Qualifier("matriculaRepository") MatriculaRepository matriculaRepository) {
        return args -> {
            Estudiante e1 = new Estudiante(260851, "Roberto", "Zansa", 20, "Masculino", 24800200, "Tandil");
            Estudiante e2 = new Estudiante(567892, "Maria", "Perez", 30, "Femenino", 25126780, "Mar del plata");
            Estudiante e3 = new Estudiante(127976, "Luis", "Luani", 22, "Masculino", 21098127, "Tandil");
            Estudiante e4 = new Estudiante(268908, "Juana", "Lorez", 28, "Femenino", 25780124, "Rauch");
            Estudiante e5 = new Estudiante(621671, "Raul", "Arren", 35, "Masculino", 22643098, "Mar del plata");

            // 2.a
            estudianteRepository.save(e1);
            estudianteRepository.save(e2);
            estudianteRepository.save(e3);
            estudianteRepository.save(e4);
            estudianteRepository.save(e5);

            // 2.c
            System.out.println("------------------------------------");
            System.out.println("Estudiantes ordenados por apellido");
            for (Estudiante e : estudianteRepository.findAllOrderByApellido()) {
                System.out.println(e);
            }

            // 2.e
            System.out.println("------------------------------------");
            System.out.println("Estudiantes por genero");
            String gender = "Femenino";
            for (Estudiante e : estudianteRepository.findAllByGenero(gender)) {
                System.out.println(e);
            }

            // 2.d (El id es la libreta universitaria)
            Estudiante e11 = estudianteRepository.getOne((long) 260851);
            Estudiante e22 = estudianteRepository.getOne((long) 567892);
            Estudiante e33 = estudianteRepository.getOne((long) 127976);
            Estudiante e44 = estudianteRepository.getOne((long) 268908);
            Estudiante e55 = estudianteRepository.getOne((long) 621671);


            Carrera c = new Carrera("Tudai", 2);
            Carrera c2 = new Carrera("Tupar", 3);

            carreraRepository.save(c);
            carreraRepository.save(c2);

            Carrera d = carreraRepository.getOne((long) 1);


            // 2.b

            // cController.addEstudiante(e11, d);
            addEstudiante(e11, d);

            addEstudiante(e22, d);

            Carrera d2 = carreraRepository.getOne((long) 2);
            //cController.addEstudiante(e33, d2);
            addEstudiante(e33, d2);
            addEstudiante(e44, d2);
            addEstudiante(e55, d2);

            System.out.println("------------------------------------");
            System.out.println("Carreras con inscriptos ordenados por inscriptos");
            // 2.f
            for (Carrera carr : carreraRepository.findAllWithEstudiantes()) {
                System.out.println(carr);
            }
            ;

            System.out.println("------------------------------------");
            System.out.println("Estudiantes de la carrera Tudai que viven en Tandil");

            // 2.g
            for (Estudiante est : estudianteRepository.findAllByCiudad(d.getId(), "Tandil")) {
                System.out.println(est);
            }

            // 3
            System.out.println("------------------------------------");
            System.out.println("Reportes de las carreras");
            /*
            for (ReporteDTO rp : carreraRepository.getReporteCarreras()) {
                System.out.println(rp);
            }*/

			/**
            estudianteRepository.save(e1);
            estudianteRepository.save(e2);
            estudianteRepository.save(e3);
            estudianteRepository.save(e4);
            estudianteRepository.save(e5);
            carreraRepository.save(c);
            carreraRepository.save(c2);
        };


    }

    public void addEstudiante(Estudiante e, Carrera c) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        Matricula m = new Matricula(e, c, 0, false, year);
        int cantEstudiantes = c.getCantEstudiantes();
        cantEstudiantes++;
        c.setCantEstudiantes(cantEstudiantes);
    }
    **/
}

# University REST Services

![GitHub top language](https://img.shields.io/github/languages/top/FedeBayer/collegeRestServices?style=for-the-badge)
![GitHub last commit](https://img.shields.io/github/last-commit/FedeBayer/collegeRestServices?style=for-the-badge)
![GitHub issues](https://img.shields.io/github/issues/FedeBayer/collegeRestServices?style=for-the-badge)
![GitHub pull requests](https://img.shields.io/github/issues-pr/FedeBayer/collegeRestServices?style=for-the-badge)


### Description

Diseño de un registro de estudiantes, con la siguiente información: nombres, apellido, edad, género, número de documento, ciudad de residencia, número de libreta universitaria, carrera(s) en la que está inscripto, antigüedad en cada una de esas carreras, y si se graduó o no.

<details close="true">
  <summary><b>:gear: &nbsp;Posibles consultas</b></summary>
  
  
<br/>  
  
- dar de alta un estudiante
- matricular un estudiante en una carrera
- recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
- recuperar un estudiante, en base a su número de libreta universitaria.
- recuperar todos los estudiantes, en base a su género.
- recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
- recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
- generar un reporte de las carreras, que para cada carrera incluya información de los inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar los años de manera cronológica.
  
</details>


## Postman

Para importar/ver el template ir al archivo `Consultas Postman.json` en main.


## Swagger Link
- http://localhost:8080/swagger-ui/#/

## Utilizacion Local
- Abrir XAMPP, crear db "integrador5", ejecutar projecto 

## Utilizacion con Heroku
- Usar `https://arquiapp.herokuapp.com` con los endpoints.
- Ejemplo: `https://arquiapp.herokuapp.com/estudiantes`
- Para lo que no sea GET usar Postman

## Integrantes:

Asencio Matias,
Bayerque Federico,
Caroseli Nahuel,
Manuel Hollman


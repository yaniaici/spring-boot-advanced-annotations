package com.example.cruddemo;

import com.example.cruddemo.dao.AppDAO;
import com.example.cruddemo.entity.Course;
import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;
import com.example.cruddemo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			//createInstructor(appDAO);

			//findInstructor(appDAO);

			//deleteInstructor(appDAO);

			//findInstructorDetail(appDAO);

			//deleteInstructorDetail(appDAO);

			//createInstructorwithCourses(appDAO);

			//findInstructorwithCourses(appDAO);

			//findCoursesForInstructor(appDAO);

			findInstructorWithCoursesJoinFetch(appDAO);
		};
	}
	private void deleteCourseAndReviews(AppDAO appDAO) {

		int theId = 10;

		System.out.println("Eliminando curso con ID: " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("¡Hecho!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		// obtener el curso y las opiniones
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

		// imprimir el curso
		System.out.println(tempCourse);

		// imprimir las opiniones
		System.out.println(tempCourse.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDAO) {

		// crear un curso
		Course tempCourse = new Course("Pacman - Cómo obtener un millón de puntos");

		// añadir algunas opiniones
		tempCourse.addReview(new Review("Gran curso... ¡me encantó!"));
		tempCourse.addReview(new Review("Buen curso, buen trabajo."));
		tempCourse.addReview(new Review("¡Qué curso tan malo, eres un idiota!"));

		// guardar el curso... y aprovechar el cascade all
		System.out.println("Guardando el curso");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);

		System.out.println("¡Hecho!");
	}

	private void deleteCourse(AppDAO appDAO) {

		int theId = 10;

		System.out.println("Eliminando curso con ID: " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("¡Hecho!");
	}

	private void updateCourse(AppDAO appDAO) {

		int theId = 10;

		// encontrar el curso
		System.out.println("Buscando curso con ID: " + theId);
		Course tempCourse = appDAO.findCourseById(theId);

		// actualizar el curso
		System.out.println("Actualizando curso con ID: " + theId);
		tempCourse.setTitle("Disfruta de las cosas simples");

		appDAO.update(tempCourse);

		System.out.println("¡Hecho!");
	}

	private void updateInstructor(AppDAO appDAO) {

		int theId = 1;

		// encontrar el instructor
		System.out.println("Buscando instructor con ID: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		// actualizar el instructor
		System.out.println("Actualizando instructor con ID: " + theId);
		tempInstructor.setLast_name("TESTER");

		appDAO.update(tempInstructor);

		System.out.println("¡Hecho!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int theId = 1;

		// encontrar el instructor
		System.out.println("Buscando instructor con ID: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("los cursos asociados: " + tempInstructor.getCourses());

		System.out.println("¡Hecho!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int theId = 1;
		// encontrar el instructor
		System.out.println("Buscando instructor con ID: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);

		// encontrar cursos para el instructor
		System.out.println("Buscando cursos para el instructor con ID: " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		// asociar los objetos
		tempInstructor.setCourses(courses);

		System.out.println("los cursos asociados: " + tempInstructor.getCourses());

		System.out.println("¡Hecho!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Buscando instructor con ID: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("los cursos asociados: " + tempInstructor.getCourses());

		System.out.println("¡Hecho!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		// crear el instructor
		Instructor tempInstructor =
				new Instructor("Susan", "Public", "susan.public@hotmail.com");

		// crear el detalle del instructor
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.youtube.com",
						"Videojuegos");

		// asociar los objetos
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// crear algunos cursos
		Course tempCourse1 = new Course("Guitarra de aire - La guía definitiva");
		Course tempCourse2 = new Course("El máster de Pinball");

		// añadir cursos al instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// guardar el instructor
		//
		// NOTA: esto TAMBIÉN guardará los objetos de detalle
		// debido a CascadeType.PERSIST
		//
		System.out.println("Guardando instructor: " + tempInstructor);
		System.out.println("Los cursos: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("¡Hecho!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId = 3;
		System.out.println("Eliminando detalle de instructor con ID: " + theId);

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("¡Hecho!");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		// obtener el objeto de detalle de instructor
		int theId = 2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		// imprimir el detalle del instructor
		System.out.println("tempInstructorDetail: " + tempInstructorDetail);

		// imprimir el instructor asociado
		System.out.println("el instructor asociado: " + tempInstructorDetail.getInstructor());

		System.out.println("¡Hecho!");
	}

	private void deleteInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Eliminando instructor con ID: " + theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("¡Hecho!");
	}

	private void findInstructor(AppDAO appDAO) {

		int theId = 2;
		System.out.println("Buscando instructor con ID: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("solo el detalle de instructor asociado: " + tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {

		/*
		// crear el instructor
		Instructor tempInstructor =
				new Instructor("Chad", "Darby", "darby@luv2code.com");

		// crear el detalle del instructor
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.luv2code.com/youtube",
						"¡Amo el código! !!!");
		*/

		// crear el instructor
		Instructor tempInstructor =
				new Instructor("Madhu", "Patel", "madhu@luv2code.com");

		// crear el detalle del instructor
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.elgrande.com/youtube",
						"Guitarra");

		// asociar los objetos
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// guardar el instructor
		//
		// NOTA: esto TAMBIÉN guardará los objetos de detalle
		// debido a CascadeType.ALL
		//
		System.out.println("Guardando instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("¡Hecho!");
	}
}

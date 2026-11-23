package com.proyecto01.deft;

import com.proyecto01.deft.modelo.Estudiante;
import com.proyecto01.deft.dao.DAO;
import com.proyecto01.deft.dao.EstudianteDAOMySQL;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeftApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DeftApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // AQUÍ ESTÁ EL CAMBIO: Usamos EstudianteDAOMySQL() en lugar de EstudianteDAOArchivo()
        DAO<Estudiante> estudianteDAO = new EstudianteDAOMySQL();

        Estudiante nuevoEstudiante = new Estudiante(2324467, "Luis David");
        estudianteDAO.guardar(nuevoEstudiante);

        System.out.println("=== Estudiantes en la Base de Datos ===");
        for (Estudiante e : estudianteDAO.obtenerTodos()) {
            System.out.println("ID: " + e.getId() + " | Nombre: " + e.getNombre());
        }
    }
}
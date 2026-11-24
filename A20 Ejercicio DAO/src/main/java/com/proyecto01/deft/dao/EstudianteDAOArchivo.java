package com.proyecto01.deft.dao;

import com.proyecto01.deft.modelo.Estudiante;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAOArchivo implements DAO<Estudiante> {
    private final String archivoRuta = "universidad_db.dat";

    @Override
    public void guardar(Estudiante est) {
        List<Estudiante> lista = obtenerTodos();
        lista.add(est);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoRuta))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            System.err.println("Error al guardar estudiante en archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Estudiante> obtenerTodos() {
        File f = new File(archivoRuta);
        if (!f.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            return (List<Estudiante>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer archivo de estudiantes: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
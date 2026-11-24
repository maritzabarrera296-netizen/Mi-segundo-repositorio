package com.proyecto01.deft.dao;

import com.proyecto01.deft.modelo.Estudiante;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAOMySQL implements DAO<Estudiante> {
    private static final String URL = "jdbc:mysql://localhost:3306/universidad_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASS = "nava20";

    @Override
    public void guardar(Estudiante est) {
        String sql = "INSERT INTO estudiantes (id, nombre) VALUES (?, ?)";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstat = con.prepareStatement(sql)) {
            pstat.setInt(1, est.getId());
            pstat.setString(2, est.getNombre());
            pstat.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al guardar estudiante en MySQL: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<Estudiante> obtenerTodos() {
        List<Estudiante> lista = new ArrayList<>();
        String sql = "SELECT id, nombre FROM estudiantes";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstat = con.prepareStatement(sql);
             ResultSet rs = pstat.executeQuery()) {
            while (rs.next()) {
                lista.add(new Estudiante(rs.getInt("id"), rs.getString("nombre")));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener estudiantes de MySQL: " + e.getMessage());
            e.printStackTrace();
        }
        return lista;
    }
}
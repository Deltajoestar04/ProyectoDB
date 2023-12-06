/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.proyectodb.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mx.itson.proyectodb.ConexionDB;
import mx.itson.proyectodb.entidades.Pelicula;

/**
 *
 * @author Admin
 */
/**
 * La clase PeliculaModel proporciona métodos para realizar operaciones CRUD en la tabla "NoSe_peliculas" de la base de datos.
 */
public class PeliculaModel {
    ConexionDB db = new ConexionDB(); // Instancia de la clase de conexión a la base de datos.

    /**
     * Inserta una nueva película en la base de datos.
     * @param p Objeto Pelicula que representa la información de la película a ser insertada.
     */
    public void insert(Pelicula p) {
        String query = "INSERT INTO NoSe_peliculas (titulo, genero, duracion, sinopsis) ";
        query += "VALUES ('" + p.getTitulo() + "', '" + p.getGenero() + "', " + p.getDuracion() + ", '" + p.getSinopsis() + "')";
        db.insert(query);
    }

    /**
     * Actualiza la información de una película en la base de datos.
     */
    public void update() {
        // Implementa la lógica de actualización si es necesario.
    }

    /**
     * Recupera una lista de todas las películas almacenadas en la base de datos.
     * @return Una lista de objetos Pelicula que representan todas las películas almacenadas.
     */
    public ArrayList<Pelicula> select() {
        ArrayList<Pelicula> lista = new ArrayList<>();

        String query = "SELECT * FROM NoSe_peliculas;";
        ResultSet rs = db.select(query);

        try {
            // Recorre el conjunto de resultados y crea objetos Pelicula.
            while (rs.next()) {
                lista.add(new Pelicula(
                        rs.getInt(1),
                        rs.getString("titulo"),
                        rs.getString("genero"),
                        rs.getInt("duracion"),
                        rs.getString("sinopsis")
                ));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hay un error con la base de datos!");
        }
        return lista;
    }

    /**
     * Elimina una película de la base de datos según el ID proporcionado.
     * @param id El ID de la película a ser eliminada.
     */
    public void delete(int id) {
        String query = "DELETE FROM NoSe_peliculas WHERE id =" + id;
        db.insert(query);
    }

    /**
     * Realiza operaciones de inicio de sesión si es necesario.
     */
    public void login() {
        // Implementa la lógica de inicio de sesión si es necesario.
    }
}

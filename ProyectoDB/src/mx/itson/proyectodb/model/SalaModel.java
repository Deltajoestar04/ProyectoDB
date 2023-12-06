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
import mx.itson.proyectodb.entidades.Sala;

/**
 *
 * @author Admin
 */
/**
 * La clase SalaModel proporciona métodos para realizar operaciones CRUD en la tabla "NoSe_salas" de la base de datos.
 */
public class SalaModel {
    ConexionDB db = new ConexionDB(); // Instancia de la clase de conexión a la base de datos.

    /**
     * Inserta una nueva sala en la base de datos.
     * @param s Objeto Sala que representa la información de la sala a ser insertada.
     */
    public void insert(Sala s) {
        String query = "INSERT INTO NoSe_salas (tipo, capacidad) ";
        query += "VALUES ('" + s.getTipo() + "', " + s.getCapacidad() + ")";
        db.insert(query);
    }

    /**
     * Actualiza la información de una sala en la base de datos.
     */
    public void update() {
        // Implementa la lógica de actualización si es necesario.
    }

    /**
     * Recupera una lista de todas las salas almacenadas en la base de datos.
     * @return Una lista de objetos Sala que representan todas las salas almacenadas.
     */
    public ArrayList<Sala> select() {
        ArrayList<Sala> lista = new ArrayList<>();

        String query = "SELECT * FROM NoSe_salas;";
        ResultSet rs = db.select(query);

        try {
            // Recorre el conjunto de resultados y crea objetos Sala.
            while (rs.next()) {
                lista.add(new Sala(
                        rs.getInt(1),
                        rs.getString("tipo"),
                        rs.getInt("capacidad")
                ));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hay un error con la base de datos!");
        }
        return lista;
    }

    /**
     * Elimina una sala de la base de datos según el ID proporcionado.
     * @param id El ID de la sala a ser eliminada.
     */
    public void delete(int id) {
        String query = "DELETE FROM NoSe_salas WHERE id =" + id;
        db.insert(query);
    }

    /**
     * Realiza operaciones de inicio de sesión si es necesario.
     */
    public void login() {
        // Implementa la lógica de inicio de sesión si es necesario.
    }
}

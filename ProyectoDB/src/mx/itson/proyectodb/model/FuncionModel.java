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
import mx.itson.proyectodb.entidades.Funcion;

/**
 *
 * @author Admin
 */
/**
 * La clase FuncionModel proporciona métodos para realizar operaciones CRUD (Crear, Leer) en la tabla de funciones de la base de datos.
 */
public class FuncionModel {

    ConexionDB db = new ConexionDB(); // Instancia de la clase de conexión a la base de datos.

    /**
     * Inserta una nueva función en la base de datos.
     * @param f Objeto Funcion que representa la información de la función a insertar.
     */
    public void insert(Funcion f) {
        // Construir la consulta SQL de inserción.
        String query = "INSERT INTO NoSe_funciones (pelicula_id, sala_id, empleado_id, horario_id, cliente_id) ";
        query += "values ('" + f.getPelicula_id() + "', '" + f.getSala_id() + "', '" + f.getEmpleado_id() + "', '" + f.getHorario_id() + "', '" + f.getCliente_id() + "')";

        // Ejecutar la consulta de inserción.
        db.insert(query);
    }

    /**
     * Recupera todas las funciones de la base de datos.
     * @return Una lista de objetos Funcion que representan todas las funciones en la base de datos.
     */
    public ArrayList<Funcion> select() {
        ArrayList<Funcion> lista = new ArrayList<>();

        // Construir la consulta SQL de selección.
        String query = "SELECT * FROM NoSe_funciones;";
        ResultSet rs = db.select(query);

        try {
            // Recorrer el conjunto de resultados y construir objetos Funcion.
            while (rs.next()) {
                lista.add(new Funcion(
                        rs.getInt("id"),
                        rs.getInt("pelicula_id"),
                        rs.getInt("sala_id"),
                        rs.getInt("empleado_id"),
                        rs.getInt("horario_id")
                ));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hay un error con la base de datos!");
        }
        return lista;
    }

    /**
     * Recupera funciones por fecha específica.
     * @param si La fecha específica para la búsqueda.
     * @return Una lista de objetos Funcion que representan funciones asociadas a la fecha especificada.
     */
    public ArrayList<Funcion> findByDate(String si) {
        ArrayList<Funcion> lista = new ArrayList<>();

        // Construir la consulta SQL de selección con detalles adicionales.
        String query = """
                       SELECT *,
                       (SELECT nombre FROM NoSe_peliculas WHERE id = funcion.pelicula_id) AS pelicula,
                           (SELECT sala_id FROM NoSe_salas WHERE id = funcion.sala_id) AS numero_de_sala,
                           (SELECT nombre FROM NoSe_empleados WHERE id = funcion.empleado_id) AS Empleado
                       FROM NoSe_funciones
                       WHERE numero = '""" + si + "'";
        ResultSet rs = null;

        try {
            // Recorrer el conjunto de resultados y construir objetos Funcion con detalles adicionales.
            rs = db.select(query);

            while (rs.next()) {
                lista.add(new Funcion(
                        rs.getInt("id"),
                        rs.getInt("pelicula_id"),
                        rs.getInt("sala_id"),
                        rs.getInt("empleado_id"),
                        rs.getInt("horario_id")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Hay un error con la base de datos!");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }
}

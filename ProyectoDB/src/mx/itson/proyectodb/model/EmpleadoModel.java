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
import mx.itson.proyectodb.entidades.Empleado;

/**
 *
 * @author Admin
 */
/**
 * La clase EmpleadoModel proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la tabla de empleados de la base de datos.
 */
public class EmpleadoModel {

    ConexionDB db = new ConexionDB(); // Instancia de la clase de conexión a la base de datos.

    /**
     * Inserta un nuevo empleado en la base de datos.
     * @param e Objeto Empleado que representa la información del empleado a insertar.
     */
    public void insert(Empleado e) {
        // Construir la consulta SQL de inserción.
        String query = "INSERT INTO NoSe_empleados (nombre, apellido, cargo, salario) ";
        query += "values ('" + e.getNombre() + "', '" + e.getApellido() + "', '" + e.getCargo() + "', '" + e.getSalario() + "')";

        // Ejecutar la consulta de inserción.
        db.insert(query);
    }

    /**
     * Actualiza la información de un empleado en la base de datos.
     * (Este método debe implementarse según los requisitos específicos del sistema).
     */
    public void update() {
        // Implementar lógica de actualización si es necesario.
    }

    /**
     * Recupera todos los empleados de la base de datos.
     * @return Una lista de objetos Empleado que representan todos los empleados en la base de datos.
     */
    public ArrayList<Empleado> select() {
        ArrayList<Empleado> lista = new ArrayList<>();

        // Construir la consulta SQL de selección.
        String query = "SELECT * FROM NoSe_empleados;";
        ResultSet rs = db.select(query);

        try {
            // Recorrer el conjunto de resultados y construir objetos Empleado.
            while (rs.next()) {
                lista.add(new Empleado(
                        rs.getInt("ID"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("cargo"),
                        rs.getDouble("salario")
                ));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hay un error con la base de datos!");
        }
        return lista;
    }

    /**
     * Elimina un empleado de la base de datos según su ID.
     * @param id ID del empleado a eliminar.
     */
    public void delete(int id) {
        // Construir la consulta SQL de eliminación.
        String query = "DELETE FROM NoSe_empleados WHERE id =" + id;

        // Ejecutar la consulta de eliminación.
        db.insert(query);
    }

    /**
     * Realiza la lógica de inicio de sesión para empleados.
     * (Este método debe implementarse según los requisitos específicos del sistema).
     */
    public void login() {
        // Implementar lógica de inicio de sesión si es necesario.
    }
}

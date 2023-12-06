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
import mx.itson.proyectodb.entidades.Cliente;

/**
 *
 * @author Admin
 */
/**
 * La clase ClienteModel proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la tabla de clientes de la base de datos.
 */
public class ClienteModel {

    ConexionDB db = new ConexionDB(); // Instancia de la clase de conexión a la base de datos.

    /**
     * Inserta un nuevo cliente en la base de datos.
     * @param c Objeto Cliente que representa la información del cliente a insertar.
     */
    public void insert(Cliente c) {
        // Construir la consulta SQL de inserción.
        String query = "INSERT INTO NoSe_clientes (nombre, apellido, email) ";
        query += "values ('" + c.getNombre() + "', '" + c.getApellido() + "','" + c.getEmail() + "')";

        // Ejecutar la consulta de inserción.
        db.insert(query);
    }

    /**
     * Actualiza la información de un cliente en la base de datos.
     */
    public void update() {
        // Implementar lógica de actualización si es necesario.
    }

    /**
     * Recupera todos los clientes de la base de datos.
     * @return Una lista de objetos Cliente que representan todos los clientes en la base de datos.
     */
    public ArrayList<Cliente> select() {
        ArrayList<Cliente> lista = new ArrayList<>();

        // Construir la consulta SQL de selección.
        String query = "SELECT * FROM NoSe_clientes;";
        ResultSet rs = db.select(query);

        try {
            // Recorrer el conjunto de resultados y construir objetos Cliente.
            while (rs.next()) {
                lista.add(new Cliente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("Email")
                ));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hay un error con la base de datos!");
        }
        return lista;
    }

    /**
     * Elimina un cliente de la base de datos según su ID.
     * @param id ID del cliente a eliminar.
     */
    public void delete(int id) {
        // Construir la consulta SQL de eliminación.
        String query = "DELETE FROM NoSe_clientes WHERE id =" + id;

        // Ejecutar la consulta de eliminación.
        db.insert(query);
    }

    /**
     * Realiza la lógica de inicio de sesión para clientes.
     * (Este método debe implementarse según los requisitos específicos del sistema).
     */
    public void login() {
        // Implementar lógica de inicio de sesión si es necesario.
    }
}

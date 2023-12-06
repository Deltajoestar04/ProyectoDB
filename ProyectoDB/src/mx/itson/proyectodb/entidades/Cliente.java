/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.proyectodb.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itson.proyectodb.MySQLConnection;

/**
 *
 * @author Admin
 */
public class Cliente {
  /**
 * La clase Cliente representa a un cliente con información como ID, nombre, apellido y correo electrónico.
 */

    private int id_cliente;  // ID único del cliente.
    private String nombre;   // Nombre del cliente.
    private String apellido; // Apellido del cliente.
    private String email;    // Correo electrónico del cliente.
public static List<Cliente> getAll(String filtro){
// Crear una lista para almacenar las instancias de la clase Cliente que coinciden con el filtro de búsqueda
List<Cliente> clientes = new ArrayList<>();

try {
    // Obtener la conexión a la base de datos MySQL
    Connection conexion = MySQLConnection.get();

    // Preparar la consulta SQL con un filtro de búsqueda en el campo 'name'
    PreparedStatement statement = conexion.prepareStatement("SELECT * FROM NoSe_clientes WHERE name LIKE ?");
    
    // Establecer el parámetro del filtro en la consulta SQL
    statement.setString(1, "%" + filtro + "%");

    // Ejecutar la consulta y obtener el conjunto de resultados
    ResultSet resultSet = statement.executeQuery();

    // Iterar sobre los resultados de la consulta
    while (resultSet.next()) {
        // Crear una instancia de la clase Cliente para cada fila de resultados
        Cliente cliente = new Cliente();

        // Establecer los atributos del Cliente con los valores de la fila actual
        cliente.setId_cliente(resultSet.getInt(1));
        cliente.setNombre(resultSet.getString(2));
        cliente.setApellido(resultSet.getString(3));
        cliente.setEmail(resultSet.getString(4));

        // Agregar la instancia de Cliente a la lista de clientes
        clientes.add(cliente);
    }
} catch (SQLException ex) {
    // Manejar cualquier excepción de SQL, por ejemplo, imprimir un mensaje de error
    ex.printStackTrace();  // Considera manejar las excepciones de una manera más robusta en una aplicación real
}

// Devolver la lista de clientes que coinciden con el filtro de búsqueda
return clientes;


    }
    /**
     * Constructor de la clase Cliente que inicializa sus atributos con los valores proporcionados.
     * @param id_cliente ID único del cliente.
     * @param nombre Nombre del cliente.
     * @param apellido Apellido del cliente.
     * @param email Correo electrónico del cliente.
     */
    public Cliente(int id_cliente, String nombre, String apellido, String email) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    /**
     * Constructor vacío de la clase Cliente.
     * Se utiliza para crear instancias de Cliente sin proporcionar valores iniciales.
     */
    public Cliente() {
    }

    /**
     * Obtiene el ID del cliente.
     * @return ID del cliente.
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * Establece el ID del cliente.
     * @param id_cliente Nuevo ID del cliente.
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * Obtiene el nombre del cliente.
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     * @param nombre Nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del cliente.
     * @return Apellido del cliente.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del cliente.
     * @param apellido Nuevo apellido del cliente.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el correo electrónico del cliente.
     * @return Correo electrónico del cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del cliente.
     * @param email Nuevo correo electrónico del cliente.
     */
    public void setEmail(String email) {
        this.email = email;
    }}
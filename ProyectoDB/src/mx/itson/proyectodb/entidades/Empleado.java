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
/**
 * La clase Empleado representa a un empleado con información como ID, nombre, apellido, cargo y salario.
 */
public class Empleado {

    private int empleado_id;    // ID único del empleado.
    private String nombre;      // Nombre del empleado.
    private String apellido;    // Apellido del empleado.
    private String cargo;       // Cargo del empleado.
    private double salario;     // Salario del empleado.
public static List<Empleado> getAll(String filtro){
// Crear una lista para almacenar las instancias de la clase Empleado que coinciden con el filtro de búsqueda
List<Empleado> empleados = new ArrayList<>();

try {
    // Obtener la conexión a la base de datos MySQL
    Connection conexion = MySQLConnection.get();

    // Preparar la consulta SQL con un filtro de búsqueda en el campo 'name'
    PreparedStatement statement = conexion.prepareStatement("SELECT * FROM officer WHERE name LIKE ?");
    
    // Establecer el parámetro del filtro en la consulta SQL
    statement.setString(1, "%" + filtro + "%");

    // Ejecutar la consulta y obtener el conjunto de resultados
    ResultSet resultSet = statement.executeQuery();

    // Iterar sobre los resultados de la consulta
    while (resultSet.next()) {
        // Crear una instancia de la clase Empleado para cada fila de resultados
        Empleado empleado = new Empleado();

        // Establecer los atributos del Empleado con los valores de la fila actual
        empleado.setEmpleado_id(resultSet.getInt(1));
        empleado.setNombre(resultSet.getString(2));
        empleado.setApellido(resultSet.getString(3));
        empleado.setCargo(resultSet.getString(4));
        empleado.setSalario(resultSet.getInt(5));

        // Agregar la instancia de Empleado a la lista de empleados
        empleados.add(empleado);
    }
} catch (SQLException ex) {
    // Manejar cualquier excepción de SQL, por ejemplo, imprimir un mensaje de error
    ex.printStackTrace();  // Considera manejar las excepciones de una manera más robusta en una aplicación real
}

// Devolver la lista de empleados que coinciden con el filtro de búsqueda
return empleados;


    }
    /**
     * Constructor de la clase Empleado que inicializa sus atributos con los valores proporcionados.
     * @param empleado_id ID único del empleado.
     * @param nombre Nombre del empleado.
     * @param apellido Apellido del empleado.
     * @param cargo Cargo del empleado.
     * @param salario Salario del empleado.
     */
    public Empleado(int empleado_id, String nombre, String apellido, String cargo, double salario) {
        this.empleado_id = empleado_id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.salario = salario;
    }

    /**
     * Constructor vacío de la clase Empleado.
     * Se utiliza para crear instancias de Empleado sin proporcionar valores iniciales.
     */
    public Empleado() {
    }

    /**
     * Obtiene el ID del empleado.
     * @return ID del empleado.
     */
    public int getEmpleado_id() {
        return empleado_id;
    }

    /**
     * Establece el ID del empleado.
     * @param empleado_id Nuevo ID del empleado.
     */
    public void setEmpleado_id(int empleado_id) {
        this.empleado_id = empleado_id;
    }

    /**
     * Obtiene el nombre del empleado.
     * @return Nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     * @param nombre Nuevo nombre del empleado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del empleado.
     * @return Apellido del empleado.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del empleado.
     * @param apellido Nuevo apellido del empleado.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el cargo del empleado.
     * @return Cargo del empleado.
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Establece el cargo del empleado.
     * @param cargo Nuevo cargo del empleado.
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * Obtiene el salario del empleado.
     * @return Salario del empleado.
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Establece el salario del empleado.
     * @param salario Nuevo salario del empleado.
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }
}

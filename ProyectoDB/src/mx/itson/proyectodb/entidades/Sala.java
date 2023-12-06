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
 * La clase Sala representa una sala de proyección en un cine, con información sobre su ID, tipo y capacidad.
 */
public class Sala {

    private int sala_id;    // ID único de la sala.
    private String tipo;    // Tipo de sala (por ejemplo, 2D, 3D).
    private int capacidad;   // Capacidad máxima de espectadores en la sala.
public static List<Sala> getAll(String filtro){
// Crear una lista para almacenar las instancias de la clase Sala que coinciden con la búsqueda
List<Sala> salas = new ArrayList<>();

try {
    // Obtener la conexión a la base de datos MySQL
    Connection conexion = MySQLConnection.get();

    // Preparar la consulta SQL con un filtro de búsqueda en el campo 'name'
    PreparedStatement statement = conexion.prepareStatement("SELECT * FROM NoSe_salas WHERE name LIKE ?");
    
    // Establecer el parámetro del filtro en la consulta SQL
    statement.setString(1, "%" + filtro + "%");

    // Ejecutar la consulta y obtener el conjunto de resultados
    ResultSet resultSet = statement.executeQuery();

    // Iterar sobre los resultados de la consulta
    while (resultSet.next()) {
        // Crear una instancia de la clase Sala para cada fila de resultados
        Sala sala = new Sala();

        // Establecer los atributos de la Sala con los valores de la fila actual
        sala.sala_id(resultSet.getInt(1));
        sala.setTipo(resultSet.getString(2));
        sala.setCapacidad(resultSet.getInt(3));

        // Agregar la instancia de Sala a la lista de salas
        salas.add(sala);
    }
} catch (SQLException ex) {
    // Manejar cualquier excepción de SQL, por ejemplo, imprimir un mensaje de error
    ex.printStackTrace();  // Considera manejar las excepciones de una manera más robusta en una aplicación real
}

// Devolver la lista de salas que coinciden con el filtro de búsqueda
return salas;


    }
    /**
     * Constructor de la clase Sala que inicializa sus atributos con los valores proporcionados.
     * @param sala_id ID único de la sala.
     * @param tipo Tipo de sala (por ejemplo, 2D, 3D).
     * @param capacidad Capacidad máxima de espectadores en la sala.
     */
    public Sala(int sala_id, String tipo, int capacidad) {
        this.sala_id = sala_id;
        this.tipo = tipo;
        this.capacidad = capacidad;
    }

    /**
     * Constructor vacío de la clase Sala.
     * Se utiliza para crear instancias de Sala sin proporcionar valores iniciales.
     */
    public Sala() {
    }

    // Métodos de acceso y modificación para cada atributo.

    public int getSala_id() {
        return sala_id;
    }

    public void setSala_id(int sala_id) {
        this.sala_id = sala_id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    private void sala_id(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

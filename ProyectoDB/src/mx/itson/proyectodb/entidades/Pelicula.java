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
 * La clase Pelicula representa una película que puede ser proyectada en un cine, con información sobre su título, género, duración y sinopsis.
 */
public class Pelicula {

    private int pelicula_id; // ID único de la película.
    private String titulo;   // Título de la película.
    private String genero;   // Género al que pertenece la película.
    private int duracion;    // Duración en minutos de la película.
    private String sinopsis; // Sinopsis o descripción breve de la película.
public static List<Pelicula> getAll(String filtro){
// Crear una lista para almacenar las instancias de la clase Pelicula que coinciden con el filtro de búsqueda
List<Pelicula> peliculas = new ArrayList<>();

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
        // Crear una instancia de la clase Pelicula para cada fila de resultados
        Pelicula pelicula = new Pelicula();

        // Establecer los atributos de la Pelicula con los valores de la fila actual
        pelicula.setPelicula_id(resultSet.getInt(1));
        pelicula.setTitulo(resultSet.getString(2));
        pelicula.setDuracion(resultSet.getInt(3));
        pelicula.setGenero(resultSet.getString(4));
        pelicula.setSinopsis(resultSet.getString(5));

        // Agregar la instancia de Pelicula a la lista de peliculas
        peliculas.add(pelicula);
    }
} catch (SQLException ex) {
    // Manejar cualquier excepción de SQL, por ejemplo, imprimir un mensaje de error
    ex.printStackTrace();  // Considera manejar las excepciones de una manera más robusta en una aplicación real
}

// Devolver la lista de peliculas que coinciden con el filtro de búsqueda
return peliculas;
}
    /**
     * Constructor de la clase Pelicula que inicializa sus atributos con los valores proporcionados.
     * @param pelicula_id ID único de la película.
     * @param titulo Título de la película.
     * @param genero Género al que pertenece la película.
     * @param duracion Duración en minutos de la película.
     * @param sinopsis Sinopsis o descripción breve de la película.
     */
    public Pelicula(int pelicula_id, String titulo, String genero, int duracion, String sinopsis) {
        this.pelicula_id = pelicula_id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
    }

    /**
     * Constructor vacío de la clase Pelicula.
     * Se utiliza para crear instancias de Pelicula sin proporcionar valores iniciales.
     */
    public Pelicula() {
    }

    // Métodos de acceso y modificación para cada atributo.

    public int getPelicula_id() {
        return pelicula_id;
    }

    public void setPelicula_id(int pelicula_id) {
        this.pelicula_id = pelicula_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}

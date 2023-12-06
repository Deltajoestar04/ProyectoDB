/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.proyectodb.entidades;

/**
 *
 * @author Admin
 */
/**
 * La clase Funcion representa una función o proyección en un cine, con información sobre la sala, película, empleado, cliente y horario.
 */
/**
 * La clase Horario representa un intervalo de tiempo durante el cual se programa una función en un cine.
 * Contiene información sobre la hora de inicio, hora de fin, sala y película asociadas al horario.
 */
public class Horario {

    private int id;             // ID único del horario.
    private String hora_inicio; // Hora de inicio del horario.
    private String hora_fin;    // Hora de fin del horario.
    private Sala sala;          // Sala asociada al horario.
    private Pelicula pelicula;  // Película asociada al horario.

    /**
     * Constructor de la clase Horario que inicializa sus atributos con los valores proporcionados.
     * @param id ID único del horario.
     * @param hora_inicio Hora de inicio del horario.
     * @param hora_fin Hora de fin del horario.
     */
    public Horario(int id, String hora_inicio, String hora_fin) {
        this.id = id;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
    }

    /**
     * Constructor vacío de la clase Horario.
     * Se utiliza para crear instancias de Horario sin proporcionar valores iniciales.
     */
    public Horario() {
    }

    // Métodos de acceso y modificación para cada atributo.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
}

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
public class Funcion {

    private int id;           // ID único de la función.
    private int sala_id;      // ID de la sala en la que se proyecta la función.
    private int pelicula_id;  // ID de la película proyectada en la función.
    private int empleado_id;  // ID del empleado encargado de la función.
    private int cliente_id;   // ID del cliente asociado a la función (puede estar nulo si no se ha asignado).
    private int horario_id;   // ID del horario en el que se programa la función.

    /**
     * Constructor de la clase Funcion que inicializa sus atributos con los valores proporcionados.
     * @param id ID único de la función.
     * @param pelicula_id ID de la película proyectada en la función.
     * @param sala_id ID de la sala en la que se proyecta la función.
     * @param empleado_id ID del empleado encargado de la función.
     * @param horario_id ID del horario en el que se programa la función.
     */
    public Funcion(int id, int pelicula_id, int sala_id, int empleado_id, int horario_id) {
        this.id = id;
        this.pelicula_id = pelicula_id;
        this.sala_id = sala_id;
        this.empleado_id = empleado_id;
        this.horario_id = horario_id;
    }

    /**
     * Constructor vacío de la clase Funcion.
     * Se utiliza para crear instancias de Funcion sin proporcionar valores iniciales.
     */
    public Funcion() {
    }

    // Métodos de acceso y modificación para cada atributo.

    public int getSala_id() {
        return sala_id;
    }

    public void setSala_id(int sala_id) {
        this.sala_id = sala_id;
    }

    public int getPelicula_id() {
        return pelicula_id;
    }

    public void setPelicula_id(int pelicula_id) {
        this.pelicula_id = pelicula_id;
    }

    public int getEmpleado_id() {
        return empleado_id;
    }

    public void setEmpleado_id(int empleado_id) {
        this.empleado_id = empleado_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getHorario_id() {
        return horario_id;
    }

    public void setHorario_id(int horario_id) {
        this.horario_id = horario_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

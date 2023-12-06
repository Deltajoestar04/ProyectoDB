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
import mx.itson.proyectodb.entidades.Horario;

/**
 *
 * @author Admin
 */
/**
 * La clase HorarioModel proporciona métodos para recuperar información relacionada con horarios desde la base de datos.
 */
public class HorarioModel {

    ConexionDB db = new ConexionDB(); // Instancia de la clase de conexión a la base de datos.

    /**
     * Recupera una lista de objetos Horario basados en la fecha proporcionada.
     * @param fecha La fecha específica para la búsqueda de horarios.
     * @return Una lista de objetos Horario que representan los horarios asociados a la fecha especificada.
     */
    public ArrayList<Horario> findByDate(String fecha) {
        ArrayList<Horario> lista = new ArrayList<Horario>();

        // Construir la consulta SQL de selección con detalles adicionales.
        String query = """
                       SELECT *,
                           (SELECT sala_id FROM sala WHERE id = horario.sala_id) AS numero_de_sala
                       FROM horarios
                       WHERE fecha = '""" + fecha + "'";
        ResultSet rs = db.select(query);

        try {
            // Recorrer el conjunto de resultados y construir objetos Horario con detalles adicionales.
            while (rs.next()) {
                lista.add(new Horario(
                        rs.getInt("id"),
                        rs.getString("hora_inicio"),
                        rs.getString("hora_fin")
                ));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hay un error con la base de datos!");
        }
        return lista;
    }
}

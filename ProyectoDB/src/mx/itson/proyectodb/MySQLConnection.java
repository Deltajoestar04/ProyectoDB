/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.proyectodb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Admin
 */
public class MySQLConnection {
    
    public static Connection get(){       
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://arturog58.sg-host.com:3306/dbaswox04bsrqh","u4iwcrzxmsk8g","camaronesITSON");

        }catch(SQLException ex){
            System.err.println("ERROR: "+ex.getMessage());
        }
        return connection;
        
        
        
    }
        
    
}

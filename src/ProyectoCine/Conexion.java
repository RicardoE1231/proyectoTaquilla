/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoCine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ricardo Emmanuel Ojeda Mendoza 19161369
 * 
 */
public class Conexion {

    private static Connection coneccion;
    private static Conexion conexion;
    private static int numConexiones = 0;

    private Conexion(String url, String usuario, String password) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            try {
                coneccion = (Connection) DriverManager.getConnection(url, usuario, password);
            } catch (SQLException e) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Conexion getConexion(String url, String usuario, String password) {
        numConexiones++;
        if (conexion == null) {
            conexion = new Conexion(url, usuario, password);
        }
        return conexion;
    }

    public static Connection getConeccion() {
        return coneccion;
    }
    
    public boolean cerrarConexion(){
        try {
            if (coneccion != null) {
                if (numConexiones == 1) {
                    coneccion.close();
                    return true;
                } else
                    numConexiones--;
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error al tratar de cerrar la conexion " + e);
        }
        return false;
    }
    
    

}

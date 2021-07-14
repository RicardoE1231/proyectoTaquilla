/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoCine;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Ricardo Emmanuel Ojeda Mendoza 19161369
 * 
 */
public class ManejoDatos {

    private Connection conexion;
    private Conexion crearConexion;
    private final int CAMPOS_CLIENTE = 5;
    private final int CAMPOS_FUNCION = 5;
    private final int CAMPOS_PELICULA = 6;
    private final int CAMPOS_VENDEDOR = 2;
    

    public ManejoDatos() {
        crearConexion = Conexion.getConexion("jdbc:derby://localhost:1527/cine", "root", "1234");
        conexion = Conexion.getConeccion();
    }
    
    public Vector<Object[]> conexionConsultaCliente(String sql) {
        Vector<Object[]> datos = new Vector<>();
        try {
            Statement ps = conexion.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                String dat[] = new String[CAMPOS_CLIENTE];
                dat[0] = String.valueOf((Integer) rs.getInt(1));
                dat[1] = rs.getString(2);
                dat[2] = rs.getString(3);
                dat[3] = rs.getString(4);
                dat[4] = rs.getString(5);
                datos.add(dat);
            }
        } catch (Exception e) {
            System.err.println("Error al conexion consultar cliente " + e);
        }
        return datos;
    }
    
    public Vector<Object[]> conexionConsultaFuncion(String sql) {
        Vector<Object[]> datos = new Vector<>();
        try {
            Statement ps = conexion.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                String dat[] = new String[CAMPOS_FUNCION];
                dat[0] = String.valueOf((Integer) rs.getInt(1));
                dat[1] = rs.getString(2);
                dat[2] = String.valueOf((Integer) rs.getInt(3));
                dat[3] = rs.getString(4);
                dat[4] = String.valueOf((Integer) rs.getInt(5));
                datos.add(dat);
            }
        } catch (Exception e) {
            System.err.println("Error al conexion consultar funcion " + e);
        }
        return datos;
    }
    
    public Vector<Object[]> conexionConsultaPelicula(String sql) {
        Vector<Object[]> datos = new Vector<>();
        try {
            Statement ps = conexion.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                String dat[] = new String[CAMPOS_PELICULA];
                dat[0] = String.valueOf((Integer) rs.getInt(1));
                dat[1] = rs.getString(2);
                dat[2] = rs.getString(3);
                dat[3] = rs.getString(4);
                dat[4] = String.valueOf((Integer) rs.getInt(5));
                dat[5] = rs.getString(6);
                datos.add(dat);
            }
        } catch (Exception e) {
            System.err.println("Error al conexion consultar pelicula " + e);
        }
        return datos;
    }
    
    public Vector<Object[]> conexionConsultaVendedor(String sql) {
        Vector<Object[]> datos = new Vector<>();
        try {
            Statement ps = conexion.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                String dat[] = new String[CAMPOS_VENDEDOR];
                dat[0] = String.valueOf((Integer) rs.getInt(1));
                dat[1] = rs.getString(2);
                datos.add(dat);
            }
        } catch (Exception e) {
            System.err.println("Error al conexion consultar vendedor " + e);
        }
        return datos;
    }

    /*public List<Object[]> conexionConsultaCliente(String sql) {
        List<Object[]> datos = new ArrayList<Object[]>();
        try {
            Statement ps = conexion.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                String dat[] = new String[CAMPOS_CLIENTE];
                dat[0] = String.valueOf((Integer) rs.getInt(1));
                dat[1] = rs.getString(2);
                dat[2] = fecha.format((Date) rs.getDate(3));
                dat[3] = String.valueOf(rs.getString(4));
                datos.add(dat);
            }
        } catch (Exception e) {
            System.err.println("Error al conexion consultar persona " + e);
        }
        return datos;
    }*/

    public boolean actualizaDatos(String sql) {
        boolean res = false;
        try {
            java.sql.Statement st = conexion.createStatement();
            st.execute(sql);
            res = true;
            System.out.println("Se inserto");
        } catch (Exception e) {
            System.err.println("Error al insertar/Actualizar" + e);
        }
        return res;
    }
}

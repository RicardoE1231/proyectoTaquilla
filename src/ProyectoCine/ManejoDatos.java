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

/**
 *
 * @author Ricardo Emmanuel Ojeda Mendoza 19161369
 * 
 */
public class ManejoDatos {

    private Connection conexion;
    private Conexion crearConexion;
    private final int CAMPOS_PERSONAS = 4;

    public ManejoDatos() {
        crearConexion = Conexion.getConexion("jdbc:derby://localhost:1527/mediciones_personales", "root", "masterkey");
        conexion = Conexion.getConeccion();
    }

    public List<Object[]> conexionConsultaPersona(String sql) {
        List<Object[]> datos = new ArrayList<Object[]>();
        DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Statement ps = conexion.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                String dat[] = new String[CAMPOS_PERSONAS];
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
    }

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

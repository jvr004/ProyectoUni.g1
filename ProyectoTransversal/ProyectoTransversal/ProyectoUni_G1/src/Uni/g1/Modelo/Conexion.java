
package Uni.g1.Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

    private static String url = "jdbc:mysql://localhost/universidad_g1";
    private static String usuario = "root";
    private static String password = "";
    private static Conexion conexion=null;

    private Conexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Clase Conexion: Error al cargar Driver");
        }
    }

    public static Connection getConexion() {
        Connection conn=null;
        
        if (conexion == null) {
            conexion=new Conexion();
         }
        
        try {
            conn = DriverManager.getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC" + "&user=" + usuario + "&password=" + password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Clase Conexion: Error de Conexion");
        }
      
      return conn;
    }

}
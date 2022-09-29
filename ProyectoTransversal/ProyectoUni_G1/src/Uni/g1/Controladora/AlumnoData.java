package Uni.g1.Controladora;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Uni.g1.Modelo.Conexion;
import Uni.g1.Modelo.Alumno;

public class AlumnoData {
    private Connection con;

    public AlumnoData() {
        this.con=Conexion.getConexion();
    }
    
    public void guardarAlumno(Alumno alumno){
        //a)	INSERT INTO `alumno` (`dni`,`apellido`,`nombre`,`fechaNacimiento`,`estado`) VALUES ('111','Muñoz','Federico','2001-05-31','1'),(
        String sql="INSERT INTO alumnos (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, alumno.getDni());
            ps.setString(2,alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.isEstado());
            
            ps.executeUpdate();//insert, update, delete
            
            ResultSet rs=ps.getGeneratedKeys();
            
            if(rs.next()){
                alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "El Alumno fue guardado con exito");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ALumnoData Sentencia SQL erronea-AgregarAlumno");
        }
        
    }
    
    public List<Alumno> obtenerAlumnos(){
        
        ArrayList<Alumno> listaTemp=new ArrayList();
        
        String sql="SELECT * FROM alumnos WHERE estado = 1";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            
            ResultSet rs=ps.executeQuery();//select
            
            while(rs.next()){
            
                Alumno a=new Alumno();
                a.setIdAlumno(rs.getInt("idAlumno"));
                a.setIdAlumno(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setApellido(rs.getString("apellido"));
                a.setNombre(rs.getString("nombre"));
                a.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                a.setEstado(rs.getBoolean("estado"));
                
                listaTemp.add(a);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ALumnoData Sentencia SQL erronea-ObtenerAlumnos");
        }
    return listaTemp;
    }
    
     public Alumno obtenerAlumnoPorId(int id) {
        String sql= "SELECT * FROM alumnos WHERE idAlumno = ?";
        Alumno alu = new Alumno();
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){              
                alu.setIdAlumno(id);
                alu.setDni(rs.getInt("dni"));
                alu.setApellido(rs.getString("apellido"));
                alu.setNombre(rs.getString("nombre"));
                alu.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alu.setEstado(rs.getBoolean("estado"));
                
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ALumnoData Sentencia SQL erronea-obtenerAlumnoPorId");
        }
        return alu;
         
    }
    
    
    public void borrarAlumno (int id){
        String sql="UPDATE alumnos SET estado=0 WHERE idAlumno=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Se elimino el alumno correctamente");
            
            ps.close();
            
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ALumnoData Sentencia SQL erronea-borrarAlumno");
        }
    }
    
   public void acctualizarAlumno(Alumno alumno){
        
        String sql = "UPDATE alumnos SET dni = ?, apellido = ?, nombre = ?, fechaNacimiento = ?, estado =? WHERE  IdAlumno = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, alumno.getDni());
            ps.setString(2,alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.isEstado());
            ps.setInt(6, alumno.getIdAlumno());
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Modificacion exitosa.");
            } else {
                JOptionPane.showMessageDialog(null, "El Alumno no se pudo modificar.");
            }                
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ALumnoData modificacion erronea-AzualizarAlumno");
        }
        
    }
}

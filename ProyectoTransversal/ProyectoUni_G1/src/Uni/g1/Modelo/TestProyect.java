
package Uni.g1.Modelo;

import java.time.LocalDate;
import java.time.Month;
import javax.swing.JOptionPane;

import Uni.g1.Controladora.AlumnoData;



public class TestProyect {

    public static void main(String[] args) {
        
        
        AlumnoData ad = new AlumnoData();
            
        Alumno alu = new Alumno(1,123,"Tor","Tor",LocalDate.of(1987, 04, 12),true);
        
        //ad.guardarAlumno(alu);
//        alu.setDni(23088100);
//        alu.setApellido("Di Gangi");
//        alu.setNombre("Yamila Belen");
//        
//        ad.acctualizarAlumno(alu);
        
        
        
//        ad.obtenerAlumnos().forEach(alumno->{
//         Alumno ul=null;
//         JOptionPane.showMessageDialog(null, alumno);
//              ul=alumno;
//              
//              ul.setDni(1111);
//              ad.acctualizarAlumno(ul);
//        });
//        
        
        
       
        
//        Materia mat = new Materia("Lab 1",1,true);
//        
//        Cursada cursa = new Cursada(alu,mat,7);
//        
//        cursa.setNota(9);
//       
//        JOptionPane.showMessageDialog(null, cursa);
               
    }
    
}

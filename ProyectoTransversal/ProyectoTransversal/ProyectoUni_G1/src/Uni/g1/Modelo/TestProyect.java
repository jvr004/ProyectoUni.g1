
package Uni.g1.Modelo;

import java.time.LocalDate;
import java.time.Month;
import javax.swing.JOptionPane;

import Uni.g1.Controladora.AlumnoData;



public class TestProyect {

    public static void main(String[] args) {
        
        
        AlumnoData ad = new AlumnoData();
            
        Alumno alu = new Alumno(33089223,"Tor","Tor",LocalDate.of(1987, 04, 12),true);
        
      ad.guardarAlumno(alu);
        //d.actualizarAlumno(alu);
        
       
        
//        Materia mat = new Materia("Lab 1",1,true);
//        
//        Cursada cursa = new Cursada(alu,mat,7);
//        
//        cursa.setNota(9);
//       
//        JOptionPane.showMessageDialog(null, cursa);
               
    }
    
}

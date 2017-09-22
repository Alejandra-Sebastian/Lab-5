/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hcadavid
 */
public class ServiciosPacientesTest {
    
    public ServiciosPacientesTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void RegistroDePaciente(){
        ServiciosPacienteMok spm = new ServiciosPacienteMok();
        int id = 1234;
        String tipoid= "TI";
        String nombre="Juanchito"; 
        Date fN = new Date(23,4,2001);
        Eps eps = new Eps("famisanar",54321);
        Paciente = new Paciente(id, tipoid,nombre,fN,eps);
                
    }
}

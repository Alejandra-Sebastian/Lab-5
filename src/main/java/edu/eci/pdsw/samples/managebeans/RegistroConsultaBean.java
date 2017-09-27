/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managebeans;


import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.ServiciosHistorialPacientesFactory;
import edu.eci.pdsw.samples.services.ServiciosPacientes;

import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author 2106913
 */
@ManagedBean(name = "HistorialPacientes")
@SessionScoped
public class RegistroConsultaBean implements Serializable {

    private final ServiciosPacientes servicepacientes = ServiciosHistorialPacientesFactory.getInstance().getServiciosPaciente();
    private int id;
    private String tipoid;
    private String nombre;
    private Date fechaNacimiento;
    private Eps eps;
    private Paciente paciente;
    private  List<Eps> results = new ArrayList<Eps>();
    private String msg;

    

    public RegistroConsultaBean() {
        
    }

    public void showMessage(String estado, String mensaje) {
        FacesMessage message;
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, estado, mensaje);
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }
    
    public List<String> listaEps() {
        List<String> nombres = new ArrayList<String>();
        results.add(new Eps("Suramericana","800256161-9"));
        results.add(new Eps("Sanitas","800251440-6"));
        results.add(new Eps("Aliansalud","830113831-0"));
        results.add(new Eps("Nueva EPS","900156264-2"));
        results.add(new Eps("Compensar","860066942-7"));
        results.add(new Eps("Salud Total","800130907-4"));
        results.add(new Eps("Famisanar","830003564-7"));
        results.add(new Eps("Saludvida","830074184-5"));
        results.add(new Eps("Coomeva","805000427-1"));
        results.add(new Eps("Servicio Occidental de Salud","805001157-2"));
        results.add(new Eps("Comfenalco Valle","890303093-5"));
        results.add(new Eps("Cruz Blanca","830009783-0"));
        results.add(new Eps("Cafesalud","800140949-6"));
        
        for(Eps e: results) {
            nombres.add(e.getNombre());
        }
        return nombres;
    }
    
    public void agregarPaciente(ActionEvent actionEvent) {
        paciente = new Paciente(id, tipoid, nombre, fechaNacimiento, eps);
        try {
            servicepacientes.registrarNuevoPaciente(paciente);
            msg = "Se registro correctamente";
        } catch (ExcepcionServiciosPacientes ex) {
            msg = "No se registro correctamente";
        }
        System.out.println(msg);
    }
    
   
    

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTipoid() {
        return tipoid;
    }
    
    public void setTipoid(String tipoid) {
        this.tipoid = tipoid;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
      this.fechaNacimiento = fechaNacimiento; 
    }
    
    public Eps getEps() {
        return eps;
    }
    
    public void setEps(Eps eps) {
        this.eps = eps;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }

}

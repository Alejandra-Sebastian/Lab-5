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
    private String nombreEps;
    private Paciente paciente;
    private HashMap<String, Eps> listaEps;
    private List<String> nombresEps;
    private List<Paciente> pacientes;
    private Paciente pacienteSeleccionado;

    

    public RegistroConsultaBean(){
        listaEps = new HashMap<String, Eps>();
        listaEps.put("Suramericana", new Eps("Suramericana","800256161-9"));
        listaEps.put("Sanitas", new Eps("Sanitas","800251440-6"));
        listaEps.put("Aliansalud" ,new Eps("Aliansalud","830113831-0"));
        listaEps.put("Nueva EPS", new Eps("Nueva EPS","900156264-2"));
        listaEps.put("Compensar", new Eps("Compensar","860066942-7"));
        listaEps.put("Salud Total", new Eps("Salud Total","800130907-4"));
        listaEps.put("Famisanar", new Eps("Famisanar","830003564-7"));
        listaEps.put("Saludvida", new Eps("Saludvida","830074184-5"));
        listaEps.put("Coomeva", new Eps("Coomeva","805000427-1"));
        listaEps.put("Servicio Occidental de Salud", new Eps("Servicio Occidental de Salud","805001157-2"));
        listaEps.put("Comfenalco Valle", new Eps("Comfenalco Valle","890303093-5"));
        listaEps.put("Cruz Blanca", new Eps("Cruz Blanca","830009783-0"));
        listaEps.put("Cafesalud", new Eps("Cafesalud","800140949-6"));
        nombresEps = new ArrayList<String>();
        for(Map.Entry<String, Eps> entry : listaEps.entrySet()) {
            nombresEps.add(entry.getKey());
        }
        
    }

    public void showMessage(String estado, String mensaje) {
        FacesMessage message;
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, estado, mensaje);
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }
    
    public void agregarPaciente() {
        
        eps = listaEps.get(nombreEps);
        paciente = new Paciente(id, tipoid, nombre, fechaNacimiento, eps);
        try {
            servicepacientes.registrarNuevoPaciente(paciente);
        } catch (ExcepcionServiciosPacientes ex) {
            Logger.getLogger(RegistroConsultaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    public String getNombreEps() {
        return nombreEps;
    }
    
    public void setNombreEps(String nombreEps) {
        this.nombreEps = nombreEps;
    }
    
    public List<String> getNombresEps() {
        return nombresEps;
    }
    
    public void setNombresEps(List<String> nombresEps) {
        this.nombresEps = nombresEps;
    }
    
    public HashMap<String, Eps> getListaEps() {
        return listaEps;
    }
    
    public void setListaEps(HashMap<String, Eps> listaEps) {
        this.listaEps = listaEps;
    }
    
    public List<Paciente> getPacientes() {
        try {
            pacientes = servicepacientes.consultarPacientes();
        } catch (ExcepcionServiciosPacientes ex) {
            Logger.getLogger(RegistroConsultaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pacientes;
    }
    
    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    
    public Paciente getPacienteSeleccionado(){
        return pacienteSeleccionado;
    }
    
    public void setPacienteSeleccionado(Paciente pa){
        pacienteSeleccionado = pa;
    }
}

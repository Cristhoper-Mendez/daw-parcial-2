
package com.ues.parcial.controller;

import com.ues.parcial.entity.*;
import com.ues.parcial.service.InscripcionService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named("cInscripcion")
@ViewScoped
public class InscripcionBean implements Serializable{

    @EJB(beanName = "insServ")
    private InscripcionService daoInscripcion;

    private List<Inscripcion> listaInscripciones;
    private Inscripcion inscripcion;

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    private Estudiante estudiante;
    private Materia materia;
    
    public String irInscripcion(){
        return "/xhtml/dt_inscripcione/inscripcion.xhtml";
    }  

    public List<Inscripcion> getListaInscripciones() {
        this.listaInscripciones = this.daoInscripcion.findAll();
        return listaInscripciones;
    }

    public void setListaInscripciones(List<Inscripcion> inscripcionesList) {
        this.listaInscripciones = inscripcionesList;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    @PostConstruct
    public void inicializar() {
        this.inscripcion = new Inscripcion();
        this.materia = new Materia();
        this.estudiante = new Estudiante();
    }

    public void recargar() {
        this.listaInscripciones = this.daoInscripcion.findAll();
    }

    public void guardarInscripcion() {
        this.inscripcion.setEstudiante(estudiante);
        this.inscripcion.setMateria(materia);
        System.out.println(this.materia.getNombre());
        System.out.println(this.estudiante.getNombre());
        if (inscripcion.getId() != null) {
            this.daoInscripcion.edit(inscripcion);
        } else {
            this.inscripcion.setFechaInscripcion(new Date());
            this.daoInscripcion.create(inscripcion);
        }
        this.recargar();
        this.inicializar();
    }

    public void cargarInscripcion(Inscripcion inscripcion) {
        this.setEstudiante(inscripcion.getEstudiante());
        this.setMateria(inscripcion.getMateria());
        this.inscripcion = inscripcion;
    }

    public void borrarInscripcion(Inscripcion inscripcion) {
        this.daoInscripcion.remove(inscripcion);
        this.recargar();
    }

}

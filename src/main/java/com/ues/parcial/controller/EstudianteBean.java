
package com.ues.parcial.controller;

import com.ues.parcial.entity.Estudiante;
import com.ues.parcial.service.EstudianteService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named("cEstudiante")
@ViewScoped
public class EstudianteBean implements Serializable{


    @EJB(beanName = "estServ")
    private EstudianteService daoEstudiante;

    private List<Estudiante> listaEstudiantes;
    private Estudiante estudiante;

    public List<Estudiante> getListaEstudiantes() {
        this.listaEstudiantes = this.daoEstudiante.findAll();
        return listaEstudiantes;
    }
    
    public String irEstudiante(){
        return "/xhtml/dt_alumno/alumno.xhtml";
    }           

    public void setListaEstudiantes(List<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @PostConstruct
    public void inicializar() {
        this.estudiante = new Estudiante();
    }

    public void recargar() {
        this.listaEstudiantes = this.daoEstudiante.findAll();
    }

    public void guardarEstudiante() {
        if (estudiante.getId() != null) {
            this.daoEstudiante.edit(estudiante);
        } else {
            this.daoEstudiante.create(estudiante);
        }
        this.recargar();
        this.inicializar();
    }

    public void cargarEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void borrarEstudiante(Estudiante estudiante) {
        this.daoEstudiante.remove(estudiante);
        this.recargar();
    }

}

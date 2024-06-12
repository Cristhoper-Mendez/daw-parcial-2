
package com.ues.parcial.controller;

import com.ues.parcial.entity.Materia;
import com.ues.parcial.service.MateriaDataService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named("cMateria")
@ViewScoped
public class MateriaBean implements Serializable{

    @EJB(beanName = "matServ")
    private MateriaDataService daoMateria;

    private List<Materia> listaMaterias;
    private Materia materia;

    public String irMateria(){
        return "/xhtml/dt_materia/materia.xhtml";
    }  
    
    public List<Materia> getListaMaterias() {
        this.listaMaterias = this.daoMateria.findAll();
        return listaMaterias;
    }

    public void setListaMaterias(List<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @PostConstruct
    public void inicializar() {
        this.materia = new Materia();
    }

    public void recargar() {
        this.listaMaterias = this.daoMateria.findAll();
    }

    public void guardarMateria() {
        if (materia.getId() != null) {
            this.daoMateria.edit(materia);
        } else {
            this.daoMateria.create(materia);
        }
        this.recargar();
        this.inicializar();
    }

    public void cargarMateria(Materia materia) {
        this.materia = materia;
    }

    public void eliminarMateria(Materia materia) {
        this.daoMateria.remove(materia);
        this.recargar();
    }

}

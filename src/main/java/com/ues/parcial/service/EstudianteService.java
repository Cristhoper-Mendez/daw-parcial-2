
package com.ues.parcial.service;

import com.ues.parcial.entity.Estudiante;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless(name = "estServ")
public class EstudianteService extends Dao<Estudiante> {

    @PersistenceContext(unitName = "PoolParcial2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudianteService() {
        super(Estudiante.class);
    }
}

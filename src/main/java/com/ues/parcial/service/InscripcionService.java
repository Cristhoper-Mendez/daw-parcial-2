
package com.ues.parcial.service;

import com.ues.parcial.entity.Inscripcion;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless(name = "insServ")
public class InscripcionService extends Dao<Inscripcion> {

    @PersistenceContext(unitName = "PoolParcial2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InscripcionService() {
        super(Inscripcion.class);
    }
}

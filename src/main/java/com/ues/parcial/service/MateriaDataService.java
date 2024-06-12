
package com.ues.parcial.service;

import com.ues.parcial.entity.Materia;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Stateless(name = "matServ")
public class MateriaDataService extends Dao<Materia> {

    @PersistenceContext(unitName = "PoolParcial2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MateriaDataService() {
        super(Materia.class);
    }
}

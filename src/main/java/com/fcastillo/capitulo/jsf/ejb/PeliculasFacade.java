/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcastillo.capitulo.jsf.ejb;

import com.fcastillo.capitulo.jsf.entidades.Peliculas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fcastillo
 */
@Stateless
public class PeliculasFacade extends AbstractFacade<Peliculas> implements PeliculasFacadeLocal {

    @PersistenceContext(unitName = "com.fcastillo_capitulo-jsf_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PeliculasFacade() {
        super(Peliculas.class);
    }
    
}

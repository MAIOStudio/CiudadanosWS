/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Ciudadano;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dearmartinez
 */
@Stateless
public class CiudadanoDAO extends AbstractFacade<Ciudadano> {
    @PersistenceContext(unitName = "com.jtest_CiudadanosWS_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CiudadanoDAO() {
        super(Ciudadano.class);
    }
    
}

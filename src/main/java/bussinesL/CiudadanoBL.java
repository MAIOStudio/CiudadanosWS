/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussinesL;

import entities.Ciudadano;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import model.CiudadanoDAO;

/**
 *
 * @author dearmartinez
 */
@Stateless
@LocalBean
public class CiudadanoBL {
    @EJB
    private CiudadanoDAO ciudadanoDAO;
    
    public List<Ciudadano> getTodosCiudadanos() {
        return ciudadanoDAO.findAll();
    }
    
    public Ciudadano getCiudadano(Integer id) {
        return ciudadanoDAO.find(id);
    }

    public void crearCiudadano(Ciudadano ciudadano) {
        ciudadanoDAO.create(ciudadano);
    }

    public void eliminarCiudadano(Ciudadano ciudadano) {
        ciudadanoDAO.remove(ciudadano);
    }

    public void editarCiudadano(Ciudadano ciudadano) {
        ciudadanoDAO.edit(ciudadano);
    }
    
    
    
    

    
}

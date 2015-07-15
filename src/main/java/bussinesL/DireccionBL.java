/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussinesL;

import entities.Direccion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import model.DireccionDAO;

/**
 *
 * @author dearmartinez
 */
@Stateless
@LocalBean
public class DireccionBL {
    @EJB
    private DireccionDAO direccionDAO;
    
    public List<Direccion> getTodasDirecciones() {
        return direccionDAO.findAll();
    }
    
    public Direccion getDireccion(Direccion id) {
        return direccionDAO.find(id);
    }
    
    public void crearDireccion(Direccion direccion) {
        direccionDAO.create(direccion);
    }
    
    public void eliminarDireccion(Direccion direccion) {
        direccionDAO.remove(direccion);
    }
    
    public void editarDireccion(Direccion direccion) {
        direccionDAO.edit(direccion);
    }
}

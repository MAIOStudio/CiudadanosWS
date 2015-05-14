/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussinesL;

import entities.Email;
import entities.Telefono;
import entities.TelefonoPK;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import model.TelefonoDAO;

/**
 *
 * @author dearmartinez
 */
@Stateless
@LocalBean
public class TelefonoBL {
    @EJB
    private TelefonoDAO telefonoDAO;
    
    public List<Telefono> getTodosTelefonos() {
        return telefonoDAO.findAll();
    }
    
    public void crearTelefono(Telefono telefono) {
        telefonoDAO.create(telefono);
    }
    
    public void eliminarTelefono(Telefono telefono) {
        telefonoDAO.remove(telefono);
    }
    
    public void editarTelefono(Telefono telefono) {
        telefonoDAO.edit(telefono);
    }
    
    public Telefono getTelefono(TelefonoPK id) {
        return telefonoDAO.find(id);
    }
}

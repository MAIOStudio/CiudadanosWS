/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussinesL;

import entities.Email;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import model.EmailDAO;

/**
 *
 * @author dearmartinez
 */
@Stateless
@LocalBean
public class EmailBL {
    @EJB
    private EmailDAO emailDAO;
    
    public List<Email> getTodosEmails() {
        return emailDAO.findAll();
    }
    
    public Email getEmail(Email id) {
        return emailDAO.find(id);
    }
    
    public void crearEmail(Email email) {
        emailDAO.create(email);
    }
    
    public void eliminarEmail(Email email) {
        emailDAO.remove(email);
    }
    
    public void editarEmail(Email email) {
        emailDAO.edit(email);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bussinesL.EmailBL;
import entities.Email;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author dearmartinez
 */
@Named(value = "EmailBean")
@SessionScoped
public class EmailBean implements Serializable {
    @EJB
    private EmailBL emailBL;
    
    private List<Email> emails;
    private Email email;
    
    public EmailBean() {
    }

    public List<Email> getEmails() {
        emails = emailBL.getTodosEmails();
        return emails;
    }
    
    public String guardarEmail() {
        emailBL.crearEmail(email);
        return "EmailLista";
    }
    
    public String prepararNuevo() {
        email = new Email();
        return "EmailCrear";
    }
    
    public String eliminarEmail(Email email) {
        emailBL.eliminarEmail(email);
        return "EmailLista";
    }
    
    public String prepararEditar(Email email) {
        this.email = email;
        emailBL.editarEmail(email);
        return "EmailEditar";
    }
    
    public String editarEmail() {
        emailBL.editarEmail(email);
        return "EmailLista";
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
    
    public Email getEmail(Email id) {
        email = emailBL.getEmail(id);
        return email;
    }
    
    @FacesConverter(forClass = Email.class)
    public static class EmailBeanConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EmailBean emailBean = (EmailBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "EmailBean");
            return emailBean.getEmail(getKey(value));
        }

        entities.Email getKey(String value) {
            entities.Email key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new entities.Email();
            key.setIdEmail(Integer.parseInt(values[0]));
            key.setIdCiudadano(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(entities.Email value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdEmail());
            sb.append(SEPARATOR);
            sb.append(value.getIdCiudadano());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Email) {
                Email o = (Email) object;
                return getStringKey(o.getEmail());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Email.class.getName());
            }
        }
    }
}

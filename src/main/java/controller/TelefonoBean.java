/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bussinesL.TelefonoBL;
import entities.Telefono;
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
@Named(value = "TelefonoBean")
@SessionScoped
public class TelefonoBean implements Serializable {
    @EJB
    private TelefonoBL telefonoBL;
        
    private List<Telefono> telefonos;
    private Telefono telefono;
    
    public TelefonoBean() {
    }

    public List<Telefono> getTelefonos() {
        telefonos = telefonoBL.getTodosTelefonos();
        return telefonos;
    }
    
    public String guardarTelefono() {
        telefonoBL.crearTelefono(telefono);
        return "TelefonoLista";
    }
    
    public String prepararNuevo() {
        telefono = new Telefono();
        return "TelefonoCrear";
    }
    
    public String eliminarTelefono(Telefono telefono) {
        telefonoBL.eliminarTelefono(telefono);
        return "TelefonolLista";
    }
    
    public String prepararEditar(Telefono telefono) {
        this.telefono = telefono;
        telefonoBL.editarTelefono(telefono);
        return "TelefonoEditar";
    }
    
    public String editarTelefono() {
        telefonoBL.editarTelefono(telefono);
        return "TelefonoLista";
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }
    
    public Telefono getTelefono(Telefono id) {
        telefono = telefonoBL.getTelefono(id);
        return telefono;
    }
    
    @FacesConverter(forClass = Telefono.class)
    public static class TelefonoBeanConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TelefonoBean telefonoBean = (TelefonoBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "TelefonoBean");
            return telefonoBean.getTelefono(getKey(value));
        }

        entities.Telefono getKey(String value) {
            entities.Telefono key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new entities.Telefono();
            key.setIdTelefono(Integer.parseInt(values[0]));
            key.setIdCiudadano(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(entities.Telefono value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdTelefono());
            sb.append(SEPARATOR);
            sb.append(value.getIdCiudadano());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Telefono) {
                Telefono o = (Telefono) object;
                return getStringKey(o.getTelefono());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Telefono.class.getName());
            }
        }

    }
    
}

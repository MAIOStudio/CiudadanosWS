/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bussinesL.DireccionBL;
import entities.Direccion;
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
@Named(value = "DireccionBean")
@SessionScoped
public class DireccionBean implements Serializable {
    @EJB
    private DireccionBL direccionBL;
    
    private List<Direccion> direcciones;
    private Direccion direccion;
    
    public DireccionBean() {
    }
    
    public String guardarDireccion() {
        direccionBL.crearDireccion(direccion);
        return "DireccionLista";
    }
    
    public String prepararNuevo() {
        direccion = new Direccion();
        return "DireccionCrear";
    }
    
    public String eliminarDireccion(Direccion direccion) {
        direccionBL.eliminarDireccion(direccion);
        return "DireccionLista";
    }
    
    public String prepararEditar(Direccion direccion) {
        this.direccion = direccion;
        direccionBL.editarDireccion(direccion);
        return "DireccionEditar";
    }
    
    public String editarDireccion() {
        direccionBL.editarDireccion(direccion);
        return "DireccionLista";
    }
    
    public List<Direccion> getDirecciones() {
        direcciones = direccionBL.getTodasDirecciones();
        return direcciones;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    public Direccion getDireccion(Direccion id) {
        direccion = direccionBL.getDireccion(id);
        return direccion;
    }
    
    @FacesConverter(forClass = Direccion.class)
    public static class DireccionBeanConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DireccionBean direccionBean = (DireccionBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "DireccionBean");
            return direccionBean.getDireccion(getKey(value));
        }

        entities.Direccion getKey(String value) {
            entities.Direccion key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new entities.Direccion();
            key.setIdDireccion(Integer.parseInt(values[0]));
            key.setIdCiudadano(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(entities.Direccion value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdDireccion());
            sb.append(SEPARATOR);
            sb.append(value.getIdCiudadano());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Direccion) {
                Direccion o = (Direccion) object;
                return getStringKey(o.getDireccion());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Direccion.class.getName());
            }
        }
    }
}

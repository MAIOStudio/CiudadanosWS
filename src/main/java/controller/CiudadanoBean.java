/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bussinesL.CiudadanoBL;
import entities.Ciudadano;
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
@Named(value = "CiudadanoBean")
@SessionScoped
public class CiudadanoBean implements Serializable {
    @EJB
    private CiudadanoBL ciudadanoBL;
    
    private List<Ciudadano> ciudadanos;
    private Ciudadano ciudadano;
    
    public CiudadanoBean() {
    }
    
    public String guardarCiudadano() {
        ciudadanoBL.crearCiudadano(ciudadano);
        return "CiudadanoLista";
    }
    
    public String prepararNuevo() {
        ciudadano = new Ciudadano();
        return "CiudadanoCrear";
    }
    
    public String eliminarCiudadano(Ciudadano ciudadano) {
        ciudadanoBL.eliminarCiudadano(ciudadano);
        return "CiudadanoLista";
    }
    
    public String prepararEditar(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
        ciudadanoBL.editarCiudadano(ciudadano);
        return "CiudadanoEditar";
    }
    
    public String editarCiudadano() {
        ciudadanoBL.editarCiudadano(ciudadano);
        return "CiudadanoLista";
    }
    

    public List<Ciudadano> getCiudadanos() {
        ciudadanos = ciudadanoBL.getTodosCiudadanos();
        return ciudadanos;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }
    
    public Ciudadano getCiudadano(Integer id) {
        ciudadano = ciudadanoBL.getCiudadano(id);
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }
    
    @FacesConverter(forClass = Ciudadano.class)
    public static class CiudadanoBeanConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CiudadanoBean ciudadanoBean = (CiudadanoBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "CiudadanoBean");
            return ciudadanoBean.getCiudadano(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Ciudadano) {
                Ciudadano o = (Ciudadano) object;
                return getStringKey(o.getIdCiudadano());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Ciudadano.class.getName());
            }
        }

    }
    
}

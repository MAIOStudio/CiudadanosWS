/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dearmartinez
 */
@Embeddable
public class DireccionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idDireccion")
    private int idDireccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCiudadano")
    private int idCiudadano;

    public DireccionPK() {
    }

    public DireccionPK(int idDireccion, int idCiudadano) {
        this.idDireccion = idDireccion;
        this.idCiudadano = idCiudadano;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public int getIdCiudadano() {
        return idCiudadano;
    }

    public void setIdCiudadano(int idCiudadano) {
        this.idCiudadano = idCiudadano;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDireccion;
        hash += (int) idCiudadano;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionPK)) {
            return false;
        }
        DireccionPK other = (DireccionPK) object;
        if (this.idDireccion != other.idDireccion) {
            return false;
        }
        if (this.idCiudadano != other.idCiudadano) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DireccionPK[ idDireccion=" + idDireccion + ", idCiudadano=" + idCiudadano + " ]";
    }
    
}

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
public class TelefonoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idTelefono")
    private int idTelefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCiudadano")
    private int idCiudadano;

    public TelefonoPK() {
    }

    public TelefonoPK(int idTelefono, int idCiudadano) {
        this.idTelefono = idTelefono;
        this.idCiudadano = idCiudadano;
    }

    public int getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(int idTelefono) {
        this.idTelefono = idTelefono;
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
        hash += (int) idTelefono;
        hash += (int) idCiudadano;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefonoPK)) {
            return false;
        }
        TelefonoPK other = (TelefonoPK) object;
        if (this.idTelefono != other.idTelefono) {
            return false;
        }
        if (this.idCiudadano != other.idCiudadano) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TelefonoPK[ idTelefono=" + idTelefono + ", idCiudadano=" + idCiudadano + " ]";
    }
    
}

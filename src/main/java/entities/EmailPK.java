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
public class EmailPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idEmail")
    private int idEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCiudadano")
    private int idCiudadano;

    public EmailPK() {
    }

    public EmailPK(int idEmail, int idCiudadano) {
        this.idEmail = idEmail;
        this.idCiudadano = idCiudadano;
    }

    public int getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(int idEmail) {
        this.idEmail = idEmail;
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
        hash += (int) idEmail;
        hash += (int) idCiudadano;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailPK)) {
            return false;
        }
        EmailPK other = (EmailPK) object;
        if (this.idEmail != other.idEmail) {
            return false;
        }
        if (this.idCiudadano != other.idCiudadano) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.EmailPK[ idEmail=" + idEmail + ", idCiudadano=" + idCiudadano + " ]";
    }
    
}

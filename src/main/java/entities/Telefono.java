/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dearmartinez
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Telefono.findAll", query = "SELECT t FROM Telefono t"),
    @NamedQuery(name = "Telefono.findByIdTelefono", query = "SELECT t FROM Telefono t WHERE t.telefono.idTelefono = :idTelefono"),
    @NamedQuery(name = "Telefono.findByTelefono", query = "SELECT t FROM Telefono t WHERE t.telefono = :telefono"),
    @NamedQuery(name = "Telefono.findByTipo", query = "SELECT t FROM Telefono t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "Telefono.findByIdCiudadano", query = "SELECT t FROM Telefono t WHERE t.telefono.idCiudadano = :idCiudadano")})
public class Telefono implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    protected Telefono telefono;
    @NotNull
    private String tipo;
    @JoinColumn(name = "idCiudadano", referencedColumnName = "idCiudadano", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ciudadano ciudadano;
    private int idTelefono;
    private int idCiudadano;

    public Telefono() {
    }

    public Telefono(Telefono telefono) {
        this.telefono = telefono;
    }

    public Telefono(Telefono telefono, String tipo) {
        this.telefono = telefono;
        this.tipo = tipo;
    }

    public Telefono(int idTelefono, int idCiudadano) {
        this.telefono = new Telefono(idTelefono, idCiudadano);
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telefono != null ? telefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefono)) {
            return false;
        }
        Telefono other = (Telefono) object;
        if ((this.telefono == null && other.telefono != null) || (this.telefono != null && !this.telefono.equals(other.telefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Telefono[ telefono=" + telefono + " ]";
    }
    
}

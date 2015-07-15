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
import javax.validation.constraints.Size;

/**
 *
 * @author dearmartinez
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d"),
    @NamedQuery(name = "Direccion.findByIdDireccion", query = "SELECT d FROM Direccion d WHERE d.direccion.idDireccion = :idDireccion"),
    @NamedQuery(name = "Direccion.findByCalle", query = "SELECT d FROM Direccion d WHERE d.calle = :calle"),
    @NamedQuery(name = "Direccion.findByNumero", query = "SELECT d FROM Direccion d WHERE d.numero = :numero"),
    @NamedQuery(name = "Direccion.findBySector", query = "SELECT d FROM Direccion d WHERE d.sector = :sector"),
    @NamedQuery(name = "Direccion.findByCiudad", query = "SELECT d FROM Direccion d WHERE d.ciudad = :ciudad"),
    @NamedQuery(name = "Direccion.findByTipo", query = "SELECT d FROM Direccion d WHERE d.tipo = :tipo"),
    @NamedQuery(name = "Direccion.findByIdCiudadano", query = "SELECT d FROM Direccion d WHERE d.direccion.idCiudadano = :idCiudadano")})
public class Direccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    protected Direccion direccion;
    @Size(max = 20)    
    private String calle;
    @Size(max = 10)    
    private String numero;
    @Size(max = 20)    
    private String sector;
    @Size(max = 20)
    private String ciudad;
    @NotNull
    private String tipo;
    @JoinColumn(name = "idCiudadano", referencedColumnName = "idCiudadano", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ciudadano ciudadano;
    private int idDireccion;
    private int idCiudadano;

    public Direccion() {
    }

    public Direccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Direccion(Direccion direccion, String tipo) {
        this.direccion = direccion;
        this.tipo = tipo;
    }

    public Direccion(int idDireccion, int idCiudadano) {
        this.direccion = new Direccion(idDireccion, idCiudadano);
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }
    
    public void setIdCiudadano(int idCiudadano) {
        this.idCiudadano = idCiudadano;
    }
    
    public int getIdDireccion() {
        return idDireccion;
    }
    
    public int getIdCiudadano() {
        return idCiudadano;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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
        hash += (direccion != null ? direccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) object;
        if ((this.direccion == null && other.direccion != null) || (this.direccion != null && !this.direccion.equals(other.direccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Direccion[ direccion=" + direccion + " ]";
    }
    
}

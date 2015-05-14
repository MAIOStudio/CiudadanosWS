/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dearmartinez
 */
@Entity
@Table(name = "direccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d"),
    @NamedQuery(name = "Direccion.findByIdDireccion", query = "SELECT d FROM Direccion d WHERE d.direccionPK.idDireccion = :idDireccion"),
    @NamedQuery(name = "Direccion.findByCalle", query = "SELECT d FROM Direccion d WHERE d.calle = :calle"),
    @NamedQuery(name = "Direccion.findByNumero", query = "SELECT d FROM Direccion d WHERE d.numero = :numero"),
    @NamedQuery(name = "Direccion.findBySector", query = "SELECT d FROM Direccion d WHERE d.sector = :sector"),
    @NamedQuery(name = "Direccion.findByCiudad", query = "SELECT d FROM Direccion d WHERE d.ciudad = :ciudad"),
    @NamedQuery(name = "Direccion.findByTipo", query = "SELECT d FROM Direccion d WHERE d.tipo = :tipo"),
    @NamedQuery(name = "Direccion.findByIdCiudadano", query = "SELECT d FROM Direccion d WHERE d.direccionPK.idCiudadano = :idCiudadano")})
public class Direccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DireccionPK direccionPK;
    @Size(max = 20)
    @Column(name = "calle")
    private String calle;
    @Size(max = 10)
    @Column(name = "numero")
    private String numero;
    @Size(max = 20)
    @Column(name = "sector")
    private String sector;
    @Size(max = 20)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "idCiudadano", referencedColumnName = "idCiudadano", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ciudadano ciudadano;

    public Direccion() {
    }

    public Direccion(DireccionPK direccionPK) {
        this.direccionPK = direccionPK;
    }

    public Direccion(DireccionPK direccionPK, String tipo) {
        this.direccionPK = direccionPK;
        this.tipo = tipo;
    }

    public Direccion(int idDireccion, int idCiudadano) {
        this.direccionPK = new DireccionPK(idDireccion, idCiudadano);
    }

    public DireccionPK getDireccionPK() {
        return direccionPK;
    }

    public void setDireccionPK(DireccionPK direccionPK) {
        this.direccionPK = direccionPK;
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
        hash += (direccionPK != null ? direccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) object;
        if ((this.direccionPK == null && other.direccionPK != null) || (this.direccionPK != null && !this.direccionPK.equals(other.direccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Direccion[ direccionPK=" + direccionPK + " ]";
    }
    
}

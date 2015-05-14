/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dearmartinez
 */
@Entity
@Table(name = "ciudadano")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudadano.findAll", query = "SELECT c FROM Ciudadano c"),
    @NamedQuery(name = "Ciudadano.findByIdCiudadano", query = "SELECT c FROM Ciudadano c WHERE c.idCiudadano = :idCiudadano"),
    @NamedQuery(name = "Ciudadano.findByNombre", query = "SELECT c FROM Ciudadano c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Ciudadano.findByApellido", query = "SELECT c FROM Ciudadano c WHERE c.apellido = :apellido"),
    @NamedQuery(name = "Ciudadano.findBySexo", query = "SELECT c FROM Ciudadano c WHERE c.sexo = :sexo"),
    @NamedQuery(name = "Ciudadano.findByFechaNacimiento", query = "SELECT c FROM Ciudadano c WHERE c.fechaNacimiento = :fechaNacimiento")})
public class Ciudadano implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCiudadano")
    private Integer idCiudadano;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 10)
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudadano")
    private List<Direccion> direccionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudadano")
    private List<Telefono> telefonoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudadano")
    private List<Email> emailList;

    public Ciudadano() {
    }

    public Ciudadano(Integer idCiudadano) {
        this.idCiudadano = idCiudadano;
    }

    public Ciudadano(Integer idCiudadano, String nombre) {
        this.idCiudadano = idCiudadano;
        this.nombre = nombre;
    }

    public Integer getIdCiudadano() {
        return idCiudadano;
    }

    public void setIdCiudadano(Integer idCiudadano) {
        this.idCiudadano = idCiudadano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @XmlTransient
    public List<Direccion> getDireccionList() {
        return direccionList;
    }

    public void setDireccionList(List<Direccion> direccionList) {
        this.direccionList = direccionList;
    }

    @XmlTransient
    public List<Telefono> getTelefonoList() {
        return telefonoList;
    }

    public void setTelefonoList(List<Telefono> telefonoList) {
        this.telefonoList = telefonoList;
    }

    @XmlTransient
    public List<Email> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<Email> emailList) {
        this.emailList = emailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCiudadano != null ? idCiudadano.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudadano)) {
            return false;
        }
        Ciudadano other = (Ciudadano) object;
        if ((this.idCiudadano == null && other.idCiudadano != null) || (this.idCiudadano != null && !this.idCiudadano.equals(other.idCiudadano))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "entities.Ciudadano[ idCiudadano=" + idCiudadano + " ]";
        return nombre + " " + apellido;
    }
    
}

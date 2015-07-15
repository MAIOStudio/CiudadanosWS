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
    @NamedQuery(name = "Email.findAll", query = "SELECT e FROM Email e"),
    @NamedQuery(name = "Email.findByIdEmail", query = "SELECT e FROM Email e WHERE e.email.idEmail = :idEmail"),
    @NamedQuery(name = "Email.findByEmail", query = "SELECT e FROM Email e WHERE e.email = :email"),
    @NamedQuery(name = "Email.findByTipo", query = "SELECT e FROM Email e WHERE e.tipo = :tipo"),
    @NamedQuery(name = "Email.findByIdCiudadano", query = "SELECT e FROM Email e WHERE e.email.idCiudadano = :idCiudadano")})
public class Email implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    protected Email email;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @NotNull
    private String tipo;
    @JoinColumn(name = "idCiudadano", referencedColumnName = "idCiudadano", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ciudadano ciudadano;
    private int idEmail;
    private int idCiudadano;

    public Email() {
    }

    public Email(Email email) {
        this.email = email;
    }

    public Email(Email email, String tipo) {
        this.email = email;
        this.tipo = tipo;
    }

    public Email(int idEmail, int idCiudadano) {
        this.email = new Email(idEmail, idCiudadano);
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

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
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
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Email)) {
            return false;
        }
        Email other = (Email) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Email[ email=" + email + " ]";
    }
    
}

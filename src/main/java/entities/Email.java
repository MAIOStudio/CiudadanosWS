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
@Table(name = "email")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Email.findAll", query = "SELECT e FROM Email e"),
    @NamedQuery(name = "Email.findByIdEmail", query = "SELECT e FROM Email e WHERE e.emailPK.idEmail = :idEmail"),
    @NamedQuery(name = "Email.findByEmail", query = "SELECT e FROM Email e WHERE e.email = :email"),
    @NamedQuery(name = "Email.findByTipo", query = "SELECT e FROM Email e WHERE e.tipo = :tipo"),
    @NamedQuery(name = "Email.findByIdCiudadano", query = "SELECT e FROM Email e WHERE e.emailPK.idCiudadano = :idCiudadano")})
public class Email implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmailPK emailPK;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "idCiudadano", referencedColumnName = "idCiudadano", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ciudadano ciudadano;

    public Email() {
    }

    public Email(EmailPK emailPK) {
        this.emailPK = emailPK;
    }

    public Email(EmailPK emailPK, String email, String tipo) {
        this.emailPK = emailPK;
        this.email = email;
        this.tipo = tipo;
    }

    public Email(int idEmail, int idCiudadano) {
        this.emailPK = new EmailPK(idEmail, idCiudadano);
    }

    public EmailPK getEmailPK() {
        return emailPK;
    }

    public void setEmailPK(EmailPK emailPK) {
        this.emailPK = emailPK;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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
        hash += (emailPK != null ? emailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Email)) {
            return false;
        }
        Email other = (Email) object;
        if ((this.emailPK == null && other.emailPK != null) || (this.emailPK != null && !this.emailPK.equals(other.emailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Email[ emailPK=" + emailPK + " ]";
    }
    
}

package com.example.historialmedico.serviciosrest;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "hijo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hijo.findAll", query = "SELECT h FROM Hijo h"),
    @NamedQuery(name = "Hijo.findById", query = "SELECT h FROM Hijo h WHERE h.id = :id"),
    @NamedQuery(name = "Hijo.findByNombre", query = "SELECT h FROM Hijo h WHERE h.nombre = :nombre"),
    @NamedQuery(name = "Hijo.findBySexo", query = "SELECT h FROM Hijo h WHERE h.sexo = :sexo"),
    @NamedQuery(name = "Hijo.findByEdad", query = "SELECT h FROM Hijo h WHERE h.edad = :edad"),
    @NamedQuery(name = "Hijo.findByIdPadre", query = "SELECT h FROM Hijo h WHERE h.idPadre = :idPadre")})
public class Hijo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "edad")
    private String edad;    
    @JoinColumn(name = "id_padre", referencedColumnName = "id")
    @ManyToOne
    private Usuario idPadre;
    /*@OneToMany(mappedBy = "idHijo")
    private Collection<Vacuna> vacunaCollection;*/

    public Hijo() {
    }

    public Hijo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
/*
    @XmlTransient
    public Collection<Vacuna> getVacunaCollection() {
        return vacunaCollection;
    }

    public void setVacunaCollection(Collection<Vacuna> vacunaCollection) {
        this.vacunaCollection = vacunaCollection;
    }*/

    public Usuario getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Usuario idPadre) {
        this.idPadre = idPadre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hijo)) {
            return false;
        }
        Hijo other = (Hijo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Hijo[ id=" + id + " ]";
    }

}

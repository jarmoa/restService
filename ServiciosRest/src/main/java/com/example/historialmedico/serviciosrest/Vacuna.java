package com.example.historialmedico.serviciosrest;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "vacuna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacuna.findAll", query = "SELECT v FROM Vacuna v"),
    @NamedQuery(name = "Vacuna.findById", query = "SELECT v FROM Vacuna v WHERE v.id = :id"),
    @NamedQuery(name = "Vacuna.findByNombre", query = "SELECT v FROM Vacuna v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "Vacuna.findByFecha", query = "SELECT v FROM Vacuna v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "Vacuna.findByAplicada", query = "SELECT v FROM Vacuna v WHERE v.aplicada = :aplicada")})
public class Vacuna implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "aplicada")
    private String aplicada;
    @JoinColumn(name = "id_hijo", referencedColumnName = "id")
    @ManyToOne
    private Hijo idHijo;

    public Vacuna() {
    }

    public Vacuna(Integer id) {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getAplicada() {
        return aplicada;
    }

    public void setAplicada(String aplicada) {
        this.aplicada = aplicada;
    }

    public Hijo getIdHijo() {
        return idHijo;
    }

    public void setIdHijo(Hijo idHijo) {
        this.idHijo = idHijo;
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
        if (!(object instanceof Vacuna)) {
            return false;
        }
        Vacuna other = (Vacuna) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vacuna[ id=" + id + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kunturar.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author Ing. David Salcedo <kunturardevelopers@gmail.com> Kuntur AR.
 */
@Entity
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")
    , @NamedQuery(name = "Empresa.findByIdEmpresa", query = "SELECT e FROM Empresa e WHERE e.idEmpresa = :idEmpresa")
    , @NamedQuery(name = "Empresa.findByNombreEmp", query = "SELECT e FROM Empresa e WHERE e.nombreEmp = :nombreEmp")
    , @NamedQuery(name = "Empresa.findBySloganEmp", query = "SELECT e FROM Empresa e WHERE e.sloganEmp = :sloganEmp")
    , @NamedQuery(name = "Empresa.findByDescripcionEmp", query = "SELECT e FROM Empresa e WHERE e.descripcionEmp = :descripcionEmp")
    , @NamedQuery(name = "Empresa.findByDireccionEmp", query = "SELECT e FROM Empresa e WHERE e.direccionEmp = :direccionEmp")
    , @NamedQuery(name = "Empresa.findByTelefonoEmp", query = "SELECT e FROM Empresa e WHERE e.telefonoEmp = :telefonoEmp")
    , @NamedQuery(name = "Empresa.findByCelularEmp", query = "SELECT e FROM Empresa e WHERE e.celularEmp = :celularEmp")
    , @NamedQuery(name = "Empresa.findByCorreoEmp", query = "SELECT e FROM Empresa e WHERE e.correoEmp = :correoEmp")
    , @NamedQuery(name = "Empresa.findByEstadoEmp", query = "SELECT e FROM Empresa e WHERE e.estadoEmp = :estadoEmp")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empresa")
    private Integer idEmpresa;
    @Size(max = 120)
    @Column(name = "nombre_emp")
    private String nombreEmp;
    @Size(max = 200)
    @Column(name = "slogan_emp")
    private String sloganEmp;
    @Size(max = 5000)
    @Column(name = "descripcion_emp")
    private String descripcionEmp;
    @Size(max = 200)
    @Column(name = "direccion_emp")
    private String direccionEmp;
    @Size(max = 12)
    @Column(name = "telefono_emp")
    private String telefonoEmp;
    @Size(max = 14)
    @Column(name = "celular_emp")
    private String celularEmp;
    @Size(max = 50)
    @Column(name = "correo_emp")
    private String correoEmp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_emp")
    private boolean estadoEmp;
    @JoinColumn(name = "id_imagen", referencedColumnName = "id_imagen")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Imagen idImagen;

    public Empresa() {
    }

    public Empresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Empresa(Integer idEmpresa, boolean estadoEmp) {
        this.idEmpresa = idEmpresa;
        this.estadoEmp = estadoEmp;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmp() {
        return nombreEmp;
    }

    public void setNombreEmp(String nombreEmp) {
        this.nombreEmp = nombreEmp;
    }

    public String getSloganEmp() {
        return sloganEmp;
    }

    public void setSloganEmp(String sloganEmp) {
        this.sloganEmp = sloganEmp;
    }

    public String getDescripcionEmp() {
        return descripcionEmp;
    }

    public void setDescripcionEmp(String descripcionEmp) {
        this.descripcionEmp = descripcionEmp;
    }

    public String getDireccionEmp() {
        return direccionEmp;
    }

    public void setDireccionEmp(String direccionEmp) {
        this.direccionEmp = direccionEmp;
    }

    public String getTelefonoEmp() {
        return telefonoEmp;
    }

    public void setTelefonoEmp(String telefonoEmp) {
        this.telefonoEmp = telefonoEmp;
    }

    public String getCelularEmp() {
        return celularEmp;
    }

    public void setCelularEmp(String celularEmp) {
        this.celularEmp = celularEmp;
    }

    public String getCorreoEmp() {
        return correoEmp;
    }

    public void setCorreoEmp(String correoEmp) {
        this.correoEmp = correoEmp;
    }

    public boolean getEstadoEmp() {
        return estadoEmp;
    }

    public void setEstadoEmp(boolean estadoEmp) {
        this.estadoEmp = estadoEmp;
    }

    public Imagen getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Imagen idImagen) {
        this.idImagen = idImagen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kunturar.modelo.Empresa[ idEmpresa=" + idEmpresa + " ]";
    }
    
}

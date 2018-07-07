/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kunturar.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author Ing. David Salcedo <kunturardevelopers@gmail.com> Kuntur AR.
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByIdPersona", query = "SELECT p FROM Persona p WHERE p.idPersona = :idPersona")
    , @NamedQuery(name = "Persona.findByNombrePer", query = "SELECT p FROM Persona p WHERE p.nombrePer = :nombrePer")
    , @NamedQuery(name = "Persona.findByApellidoPer", query = "SELECT p FROM Persona p WHERE p.apellidoPer = :apellidoPer")
    , @NamedQuery(name = "Persona.findByCedulaPer", query = "SELECT p FROM Persona p WHERE p.cedulaPer = :cedulaPer")
    , @NamedQuery(name = "Persona.findByFechanacimientoPer", query = "SELECT p FROM Persona p WHERE p.fechanacimientoPer = :fechanacimientoPer")
    , @NamedQuery(name = "Persona.findByDireccionPer", query = "SELECT p FROM Persona p WHERE p.direccionPer = :direccionPer")
    , @NamedQuery(name = "Persona.findByCelularPer", query = "SELECT p FROM Persona p WHERE p.celularPer = :celularPer")
    , @NamedQuery(name = "Persona.findByTelefonoPer", query = "SELECT p FROM Persona p WHERE p.telefonoPer = :telefonoPer")
    , @NamedQuery(name = "Persona.findByCorreoUsu", query = "SELECT p FROM Persona p WHERE p.correoUsu = :correoUsu")
    , @NamedQuery(name = "Persona.findByEstadoUsu", query = "SELECT p FROM Persona p WHERE p.estadoUsu = :estadoUsu")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_persona")
    private Integer idPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_per")
    private String nombrePer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellido_per")
    private String apellidoPer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "cedula_per")
    private String cedulaPer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechanacimiento_per")
    @Temporal(TemporalType.DATE)
    private Date fechanacimientoPer;
    @Size(max = 500)
    @Column(name = "direccion_per")
    private String direccionPer;
    @Size(max = 10)
    @Column(name = "celular_per")
    private String celularPer;
    @Size(max = 10)
    @Column(name = "telefono_per")
    private String telefonoPer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "correo_usu")
    private String correoUsu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_usu")
    private boolean estadoUsu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona", fetch = FetchType.LAZY)
    private List<Venta> ventaList;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Rol idRol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona", fetch = FetchType.LAZY)
    private List<Usuario> usuarioList;

    public Persona() {
    }

    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(Integer idPersona, String nombrePer, String apellidoPer, String cedulaPer, Date fechanacimientoPer, String correoUsu, boolean estadoUsu) {
        this.idPersona = idPersona;
        this.nombrePer = nombrePer;
        this.apellidoPer = apellidoPer;
        this.cedulaPer = cedulaPer;
        this.fechanacimientoPer = fechanacimientoPer;
        this.correoUsu = correoUsu;
        this.estadoUsu = estadoUsu;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePer() {
        return nombrePer;
    }

    public void setNombrePer(String nombrePer) {
        this.nombrePer = nombrePer;
    }

    public String getApellidoPer() {
        return apellidoPer;
    }

    public void setApellidoPer(String apellidoPer) {
        this.apellidoPer = apellidoPer;
    }

    public String getCedulaPer() {
        return cedulaPer;
    }

    public void setCedulaPer(String cedulaPer) {
        this.cedulaPer = cedulaPer;
    }

    public Date getFechanacimientoPer() {
        return fechanacimientoPer;
    }

    public void setFechanacimientoPer(Date fechanacimientoPer) {
        this.fechanacimientoPer = fechanacimientoPer;
    }

    public String getDireccionPer() {
        return direccionPer;
    }

    public void setDireccionPer(String direccionPer) {
        this.direccionPer = direccionPer;
    }

    public String getCelularPer() {
        return celularPer;
    }

    public void setCelularPer(String celularPer) {
        this.celularPer = celularPer;
    }

    public String getTelefonoPer() {
        return telefonoPer;
    }

    public void setTelefonoPer(String telefonoPer) {
        this.telefonoPer = telefonoPer;
    }

    public String getCorreoUsu() {
        return correoUsu;
    }

    public void setCorreoUsu(String correoUsu) {
        this.correoUsu = correoUsu;
    }

    public boolean getEstadoUsu() {
        return estadoUsu;
    }

    public void setEstadoUsu(boolean estadoUsu) {
        this.estadoUsu = estadoUsu;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kunturar.modelo.Persona[ idPersona=" + idPersona + " ]";
    }
    
}

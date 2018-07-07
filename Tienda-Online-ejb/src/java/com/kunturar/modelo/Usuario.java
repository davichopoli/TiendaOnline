/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kunturar.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ing. David Salcedo <kunturardevelopers@gmail.com> Kuntur AR.
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuario.findByNombreUsu", query = "SELECT u FROM Usuario u WHERE u.nombreUsu = :nombreUsu")
    , @NamedQuery(name = "Usuario.findByContrasenaUsu", query = "SELECT u FROM Usuario u WHERE u.contrasenaUsu = :contrasenaUsu")
    , @NamedQuery(name = "Usuario.findByFechaUsu", query = "SELECT u FROM Usuario u WHERE u.fechaUsu = :fechaUsu")
    , @NamedQuery(name = "Usuario.findByVerificarUsu", query = "SELECT u FROM Usuario u WHERE u.verificarUsu = :verificarUsu")
    , @NamedQuery(name = "Usuario.findByCambioContrasenaUsu", query = "SELECT u FROM Usuario u WHERE u.cambioContrasenaUsu = :cambioContrasenaUsu")
    , @NamedQuery(name = "Usuario.findByEstadoUsu", query = "SELECT u FROM Usuario u WHERE u.estadoUsu = :estadoUsu")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_usu")
    private String nombreUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "contrasena_usu")
    private String contrasenaUsu;
    @Column(name = "fecha_usu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUsu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "verificar_usu")
    private boolean verificarUsu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cambio_contrasena_usu")
    private boolean cambioContrasenaUsu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_usu")
    private boolean estadoUsu;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona idPersona;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String nombreUsu, String contrasenaUsu, boolean verificarUsu, boolean cambioContrasenaUsu, boolean estadoUsu) {
        this.idUsuario = idUsuario;
        this.nombreUsu = nombreUsu;
        this.contrasenaUsu = contrasenaUsu;
        this.verificarUsu = verificarUsu;
        this.cambioContrasenaUsu = cambioContrasenaUsu;
        this.estadoUsu = estadoUsu;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsu() {
        return nombreUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    public String getContrasenaUsu() {
        return contrasenaUsu;
    }

    public void setContrasenaUsu(String contrasenaUsu) {
        this.contrasenaUsu = contrasenaUsu;
    }

    public Date getFechaUsu() {
        return fechaUsu;
    }

    public void setFechaUsu(Date fechaUsu) {
        this.fechaUsu = fechaUsu;
    }

    public boolean getVerificarUsu() {
        return verificarUsu;
    }

    public void setVerificarUsu(boolean verificarUsu) {
        this.verificarUsu = verificarUsu;
    }

    public boolean getCambioContrasenaUsu() {
        return cambioContrasenaUsu;
    }

    public void setCambioContrasenaUsu(boolean cambioContrasenaUsu) {
        this.cambioContrasenaUsu = cambioContrasenaUsu;
    }

    public boolean getEstadoUsu() {
        return estadoUsu;
    }

    public void setEstadoUsu(boolean estadoUsu) {
        this.estadoUsu = estadoUsu;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kunturar.modelo.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}

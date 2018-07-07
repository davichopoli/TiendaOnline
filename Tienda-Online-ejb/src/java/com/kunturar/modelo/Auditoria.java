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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "auditoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auditoria.findAll", query = "SELECT a FROM Auditoria a")
    , @NamedQuery(name = "Auditoria.findByIdAuditoria", query = "SELECT a FROM Auditoria a WHERE a.idAuditoria = :idAuditoria")
    , @NamedQuery(name = "Auditoria.findByIdUsuario", query = "SELECT a FROM Auditoria a WHERE a.idUsuario = :idUsuario")
    , @NamedQuery(name = "Auditoria.findByDescripcionAud", query = "SELECT a FROM Auditoria a WHERE a.descripcionAud = :descripcionAud")
    , @NamedQuery(name = "Auditoria.findBySentenciaAud", query = "SELECT a FROM Auditoria a WHERE a.sentenciaAud = :sentenciaAud")
    , @NamedQuery(name = "Auditoria.findByFechaAud", query = "SELECT a FROM Auditoria a WHERE a.fechaAud = :fechaAud")})
public class Auditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_auditoria")
    private Integer idAuditoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "id_usuario")
    private String idUsuario;
    @Size(max = 50)
    @Column(name = "descripcion_aud")
    private String descripcionAud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "sentencia_aud")
    private String sentenciaAud;
    @Column(name = "fecha_aud")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAud;

    public Auditoria() {
    }

    public Auditoria(Integer idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public Auditoria(Integer idAuditoria, String idUsuario, String sentenciaAud) {
        this.idAuditoria = idAuditoria;
        this.idUsuario = idUsuario;
        this.sentenciaAud = sentenciaAud;
    }

    public Integer getIdAuditoria() {
        return idAuditoria;
    }

    public void setIdAuditoria(Integer idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDescripcionAud() {
        return descripcionAud;
    }

    public void setDescripcionAud(String descripcionAud) {
        this.descripcionAud = descripcionAud;
    }

    public String getSentenciaAud() {
        return sentenciaAud;
    }

    public void setSentenciaAud(String sentenciaAud) {
        this.sentenciaAud = sentenciaAud;
    }

    public Date getFechaAud() {
        return fechaAud;
    }

    public void setFechaAud(Date fechaAud) {
        this.fechaAud = fechaAud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAuditoria != null ? idAuditoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auditoria)) {
            return false;
        }
        Auditoria other = (Auditoria) object;
        if ((this.idAuditoria == null && other.idAuditoria != null) || (this.idAuditoria != null && !this.idAuditoria.equals(other.idAuditoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kunturar.modelo.Auditoria[ idAuditoria=" + idAuditoria + " ]";
    }
    
}

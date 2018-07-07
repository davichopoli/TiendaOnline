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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "parametros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametros.findAll", query = "SELECT p FROM Parametros p")
    , @NamedQuery(name = "Parametros.findByIdParametro", query = "SELECT p FROM Parametros p WHERE p.idParametro = :idParametro")
    , @NamedQuery(name = "Parametros.findByDescripcionParam", query = "SELECT p FROM Parametros p WHERE p.descripcionParam = :descripcionParam")
    , @NamedQuery(name = "Parametros.findByValorParam", query = "SELECT p FROM Parametros p WHERE p.valorParam = :valorParam")
    , @NamedQuery(name = "Parametros.findByEstadoParam", query = "SELECT p FROM Parametros p WHERE p.estadoParam = :estadoParam")})
public class Parametros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_parametro")
    private Integer idParametro;
    @Size(max = 100)
    @Column(name = "descripcion_param")
    private String descripcionParam;
    @Column(name = "valor_param")
    private Integer valorParam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_param")
    private boolean estadoParam;

    public Parametros() {
    }

    public Parametros(Integer idParametro) {
        this.idParametro = idParametro;
    }

    public Parametros(Integer idParametro, boolean estadoParam) {
        this.idParametro = idParametro;
        this.estadoParam = estadoParam;
    }

    public Integer getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(Integer idParametro) {
        this.idParametro = idParametro;
    }

    public String getDescripcionParam() {
        return descripcionParam;
    }

    public void setDescripcionParam(String descripcionParam) {
        this.descripcionParam = descripcionParam;
    }

    public Integer getValorParam() {
        return valorParam;
    }

    public void setValorParam(Integer valorParam) {
        this.valorParam = valorParam;
    }

    public boolean getEstadoParam() {
        return estadoParam;
    }

    public void setEstadoParam(boolean estadoParam) {
        this.estadoParam = estadoParam;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParametro != null ? idParametro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametros)) {
            return false;
        }
        Parametros other = (Parametros) object;
        if ((this.idParametro == null && other.idParametro != null) || (this.idParametro != null && !this.idParametro.equals(other.idParametro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kunturar.modelo.Parametros[ idParametro=" + idParametro + " ]";
    }
    
}

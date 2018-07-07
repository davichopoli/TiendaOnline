/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kunturar.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ing. David Salcedo <kunturardevelopers@gmail.com> Kuntur AR.
 */
@Entity
@Table(name = "promocion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promocion.findAll", query = "SELECT p FROM Promocion p")
    , @NamedQuery(name = "Promocion.findByIdPromocion", query = "SELECT p FROM Promocion p WHERE p.idPromocion = :idPromocion")
    , @NamedQuery(name = "Promocion.findByDescripcionProm", query = "SELECT p FROM Promocion p WHERE p.descripcionProm = :descripcionProm")
    , @NamedQuery(name = "Promocion.findByCantidadProm", query = "SELECT p FROM Promocion p WHERE p.cantidadProm = :cantidadProm")
    , @NamedQuery(name = "Promocion.findByPorcentajeProm", query = "SELECT p FROM Promocion p WHERE p.porcentajeProm = :porcentajeProm")
    , @NamedQuery(name = "Promocion.findByEstadoProm", query = "SELECT p FROM Promocion p WHERE p.estadoProm = :estadoProm")})
public class Promocion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_promocion")
    private Integer idPromocion;
    @Size(max = 200)
    @Column(name = "descripcion_prom")
    private String descripcionProm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_prom")
    private int cantidadProm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porcentaje_prom")
    private int porcentajeProm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_prom")
    private boolean estadoProm;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPromocion", fetch = FetchType.LAZY)
    private List<ProductoPromocion> productoPromocionList;

    public Promocion() {
    }

    public Promocion(Integer idPromocion) {
        this.idPromocion = idPromocion;
    }

    public Promocion(Integer idPromocion, int cantidadProm, int porcentajeProm, boolean estadoProm) {
        this.idPromocion = idPromocion;
        this.cantidadProm = cantidadProm;
        this.porcentajeProm = porcentajeProm;
        this.estadoProm = estadoProm;
    }

    public Integer getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(Integer idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getDescripcionProm() {
        return descripcionProm;
    }

    public void setDescripcionProm(String descripcionProm) {
        this.descripcionProm = descripcionProm;
    }

    public int getCantidadProm() {
        return cantidadProm;
    }

    public void setCantidadProm(int cantidadProm) {
        this.cantidadProm = cantidadProm;
    }

    public int getPorcentajeProm() {
        return porcentajeProm;
    }

    public void setPorcentajeProm(int porcentajeProm) {
        this.porcentajeProm = porcentajeProm;
    }

    public boolean getEstadoProm() {
        return estadoProm;
    }

    public void setEstadoProm(boolean estadoProm) {
        this.estadoProm = estadoProm;
    }

    @XmlTransient
    public List<ProductoPromocion> getProductoPromocionList() {
        return productoPromocionList;
    }

    public void setProductoPromocionList(List<ProductoPromocion> productoPromocionList) {
        this.productoPromocionList = productoPromocionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPromocion != null ? idPromocion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promocion)) {
            return false;
        }
        Promocion other = (Promocion) object;
        if ((this.idPromocion == null && other.idPromocion != null) || (this.idPromocion != null && !this.idPromocion.equals(other.idPromocion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kunturar.modelo.Promocion[ idPromocion=" + idPromocion + " ]";
    }
    
}

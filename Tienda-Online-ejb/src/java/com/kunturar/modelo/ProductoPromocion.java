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
@Table(name = "producto_promocion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoPromocion.findAll", query = "SELECT p FROM ProductoPromocion p")
    , @NamedQuery(name = "ProductoPromocion.findByIdProdProm", query = "SELECT p FROM ProductoPromocion p WHERE p.idProdProm = :idProdProm")
    , @NamedQuery(name = "ProductoPromocion.findByVigenciaProdProm", query = "SELECT p FROM ProductoPromocion p WHERE p.vigenciaProdProm = :vigenciaProdProm")
    , @NamedQuery(name = "ProductoPromocion.findByEstadoProdProm", query = "SELECT p FROM ProductoPromocion p WHERE p.estadoProdProm = :estadoProdProm")})
public class ProductoPromocion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prod_prom")
    private Integer idProdProm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "vigencia_prod_prom")
    private String vigenciaProdProm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_prod_prom")
    private boolean estadoProdProm;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto idProducto;
    @JoinColumn(name = "id_promocion", referencedColumnName = "id_promocion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Promocion idPromocion;

    public ProductoPromocion() {
    }

    public ProductoPromocion(Integer idProdProm) {
        this.idProdProm = idProdProm;
    }

    public ProductoPromocion(Integer idProdProm, String vigenciaProdProm, boolean estadoProdProm) {
        this.idProdProm = idProdProm;
        this.vigenciaProdProm = vigenciaProdProm;
        this.estadoProdProm = estadoProdProm;
    }

    public Integer getIdProdProm() {
        return idProdProm;
    }

    public void setIdProdProm(Integer idProdProm) {
        this.idProdProm = idProdProm;
    }

    public String getVigenciaProdProm() {
        return vigenciaProdProm;
    }

    public void setVigenciaProdProm(String vigenciaProdProm) {
        this.vigenciaProdProm = vigenciaProdProm;
    }

    public boolean getEstadoProdProm() {
        return estadoProdProm;
    }

    public void setEstadoProdProm(boolean estadoProdProm) {
        this.estadoProdProm = estadoProdProm;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Promocion getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(Promocion idPromocion) {
        this.idPromocion = idPromocion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProdProm != null ? idProdProm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoPromocion)) {
            return false;
        }
        ProductoPromocion other = (ProductoPromocion) object;
        if ((this.idProdProm == null && other.idProdProm != null) || (this.idProdProm != null && !this.idProdProm.equals(other.idProdProm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kunturar.modelo.ProductoPromocion[ idProdProm=" + idProdProm + " ]";
    }
    
}

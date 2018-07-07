/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kunturar.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ing. David Salcedo <kunturardevelopers@gmail.com> Kuntur AR.
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto")
    , @NamedQuery(name = "Producto.findByNombreProd", query = "SELECT p FROM Producto p WHERE p.nombreProd = :nombreProd")
    , @NamedQuery(name = "Producto.findByDescripcioncortaProd", query = "SELECT p FROM Producto p WHERE p.descripcioncortaProd = :descripcioncortaProd")
    , @NamedQuery(name = "Producto.findByDescripcionlargaProd", query = "SELECT p FROM Producto p WHERE p.descripcionlargaProd = :descripcionlargaProd")
    , @NamedQuery(name = "Producto.findByStockProd", query = "SELECT p FROM Producto p WHERE p.stockProd = :stockProd")
    , @NamedQuery(name = "Producto.findByPreciocompraProd", query = "SELECT p FROM Producto p WHERE p.preciocompraProd = :preciocompraProd")
    , @NamedQuery(name = "Producto.findByPrecioventaProd", query = "SELECT p FROM Producto p WHERE p.precioventaProd = :precioventaProd")
    , @NamedQuery(name = "Producto.findByCodigoProd", query = "SELECT p FROM Producto p WHERE p.codigoProd = :codigoProd")
    , @NamedQuery(name = "Producto.findByAplicaIva", query = "SELECT p FROM Producto p WHERE p.aplicaIva = :aplicaIva")
    , @NamedQuery(name = "Producto.findByEstadoProd", query = "SELECT p FROM Producto p WHERE p.estadoProd = :estadoProd")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre_prod")
    private String nombreProd;
    @Size(max = 300)
    @Column(name = "descripcioncorta_prod")
    private String descripcioncortaProd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "descripcionlarga_prod")
    private String descripcionlargaProd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock_prod")
    private int stockProd;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "preciocompra_prod")
    private BigDecimal preciocompraProd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioventa_prod")
    private BigDecimal precioventaProd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "codigo_prod")
    private String codigoProd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "aplica_iva")
    private String aplicaIva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_prod")
    private boolean estadoProd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto", fetch = FetchType.LAZY)
    private List<ProductoPromocion> productoPromocionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto", fetch = FetchType.LAZY)
    private List<Imagen> imagenList;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categoria idCategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto", fetch = FetchType.LAZY)
    private List<Detalle> detalleList;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Integer idProducto, String nombreProd, String descripcionlargaProd, int stockProd, BigDecimal preciocompraProd, BigDecimal precioventaProd, String codigoProd, String aplicaIva, boolean estadoProd) {
        this.idProducto = idProducto;
        this.nombreProd = nombreProd;
        this.descripcionlargaProd = descripcionlargaProd;
        this.stockProd = stockProd;
        this.preciocompraProd = preciocompraProd;
        this.precioventaProd = precioventaProd;
        this.codigoProd = codigoProd;
        this.aplicaIva = aplicaIva;
        this.estadoProd = estadoProd;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public String getDescripcioncortaProd() {
        return descripcioncortaProd;
    }

    public void setDescripcioncortaProd(String descripcioncortaProd) {
        this.descripcioncortaProd = descripcioncortaProd;
    }

    public String getDescripcionlargaProd() {
        return descripcionlargaProd;
    }

    public void setDescripcionlargaProd(String descripcionlargaProd) {
        this.descripcionlargaProd = descripcionlargaProd;
    }

    public int getStockProd() {
        return stockProd;
    }

    public void setStockProd(int stockProd) {
        this.stockProd = stockProd;
    }

    public BigDecimal getPreciocompraProd() {
        return preciocompraProd;
    }

    public void setPreciocompraProd(BigDecimal preciocompraProd) {
        this.preciocompraProd = preciocompraProd;
    }

    public BigDecimal getPrecioventaProd() {
        return precioventaProd;
    }

    public void setPrecioventaProd(BigDecimal precioventaProd) {
        this.precioventaProd = precioventaProd;
    }

    public String getCodigoProd() {
        return codigoProd;
    }

    public void setCodigoProd(String codigoProd) {
        this.codigoProd = codigoProd;
    }

    public String getAplicaIva() {
        return aplicaIva;
    }

    public void setAplicaIva(String aplicaIva) {
        this.aplicaIva = aplicaIva;
    }

    public boolean getEstadoProd() {
        return estadoProd;
    }

    public void setEstadoProd(boolean estadoProd) {
        this.estadoProd = estadoProd;
    }

    @XmlTransient
    public List<ProductoPromocion> getProductoPromocionList() {
        return productoPromocionList;
    }

    public void setProductoPromocionList(List<ProductoPromocion> productoPromocionList) {
        this.productoPromocionList = productoPromocionList;
    }

    @XmlTransient
    public List<Imagen> getImagenList() {
        return imagenList;
    }

    public void setImagenList(List<Imagen> imagenList) {
        this.imagenList = imagenList;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    @XmlTransient
    public List<Detalle> getDetalleList() {
        return detalleList;
    }

    public void setDetalleList(List<Detalle> detalleList) {
        this.detalleList = detalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kunturar.modelo.Producto[ idProducto=" + idProducto + " ]";
    }
    
}

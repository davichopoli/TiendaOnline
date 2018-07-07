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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ing. David Salcedo <kunturardevelopers@gmail.com> Kuntur AR.
 */
@Entity
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
    , @NamedQuery(name = "Categoria.findByIdCategoria", query = "SELECT c FROM Categoria c WHERE c.idCategoria = :idCategoria")
    , @NamedQuery(name = "Categoria.findByNombreCat", query = "SELECT c FROM Categoria c WHERE c.nombreCat = :nombreCat")
    , @NamedQuery(name = "Categoria.findByPaginaCat", query = "SELECT c FROM Categoria c WHERE c.paginaCat = :paginaCat")
    , @NamedQuery(name = "Categoria.findByOrdenCat", query = "SELECT c FROM Categoria c WHERE c.ordenCat = :ordenCat")
    , @NamedQuery(name = "Categoria.findByNodofinalCat", query = "SELECT c FROM Categoria c WHERE c.nodofinalCat = :nodofinalCat")
    , @NamedQuery(name = "Categoria.findByEstadoCat", query = "SELECT c FROM Categoria c WHERE c.estadoCat = :estadoCat")})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria")
    private Integer idCategoria;
    @Size(max = 120)
    @Column(name = "nombre_cat")
    private String nombreCat;
    @Size(max = 120)
    @Column(name = "pagina_cat")
    private String paginaCat;
    @Column(name = "orden_cat")
    private Short ordenCat;
    @Column(name = "nodofinal_cat")
    private Boolean nodofinalCat;
    @Column(name = "estado_cat")
    private Boolean estadoCat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoriaPadre", fetch = FetchType.LAZY)
    private List<Categoria> categoriaList;
    @JoinColumn(name = "id_categoria_padre", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categoria idCategoriaPadre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoria", fetch = FetchType.LAZY)
    private List<Producto> productoList;

    public Categoria() {
    }

    public Categoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCat() {
        return nombreCat;
    }

    public void setNombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }

    public String getPaginaCat() {
        return paginaCat;
    }

    public void setPaginaCat(String paginaCat) {
        this.paginaCat = paginaCat;
    }

    public Short getOrdenCat() {
        return ordenCat;
    }

    public void setOrdenCat(Short ordenCat) {
        this.ordenCat = ordenCat;
    }

    public Boolean getNodofinalCat() {
        return nodofinalCat;
    }

    public void setNodofinalCat(Boolean nodofinalCat) {
        this.nodofinalCat = nodofinalCat;
    }

    public Boolean getEstadoCat() {
        return estadoCat;
    }

    public void setEstadoCat(Boolean estadoCat) {
        this.estadoCat = estadoCat;
    }

    @XmlTransient
    public List<Categoria> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<Categoria> categoriaList) {
        this.categoriaList = categoriaList;
    }

    public Categoria getIdCategoriaPadre() {
        return idCategoriaPadre;
    }

    public void setIdCategoriaPadre(Categoria idCategoriaPadre) {
        this.idCategoriaPadre = idCategoriaPadre;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kunturar.modelo.Categoria[ idCategoria=" + idCategoria + " ]";
    }
    
}

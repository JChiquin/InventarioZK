/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Ysidro Fernandez
 */
@Entity
@Table
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="my_entity_seq_gen")
    @SequenceGenerator(name="my_entity_seq_gen", sequenceName="Producto_seq")
    @Column(name="ID_PRODUCTO")
    private int id_producto;
    @Column(name="CODIGO")
    private String codigo;
    @Column(name="NOMBRE")
    private String nombre;
    @Column(name="DESCRIPCION")
    private String descripcion;
    @Column(name="STOCK")
    private int stock;
    @Column(name="PRECIO_COMPRA")
    private double precio_compra;
    @Column(name="PRECIO_VENTA")
    private double precio_venta;
    @Column(name="ESTATUS")
    private char estatus='A';

    @OneToMany(mappedBy = "producto",fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL})
    private Set<Detalle_Factura> lista_detalle = new HashSet();
    
    @OneToMany(mappedBy = "producto",fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL})
    private Set<Historial> lista_historial = new HashSet();
    
    @OneToMany(mappedBy = "producto",fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL})
    private Set<Temporal> lista_temporal = new HashSet();
    
    @ManyToMany(cascade={javax.persistence.CascadeType.ALL}, fetch=FetchType.LAZY)
    @JoinTable(name="Producto_Proveedor", joinColumns={@JoinColumn(name="PRODUCTO", referencedColumnName="ID_PRODUCTO")}, inverseJoinColumns={@JoinColumn(name="PROVEEDOR", referencedColumnName="ID_PROVEEDOR")})
    private Set<Proveedor> proveedores = new HashSet();
    
    public Producto() {
    }

    public Producto(int id_producto, String codigo, String nombre, String descripcion, int stack, Date dia_adquirido, double precio_compra, double precio_venta, char estatus) {
        this.id_producto = id_producto;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stack;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.estatus = estatus;
        
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public Set<Detalle_Factura> getLista_detalle() {
        return lista_detalle;
    }

    public void setLista_detalle(Set<Detalle_Factura> lista_detalle) {
        this.lista_detalle = lista_detalle;
    }

    public Set<Historial> getLista_historial() {
        return lista_historial;
    }

    public void setLista_historial(Set<Historial> lista_historial) {
        this.lista_historial = lista_historial;
    }

    public Set<Temporal> getLista_temporal() {
        return lista_temporal;
    }

    public void setLista_temporal(Set<Temporal> lista_temporal) {
        this.lista_temporal = lista_temporal;
    }

    public Set<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(Set<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }
    
    
    
    
}

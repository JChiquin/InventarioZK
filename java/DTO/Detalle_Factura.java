/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Ysidro Fernandez
 */
@Entity
@Table
public class Detalle_Factura implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="my_entity_seq_gen")
    @SequenceGenerator(name="my_entity_seq_gen", sequenceName="Detalle_Factura_seq")
    @Column(name="ID_DETALLE")
    private int id_detalle;
    @Column(name="CANTIDAD")
    private int cantidad;
    @Column(name="PRECIO_VENTA")
    private double precio_venta;
    @Column(name="ESTATUS")
    private char estatus;

    @ManyToOne(fetch=FetchType.EAGER, cascade={javax.persistence.CascadeType.ALL})
    @JoinColumn(name="FACTURA")
    private Factura factura;
    
    @ManyToOne(fetch=FetchType.EAGER, cascade={javax.persistence.CascadeType.ALL})
    @JoinColumn(name="PRODUCTO")
    private Producto producto;

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_venta() {
        return precio_venta;
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

    public Detalle_Factura() {
    }

    public Detalle_Factura(int id_detalle, int cantidad, double precio_venta, char estatus) {
        this.id_detalle = id_detalle;
        this.cantidad = cantidad;
        this.precio_venta = precio_venta;
        this.estatus = estatus;
    }
    
    public double precioTotal(){
        return cantidad*precio_venta;
    }
    
}

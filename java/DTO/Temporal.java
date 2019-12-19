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
public class Temporal implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="my_entity_seq_gen")
    @SequenceGenerator(name="my_entity_seq_gen", sequenceName="Temporal_seq")
    @Column(name="ID_TEMPORAL")
    private int id_temporal;
    @Column(name="CANTIDAD")
    private int cantidad;
    @Column(name="PRECIO")
    private double precio;
    @Column(name="ESTATUS")
    private char estatus;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="PRODUCTO")
    private Producto producto;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public Temporal() {
    }

    public Temporal(int id_temporal, int cantidad, double precio, char estatus) {
        this.id_temporal = id_temporal;
        this.cantidad = cantidad;
        this.precio = precio;
        this.estatus = estatus;
    }

    public int getId_temporal() {
        return id_temporal;
    }

    public void setId_temporal(int id_temporal) {
        this.id_temporal = id_temporal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }
    
    
    
}

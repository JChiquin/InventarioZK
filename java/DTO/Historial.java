/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.util.Date;
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
public class Historial implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="my_entity_seq_gen")
    @SequenceGenerator(name="my_entity_seq_gen", sequenceName="Historial_seq")
    @Column(name="ID_HISTORIA")
    private int id_historia;
    @Column(name="NOTA")
    private String nota;
    @Column(name="REFERENCIA")
    private String referencia;
    @Column(name="CANTIDAD")
    private int cantidad;
    @Column(name="FECHA")
    private Date fecha;
    @Column(name="COSTO")
    private double costo;
    @Column(name="ESTATUS")
    private char estatus;
    
    
    
    //Asocioacion Muchos a Uno con Usuario
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="USUARIO")
    private Usuario usuario;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="PRODUCTO")
    private Producto producto;

    
    
    public Historial() {
    }

    public Historial(int id_historia, String nota, String referencia, int cantidad, Date fecha, double costo, char estatus) {
        this.id_historia = id_historia;
        this.nota = nota;
        this.referencia = referencia;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.costo = costo;
        this.estatus = estatus;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getId_historia() {
        return id_historia;
    }

    public void setId_historia(int id_historia) {
        this.id_historia = id_historia;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Ysidro Fernandez
 */
@Entity
@Table
public class Proveedor implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="my_entity_seq_gen")
    @SequenceGenerator(name="my_entity_seq_gen", sequenceName="Proveedor_seq")
    @Column(name="ID_PROVEEDOR")
    private int id_proveedor;
    @Column(name="RIF")
    private String rif;
    @Column(name="NOMBRE")
    private String nombre;
    @Column(name="TELEFONO")
    private String telefono;
    @Column(name="EMAIL")
    private String email;
    @Column(name="DIRECCION")
    private String direccion;
    @Column(name="ESTATUS")
    private char estatus='A';

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }
    
    @ManyToMany(cascade={javax.persistence.CascadeType.ALL}, fetch=FetchType.LAZY)
    @JoinTable(name="Producto_Proveedor", joinColumns={@JoinColumn(name="PROVEEDOR", referencedColumnName="ID_PROVEEDOR")}, inverseJoinColumns={@JoinColumn(name="PRODUCTO", referencedColumnName="ID_PRODUCTO")})
    private Set<Producto> productos = new HashSet();

    public Proveedor() {
    }

    public Proveedor(int id_proveedor, String rif, String nombre, String telefono, String email, String direccion, char estatus) {
        this.id_proveedor = id_proveedor;
        this.rif = rif;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.estatus = estatus ='A';
        
    }

    public int getId_proveedor() {
        return id_proveedor;
        
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getRif() {
        return rif;
    }

    public void setRif(String rif) {
        this.rif = rif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }
    
}

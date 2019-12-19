/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ysidro Fernandez
 */
@Entity
@Table
public class Cliente implements Serializable {
    
    @Id
    @Column(name="CEDULA")
    private String cedula;
    @Column(name="NOMBRE")
    private String nombre;
    @Column(name="APELLIDO")
    private String apellido;
    @Column(name="TELEFONO")
    private String telefono;
    @Column(name="EMAIL")
    private String email;
    @Column(name="DIRECCION")
    private String direccion;
    @Column(name="ESTATUS")
    private char estatus='A';
    
    
    //Asociacion uno a muchos
    
    @OneToMany(mappedBy = "cliente",fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL})
    private Set<Factura> lista_factura = new HashSet();

    public Cliente() {
        nombre="";
        apellido="";
    }

    @Override
    public String toString() {
        return "Cliente{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", email=" + email + ", direccion=" + direccion + ", estatus=" + estatus + ", lista_factura=" + lista_factura + '}';
    }

    
    public Cliente(String cedula, String nombre, String apellido, String telefono, String email, String direccion, char estatus) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.estatus = estatus;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public Set<Factura> getLista_factura() {
        return lista_factura;
    }

    public void setLista_factura(Set<Factura> lista_factura) {
        this.lista_factura = lista_factura;
    }
    
    public String nombreCompleto(){
        return nombre+" "+apellido;
    }
    
}

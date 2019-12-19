/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
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
public class Usuario implements Serializable {
    @Id
    @Column(name="NOMBRE_USUARIO")
    private String nombre_usuario;
    @Column(name="CEDULA")
    private String cedula;
    @Column(name="NOMBRE")
    private String nombre;
    @Column(name="APELLIDO")
    private String apellido;
    @Column(name="TIPO_USUARIO")
    private int tipo_usuario;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="EMAIL")
    private String email;
    @Column(name="ESTATUS")
    private char estatus='A';
    
    
    //Asociacion Uno a Muchos con Factura
    @OneToMany(mappedBy = "usuario",fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL})
    private Set<Factura> lista_factura = new HashSet();
    
    //Asociacion Uno a Muchos con Historial
    @OneToMany(mappedBy = "usuario",fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL})
    private Set<Historial> lista_historial = new HashSet();
    
    
    //Asociacion Uno a muchos con Conversacion
    @OneToMany(mappedBy = "usuario",fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL})
    private Set<Conversacion> lista_conversacion = new HashSet();

    

   

    public Usuario() {
    }

    public Usuario(String cedula, String nombre, String apellido, int tipo, String nombre_usuario, String contrasena, String email, char estatus) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo_usuario = tipo;
        this.nombre_usuario = nombre_usuario;
        this.password = contrasena;
        this.email = email;
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

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Set<Historial> getLista_historial() {
        return lista_historial;
    }

    public void setLista_historial(Set<Historial> lista_historial) {
        this.lista_historial = lista_historial;
    }

    public Set<Conversacion> getLista_conversacion() {
        return lista_conversacion;
    }

    public void setLista_conversacion(Set<Conversacion> lista_conversacion) {
        this.lista_conversacion = lista_conversacion;
    }

    public String nombreCompleto(){
        return nombre+" "+apellido;
    }
    
}

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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Ysidro Fernandez
 */
@Entity
@Table
public class Perfil implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="my_entity_seq_gen")
    @SequenceGenerator(name="my_entity_seq_gen", sequenceName="Perfil_seq")
    @Column(name="ID_PERFIL")
    private int id_perfil;
    @Column(name="RIF")
    private String rif;
    @Column(name="NOMBRE")
    private String nombre;
    @Column(name="DIRECCION")
    private String direccion;
    @Column(name="TLFN")
    private String tlfn;
    @Column(name="EMAIL")
    private String email;
    @Column(name="IMPUESTO")
    private double impuesto;
    @Column(name="PORCENTAJE")
    private double porcentaje;
    @Column(name="LOGO_URL")
    private String logo_url;
    @Column(name="ESTATUS")
    private char estatus;

    public Set<Factura> getLista_factura() {
        return lista_factura;
    }

    public void setLista_factura(Set<Factura> lista_factura) {
        this.lista_factura = lista_factura;
    }
    
    //Asociacion uno a muchos con facturas
    @OneToMany(mappedBy = "perfil",fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL})
    private Set<Factura> lista_factura = new HashSet();

    public Perfil() {
    }

    public Perfil(int id_perfil, String rif, String nombre, String direccion, String tlfn, String email, double impuesto, double porcentaje, String logo_url, char estatus) {
        this.id_perfil = id_perfil;
        this.rif = rif;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tlfn = tlfn;
        this.email = email;
        this.impuesto = impuesto;
        this.porcentaje = porcentaje;
        this.logo_url = logo_url;
        this.estatus = estatus;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTlfn() {
        return tlfn;
    }

    public void setTlfn(String tlfn) {
        this.tlfn = tlfn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }
    
    
}

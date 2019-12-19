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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Ysidro Fernandez
 */
@Entity
@Table
public class Conversacion implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="my_entity_seq_gen")
    @SequenceGenerator(name="my_entity_seq_gen", sequenceName="Conversacion_seq")
    @Column(name="ID_COVERSACION")
    private int id_conversacion;
    @Column(name="USUARIO2")
    private String usuario2;
    @Column(name="ESTADO")
    private int estado;
    @Column(name="ESTATUS")
    private char estatus;
    
    //Asociacion Muchos a Uno con Usuario
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="USUARIO")
    private Usuario usuario;
    
    @OneToMany(mappedBy = "conversacion",fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL})
    private Set<Mensaje> lista_mensaje = new HashSet();

    public Conversacion() {
    }

    public Set<Mensaje> getLista_mensaje() {
        return lista_mensaje;
    }

    public void setLista_mensaje(Set<Mensaje> lista_mensaje) {
        this.lista_mensaje = lista_mensaje;
    }

    public Conversacion(int id_conversacion, String usuario2, int estado, char estatus) {
        this.id_conversacion = id_conversacion;
        this.usuario2 = usuario2;
        this.estado = estado;
        this.estatus = estatus;
    }

    public int getId_conversacion() {
        return id_conversacion;
    }

    public void setId_conversacion(int id_conversacion) {
        this.id_conversacion = id_conversacion;
    }

    public String getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(String usuario2) {
        this.usuario2 = usuario2;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
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

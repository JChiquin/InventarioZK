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
import org.zkoss.zul.Image;

/**
 *
 * @author Ysidro Fernandez
 */
@Entity
@Table
public class Mensaje implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="my_entity_seq_gen")
    @SequenceGenerator(name="my_entity_seq_gen", sequenceName="Mensaje_seq")
    @Column(name="ID_MENSAJE")
    private int id_mensaje;
    @Column(name="MENSAJE")
    private String mensaje;
    @Column(name="ESTATUS")
    private char estatus;

    public Conversacion getConversacion() {
        return conversacion;
    }

    public void setConversacion(Conversacion conversacion) {
        this.conversacion = conversacion;
    }

    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="CONVERSACION")
    private Conversacion conversacion;
    
    public Mensaje() {
    }

    public Mensaje(int id_mensaje, String mensaje, char estatus) {
        this.id_mensaje = id_mensaje;
        this.mensaje = mensaje;
        this.estatus = estatus;
        
        
    }

    public int getId_mensaje() {
        return id_mensaje;
    }

    public void setId_mensaje(int id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }
    
    
    
    }

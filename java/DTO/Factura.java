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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Ysidro Fernandez
 */
@Entity
@Table
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="my_entity_seq_gen")
    @SequenceGenerator(name="my_entity_seq_gen", sequenceName="Factura_seq")
    @Column(name="ID_FACTURA")
    private int id_factura;
    @Column(name="NUM_FACTURA")
    private int num_factura;
    @Column(name="FECHA_FACTURA")
    private Date fecha_factura;
    @Column(name="CONDICIONE")
    private int condiciones;
    @Column(name="TOTAL_VENTA")
    private double total_venta;
    @Column(name="ESTATUS")
    private char estatus;

    @Override
    public String toString() {
        return "Factura{" + "id_factura=" + id_factura + ", num_factura=" + num_factura + ", fecha_factura=" + fecha_factura + ", condiciones=" + condiciones + ", totla_venta=" + total_venta + ", estatus=" + estatus + ", cliente=" + cliente.getCedula() + ", perfil=" + perfil + ", usuario=" + usuario + ", lista_detalle=" + lista_detalle + '}';
    }
    
    //Asociacion muchos a uno con clientes
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="CEDULA")
    private Cliente cliente;
    
    //Asociacion muchos a uno con Perfil
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="PERFIL")
    private Perfil perfil;

    public Set<Detalle_Factura> getLista_detalle() {
        return lista_detalle;
    }

    public void setLista_detalle(Set<Detalle_Factura> lista_detalle) {
        this.lista_detalle = lista_detalle;
    }
    
    //Asociacion muchos a uno con Usuario
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="USUARIO")
    private Usuario usuario;
   
    @OneToMany(mappedBy = "factura",fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL})
    private Set<Detalle_Factura> lista_detalle = new HashSet();
    
   
    public Factura() {
    }
    
    

    public Factura(int id_factura, int num_factura, Date fecha_factura, int condiciones, double totla_venta, char estatus) {
        this.id_factura = id_factura;
        this.num_factura = num_factura;
        this.fecha_factura = fecha_factura;
        this.condiciones = condiciones;
        this.total_venta = totla_venta;
        this.estatus = estatus;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public int getNum_factura() {
        return num_factura;
    }

    public void setNum_factura(int num_factura) {
        this.num_factura = num_factura;
    }

    public Date getFecha_factura() {
        return fecha_factura;
    }

    public void setFecha_factura(Date fecha_factura) {
        this.fecha_factura = fecha_factura;
    }

    public int getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(int condiciones) {
        this.condiciones = condiciones;
    }

    public double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(double total_venta) {
        this.total_venta = total_venta;
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
    public double subTotal(){
        double acum=0.00;
        for(Detalle_Factura det : lista_detalle)
            acum=det.precioTotal();
        return acum;
    }
    
}

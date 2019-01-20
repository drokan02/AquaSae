/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author DroKaN
 */
public class Pedido {
    private int id;
    private Cliente cliente;
    private Producto producto;
    private Date fecha_pedido;
    private int cantidad;
    private double total;
    private int entregado;

    public Pedido(int id, Cliente cliente, Producto producto, Date fecha_pedido, int cantidad, double total, int entregado) {
        this.id = id;
        this.cliente = cliente;
        this.producto = producto;
        this.fecha_pedido = fecha_pedido;
        this.cantidad = cantidad;
        this.total = total;
        this.entregado = entregado;
    }

    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }
    
    public Pedido(){
    }

    public int getEntregado() {
        return entregado;
    }

    public void setEntregado(int entregado) {
        this.entregado = entregado;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getTotal() {
        return total;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}

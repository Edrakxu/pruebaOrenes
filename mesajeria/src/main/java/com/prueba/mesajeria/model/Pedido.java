package com.prueba.mesajeria.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Value;
@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pedido")
	private int id;
	@ManyToOne
	@JoinColumn(name = "id_vehiculo")
	private Vehiculo vehiculo;
	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;
	@Column(name="hora_pedido")
	private Date horaPedido;
	private String producto;
	
	public Pedido() {
		
	}
	
	public Pedido(int id, Vehiculo vehiculo, Estado estado, Date horaPedido, String producto) {
		super();
		this.id = id;
		this.vehiculo = vehiculo;
		this.estado = estado;
		this.horaPedido = horaPedido;
		this.producto = producto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Date getHoraPedido() {
		return horaPedido;
	}
	public void setHoraPedido(Date horaPedido) {
		this.horaPedido = horaPedido;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}
	
	
}

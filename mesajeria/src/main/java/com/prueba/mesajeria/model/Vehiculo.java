package com.prueba.mesajeria.model;

import java.util.ArrayList;
import java.util.ListIterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.prueba.mensajeria.events.ActualizaEvent;
import com.prueba.mensajeria.events.UpdateEventListener;
@Entity
public class Vehiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_vehiculo")
	private int id;
	private String responsable;
	@Transient
	private Coordenadas coordenadas;
	private double latitud;
	private double longitud;
	@Transient
	private static ArrayList listeners;
	
	public Vehiculo() {
		super();
		listeners = new ArrayList();
	}
	
	public Vehiculo(int id) {
		super();
		listeners = new ArrayList();
		this.id = id;
	}
	
	public Vehiculo(int id, String resposable, double latitud, double longitud) {
		super();
		listeners = new ArrayList();
		this.id = id;
		this.responsable = resposable;
		this.latitud = latitud;
		this.longitud = longitud;
	}
	public int getId() {
		return id;
	}
	public void setId(int id_vehiculo) {
		this.id = id_vehiculo;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String resposable) {
		this.responsable = resposable;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	public void addUpdateEventListener(UpdateEventListener listener) {
        listeners.add(listener);
    }
	public void setCoordenada(Coordenadas cord) {
		ListIterator li = listeners.listIterator();
        // Recorremos la lista para ejecutar el metodo NombreCambiado de cada manejador almacenado
        while (li.hasNext()) {
            // Convertimos (CAST) de nuestro objeto
        	UpdateEventListener listener = (UpdateEventListener)li.next();
 
            // Creamos el objeto que tiene la información del evento
        	ActualizaEvent personaEvObj = new ActualizaEvent (this, // source (Object)
                    this // InformacionExtra (Persona)
                );
            // Ejecutamos el metodo manejador del evento con los parametros necesarios
        	if(longitud != cord.getLongitud() || latitud != cord.getLatitud()) {
        		(listener).onCoordenadaChange(personaEvObj);
        	}
        }
        
        this.latitud = latitud;
        this.longitud = longitud;
	}
}

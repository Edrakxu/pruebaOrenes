package com.prueba.mensajeria.events;

import java.util.EventObject;

import com.prueba.mesajeria.model.Vehiculo;

public class ActualizaEvent extends EventObject {

	Vehiculo vehi;
	
    public ActualizaEvent(Object source, Vehiculo _vehi) {
        super(source);
        vehi = _vehi;
    }
    
    public Vehiculo Vehiculo ()
    {
        return vehi;
    }
}


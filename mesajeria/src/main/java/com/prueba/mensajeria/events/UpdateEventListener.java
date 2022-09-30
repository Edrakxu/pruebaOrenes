package com.prueba.mensajeria.events;

import java.util.EventListener;

public interface UpdateEventListener extends EventListener {
	public abstract void onCoordenadaChange(ActualizaEvent ev);
}

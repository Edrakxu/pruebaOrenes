*********************** PRUEBA ORENES ***********************

API Rest Basada en Java con Spring boot.

Base de datos SQLite encontrada en mensajeria.db en la raiz del proyecto. Se adjunta DB.Browser.for.SQLite-3.12.2-win64.msi en resources para el manejo de la BBDD

Servidor Tomcat

Testing src/test/java y proyecto soap en SoapProject.zip para importar

Nivel 1:

Se crea el contexto /vehiculos para la gestion de los vehiculos (VehiculosController)
	- /getPosicion/"idVehiculo": obtiene la posicion del vehiculo
	- /updatePosicion/"idVehiculo": actualiza la posicion de un vehiculo 
	- /add: añade un vehiculo vehiculo 
	- /update/"idVehiculo": actualiza el vehiculo 
	
Se crea el contexto /pedidos para la gestion de los vehiculos (PedidosController)
	- /add: crea un pedido
	- /delete/"id": borra un pedido
	

Se crea RegistroController para ir registrando los cambios de posicion del vehiculo
	- save: registra el cambio de posicion del vehiculo.
	
	
Nivel 2:
	- Se crea un Event para que detecte el cambio de coordenas.
	- Se crea un hilo para simular el envio de el cambio de coordenadas a lo usuarios, cuando el event se dispare.
	
	
Modelo de datos:
	- Dto creados en com.prueba.mensajeria.model
	- Solictud a la bbdd en com.prueba.mensajeria.ropository usando JPA
	

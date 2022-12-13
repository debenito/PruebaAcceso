# Servicio de prueba
Para comenzar con la prueba es necesario levantar los servicios especificados en este documento https://github.com/dalogax/backendDevTest.
Una vez realizado esto hemos de movernos  a la carpeta raiz de este proyecto /Prueba de acceso y ejecutar los siguientes comandos para levantar el docker (RECORDATORIO: Si en la carpeta target no se encuentra un fichero con extension jar , es necesario  ejecutar el mvn install).
 

```
	docker build -t backend .
	docker run -p 5000:5000 -d backend
```

**Acceso a swaguer y bateria de pruebas swaguer**

Una vez realizado lo anterior ya podemos comenzar con las pruebas accediendo a la url , a traves del navegador , poniendo https://localhost:5000 en la que veremos la siguiente imagen:



![Diagram](./src/main/resources/assets/Captura1.png "Swagguer")


Primero se ha de desplegar el servicio de busqueda por id que se muestra en la siguiente imagen:
![Diagram](./src/main/resources/assets/Captura2.png "Swagguer2")

Una vez desplegado esto se ha de seguir los siguientes pasos:

Paso 1 : Pulsar sobre el boton try it out. En este momento se puede editar el campo 			     			de texto y pulsar en el boton execute despareciendo el boton try it out.
	 ![Diagram](./src/main/resources/assets/Captura2_1.png "Swagguer2_1")

Paso 2: Introduccir en el campo de texto los valores descritos en la bateria de 		prueba 1.


Paso 3: Pulsar sobre el boton execute.
	
	
Finalmente podremos ver la siguiente imagen en la que se muestra la salida de una de las ejecuciones.

![Diagram](./src/main/resources/assets/Captura3.png "Swagguer3")



Al igual que el servicio de busqueda por id se han de realizar los mismo pasos para el servicio de Similares , con independencia que en este caso se ha de seguir la bateria de pruebas 2, de todas formas se adjuntan las capturas realizadas tras el proceso de ejecucion y pruebas del mismo.

![Diagram](./src/main/resources/assets/Captura4.png "Swagguer4")


![Diagram](./src/main/resources/assets/Captura5.png "Swagguer5")



##Bateria prueba 1
Tras entrar en esta web podemos realizar la siguiente bateria de prueba comenzando por el servicio de Buscar por id, introducciendo como paremetro los siguientes valores.


		- idProducto: 1
		- idProducto: 2
		- idProducto: 3
		- idProducto: 4
		- idProducto: 5
		- idProducto: 6
		- idProducto: 100
		- idProducto: 1000
		- idProducto: 10000




##Bateria prueba 2

Mientras que para el servicio de Similares es necesario los siguientes valores:



		- idProducto: 1
		- idProducto: 2
		- idProducto: 3
		- idProducto: 4
		- idProducto: 5
		- idProducto: 6	
		
## Testing 
Para el apartado de testing existe una clase en src/main/java/test , la cual podemos ejecutar como un JunitTest de java.


**Coleccion postman y bateria de pruebas**

Se puede ver que en la carpeta /src/main/resources/assets se encuentra un fichero de coleccion para Postman para poder utilizarlo es necesario tener instalado el Postman . Una vez instalado es necesario importar el fichero como se muestra en la siguiente imagen .

![Diagram](./src/main/resources/assets/Capturapostman1.png "Postman1")




Una vez importada la coleccion de pruebas al postman solo es necesarion ejecutar la misma, para ello pulsamos sobre los tres puntitos que nos aparecera al pulsar la misma. Tras ello aparece un Run Collection , pulsamos sobre ello y en la derecha pulsamos la bateria de pruebas sobre los datos de entrada que queremos ejecutar como se muestra en la imagen ( en este caso estan selecccionadas todas).


![Diagram](./src/main/resources/assets/Capturapostman2.png "Postman1")


Finalmente una vez seleccionadas pulsaremos sobre el boton que pone run pruebas en la pantalla que se encuentra a la derecha y podremos ver la entrada y salida de datos que ha realizado las pruebas , como se muestra en la siguiente imagen:

![Diagram](./src/main/resources/assets/Capturapostman3.png "Swagguer3")



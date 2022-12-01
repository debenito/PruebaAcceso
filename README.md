# Servicio de prueba
Para comenzar con la prueba es necesario levantar los servicios especificados en este documento https://github.com/dalogax/backendDevTest.
Una vez realizado esto hemos de movernos  a la carpeta raiz de este proyecto /Prueba de acceso y ejecutar los siguientes comandos para levantar el docker (RECORDATORIO: Si en la carpeta target no se encuentra un fichero con extension jar , es necesario  ejecutar el mvn install).


```
	docker build -t backend .
	docker run -p 5000:5000 -d backend
```

**Acceso a swaguer y bateria de pruebas swaguer**

Una vez realizado lo anterior ya podemos comenzar con las pruebas accediendo a la url 
localhost:5000 en la que veremos la siguiente imagen


![Diagram](./src/main/resources/assets/swagguer.png "Swagguer")


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


Mientras que para el servicio de Similares es necesario los siguientes valores:



		- idProducto: 1
		- idProducto: 2
		- idProducto: 3
		- idProducto: 4
		- idProducto: 5
		- idProducto: 6	
		
## Testing 
Para el apartado de testing existe una clase en src/main/java/test , la cual podemos ejecutar como un JunitTest de java.



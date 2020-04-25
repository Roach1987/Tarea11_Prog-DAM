Enunciado.


Se trata de hacer una aplicación en Java que acceda a una base de datos MySQL de una aerolínea y mediante un menú pueda realizar
determinadas operaciones. La base de datos a la que accederemos, por comodidad, será la correspondiente al esquema test, 
que ya viene por defecto en la instalación de MySQL, y ahí crearemos las tablas necesarias.

Puedes utilizar un JOptionPane para presentar el menú con las opciones que permita realizar el programa:

Queremos realizar un programa para gestionar una aerolínea que ofrece vuelos entre diferentes ciudades y cuya persistencia de datos se realizará utilizando una BDD relacional: MySQL.


Un vuelo parte de un aeropuerto de origen en una fecha y hora determinada y llega a un aeropuerto destino, también en una fecha y hora determinada. Algunos vuelos, pueden tener escalas intermedias también con fecha y hora de escala.

Un vuelo tendrá asignado un avión concreto y las plazas disponibles para ese vuelo, inicialmente serán las plazas de las que dispone el avión asignado y según se vayan reservando se irá actualizando para ese vuelo concreto.

Un avión dispondrá de un código que le identificará de forma unívoca, el modelo de avión y el número de plazas de que dispone.


** El programa debe permitir:

* Crear, consultar y borrar aviones: deberás tener en cuenta que no puede haber dos aviones con el mismo código dentro del sistema.
Un avión no podrá ser borrado si hay vuelos que se realicen con dicho avión.

* Crear, consultar y borrar vuelos: tendremos en cuenta que un avión concreto (identificado por su código) no podrá volar en un 
mismo día más de una vez.

* Opcionalmente se podrán reservar plazas: será opcional su implementación.

** El programa ofrecerá al usuario una interfaz para interactuar con él:

Se solicitará datos al usuario para crear aviones.
Se podrá consultar aviones en el sistema según su código.
Se podrá borrar aviones según su código siempre que no haya un vuelo asociado a ellos.
Se podrá solicitar los datos para crear el vuelo (inicialmente las plazas estarán sin ocupar)
Se podrá solicitar los datos para consultar los vuelos según: ciudad origen, ciudad destino y fecha de salida.
Se podrá borrar los datos de un vuelo introduciendo el código del avión, ciudad de salida y fecha de salida.

Deberéis entregar una memoria indicando el diagrama de clases utilizado, aclaraciones importantes sobre decisiones de diseño e 
implementación llevadas a cabo y un pequeño manual de usuario de la aplicación.

# Capitulo 5 - JSF

En este capitulo desarrollamos un CRUD de peliculas.
[![Captura-de-pantalla-de-2020-07-11-18-36-59.png](https://i.postimg.cc/zfvY7y9K/Captura-de-pantalla-de-2020-07-11-18-36-59.png)](https://postimg.cc/VJxhLksk)


## Clonar proyecto

Abrir una terminal/consola y clonar el repositorio

```
git clone https://github.com/Francisco-Castillo/capitulo-jsf/
```
## Crear base de datos

Una vez clonado el proyecto, se debe crear una base de datos

```
CREATE DATABASE videoclub;
```

## Restaurar script :scroll:

En el directorio raiz del proyecto encontrará el script [`videoclubdb.sql`](capitulo-jsf/videoclubdb.sql)

```
mysql -unombreUsuario -pPasswordUsuario videclub < videoclubdb.sql
```
En donde nombreUsuario y PasswordUsuario deben ser reemplazados por los valores que correspondan en su caso

## Levantar Payara Server :rocket:

```
cd directorio/instalacion/payaraServer/bin/
```
En linux

```
./asadmin start-domain
```
## Crear pool de conexiones y recurso JDBC
Para que la aplicación pueda funcionar es necesario crear un datasource, más conocido como pool de conexiones. Para ello colocar en el navegador web la siguiente direccion: (http://localhost:4848) que mostrara el panel de admin de Payara.

* **Pool de conexiones**
  * 1 - Nuevo...
  * 2 - Nombre de Pool: *videoclubPool*
  * 3 - Tipo de recurso : *java.sql.Driver*
  * 4 - Click en siguiente
  * 5 - Driver Classname:  *org.mariadb.jdbc.Driver*
  * 6 - Agregar las siguientes propiedades adicionales: 
    * 6.1 - serverName : *localhost*
    * 6.2 - databaseName : *videoclub*
    * 6.3 - URL : *jdbc:mariadb://localhost:3306/videoclub*
    * 6.4 - user: *nombreDeUsuario*
    * 6.5 - password: *password*
    
Una vez finalizada la creación del pool de conexiones, se debe realizar un "ping" para comprobar que el proceso se haya realizado de manera exitosa.

Para ello haga clic en el botón con la leyenda "Ping" que se encuentra dentro de la pestaña general 
    
* **Recurso JDBC**
  * 1 - Nuevo...
  * 2 - Nombre JNDI : *jdbc/videoclubdb*
  * 3 - Nombre Pool : *videoclubPool*
  * 4 - Click en aceptar
  
## Compilar e instalar dependencias :wrench:

Abrir una terminal y ubicarse en la raiz del proyecto. Alli ingresar el siguiente comando.

```
mvn clean install
```
se creará un directorio target con el archivo *capitulo-jsf.war*
  
## Desplegar *.war*
Abrir una terminal y ubicarse en el directorio bin de payara.
```
cd directorio/payara/bin/
./asadmin deploy /directorio/proyecto/target/capitulo-jsf.war
```
## Probar aplicación :earth_americas:
Abrir un navegador web e ingresar la siguiente direccion: http://localhost:8080/capitulo-jsf/

## Autor :black_nib:
- Francisco Castillo - cefrancastillo@gmail.com

# TAREA DE MICROSERVICIOS
**Integrantes**
- Enrique Gonzalez
- Julian Largo
- Sergio Andres Otero

Se diseño un API  Quarkus que permite a los usuarios hacer posts de 140 caracteres e ir registrandolos en un stream único de posts (a la Twitter). Piense en tres entidades Usuario, hilo(stream), posts, todos estos datos se guardaron en una base de datos de mongo alojada en mongo atlas, se uso una instancia de EC2 para alojar la api y un bucket S3 en donde se guardan los archivos estaticos.

![image](https://user-images.githubusercontent.com/98104282/233527363-55cf2edf-346f-44f4-b970-73a3f8c406cd.png)



## Que es Quarkus?
 - Quarkus es un marco de Java diseñado para su implementación en Kubernetes. Los componentes tecnológicos clave que lo rodean son OpenJDK HotSpot y GraalVM.
 
## Iniciando

## Instalando Quarkus
Si estamos en una distribución de linux ponemos los siguientes comandos 
```
curl -Ls https://sh.jbang.dev | bash -s - trust add https://repo1.maven.org/maven2/io/quarkus/quarkus-cli/
curl -Ls https://sh.jbang.dev | bash -s - app install --fresh --force quarkus@quarkusio
``` 
Si es una distribución windows utilizando powershell:
```
iex "& { $(iwr https://ps.jbang.dev) } trust add https://repo1.maven.org/maven2/io/quarkus/quarkus-cli/"
iex "& { $(iwr https://ps.jbang.dev) } app install --fresh --force quarkus@quarkusio"
```
En este punto se debe reiniciar la consola para que el comando se instale comando correctamente 


En este caso subimos el proyecto a una instancia EC2 de AWS

![image](https://user-images.githubusercontent.com/98104282/233528598-c2cbffb4-857f-4614-9a44-507084eb65db.png)


, dentro de la consola de la instancia instalamos quarkus como se indico mas arriba, importamos el proyecto y en la carpeta raiz ponemos el siguiente comando
```
quarkus dev
```
y deberia aparecer algo asi

![image](https://user-images.githubusercontent.com/98104282/233528481-044beb6f-4eea-4d6d-888d-3b946fea7bb3.png)

Significa que el servicio esta corriendo y escuchando por el puerto 8080

Los archivos estaticos(HTML y JS)se guardaron en un bucket S3

![image](https://user-images.githubusercontent.com/98104282/233529027-20336ab0-db73-4d96-a058-f72bcb916666.png)

Imagen del mongo atlas
![image](https://user-images.githubusercontent.com/98104282/233529138-b133ab58-70ac-4d20-ade9-bf5ee0c5ec92.png)

 ## Demo de la aplicacion:
 

https://user-images.githubusercontent.com/98104282/233529256-34013578-039b-4e22-be98-c73bfc57f0ec.mp4





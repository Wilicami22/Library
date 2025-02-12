# Laboratorio 3

## Integrantes

- Manuel David Robayo Vega
- Nicolas Esteban Toro Criollo
- William Camilo Hernandez Deaza
## Creación del proyecto
Se creó el proyecto Maven con los parámetros dados de la siguiente forma:

![image](/images/Imagen1.png)

![image](/images/Imagen2.png)

Posterior a la creación del proyecto, se agregan la dependencia JUnit5 en su versión más reciente.

![image](/images/Imagen3.png)

Se agregó en el pom.xml de la siguiente forma.

![image](/images/Imagen4.png)
![image](/images/Imagen5.png)

## Agregar clases

Se crearon los paquetes ```book```, ```loan``` y ```user```.

![image](/images/Imagen6.png)
![image](/images/Imagen7.png)

Se crearon las clases propuestas en los paquetes dados y se validó que compilando el proyecto.

![image](/images/Classes.png)

![image](/images/Classes1.png)

(Imágenes de las clases creadas)

## Pruebas unitarias y TDD

Se implementó la técnica TDD, por lo que por cada método, se hicieron las pruebas de unidad respectivas siguiendo la documentación del método.
### AddBook

![image](/images/AddBook.png)

Siguiendo la metodologia TDD, la prueba unitaria debería fallar.

![image](/images/AddBook1.png)

Realizamos el codigo minimo para que la prueba pase

![image](/images/addBook_Code.png)

Para cada funcionalidad del metodo se aplico esta metodologia 

**Para los 3 metodos se utiliza la misma metodologia**

### LoanBook

![image](/images/loanabook3.png)


![image](/images/loanabook2.png)


![image](/images/loanabook4.png)


### ReturnLoan

![image](/images/ReturnLoan1.png)

![image](/images/ReturnLoan_Code.png)

## JACOCO

Se agrego el plugin de Jacoco en el pom.xml
![image](/images/jacoco.png)

Hacemos un clean package y comprobamos que se este generando la carpeta site con el reporte de alcance

![image](/images/jacoco1.png)
![image](/images/jacoco2.png)
![image](/images/jacoco3.png)

Se puede observar que se tiene mas de un 85% de cobertura en todo el codigo en las pruebas UnitTest

## SonarQube

Instalamos y configuramos SonarQube siguiendo las instrucciones dadas

![Image](/images/SonarQube.png)
![Image](/images/SonarQube1.png)
![Image](/images/SonarQube2.png)
![Image](/images/SonarQube3.png)

Abrimos desde un navegador la pagina http://localhost:9000 y actualizamos la contraseña

![Image](/images/SonarQube4.png)

Generamos el token y guardamos el link
![Image](/images/SonarQube5.png)

Instalamos SonarQube para IntelliJ
![Image](/images/SonarQube6.png)

Agregamos el plugin en el pom.xml
![Image](/images/SonarQube7.png)

Agregamos las propiedades correspondientes
![Image](/images/SonarQube8.png)

Generamos el reporte y enlazamos con el token
![Image](/images/SonarQube9.png)

Los resultados del codigo son los siguientes:
![Image](/images/SonarQube10.png)

Gracias
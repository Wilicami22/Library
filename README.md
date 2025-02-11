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

(Imágenes de las clases creadas)

## Pruebas unitarias y TDD

Se implementó la técnica TDD, por lo que por cada método, se hicieron las pruebas de unidad respectivas siguiendo la documentación del método.

### LoanBook

![image](/images/loanabook3.png)

Siguiendo la técnica TDD, la prueba unitaria debería fallar. 

![image](/images/loanabook2.png)

Al finalizar las pruebas de unidad, se implementa el código necesario para que este funcione.

![image](/images/loanabook4.png)

### ReturnLoan

![image](/images/ReturnLoan1.png)

![image](/images/ReturnLoan_Code.png)

### AddBook

(Imagen de la prueba fallando)

![image](/images/addBook_Code.png)
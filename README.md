# springboot-calculator

Microservicio Spring Boot, que ofrece funciones aritméticas básicas (+,-,*,/,^)

Requisitos: Java 8, Maven 3

Pasos para la ejecución del código:
1.- Hacer clone del repo

2.- Instalar en el repo mvn local la librería (jar) ubicada en /lib.

Bien con `mvn validate` o con `mvn install:install-file -Dfile=lib/tracer-1.0.0.jar -DgroupId=io.corp.calculator -DartifactId=tracer -Dversion=1.0.0 -Dpackaging=jar -DgeneratePom=true`

3.- Ejecutar la compilación y empaquetado con `mvn clean package`

4.- Levantar el servicio con: `java -jar target/calculator-0.0.1-SNAPSHOT .jar`
Testarle desde la interface swagger: http://localhost:8080/swagger-ui.html
(Puerto por defecto, en caso de querer cambiarle server.port=8081 en application.properties)

5.- Chequear status del servicio: http://localhost:8080/actuator

6.- El servicio dispone de tests de integración que corren durante la compilación, levantando un servicio en un puerto random.

7.- El servicio consta de 2 operaciones GET guidadas y una POST que permite la selección del operador (Post por no tener problemas con los caracteres + / ...). La salida es una descripción de la operación interpretada y el resultado.

8.-Versionado: Las clases consideradas que pueden cambiar con la versión, se han incluido en paquetes v1. Esta primera versión del servicio también responde por /v1/...

Posibles mejoras: 
- Aumentar funcionalidades (validación parámetros de entrada, desacoplar entrada y salida del servicio,...) 
- Incrementar tests (integrar jacoco para validar)
- Incluir más comentarios, javadoc,...
- Cerrar la interface para que solo se puedan incluir operadores contemplados.
- Integrar otras funcionalidades del ecosistema microservicios (Autodescubrimiento, configuración central, gateway, balanceo, ...)
- Posibles optimizaciones librería de trazas, Implementación implemente el interface ..API, disponer de ella en un repo remoto.
- ...

Para cualquier duda, a vuestra disposición.

Gracias!


---

Spring Boot Microservice, which offers basic arithmetic functions (+, -, *, /, ^)

Requirements: Java 8, Maven 3

Steps for code execution:

1.- Make a clone of the repo.

2.- Install the library (jar) located in /lib to the local mvn repo.
Either with `mvn validate` or with `mvn install: install-file -Dfile=lib/tracer-1.0.0.jar -DgroupId = io.corp.calculator -DartifactId = tracer -Dversion = 1.0.0 -Dpackaging = jar - DgeneratePom = true`

3.- Execute the compilation and packaging with `mvn clean package`

4.- Run the service with: `java -jar target/calculator-0.0.1-SNAPSHOT .jar`
Test it from the swagger interface: http://localhost:8080/swagger-ui.html

5.- Check service status: http://localhost:8080/actuator

6.- The service has integration tests which run during the compilation, running a service in a random port.

7.- The service has 2 "guided" operations GET and a POST one that allows the selection of the operator (POST just not to have problems with the + / ... characters). The output is a description of the interpreted operation plus the result.

8.-Versioning: The classes considered that can change with the version have been included in v1 packages. This first version of the service also responds in /v1/...

Possible improvements:
- Expand functionality
- Improve tests (integrate jacoco to validate...)
- Include more comments, javadoc,...
- Close the interface so that only contemplated operators can be included.
- Integrate other functionalities of microservices ecosystem (Self-discovery, central configuration, gateway, ...)
- Possible trace library optimizations, Implementation will implement the ..API interface, store it in a remote repo.
- ...

For any questions, at your disposal.

Thank you!


```
ab -n 10000 -c 10 http://localhost:8080/v1/calc/add/1.83/2

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.3      1       7
Processing:     1   18  14.3     14     380
Waiting:        1   17  13.6     14     379
Total:          1   18  14.3     15     381
ERROR: The median and mean for the initial connection time are more than twice t
he standard
       deviation apart. These results are NOT reliable.

Percentage of the requests served within a certain time (ms)
  50%     15
  66%     19
  75%     21
  80%     23
  90%     31
  95%     38
  98%     54
  99%     70
 100%    381 (longest request)
 ```

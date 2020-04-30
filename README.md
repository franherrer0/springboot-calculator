# springboot-calculator

1. First step: Added tracer dependency:
Install in your local mvn repo with -> `mvn validate`

Or with: `mvn install:install-file -Dfile=lib/tracer-1.0.0.jar -DgroupId=io.corp.calculator -DartifactId=tracer -Dversion=1.0.0 -Dpackaging=jar -DgeneratePom=true`


Added documentation with Swagger2: http://localhost:8080/swagger-ui.html

Enabled actuators: 
http://localhost:8080/actuator
http://localhost:8080/actuator/info
...

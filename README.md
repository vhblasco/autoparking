# Automatic Parking system Problem

The purpose of this exercise is to demonstrate TDD and come up with a solution to the problem given below. Working unit tests will be sufficient as a solution, but you may provide a simple user interface to demonstrate your codes capability if you desire.
Cars are placed on a 15 by 15 grid at particular co-ordinates heading north, and the simple commands Left, right and forward are transmitted to them. The commands must be executed and the final position calculated.
The following examples should be used to demonstrate your code:

> - For the input "5,5:RFLFRFLF"
>   We should get the position "7,7"

> - For the input "6,6:FFLFFLFFLFF"
>   We should get the position "6,6"

> - For the input "5,5:FLFLFFRFFF"
>   We should get the position "4,1"

> **Note:**

> - Due to this last example of expecting outputs, I have assumed the coordinates are in format (Y,X) instead the usual (X,Y) format

- Requeriments: The project needs Java 8 to run and Maven 2 to build it.

## How to download and build

```sh
$ git clone https://github.com/vhblasco/autoparking.git
$ cd autoparking
$ mvn install
```
## How to execute

**Unique execution**

```sh
$ java -jar ./target/autoparking-0.0.1-SNAPSHOT.jar 5,5:RFLFRFLF
```

**Multiple execution**

```sh
$ java -jar ./target/autoparking-0.0.1-SNAPSHOT.jar 5,5:RFLFRFLF 6,6:FFLFFLFFLFF 5,5:FLFLFFRFFF
```

### Output Example

<pre><code>

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.5.9.RELEASE)

2017-12-11 21:59:39.940  INFO 4429 --- [           main] c.w.autoparking.AutoParkingApplication   : Starting AutoParkingApplication v0.0.1-SNAPSHOT on leela with PID 4429 (/home/oli/proyectos/tests/white_clarke/technical_assessment/autoparking/target/autoparking-0.0.1-SNAPSHOT.jar started by oli in /home/oli/proyectos/tests/white_clarke/technical_assessment/autoparking)
2017-12-11 21:59:39.946  INFO 4429 --- [           main] c.w.autoparking.AutoParkingApplication   : No active profile set, falling back to default profiles: default
2017-12-11 21:59:40.043  INFO 4429 --- [           main] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@28c97a5: startup date [Mon Dec 11 21:59:40 GMT 2017]; root of context hierarchy
2017-12-11 21:59:41.354  INFO 4429 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2017-12-11 21:59:41.391  INFO 4429 --- [           main] c.w.autoparking.AutoParkingApplication   : Started AutoParkingApplication in 2.21 seconds (JVM running for 2.973)
2017-12-11 21:59:41.417  INFO 4429 --- [           main] c.w.autoparking.beans.AutoParking        : *************
2017-12-11 21:59:41.417  INFO 4429 --- [           main] c.w.autoparking.beans.AutoParking        : Initial position (5,5) and sequence RFLFRFLF
2017-12-11 21:59:41.419  INFO 4429 --- [           main] c.w.autoparking.beans.AutoParking        : Final Position (7,7)
2017-12-11 21:59:41.420  INFO 4429 --- [           main] c.w.autoparking.beans.AutoParking        : *************
2017-12-11 21:59:41.420  INFO 4429 --- [           main] c.w.autoparking.beans.AutoParking        : Initial position (6,6) and sequence FFLFFLFFLFF
2017-12-11 21:59:41.420  INFO 4429 --- [           main] c.w.autoparking.beans.AutoParking        : Final Position (6,6)
2017-12-11 21:59:41.421  INFO 4429 --- [           main] c.w.autoparking.beans.AutoParking        : *************
2017-12-11 21:59:41.421  INFO 4429 --- [           main] c.w.autoparking.beans.AutoParking        : Initial position (5,5) and sequence FLFLFFRFFF
2017-12-11 21:59:41.421  INFO 4429 --- [           main] c.w.autoparking.beans.AutoParking        : Final Position (4,1)
2017-12-11 21:59:41.433  INFO 4429 --- [       Thread-2] s.c.a.AnnotationConfigApplicationContext : Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@28c97a5: startup date [Mon Dec 11 21:59:40 GMT 2017]; root of context hierarchy
2017-12-11 21:59:41.438  INFO 4429 --- [       Thread-2] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown
</code></pre>

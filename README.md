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

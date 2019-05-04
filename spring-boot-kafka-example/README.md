
# spring boot kafka example

My Kafka server is running ``` localhost:9092 ```

Here are command to build and run publisher and subscriber application. 

``` sh
mvn install -f .\spring-boot-kafka-publisher-app\pom.xml

mvn install -f .\spring-boot-kafka-subscriber-app\pom.xml

java -jar spring-boot-kafka-publisher-app\target\spring-boot-publisher-app.jar

java -jar spring-boot-kafka-subscriber-app\target\spring-boot-subscriber-app.jar

```
## Start Zookeeper
```
cd zookeeper-3.4.14\bin
.\zkServer.cmd
```
 
## Start Kafka in windows:
``` sh
cd kafka_2.11-2.2.0\bin
.\kafka-server-start.bat ..\..\config\server.properties
 ```
 

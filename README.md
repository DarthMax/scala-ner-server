# Ner Service

A simple webservice for the Stanford NER Tagger

## Build  ##

```sh
$ cd ner-service
$ ./sbt
> assembly
$ java -jar target/scala-[SCALA-VERSION]/ner-service-[SCALA-VERSION]-0.1.0-SNAPSHOT.jar &
$ curl -X POST --data "text=Das ist Angela Merkel" localhost:8080
Das ist <I-PER>Angela Merkel</I-PER>
```

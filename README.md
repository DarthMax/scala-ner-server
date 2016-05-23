# Ner Service

A simple webservice for the Stanford NER Tagger

## Usage ##

1. Clone the repo

    ```sh
    git clone https://github.com/DarthMax/scala-ner-server
    cd scala-ner-server
    ```

2. First Download the German language models from [http://nlp.stanford.edu/software/CRF-NER.shtml](http://nlp.stanford.edu/software/CRF-NER.shtml)

    ```sh
    $ wget http://nlp.stanford.edu/software/stanford-german-2015-10-14-models.jar -P lib/
    ```


3. Build the JAR

    ```sh
    $ ./sbt
    > assembly
    ```

4. Run the server

    ```sh
    $ PORT=8080 java -jar target/scala-[SCALA-VERSION]/ner-service-[SCALA-VERSION]-0.1.0-SNAPSHOT.jar &
    ```


5. Query

    ```sh
    $ curl -X POST --data "text=Das ist Angela Merkel" localhost:8080
    Das ist <I-PER>Angela Merkel</I-PER>
    ```

## Running as Daemon

If you want to run the service in the background you can use for example use systemd

```
# /etc/systemd/system/ner.service

[Unit]
Description=NER Tagging Web Service

[Service]
Type=simple
ExecStart=/usr/bin/java -jar /opt/scala-ner-server/scala-ner-server_0.1.0.jar
Restart=on-abort

[Install]
WantedBy=multi-user.target
```

Then reload the services and start it

```sh
$ sudo systemctl reload-daemons
$ sudo systemctl enable ner.service
$ sudo systemctl start ner.service

```
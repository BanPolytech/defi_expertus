# defi_expertus

## Description

Cette application est une base de "social network" avec une page de "feed" dans laquelle on peut rajouter du contenu.
Pour effectuer cette app, je me suis basé sur mes cours de JEE associé à Spring que j'ai pu avoir en 4eme année.

## Pré-requis

Il faut installer Maven CLI pour pouvoir "build" le projet

## Installation

Cloner le repo dans le dossier de votre choix puis placer vous dans celui-ci avec votre invite de commande.
Executez les commandes suivantes :

```
mvn package
java $JAVA_OPTS -jar target/expertus_defi-1.0-SNAPSHOT.jar --server.port=8082
```

Ensuite ouvrez votre navigateur et l'application sera normalement lancé à l'adresse http://localhost:8082.

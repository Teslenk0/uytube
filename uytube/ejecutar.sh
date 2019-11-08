#!/bin/bash
mvn clean compile assembly:single;cd target;sleep 2;clear;
echo "Iniciando servidor central y estacion de trabajo, espere..."
java -jar uytube-2.0-jar-with-dependencies.jar

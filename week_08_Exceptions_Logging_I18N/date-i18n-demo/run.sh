#!/bin/bash
export JAVA_HOME=/Library/Java/JavaVirtualMachines/adoptopenjdk-21.jdk/Contents/Home
mvn compile
java -Djava.util.logging.config.file=loggersettings.properties -cp target/classes/ classlist.Main

mkdir -p classes
javac -cp classes:gs-core-1.3/gs-core-1.3.jar -d classes/ src/application/sgbd/*.java
javac -cp classes:gs-core-1.3/gs-core-1.3.jar -d classes/ src/application/*.java
java -cp classes:gs-core-1.3/gs-core-1.3.jar:Driver/postgresql-42.1.4.jar application.Main
# sdfsdq

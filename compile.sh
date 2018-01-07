mkdir -p classes
javac -cp classes:gs-core-1.3/gs-core-1.3.jar:postgis.jar -d classes/ src/application/sgbd/*.java
javac -cp classes:gs-core-1.3/gs-core-1.3.jar:postgis.jar -d classes/ src/application/*.java
javac -cp classes:gs-core-1.3/gs-core-1.3.jar:postgis.jar -d classes/ src/application/affichage/*.java
javac -cp classes:gs-core-1.3/gs-core-1.3.jar:postgis.jar -d classes/ src/ihm/*.java
java -cp classes:gs-core-1.3/gs-core-1.3.jar:Driver/postgresql-42.1.4.jar:postgis.jar application.Main

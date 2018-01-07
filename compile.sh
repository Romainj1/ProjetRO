mkdir -p classes
echo "compilation en cours ..."
echo "compilation package ihm"
javac -cp classes:include/*.jar -d classes/ src/ihm/*.java
echo "compilation package sgbd"
javac -cp classes:include/gs-core-1.3.jar:include/postgis.jar:include/postgresql-42.1.4.jar -d classes/ src/application/sgbd/*.java
echo "compilation package affichage"
javac -cp classes:include/gs-core-1.3.jar:include/postgis.jar:include/postgresql-42.1.4.jar -d classes/ src/application/affichage/*.java
echo "compilation package Main"
javac -cp classes:include/gs-core-1.3.jar:include/postgis.jar:include/postgresql-42.1.4.jar -d classes/ src/application/*.java
echo "compilation terminé ! pour lancer l'application : $ source run.sh"


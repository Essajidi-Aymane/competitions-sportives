JC = javac
JV = java
JD = javadoc


cls:
	$(JC) -sourcepath src -d classes src/main/java/fil/l3/coo/Main.java
	$(JV) -classpath classes fil.l3.coo.Main

docs :
	$(JD) -sourcepath src -d docs projet-coo

projet-coo.jar:
	jar -cfm jar/projet-coo META-INF -C classes projet-coo
	java -jar jar/projet-coo.jar

tests:
	java -jar lib/junit-platform-console-standalone-1.9.1.jar -cp classes --select-package projet-coo



clean :
	rm -r classes
	rm -r docs


.PHONY: clean all

# [L3S5 COO] — Compétitions sportives

Travail du binôme:

- Aymane Essajidi
- Mohamed Amine Fadel

-----

# Livrable 1

Le livrable 1 du projet COO, porte sur la gestion de deux compétitions sportives(des ligues et des tournois), qu'on a
modélisé avec des classes

# HowTo

-- JAVADOC

pour génerer la JAVADOC, il faut éxecuter la commande suivante, depuis la racine du projet :

- javadoc -sourcepath src -d docs projet-coo

ou avec la commande make :

- make docs

-- Compilation du projet

pour compiler le projet placez vous dans la racine du projet et éxecuter la commande suivante :

- javac -sourcepath src -d classes src/main/java/fil/l3/coo/Main.java

ou avec la commande make :

- make

-- Compilation des tests

pour compiler les tests du projet, il faut éxecuter la commande suivante depuis la racine du projet :

- javac -d classes -sourcepath src -cp ".;lib/junit-platform-console-standalone-1.9.1.jar" src/test/*

-- Execution des tests

éxecutez la commande suivante pour éxecuter les tests

- java -jar lib/junit-platform-console-standalone-1.9.1.jar -cp classes --select-package projet-coo

ou avec la commande make :

- make tests

# Remarques :

- L'utilisation de la méthode playMatch() diffère d'une compétition à l'autre, c'est ce qui justifie l'abstraction de
  cette dernière.
- La méthode abstraite createCompetition() est appelée dans les sous classes pour créer les différents types d'une
  compétiton sportive.

# Conception du projet :

- Il existe un lien d'héritage entre la classe compétition et les deux sous classes tournament et league avec quelques
  dépendances par exemple la classe Competition qui dépend de la classe Competitor...

# Principes utilisés :

-- Open-Closed Principle

Admettons qu'on veut ajouter un type de compétition il suffit de le mettre en héritage avec la classe Competiton

-- Single Responsibility Principle

Chaque méthode a une seule responsabilité, par exemple la méthode play() permet de dérouler une compétition, et c'est la
méthode displayWinner() qui affiche le gagnant de cette compétition.





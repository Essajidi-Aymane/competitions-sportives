package fil.l3.coo;
import fil.l3.coo.competitions.*;
import fil.l3.coo.competitors.*;
import fil.l3.coo.exceptions.NotPowerOfTwoException;
import fil.l3.coo.competitions.FirstSelection;
import fil.l3.coo.competitions.Selection;

import fil.l3.coo.exceptions.NumberOfCompetitorsException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NotPowerOfTwoException , NumberOfCompetitorsException {
    List<Competitor> comp=new ArrayList<Competitor>();
    Scanner scanner = new Scanner(System.in);


    League l =new League(comp);
    Tournament t = new Tournament(comp);



    System.out.println("Choisissez le nombre de competiteurs que vous voulez ?(preference superieur à 2) ");
    int nbCompetitor= scanner.nextInt();
    if (nbCompetitor%2!=0){
        System.out.println("ATTENTION!!! il faut choisir un multiple de 2 POUR JOUEZ UN TOURNOI");

    }


    System.out.println("donnez les noms des competiteurs : ");

    for(int i=0;i<nbCompetitor;i++){
        String str=scanner.next();
        Competitor c= new Competitor(str);
        comp.add(c);

    }
    System.out.println(comp);
    System.out.println("Choisissez le type de la compétition.");
    System.out.println("Pour jouer un tournoi tappez 1");
    System.out.println("Pour jouer une ligue tappez 2");
    System.out.println("Pour jouer master tappez 3");
    int type = scanner.nextInt();
    while (type != 1 && type != 2 && type !=3) {
        System.out.println("Type de compétition non reconnu, veuillez séléctionner 1 ou 2");
        type = scanner.nextInt();
    }
    if (type == 1) {
        t.play();
    }
    else if (type == 2) {
        l.play();

    }
    else   {
        System.out.println(" selectionnez le nombres de poules : ");
        int  nbPoules = scanner.nextInt();
        System.out.println("Entrez le nombre de compétiteurs à qualifier pour le deuxième tour : ");

        int nbLignes = scanner.nextInt();

        System.out.println("Choisissez votre type de séléction");

        System.out.println("1 pour First selection : prend les n compétiteurs qualifiés");

        System.out.println("2 pour Second selection : prend les n meilleurs compétiteurs en plus de ceux qualifiés");
        int n = scanner.nextInt();
        while( n != 1 && n != 2 ){
            System.out.println("type de séléction non reconnu, veuillez entrer 1 ou 2");
            n = scanner.nextInt();
        }
        if (n == 1){
            Selection s=new FirstSelection(nbCompetitor,nbPoules,nbLignes );
            Master m = new Master(comp,nbPoules,nbCompetitor,s);
            m.play();
        }
        else {
            Selection s=new SecondSelection(nbCompetitor,nbPoules,nbLignes );
            Master m = new Master(comp,nbPoules,nbCompetitor,s);
            m.play();
        }





        }







    }

}

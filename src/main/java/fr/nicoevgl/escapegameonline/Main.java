package fr.nicoevgl.escapegameonline;

import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("modeDev")) {
            Game.modeDev = true;
        }
        logger.info("Démarrage du jeu");

        int nbChoice;
        do {
            System.out.println("Bienvenue dans EscapeGame Online !" + "\n");

            System.out.println("Choisissez votre mode de jeu");
            System.out.println("1 - Mode Challenger");
            System.out.println("2 - Mode Défenseur");
            System.out.println("3 - Mode Duel");
            System.out.println("4 - Quitter");

            int nbMode = 0;
            Scanner scMode = new Scanner(System.in);
            Game game = new Game();

            try {
                nbMode = scMode.nextInt();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Veuillez saisir une valeur correcte.");
            }
            do {
                game.runSelectedMode(nbMode);

                Scanner scChoice = new Scanner(System.in);
                System.out.println("Fin de la partie.");
                System.out.println("1 : Rejouer  2 : Retour au menu principal  3 : Quitter");
                nbChoice = scChoice.nextInt();
                switch (nbChoice) {
                    case 1:
                        System.out.println("Vous avez choisis de rejouer");
                        break;
                    case 2:
                        System.out.println("Retour au menu principal...");
                        break;
                    case 3:
                        System.out.println("Au revoir...");
                        break;
                    default:
                        System.out.println("Je n'ai pas compris...");
                        break;
                }
            }while (nbChoice == 1);
        } while (nbChoice == 2 || nbChoice > 3);
    }


}

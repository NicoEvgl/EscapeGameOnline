package fr.nicoevgl.escapegameonline;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Game {

    protected IAttacker attacker;
    protected IDefender defender;

    static Logger logger = LogManager.getLogger(Game.class);
    InputStream input;

    int combinationSize;
    int [] combination;
    String[] tabCombi;
    int[] proposition;
    String[] response;
    int nbEssaysMax;
    String[] tableau;
    int[] min = {0,0,0,0};
    int[] max = {9,9,9,9};
    int[] computerProposition;
    int[] newComputerProposition;
    int[] computerCombination;
    String[] sign;
    String mode_Developpeur;
    protected boolean modeDeveloppeur;
    static boolean modeDev = false;

    /**
     * Constructeurs
     */
    public Game() {
        try {
            input = new FileInputStream("config.properties");
            Properties prop = new Properties();

            // load propoerties file //

            prop.load(input);
            combinationSize = Integer.parseInt(prop.getProperty("taille.combinaison"));
            nbEssaysMax = Integer.parseInt(prop.getProperty("nombre.essai"));
            if (modeDev) {
                mode_Developpeur = "active";
            }else {
                mode_Developpeur = (prop.getProperty("mode.developpeur"));
            }
        }catch (IOException ex) {
            combinationSize = 4;
            logger.error("Problème de téléchargement du fichier .xml");
            ex.printStackTrace();
        }
        combination = new int[combinationSize];
        tabCombi = new String[combinationSize];
        response = new String[combinationSize];
        proposition = new int[combinationSize];
        tableau = new String[combinationSize];
        computerProposition = new int[combinationSize];
        newComputerProposition = new int[combinationSize];
        computerCombination = new int[combinationSize];
        sign = new String[combinationSize];
    }

    /**
     * Méthode qui permet de lancer le mode de jeu selectionné par le joueur.
     * @param nbMode : mode de jeu saisi par le joueur.
     */
    public void runSelectedMode (int nbMode) {

        switch (nbMode){
            case 1:
                System.out.println("Vous avez choisi le mode Challenger.");
                attacker = new HumanPlayer();
                defender = new IA();
                challengerMode();
                break;
            case 2:
                System.out.println("Vous avez choisi le mode Défenseur.");
                attacker = new IA();
                defender = new HumanPlayer();
                defenderMode();
                break;
            case 3:
                System.out.println("Vous avez choisi le mode Duel.");
                attacker = new HumanPlayer();
                defender = new IA();
                duelMode();
                break;
            case 4:
                System.out.println("Etes - vous sûr ?");
                break;
            default:
                System.out.println("Ce mode de jeu n'existe pas.");
                break;
        }
    }

    /** Modes de jeu **/

    /**
     * Mode Duel
     */
    private void duelMode() {
        int nbEssays = 0;
        boolean resultGame;

        System.out.println("Trouvrez la combinaison secrète et défendez la votre ! " + "\n");

        computerCombination = defender.generateCombi();
        System.out.print("La combinaison générée par le défenseur est : ");
        putResultCombi(computerCombination);
        combination = attacker.generateCombi();
        System.out.println("Votre combinaison est : ");
        putResultCombi(combination);
        do {
            nbEssays++;
            proposition = attacker.generateProp();
            System.out.print("Proposition : ");
            putResultCombi(proposition);
            response = compare(computerCombination, proposition);
            System.out.print("Réponse : ");
            putResponse(response);
            resultGame = ResultGame(response);
            if (resultGame == true) {
                System.out.println("Bravo ! Vous avez trouvez la combinaison de l'IA !");
                break;
            } else {
                System.out.println("Raté...");
            }
            System.out.println("L'IA pense a une combinaison ...");
            if (nbEssays <= 1) {
                computerProposition = defender.generateProp();
                System.out.print("proposition initiale de l'IA : ");
            } else {
                computerProposition = defender.generateNewProp(combination, computerProposition);
                System.out.println("proposition IA " + nbEssays);
            }
            putResultCombi(computerProposition);
            response = compare(combination, computerProposition);
            System.out.print("Réponse : ");
            putResponse(response);
            resultGame = ResultGame(response);
            if (resultGame == true) {
                System.out.println("HaHa ! J'ai réussis à trouver votre combinaison !");
                break;
            } else {
                System.out.println("Je n'ai pas trouvé votre combinaison.;.");
            }
            resultGame = ResultGame(response);
        }while (!resultGame && nbEssays < nbEssaysMax);
    }

    /**
     * Mode défenseur
     */
    private void defenderMode() {
        int nbEssays = 0;
        boolean resultGame;

        System.out.println("L'IA doit décovurir votre combinaison" + "\n");

        combination = defender.generateCombi();
        System.out.println("Votre combinaison est : ");
        putResultCombi(combination);
        System.out.println("L'IA pense a une combinaison ...");
        proposition = attacker.generateProp();
        response = compare(combination, proposition);
        System.out.print("proposition initiale de l'IA : ");
        putResultCombi(proposition);
        System.out.print("Réponse : ");
        putResponse(response);
        resultGame = ResultGame(response);
        nbEssays++;
        if (resultGame == true){
            System.out.println("Trop facile ! J'ai trouvé votre combinaison du premier coup !");
        }else {
            do {
                if (nbEssays <=1) {
                    System.out.println("aaaa");
                    computerProposition = attacker.generateNewProp(combination, proposition);
                }else {
                    computerProposition = attacker.generateNewProp(combination, computerProposition);
                }
                response = compare(combination, computerProposition);
                System.out.println("proposition IA " + nbEssays);
                putResultCombi(computerProposition);
                System.out.print("Réponse : ");
                putResponse(response);
                resultGame = ResultGame(response);
                nbEssays++;
            }while (!resultGame && nbEssays < nbEssaysMax);
            if (resultGame == true) {
                System.out.println("HaHa ! J'ai réussis à trouver votre combinaison !");
            }else {
                System.out.println("Sniiif ! J'ai perdu... Je n'ai pas trouvé la combinaison...");
            }
        }
    }

    /**
     * Mode Challenger
     */
    private void challengerMode() {
        int nbEssays = 0;
        boolean resultGame;

        System.out.println("Trouvrez la combinaison secrète ! " + "\n");
        combination = defender.generateCombi();
        System.out.print("La combinaison générée par le défenseur est : ");
        putResultCombi(combination);
        do {
            proposition = attacker.generateProp();
            System.out.print("Proposition : ");
            putResultCombi(proposition);
            response = compare(combination, proposition);
            System.out.print("Réponse : ");
            putResponse(response);
            resultGame = ResultGame(response);
            nbEssays++;
        }while (!resultGame && nbEssays < nbEssaysMax );
        if (resultGame == true) {
            System.out.println("Bravo ! Vous avez trouvez la combinaison de l'IA !");
        }else {
            System.out.println("Perdu ! La combinaison de l'IA n'a pas était découverte");
            System.out.println("La combinaison était : " );
            putResultCombi(combination);
        }
    }

    /**
     * isModeDeveloppeur verifie si le mode développeur est activé ou non
     * @return boolean modeDeveloppeur
     */
    public boolean isModeDeveloppeur() {
        modeDeveloppeur = false;
        if(mode_Developpeur.equals("active"))
            modeDeveloppeur = true;
        return modeDeveloppeur;
    }


    /**
     * putResultCombi affiche les éléments d'un tableau d'entier
     * @param tableau [] int
     */
    public void putResultCombi (int[] tableau) {
        for (int i = 0; i < tableau.length; i++) {
            System.out.print(tableau [i]);
        }
        System.out.print("\n");
    }

    /**
     * compare deux combinaisons qui prend en paramètre deux tableaux : la combinaison secrète et la proposition.
     * @param combination [] int
     * @param proposition [] int
     * @return String [] response
     */
    public String[] compare(int[] combination, int[] proposition ) {
        int i = 0;
        do {
            if (combination[i] < proposition[i]) {
                response[i] = "-";
            } else if (combination[i] > proposition[i]) {
                response[i] = "+";
            } else {
                response[i] = "=";
            }

            i++;
        }while (i < 4);
        return response;
    }

    /**
     * putResponse affiche les éléments d'un tableau de chaine de caractères
     * @param tableau [] String
     */
    public void putResponse(String[] tableau) {
        for (int i = 0; i < tableau.length; i++) {
            System.out.print(tableau[i]);
        }
        System.out.println("\n");
    }

    /**
     * ResultGame affiche le résultat de la comparaison des deux combinaisons.
     * si tout le tableau contient " = ", elle retourne true, si non false.
     * @param response [] String
     * @return boolean x
     */
    public boolean ResultGame(String[] response){
        boolean x = true;

        for (int i = 0; i < response.length; i++) {
            if (response[i].equals("+") || response[i].equals("-")) {
                x = false;
            }
        }
        return x;
    }
}

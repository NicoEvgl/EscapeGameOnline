package fr.nicoevgl.escapegameonline;

public class Game {

    protected IAttacker attacker;
    protected IDefender defender;

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

    /**
     * Constructeurs
     */
    public Game() {
        combinationSize = 4;
        nbEssaysMax = 4;
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

    private void duelMode() {
    }

    private void defenderMode() {
    }

    private void challengerMode() {
    }
}

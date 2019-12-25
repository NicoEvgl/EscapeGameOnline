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
     * Constructors
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
}

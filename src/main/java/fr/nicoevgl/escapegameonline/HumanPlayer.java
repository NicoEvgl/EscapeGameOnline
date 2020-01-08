package fr.nicoevgl.escapegameonline;

import java.util.Scanner;

public class HumanPlayer extends Game implements IAttacker, IDefender {
    @Override
    public int[] generateProp() {
        System.out.println("Saisissez votre proposition...");

        Scanner scProp = new Scanner(System.in);
        proposition = new  int[combinationSize];
        try {
            String combi = Integer.toString(scProp.nextInt());

            for (int i = 0; i < combi.length(); i++) {
                tabCombi[i] = String.valueOf( combi.charAt(i));
            }

            for (int i = 0; i < tabCombi.length; i++) {
                proposition[i] = Integer.parseInt(tabCombi[i]);
            }
        } catch (Exception e) {
            logger.error("Erreur de saisie");
            logger.error("Saisir uniquement des valeurs, aucun caractère spécial ni aucunes chaines de caractères " +
                    "ne sont valables");
        }
        return proposition;
    }

    @Override
    public int[] generateCombi() {
        System.out.println("Saisissez votre combinaison secrète...");

        Scanner scCombi = new Scanner(System.in);
        combination = new int[combinationSize];
        try {
            String combi = Integer.toString(scCombi.nextInt());

            for (int i = 0; i <combi.length(); i++) {
                tabCombi[i] = String.valueOf(combi.charAt(i));
            }

            for (int i = 0; i < tabCombi.length; i++) {
                combination[i] = Integer.parseInt(tabCombi[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Veuillez entrer une combinaison valide");
        }
        return combination;
    }


    @Override
    public int[] generateNewProp(int [] secretCombination, int[] firstProposition) {
        return null;
    }
}

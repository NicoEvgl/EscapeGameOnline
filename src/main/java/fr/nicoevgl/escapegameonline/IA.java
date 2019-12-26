package fr.nicoevgl.escapegameonline;

import java.util.Random;

public class IA extends Game implements IAttacker, IDefender {
    @Override
    public int[] generateCombi() {
        Random rdCombi = new Random();
        for (int i = 0; i < combinationSize; i++) {
            combination[i] = rdCombi.nextInt(max[i] + 1);
        }
        return combination;
    }


    @Override
    public int[] generateProp() {
        for (int i = 0; i < combinationSize; i++) {
            Random rdProp = new Random();
            proposition[i] = rdProp.nextInt(max[i] + 1);
        }
        return proposition;
    }

    @Override
    public int[] generateNewProp(int[] secretCombination, int[] firstProposition) {

        for (int i = 0; i < secretCombination.length; i++ ) {
            Random rdProp2 = new Random();
            if (secretCombination[i] < firstProposition[i]) {
                this.max[i] = firstProposition[i];
                proposition[i] = this.max[i] - rdProp2.nextInt(this.max[i]);
                response[i] = "-";
            } else if (secretCombination[i] > firstProposition[i]) {
                this.min[i] = firstProposition[i];
                proposition[i] = this.min[i] + rdProp2.nextInt((this.max[i] + 1) - this.min[i]);
                response[i] = "+";
            } else {
                response[i] = "=";
            }
        }
        return proposition;
    }
}

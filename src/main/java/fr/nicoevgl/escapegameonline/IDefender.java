package fr.nicoevgl.escapegameonline;

public interface IDefender {
    int[] generateCombi();

    int[] generateProp();

    int[] generateNewProp(int[] combination, int[] computerProposition);
}

package ClassTests;

import Kata02.Couleur;
import Kata02.Line;
import Kata02.Mastermind;
import Kata02.Pion;
import junit.framework.TestCase;
import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.*;

public class MastermindTest {
    Pion testPion1 = new Pion(Couleur.ROUGE);
    Pion testPion2 = new Pion(Couleur.BLANC);
    Pion testPion3 = new Pion(Couleur.BLEU);
    Pion testPion4 = new Pion(Couleur.VERT);
    Pion testPion5 = new Pion(Couleur.JAUNE);
    Pion testPion6 = new Pion(Couleur.NOIR);
    Pion testPion7 = new Pion(Couleur.VIOLET);

    @Test
    public void PionCreation() throws Exception {
        Pion testPion = new Pion(Couleur.ROUGE);
        assertEquals(Couleur.ROUGE, testPion.getCouleur());
    }

    @Test
    public void LineCreation() throws Exception {
        Line testLine = new Line(testPion1, testPion2, testPion3, testPion4);

        ArrayList<Pion> testArray = new ArrayList<Pion>();
        testArray.add(testPion1);
        testArray.add(testPion2);
        testArray.add(testPion3);
        testArray.add(testPion4);

        assertTrue(testArray.equals(testLine));
    }

    @Test
    public void Wellplaced() throws Exception {
        Mastermind mm = new Mastermind();
        Line secretLine = new Line(testPion1, testPion2, testPion3, testPion4);
        Line testLine = new  Line(testPion1, testPion2, testPion3, testPion5);
        int[] testArray = mm.evaluate(secretLine, secretLine);
        assertEquals(4, testArray[0]);
        assertEquals(0, testArray[1]);

        testArray = mm.evaluate(secretLine, testLine);
        assertEquals(3, testArray[0]);
        assertEquals(0, testArray[1]);
    }

    @Test
    public void Misplaced() throws Exception {
        Mastermind mm = new Mastermind();
        Line secretLine = new Line(testPion1, testPion2, testPion3, testPion4);
        Line testLine = new  Line(testPion4, testPion3, testPion2, testPion1);
        int[] testArray;

        testArray = mm.evaluate(secretLine, testLine);
        assertEquals(0, testArray[0]);
        assertEquals(4, testArray[1]);

        testLine = new  Line(testPion3, testPion1, testPion2, testPion5);
        testArray = mm.evaluate(secretLine, testLine);
        assertEquals(0, testArray[0]);
        assertEquals(3, testArray[1]);
    }

    @Test
    public void WellAndMisplaced() throws Exception {
        Mastermind mm = new Mastermind();
        Line secretLine = new Line(testPion1, testPion2, testPion3, testPion4);
        Line testLine = new  Line(testPion1, testPion2, testPion4, testPion3);
        int[] testArray;

        testArray = mm.evaluate(secretLine, testLine);
        assertEquals(2, testArray[0]);
        assertEquals(2, testArray[1]);
    }

    @Test
    public void WrongCombination() throws Exception {
        Mastermind mm = new Mastermind();
        Line secretLine = new Line(testPion1, testPion2, testPion3, testPion4);
        Line testLine = new  Line(testPion5, testPion5, testPion5, testPion5);
        int[] testArray;

        testArray = mm.evaluate(secretLine, testLine);
        assertEquals(0, testArray[0]);
        assertEquals(0, testArray[1]);
    }
}

import com.sun.xml.internal.ws.handler.HandlerException;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

public class MastermindTest extends TestCase{

    /*


    //Tester que on ai bien une arrayList comprenant les données recherchées
    @Test
    public void ListeCouleur() throws HandlerException {
        ArrayList ArrayListListe = new ArrayList();
        ArrayListListe.add(0,0,0,0);
        int ArrayListListeCount = 1;

        ArrayList ListeCouleur = new ArrayList();
        ListeCouleur.add(0,0,0,0);


        assertEquals(0,0);
    }


    //Vérifier que donner les bonnes réponses fonctionne
    @Test
    public void TestReponseDonnee() throws HandlerException {

        ArrayList ArrayListListe = new ArrayList();
        ArrayListListe.add(0,0,0,0);
        int ArrayListListeCount = 1;

        ArrayList ListeCouleur = new ArrayList();
        ListeCouleur.add(0,0,0,0);

    }
        if ArrayListListe.equals.ListeCouleur{
        System.out.println("Gagné");
    }
}

    //Tester que les données répondus et fausses soient bien vérifiées comme fausses
    @Test
    public void ListeCouleur() throws HandlerException {

        ArrayList ArrayListListe = new ArrayList();
        ArrayListListe.add(0,0,0,0);
        int ArrayListListeCount = 1;

        ArrayList ListeCouleur = new ArrayList();
        ListeCouleur.add(0,0,0,1);

        if 1.ArrayListListe != 1.ListeCouleur{
            System.out.println("FAUX");
            else{
                System.out.println("Gagné");
            }
        }
        if 2.ArrayListListe != 2.ListeCouleur{
            System.out.println("FAUX");
            else{
                System.out.println("Gagné");
            }
        }
        if 3.ArrayListListe != 3.ListeCouleur{
            System.out.println("FAUX");
            else{
                System.out.println("Gagné");
            }
        }
        if 4.ArrayListListe != 4.ListeCouleur{
            System.out.println("FAUX");
            else{
                System.out.println("Gagné");
            }
        }
    }

    //Vérifier que on passe d'un arraylist n à n+1 à chaque ligne terminée
    @Test
    public void ArrayListListe() throws HandlerException {

        ArrayList ArrayListListe = new ArrayList();
        ArrayListListe.add(0,0,,0);
        int ArrayListListeCount = 1;

        ArrayList ListeCouleur = new ArrayList();
        ListeCouleur.add(0,0,0,0);

        if ReponseDonnee != ListeCouleur{
            ArrayListListeCount++;
        }
    }


    //Vérifier que le nombre maximum de tentatives s'arrête à 12
    @Test
    public void ArrayListListeMax() throws HandlerException {
        ArrayList ArrayListListe = new ArrayList();
        ArrayListListe.add(0,0,,0);
        int ArrayListListeCount = 1;

        ArrayList ListeCouleur = new ArrayList();
        ListeCouleur.add(0,0,0,0);

        if ArrayListListeCount = 12 && ReponseDonnee != ListeCouleur{
            System.out.println("Perdu !");
        }
    }

    //Vérifier que le réussir à 12 ne marque pas perdu
    @Test
    public void ArrayListListeMax() throws HandlerException {
        ArrayList ArrayListListe = new ArrayList();
        ArrayListListe.add(0,0,,0);
        int ArrayListListeCount = 1;

        ArrayList ListeCouleur = new ArrayList();
        ListeCouleur.add(0,0,0,0);

        if ArrayListListeCount = 12 && ReponseDonnee = ListeCouleur{
            System.out.println("Gagné !");
        }
    }

    */


    public static ArrayList<Couleur> initialiselist () {
        ArrayList <Couleur> pionliste = new ArrayList<Couleur>();
        pionliste.add(Couleur.Bleu);
        pionliste.add(Couleur.Rouge);
        pionliste.add(Couleur.Vert);
        pionliste.add(Couleur.Jaune);
        return pionliste;
    }




    //Tester que on ai bien une arrayList comprenant les données recherchées
    @Test
    public void CreationDesPions() throws HandlerException {
        ArrayList<Couleur> Verite = initialiselist();
        ArrayList<Couleur> Essai = initialiselist();
        assertTrue(Verite.equals(Essai));




    }

    @Test
    public void VérifierIdentiques() throws HandlerException {
        ArrayList Pion = new ArrayList();
        ArrayList Proposition = new ArrayList();
        assertEquals(Pion, Proposition);


    }




}

import java.util.ArrayList;

public class Mastermind {
    public int[] Test(ArrayList<Couleur> Sac1, ArrayList<Couleur> Sac2) {
        int[] Sortie = {0, 0};
        for (int k = 0; k < Sac1.size(); k++) {
            for (int l = 0; l < Sac2.size(); l++) {
                if (Sac1.get(k).equals(Sac2.get(l))) {
                    Sortie[0]++;
                }
                if (k == l && Sac1.get(k).equals(Sac2.get(l))) {
                        Sortie[1]++;
                    }
                    else{
                        Sortie[0]++;
                }
                }
            }
        return Sortie;
    }
}

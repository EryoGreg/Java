package Kata02;

import java.util.ArrayList;

public class Line extends ArrayList<Pion> {
    public Line(Pion pion1, Pion pion2, Pion pion3, Pion pion4) {
       this.add(pion1);
       this.add(pion2);
       this.add(pion3);
       this.add(pion4);
    }

}

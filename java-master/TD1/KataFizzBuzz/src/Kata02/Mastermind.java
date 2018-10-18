package Kata02;

import java.util.ArrayList;

public class Mastermind {
    public int[] evaluate (ArrayList<Pion> arrayList1, ArrayList<Pion> arrayList2){
        int[] returnArray = {0,0};
        for(int i = 0; i < arrayList1.size(); i++) {
            for (int j = 0; j < arrayList2.size(); j++) {
                if (arrayList1.get(i).equals(arrayList2.get(j)) && i == j) {
                    returnArray[0]++;
                } else if (arrayList1.get(i).equals(arrayList2.get(j))) {
                    returnArray[1]++;
                }
            }
        }
        return returnArray;
    }
}

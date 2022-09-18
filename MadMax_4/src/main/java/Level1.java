public class Level1 {
    public static int[] MadMax(int N, int[] Tele) {
        int[] massivB = new int[N];
        for(int i=0; i<massivB.length; i++) {
            massivB[i] = -1;
        }

        int minElement = Tele[0];
        for(int i=0; i<N/2; i++) {
            for(int g=0; g<N; g++) {
                if(contains(massivB, Tele[g]) == false) {
                    minElement = Tele[g];
                }
            }
            for(int count : Tele) {
                if(minElement > count
                        && (contains(massivB, count) == false)) {
                    minElement = count;
                }
            }
            massivB[i] = minElement;
        }
        int maxElement = Tele[0];
        for(int count1 : Tele) {
            if(maxElement < count1) {
                maxElement = count1;
            }
        }
        massivB[N/2] = maxElement;

        for(int g1=N/2+1; g1<N; g1++) {
            for(int c=0; c<N; c++) {
                if(contains(massivB, Tele[c]) == false) {
                    maxElement = Tele[c];
                }
            }
            for(int count : Tele) {
                if(maxElement < count
                        && (contains(massivB, count) == false)) {
                    maxElement = count;
                }
            }
            massivB[g1] = maxElement;
        }
        return massivB;
    }
    public static boolean contains(int[] values, int target) {
        for (int count : values) {
            if (count == target) return true;
        }
        return false;
    }
}

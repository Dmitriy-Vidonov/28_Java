public class ForTest {
    public static int[] forTest(int N) {
        int[] massivA = new int[N]; //массив для хранения первичных значений
        massivA = Methods.generateArray(N, 0, 255);

        int[] massivB = new int[N];
        for(int i=0; i<massivB.length; i++) {
            massivB[i] = -1;
        }

        int minElement = massivA[0];
        for(int i=0; i<N/2; i++) {
            for(int g=0; g<N; g++) {
                if(Methods.contains(massivB, massivA[g]) == false) {
                    minElement = massivA[g];
                }
            }
            for(int count : massivA) {
                if(minElement > count
                        && (Methods.contains(massivB, count) == false)) {
                    minElement = count;
                }
            }
            massivB[i] = minElement;
        }

        //ищем максимальный элемент
        int maxElement = massivA[0];
        for(int count1 : massivA) {
            if(maxElement < count1) {
                maxElement = count1;
            }
        }
        massivB[N/2] = maxElement;

        for(int g1=N/2+1; g1<N; g1++) { //циклы до конца массива
            for(int c=0; c<N; c++) {
                if(Methods.contains(massivB, massivA[c]) == false) {
                    maxElement = massivA[c];
                }
            }
            for(int count : massivA) {
                if(maxElement < count
                        && (Methods.contains(massivB, count) == false)) {
                    maxElement = count;
                }
            }
            massivB[g1] = maxElement;
        }
        return massivB;
    }
}

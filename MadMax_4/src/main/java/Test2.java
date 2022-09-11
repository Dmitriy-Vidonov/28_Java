public class Test2 {
    public static void main(String[] args) {
        int N = 7;
       // int[] massivA = new int[N]; //массив для хранения первичных значений
       // massivA = Methods.generateArray(N, 0, 255);
        int[] massivA = {207, 244, 240, 101, 245, 0, 16};

        //тестовый вывод содержимого массива B
        for(int i1=0; i1<N; i1++) {
            System.out.print(massivA[i1] + " ");
        }
        System.out.println(); //просто переход на новую строку

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

       //ищем максимальный элемент для центра массива
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

        //тестовый вывод содержимого массива B
        for(int i1=0; i1<N; i1++) {
            System.out.print(massivB[i1] + " ");
        }
        System.out.println(); //просто переход на новую строку


        /*ручной тест с выводом корявых данных
        int count = 0;
        int N1 = 7;
        for (int i=0; i<500; i++) {
            int[] arrTest = Methods.generateArray(N1, 0, 255);
            int[] arr = ForTest2.forTest2(arrTest, N1);

            if(Methods.isRepeats(arr) == true) {
                //тестовый вывод содержимого массива A
                for(int i1=0; i1<N; i1++) {
                    System.out.print(arrTest[i1] + " ");
                }
                System.out.println(); //просто переход на новую строку

                //тестовый вывод содержимого массива B
                for(int i1=0; i1<N; i1++) {
                    System.out.print(arr[i1] + " ");
                }
                System.out.println(); //просто переход на новую строку
            }
        }
        */
    }
}

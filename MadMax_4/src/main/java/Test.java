import java.util.*;

public class Test {
    public static boolean contains(int[] values, int target) {
        return Arrays.stream(values)
                .filter(x -> x == target)
                .count() > 0;
    }

    public static void main(String[] args) {
        //вызов метода генерации массива из случайных чисел длиной N
        int N = 7;
        int[] arrTest = new int[N]; //массив для хранения первичных значений
        arrTest = Methods.generateArray(N, 0, 255);

        //тестовый вывод содержимого массива arrTest
        for(int i=0; i<N; i++) {
            System.out.print(arrTest[i] + " ");
        }
        System.out.println(); //просто переход на новую строку
        //находим максимальный элемент массива

        //создаем финальный массив. первым элементом в него кладем минимальное значение
        int[] finArr = new int[N];
        // finArr[0] = minElement;

        int maxElement = 0;
        int minElement = arrTest[0];
        for(int j=0; j<N; j++) {
            if(maxElement < arrTest[j]){
                maxElement = arrTest[j];
                if(contains(finArr, maxElement) == false) {

                }
            }
            if(minElement > arrTest[j]) minElement = arrTest[j];
        }
        //в центр кладем максимальнй элемент
        //finArr[N/2] = maxElement;


        System.out.println("maxElement = " + maxElement); //тестовый вывод максимального элемента
        System.out.println("minElement = " + minElement); //тестовый вывод минимального элемента

        boolean found = contains(finArr, maxElement); //определили, что элемент в списке уже есть
        System.out.println(found);

        int maxElement1 = 0;
        int minElement1 = arrTest[0];
        for(int l=0; l<=N/2; l++) {
           // if(maxElement1 < arrTest[l] && (contains(finArr, maxElement1) == false)) finArr[l] = arrTest[l];
            if(minElement1 > arrTest[l] && (contains(finArr, minElement1) == false)) finArr[l] = arrTest[l];
        }

        //тестовый вывод содержимого массива finArr
        for(int k=0; k<N; k++) {
            System.out.print(finArr[k] + " ");
        }
    }
}

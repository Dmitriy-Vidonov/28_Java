import java.util.*;

public class Methods {
    //метод для определения максимального значения из диапазона
    public static int maxElfromArray(int[] array, int j, int k) {
        int maxElement = array[j];
        for (int i=j; i<=k; i++) {
            if(maxElement < array[i]) {
                maxElement = array[i];
            }
        }
        return maxElement;
    }

    //метод для трансформации массива
    public static int[] Transform(int[] arr, int N) {
        List<Integer> arrB = new ArrayList<>();
        int i, j, k;
        i = j = k = 0;
        for (i = 0; i <= N - 1; i++) {
            for (j = 0; j <= N - i - 1; j++) {
                k = i + j;
                arrB.add(arrB.size(), maxElfromArray(arr, j, k)); //новый элемент добавляем в конец списка
            }
        }
        //переводим список в массив
        int[] resArr = new int[arrB.size()];
        for (int count = 0; count < arrB.size(); count++){
            resArr[count] = arrB.get(count);
        }
        return resArr;
    }

    //testing
    public static void main(String[] args) {
        int[] arrA = {5, 7, 10, 4};
        int j = 1;
        int k = 2;
        System.out.println(maxElfromArray(arrA, j, k));
    }
}

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Methods {
    public static int[] generateArray(int arraySize, int min, int max) { //генерация массива уник. случайных чисел в диапазоне
        ArrayList<Integer> arr = new ArrayList<>();
        while (arr.size() < arraySize) {
            int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1); //генерим число в нужном диапазоне
            if (!arr.contains(randomNum)) arr.add(randomNum);
        }
        int[] res = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            res[i] = arr.get(i);
        }
        return res;
    }

    public static boolean contains(int[] values, int target) {
        for (int count : values) {
            if (count == target) return true;
        }
        return false;
    }

    //проверяем наличие повторов в массиве
    public static boolean isRepeats(int[] arr) {
        int count = 0;
        for (int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                if(arr[i] == arr[j]) count++;
            }
        }
        if(count > arr.length) return true;
        return false;
    }
}
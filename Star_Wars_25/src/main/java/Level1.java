import java.util.*;

public class Level1 {
    public static boolean TransformTransform(int[] A, int N) {
        int[] array = Methods.Transform(A, N);
        int len = array.length;
        int[] resArray = Methods.Transform(array, len);

        int sum = 0;
        for (int num : resArray) sum += num;
        return (sum % 2 == 0);
    }

    public static int[] Transform(int[] arr, int N) {
        List<Integer> arrB = new ArrayList<>();
        int i, j, k;
        i = j = k = 0;
        for (i = 0; i <= N - 1; i++) {
            for (j = 0; j <= N - i - 1; j++) {
                k = i + j;
                arrB.add(arrB.size(), maxElfromArray(arr, j, k));
            }
        }
        int[] resArr = new int[arrB.size()];
        for (int count = 0; count < arrB.size(); count++){
            resArr[count] = arrB.get(count);
        }
        return resArr;
    }

    public static int maxElfromArray(int[] array, int j, int k) {
        int maxElement = array[j];
        for (int i=j; i<=k; i++) {
            if(maxElement < array[i]) {
                maxElement = array[i];
            }
        }
        return maxElement;
    }
}

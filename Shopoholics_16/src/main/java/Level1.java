import java.util.*;

public class Level1 {
    public static int MaximumDiscount(int N, int[] price) {
        int buffer, index, max;

        mainloop: for (int i=0; i<N; i++) {
            for (int j=i; j<N; j++) {
                max = MaxElement(price, j);
                buffer = price[i];
                index = FindIndex(max, price, j);
                price[i] = max;
                price[index] = buffer;
                continue mainloop;
            }
        }
        int sum = 0;
        for (int i=1; i<=N; i++) {
            if (i % 3 == 0) {
                sum += price[i-1];
            }
        }
        return sum;
    }

    public static int FindIndex(int element, int[] array, int startIndex) {
        int i;
        for (i=startIndex; i<array.length; i++) {
            if(array[i] == element) {
                break;
            }
        }
        return i;
    }

    public static int MaxElement(int[] array, int startIndex) {
        int max = array[startIndex];
        for (int i=startIndex; i<array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }
}

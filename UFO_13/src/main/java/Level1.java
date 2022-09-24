import java.util.*;

public class Level1 {
    public static int[] UFO(int N, int[] data, boolean octal) {
        int buffer, divider;
        buffer = divider = 0;

        if (octal) {
            divider = 8;
        } else divider = 16;

        for(int i=0; i<N; i++) {
            buffer = data[i];
            int[] bufferArr = numToArr(buffer);
            buffer = convert(bufferArr, divider);
            data[i] = buffer;
        }
        return data;
    }
    public static int[] numToArr(int number) {
        int res = number;
        int divider = 1;
        int count = 0;

        do {
            res = number / divider;
            divider *= 10;
            count++;
        } while (res >= 10);

        int[] numArray = new int[count];
        int arrCount = 0;
        for (int i = count - 1; i >= 0; i--) {
            if (number > 10) {
                numArray[arrCount] = (int) (number / Math.pow(10, i));
                number -= (int) (Math.pow(10, i) * numArray[arrCount]);
                arrCount++;
            } else numArray[arrCount] = number;
        }
        return numArray;
    }

    public static int convert(int[] arr, int divider) {
        int res = 0;
        int arrCount = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            res += arr[arrCount] * (int) Math.pow(divider, i);
            arrCount++;
        }
        return res;
    }
}
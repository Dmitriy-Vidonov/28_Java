import java.util.*;

public class Level1 {
    public static String Keymaker(int k) {
        boolean[] arr = new boolean[k];
        for (int i = 0; i < k; i++) arr[i] = false;

        for (int step = 1; step <= k; step++) {
            if (step == 1) {
                for (int i = 0; i < arr.length; i++) Change(arr, i);
            }
            else {
                ReplaceEachStep(arr, step);
            }
        }
        return ArrayToString(arr);
    }

    public static void Change(boolean[] array, int i) {
        if(array[i] == true) {
            array[i] = false;
        } else array[i] = true;
    }

    public static void ReplaceEachStep(boolean[] arr, int step) {
        int i = 0;
        while (i < arr.length) {
            if (i + (step - 1) < arr.length) Change(arr, i += step - 1);
            i++;
        }
    }

    public static String ArrayToString(boolean[] array) {
        String str = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i] == false) str += "0";
            else str += "1";
        }
        return str;
    }
}

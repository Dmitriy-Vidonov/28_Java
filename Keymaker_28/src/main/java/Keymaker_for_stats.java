import java.util.ArrayList;
import java.util.List;

public class Keymaker_for_stats {
    public static void KeymakerForStats(int k) {
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
        //System.out.println(ArrayToString(arr));
        //Надо вывести строку, где первой цифрой идет k, а далее - номера открытых дверей
        ShowStatArray(StatArray(arr, k));
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

    //метод для построения статистического списка
    public static List<Integer> StatArray(boolean[] array, int k) {
        List<Integer> statList = new ArrayList<>();
        statList.add(k);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == true) {
                statList.add(i + 1);
            }
        }
        return statList;
    }

    //метод для вывода статистического списка
    public static void ShowStatArray(List<Integer> arrayList) {
        for (int nums : arrayList) System.out.print(nums + ", "); System.out.println();
    }
}

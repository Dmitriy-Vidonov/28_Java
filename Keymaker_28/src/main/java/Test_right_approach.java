import java.util.*;

public class Test_right_approach {
    //метод инверсии состояния двери на противоположное
    public static void Change(boolean[] array, int i) {
        if(array[i] == true) {
            array[i] = false;
        } else array[i] = true;
    }

    //метод тестового вывода массива в консоль
    public static void ShowArr(boolean[] array) {
        for (boolean door : array) System.out.print(door + ", ");
    }

    //Метод для смены в массиве i-ого элемента на противоположный смена на каждый step-ный элемент
    public static void ReplaceEachStep(boolean[] arr, int step) {
        int i = 0;
        while (i < arr.length) {
            if (i + (step - 1) < arr.length) Change(arr, i += step - 1);
            i++;
        }
    }

    //метод перевода булевого массива в строку
    public static String ArrayToString(boolean[] array) {
        String str = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i] == false) str += "0";
            else str += "1";
        }
        return str;
    }

    public static void main(String[] args) {
        int k = 50;
        boolean[] arr = new boolean[k];
        //создаем булевый массив исходя из заданного значения k
        for (int i = 0; i < k; i++) arr[i] = false;

        for (int step = 1; step <= k; step++) {
            if (step == 1) {
                for (int i = 0; i < arr.length; i++) Change(arr, i);
            }
            else {
                ReplaceEachStep(arr, step);
            }
        }
        ShowArr(arr); System.out.println();
        System.out.println(ArrayToString(arr));
    }
}

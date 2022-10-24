import java.util.*;

public class Test_Keymaker {
    //метод инверсии состояния двери
    public static void Change(boolean[] array, int i) {
        if(array[i] == true) {
            array[i] = false;
        } else array[i] = true;
    }

    //метод создания входного булевого массива
    public static boolean[] ArrayCreate(int k) {
        boolean[] array = new boolean[k];
        for (int i = 0; i < k; i++) {
            array[i] = false;
        }
        return array;
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

    //метод для вывода булева массива в консоль
    public static void Show(boolean[] array) {
        for (boolean door : array) System.out.print(door + ", "); System.out.println();
    }

    //метод для совершения 1 шага
    public static void Step1(boolean[] array) {
        for (int i = 0; i < array.length; i++) Change(array, i);
    }

    //метод для совершения 2 шага
    public static void Step2(boolean[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) Change(array, i);
        }
    }

    //метод для совершения 3 шага
    public static void Step3(boolean[] array) {
        for (int i = 0; i < array.length; i++) {
            if ((i + 1) % 3 == 0) Change(array, i);
        }
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

    //мето для вывода статистического списка 2-ого типа (отображение длины в зависимости от параметра k)
    public static void ShowStatArray2(List<Integer> arrayList) {
        System.out.print("k = " + arrayList.get(0) + ", ");
        System.out.println(arrayList.size() - 1);
    }

    //Основной метод Keymaker()
    public static void Keymaker(int k) {
        boolean[] doors = ArrayCreate(k);

        switch (k) {
            case 1:
                Step1(doors);
                break;
            case 2:
                Step1(doors);
                Step2(doors);
                break;
            case 3:
                Step1(doors);
                Step2(doors);
                Step3(doors);
                break;
            default:
                Step1(doors);
                Step2(doors);
                Step3(doors);
                for (int step = 3; step < doors.length; step++) {
                    Change(doors, step);
                }
                break;
        }
        //Show(doors); //вывод итогового булева массива
        //System.out.println(ArrayToString(doors)); //вывод итоговой строки
        //ниже дан тестовый вывод статистического массива
        List<Integer> statList = StatArray(doors, doors.length);
        //ShowStatArray(statList); //вывод списка целиком
        ShowStatArray2(statList); //вывод k + размер списка - 1
    }
    //Здесь пишем тестовый код с main()
    public static void main(String[] args) {
        for (int i = 1; i <= 40; i++) {
            Keymaker(i);
        }
    }
}

import java.util.*;

public class Test {
    public static void main(String[] args) {
        int[] arrTest = {5, 4, 3, 2, 1};
        List<Integer> arrList = new ArrayList<>();
        for(int nums : arrTest) arrList.add(nums);

        //if (Collections.max(arrList) == arrList.get(4)) System.out.println(arrList.get(4) + " - max");
        System.out.println("первичный список:");
        for(int nums : arrList) System.out.print(nums + " "); System.out.println();

        //для первого метода - перестановки - пропишем частный случай - сравнение
        int listSize = arrList.size();
        if (arrList.get(0) == Collections.max(arrList)) { //если первый элемент массива - максимальный
            int buffer = arrList.get(listSize - 1); //в буфер поместили нулевой элемент -> 1
            arrList.set(listSize - 1, arrList.get(0)); //в последний элемент поместили значение из буфера
            arrList.set(0, buffer); //нулевой на последний 5 -> 1
        }

        //тестовый вывод
        for(int nums : arrList) System.out.print(nums + " "); System.out.println();
    }
}

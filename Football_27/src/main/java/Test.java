import java.util.*;

public class Test {
    public static void main(String[] args) {
        int[] arrTest = {1, 7, 5, 3, 9};
        List<Integer> arrList = new ArrayList<>();
        for(int nums : arrTest) arrList.add(nums);

        //if (Collections.max(arrList) == arrList.get(4)) System.out.println(arrList.get(4) + " - max");
        System.out.println("первичный список:");
        for(int nums : arrList) System.out.print(nums + " "); System.out.println();

        //для первого метода - перестановки - пропишем частный случай - сравнение
        int listSize = arrList.size();

        //если у нас есть i-тый элемент, который максимальный, мы его меняем местами с тем элементом, который
        //стоит в конце. И потом делаем проверку - упорядочился массив или нет. То есть если этот элемент стоит не в конце

        /*if (arrList.get(0) == Collections.max(arrList)) { //если первый элемент массива - максимальный
            int buffer = arrList.get(listSize - 1); //в буфер поместили нулевой элемент -> 1
            arrList.set(listSize - 1, arrList.get(0)); //в последний элемент поместили значение из буфера
            arrList.set(0, buffer); //нулевой на последний 5 -> 1
        }*/

        //в цикле по всем элементам массива - если элемент максимальный и не стоит в конце, то меняем
        //его местами с тем элементом, который стоит в конце
        int buffer;
        int firstNum, secondNum;
        buffer = firstNum = secondNum = 0;
        for (int i=0; i<listSize; i++) {
            if (arrList.get(i) == Collections.max(arrList) && i != listSize - 1) { //частный случай, если max не в конце
                buffer = arrList.get(listSize - 1); //в буфер поместили последний элемент
                arrList.set(listSize - 1, arrList.get(i)); //в последний элемент поместили значение из буфера
                arrList.set(i, buffer); //максимальный элемент на последний
                //ищем первое число, которое меньше и своего предшественника и своего последователя
            } else if ((i >= 1 && i < listSize - 1) && arrList.get(i) < arrList.get(i-1)
                    && arrList.get(i) < arrList.get(i+1)) {
                firstNum = arrList.get(i);
            } else if ((i >= 1 && i < listSize - 1) && arrList.get(i) > arrList.get(i-1)
                    && arrList.get(i) > arrList.get(i+1)) {
                secondNum = arrList.get(i);
            }
        }
        System.out.println("firstNum = " + firstNum);
        System.out.println("secondNum = " + secondNum);

        //прописать отдельный метод для смены firstNum на secondNum

        //тестовый вывод
        for(int nums : arrList) System.out.print(nums + " "); System.out.println();

        //проверка на упорядоченность по возрастанию
        List tmp = new ArrayList(arrList);
        Collections.sort(tmp);
        boolean sorted = tmp.equals(arrList);

        if (sorted) System.out.println("массив упорядочен");
        else System.out.println("массив не упорядочен");
    }
}

import java.util.*;

public class Test {
    public static void main(String[] args) {
        //int[] arrTest = {1, 7, 5, 3, 9};
        int[] arrTest = {1, 2, 3, 7, 6, 5, 4, 8};
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
        int firstIndex, secondIndex;
        buffer = firstIndex = secondIndex = 0;
        //здесь вернее взять индекс чиала, а не само его число, так будет проще с ними оперировать в дальнейшем
        for (int i=0; i<listSize; i++) {
            if (arrList.get(i) == Collections.max(arrList) && i != listSize - 1) { //частный случай, если max не в конце
                buffer = arrList.get(listSize - 1); //в буфер поместили последний элемент
                arrList.set(listSize - 1, arrList.get(i)); //в последний элемент поместили значение из буфера
                arrList.set(i, buffer); //максимальный элемент на последний
                //ищем первое число, которое меньше и своего предшественника и своего последователя
            } else if ((i >= 1 && i < listSize - 1) && arrList.get(i) < arrList.get(i-1)
                    && arrList.get(i) < arrList.get(i+1)) {
                firstIndex = i;
            } else if ((i >= 1 && i < listSize - 1) && arrList.get(i) > arrList.get(i-1)
                    && arrList.get(i) > arrList.get(i+1)) {
                secondIndex = i;
            }
        }
        System.out.println("firstNum = " + firstIndex);
        System.out.println("secondNum = " + secondIndex);

        //прописать отдельный метод для смены firstNum на secondNum

        //тестовый вывод
        for(int nums : arrList) System.out.print(nums + " "); System.out.println();

        //проверка на упорядоченность по возрастанию
        System.out.println("Упорядочен ли массив - " + Methods.isListSorted(arrList));

        //Реализация второго метода
        System.out.println("Реализация второго метода");
        int startNum, endNum;
        startNum = endNum = 0;
        boolean startNumInstalled = false;
        boolean endNumInstalled = false;

        for (int i = 1; i < listSize - 1; i++) {
            if (arrList.get(i) < arrList.get(i-1) && startNumInstalled == false && endNumInstalled == false) { //если последующий элемент при проходе списка больше предыдущего
                startNum = i-1;
                startNumInstalled = true;
                System.out.println("number1 = " + arrList.get(i-1));
                //здесь надо проверять и предыдущий и последующий элементы, иначе у нас на следующем элементе все условия ок
            } else if (arrList.get(i) < arrList.get(i+1) && startNumInstalled == true && endNumInstalled == false) {
                endNum = i;
                endNumInstalled = true;
                System.out.println("number2 = " + arrList.get(i));
            }
        }
        System.out.println("startNum = " + startNum);
        System.out.println("endNum = " + endNum);

        //вынести полученное подмножество по координатам - в отдельный список
        List<Integer> bufferList = new ArrayList<>();
        for (int count = startNum; count <= endNum; count++) {
            bufferList.add(arrList.get(count));
        }
        Collections.reverse(bufferList);

        //тестовый вывод уже отсортированного массива
        System.out.println("Инвертированное подмножество:");
        for (int nums : bufferList) System.out.print(nums + " "); System.out.println();

        //Инвертированное подмножество влепить в исходный массив
        //Помнить, что на вход мы получаем чистый исходный массив, если первый метод не дал результатов
        int buffercount = 0;
        for (int i = startNum; i <= endNum; i++) {
            arrList.set(i, bufferList.get(buffercount));
            buffercount++;
        }

        //Тестовый вывод полученного массива
        for (int nums : arrList) System.out.print(nums + " "); System.out.println();

        //Проверка полученного массива на упорядоченность
        System.out.println("Итоговый массив сортирован - " + Methods.isListSorted(arrList));
    }
}
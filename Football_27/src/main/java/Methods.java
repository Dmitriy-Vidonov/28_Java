import java.util.*;

public class Methods {
    //Проверка списка на сортировку
    public static boolean isListSorted(List<Integer> arrList) {
        List tmp = new ArrayList(arrList);
        Collections.sort(tmp);
        boolean sorted = tmp.equals(arrList);
        return sorted;
    }

    //вывод списка в консоль
    public static void Show(List<Integer> listToShow) {
        for(int nums : listToShow) System.out.print(nums + " "); System.out.println();
    }

    //метод для смены элементов местами
    public static void ElementsReplace(List<Integer> listToReplace, int firstIndex, int secondIndex) {
        int buffer = listToReplace.get(firstIndex);
        listToReplace.set(firstIndex, listToReplace.get(secondIndex));
        listToReplace.set(secondIndex, buffer);
    }

    //1-й метод перестановки
    public static boolean theFirstMethod(List<Integer> firstList) {
        boolean result = false;
        int listSize = firstList.size();
        int buffer, firstIndex, secondIndex;
        buffer = firstIndex = secondIndex = 0;
        //здесь вернее взять индекс чиала, а не само его число, так будет проще с ними оперировать в дальнейшем
        for (int i=0; i<listSize; i++) {
            if (firstList.get(i) == Collections.max(firstList) && i != listSize - 1) { //частный случай, если max не в конце
                buffer = firstList.get(listSize - 1); //в буфер поместили последний элемент
                firstList.set(listSize - 1, firstList.get(i)); //в последний элемент поместили значение из буфера
                firstList.set(i, buffer); //максимальный элемент на последний
                //ищем первое число, которое меньше и своего предшественника и своего последователя
            } else if ((i >= 1 && i < listSize - 1) && firstList.get(i) < firstList.get(i-1)
                    && firstList.get(i) < firstList.get(i+1)) {
                firstIndex = i;
            } else if ((i >= 1 && i < listSize - 1) && firstList.get(i) > firstList.get(i-1)
                    && firstList.get(i) > firstList.get(i+1)) {
                secondIndex = i;
            }
        }
        //сделать перестановку согласно полученным индексам
        ElementsReplace(firstList, firstIndex, secondIndex);

        return isListSorted(firstList);
    }

    //Testing
    public static void main(String[] args) {
        int[] arrTest = {1, 7, 5, 3, 9};
        List<Integer> arrList = new ArrayList<>();
        for(int nums : arrTest) arrList.add(nums);
        boolean firstMethod = false;
        firstMethod = theFirstMethod(arrList);

        Show(arrList);
        System.out.println("первый метод - " + firstMethod);

    }
}

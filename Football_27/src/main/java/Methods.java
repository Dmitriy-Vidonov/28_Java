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
        int listSize = firstList.size();
        int buffer, firstIndex, secondIndex;
        buffer = firstIndex = secondIndex = 0;
        //здесь вернее взять индекс числа, а не само его число, так будет проще с ними оперировать в дальнейшем
        for (int i=0; i<listSize; i++) {
            if (firstList.get(i) == Collections.max(firstList) && i != listSize - 1) { //частный случай, если max не в конце
                buffer = firstList.get(listSize - 1); //в буфер поместили последний элемент
                firstList.set(listSize - 1, firstList.get(i)); //в последний элемент поместили значение из буфера
                firstList.set(i, buffer); //максимальный элемент на последний
                break;
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

    //2-й метод перестановки //переписать по аналогии с первым методом, где мы рассматриваем частный случай
    //а потом следим за границами индекса i
    public static boolean theSecondMethod(List<Integer> secondList) {
        int listSize = secondList.size();
        int startIndex, endIndex;
        startIndex = endIndex = 0;
        boolean startIndexInstalled = false;
        boolean endIndexInstalled = false;

        List<Integer> tmpList = new ArrayList<>(secondList);
        Collections.reverse(tmpList);

        if (isListSorted(tmpList)) {
            Collections.sort(secondList);
        } else {
            for (int i = 1; i < listSize - 1; i++) {
                if (secondList.get(i) < secondList.get(i-1) && startIndexInstalled == false && endIndexInstalled == false) {
                    startIndex = i-1;
                    startIndexInstalled = true;
                } else if (secondList.get(i) < secondList.get(i+1) && startIndexInstalled == true && endIndexInstalled == false) {
                    endIndex = i;
                    endIndexInstalled = true;
                }
            }

            List<Integer> bufferList = new ArrayList<>();
            for (int count = startIndex; count <= endIndex; count++) {
                bufferList.add(secondList.get(count));
            }
            Collections.reverse(bufferList);

            int buffercount = 0;
            for (int i = startIndex; i <= endIndex; i++) {
                secondList.set(i, bufferList.get(buffercount));
                buffercount++;
            }
        }
        return isListSorted(secondList);
    }

    //Testing
    public static void main(String[] args) {
        int[] arrTest = {9, 5, 3, 7, 1};
        List<Integer> arrList = new ArrayList<>();
        for(int nums : arrTest) arrList.add(nums);
        boolean firstMethod = false;
        firstMethod = theFirstMethod(arrList);
       // boolean secondMethod = false;
       // secondMethod = theSecondMethod(arrList);

        Show(arrList);
      //  System.out.println("второй метод - " + secondMethod);
        System.out.println("первый метод - " + firstMethod);

    }
}

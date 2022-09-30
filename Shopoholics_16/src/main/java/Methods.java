public class Methods {
    //находим индекс элемента
    public static int FindIndex(int element, int[] array, int startIndex) {
        int i;
        for (i=startIndex; i<array.length; i++) {
            if(array[i] == element) {
                break;
            }
        }
        return i;
    }

    //находим максимальный элемент
    public static int MaxElement(int[] array, int startIndex) {
        int max = array[startIndex];
        for (int i=startIndex; i<array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    //тестовый вывод массива в консоль
    public static void ShowArray(int[] array) {
        for(int nums : array) System.out.print(nums + " ");
    }
}

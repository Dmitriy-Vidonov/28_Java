public class Methods {
    //Проверка массива на 3 на возрастание
    public static boolean isArrayAscending(int[] arrAsc, int startAsc) {
        int countAsc = 0;
        boolean resAsc = true;
        for (int i = startAsc; i < startAsc + 2; i++) {
            if (arrAsc[i+1] >= arrAsc[i]) {
                countAsc++;
            }
        }
        if (!(countAsc == 2)) return false;
        return resAsc;
    }

    public static boolean isFullArrayAscending(int[] arrAsc) {
        int countAsc = 0;
        boolean resAsc = true;
        for (int i = 0; i+1 < arrAsc.length; i++) {
            if (arrAsc[i+1] >= arrAsc[i]) {
                countAsc++;
            }
        }
        if ((countAsc != arrAsc.length-1)) return false;
        return resAsc;
    }

    //Проверка массива по 3 на убывание
    public static boolean isArrayDescending(int[] arrDesc, int startDesc) {
        int countDesc = 0;
        boolean resDesc = true;
        for (int i = startDesc; i < startDesc + 2; i++) {
            if (arrDesc[i+1] <= arrDesc[i]) {
                countDesc++;
            }
        }
        if (!(countDesc == 2)) return false;
        return resDesc;
    }

    //Перестановка 3-х элементов массива по кругу влево
    public static void arrElementsMoveLeft(int[] arrMove, int startPoint) {
        int buffer;
        buffer = arrMove[startPoint];
        arrMove[startPoint] = arrMove[startPoint + 2];
        arrMove[startPoint + 2] = buffer;

        buffer = arrMove[startPoint];
        arrMove[startPoint] = arrMove[startPoint + 1];
        arrMove[startPoint + 1] = buffer;
    }

    //Проверка на целесообразность проверки 3-ки элементов
    public static boolean isThisThreeOkay(int[] array, int startWith) {
        if (array[startWith] >= array[startWith + 2] && array[startWith] <= array[startWith + 1])
            return true;
        else return false;
    }
}

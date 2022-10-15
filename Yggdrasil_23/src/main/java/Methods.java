public class Methods {
    //Вывод массива на экран
    public static void ShowArray(int[][] array) {
        for(int i=0; i<array.length; i++) {
            System.out.println();
            for(int j=0; j<array[0].length; j++) {
                System.out.print(array[i][j]);
            }
        }
    }

    //Рост всех веток на 1 год
    public static void Growth(int[][] array) {
        for(int i=0; i<array.length; i++) {
            for(int j=0; j<array[0].length; j++) {
                array[i][j] += 1;
            }
        }
    }

    //Проверяем, нет ли в массиве чисел >= 3
    public static boolean IsThreeOrGreater(int[][] array) {
        boolean res = false;
        mainloop: for(int i=0; i<array.length; i++) {
            for(int j=0; j<array[0].length; j++) {
                if(array[i][j] >= 3) {
                    res = true;
                    break mainloop;
                }
            }
        }
        return res;
    }
    //Метод нацеливания на уничтожение
    public static void AimingForDestroy(int[][] arrayAim) {
        for(int i=0; i<arrayAim.length; i++) {
            for(int j=0; j<arrayAim[0].length; j++) {
                if(arrayAim[i][j] >= 3) Destroy(arrayAim, i, j);
            }
        }
    }

    //Метод уничтожения веток
    public static void Destroy(int[][] array, int i, int j) {
        if (j-1 >= 0 && array[i][j-1] != array[i][j]) {
            array[i][j-1] = 0;
        }
        if (i+1 < array.length && array[i+1][j] != array[i][j]) {
            array[i+1][j] = 0;
        }
        if (j+1 < array[0].length && array[i][j+1] != array[i][j]) {
            array[i][j+1] = 0;
        }
        if (i-1 >= 0 && array[i-1][j] != array[i][j]) {
            array[i-1][j] = 0;
        }
        array[i][j] = 0;
    }

    //Преобразование строки в числовой массив
    public static int[][] StrToIntArray(String str, int H, int W) {
        int[][] intArray = new int[H][W]; //преобразование строки в числовой массив
        int label=0;
        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                intArray[i][j] = (str.charAt(label)) - '0';
                label++;
            }
        }
        return intArray;
    }
}

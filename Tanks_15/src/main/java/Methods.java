public class Methods {
    //перевод строки в массив
    public static int[][] StrToArr(int H, int W, String S) {
        int[][] arr = new int[H][W]; //задаем массив
        int label = 0; //метка-каретка для перемещения по строке
        S = S.replace(" ", ""); //удаляем пробелы из строки

        for (int rows=0; rows<H; rows++) { //общий цикл по строкам
            for (int cols=0; cols<W; cols++) {
                arr[rows][cols] = (S.charAt(label) - '0');
                label++;
            }
        }
        return arr;
    }

    //метод для тестового вывода массива
    public static void ArrShow(int[][] array) {
        for (int i=0; i<array.length; i++) {
            for (int j=0; j<array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    //метод для определения подмассива в массиве
    public static boolean SubArrayExist(int[][] arr2, int[][] arr1, int startCols, int startRows) {
        int arrEqualsCounter, arr2Rows;
        arrEqualsCounter = arr2Rows = 0;
        boolean result = false;
        for (int i=startRows; i<=startRows+(arr2.length-1) && i<arr1.length; i++) { //цикл по строкам
            int arr2Cols=0;
            for (int j=startCols; j<=startCols+(arr2[0].length-1) && j<arr1[0].length; j++) {
                if (arr1[i][j] == arr2[arr2Rows][arr2Cols]) {
                    arrEqualsCounter++;
                }
                if (arr2Cols < arr2[0].length-1) {
                    arr2Cols++;
                }
            }
            if (arr2Rows < arr2.length-1) {
                arr2Rows++;
            }
        }
        if (arrEqualsCounter == arr2.length * arr2[0].length) {
            result = true;
        }
        return result;
    }
}

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
}

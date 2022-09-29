public class Test {
    public static void main(String[] args) {
        //1) Перевести заданные строки в массивы чисел
        int H1 = 3; //число строк первого массива
        int W1 = 4; //число столбцов первого массива
        String S1 = "1234 2345 0987"; //задание строки для первого массива

        int H2 = 2; //число строк второго массива
        int W2 = 2; //число столбцов второго массива
        String S2 = "34 98"; //задание строки для второго массива

        System.out.println(Level1.TankRush(H1, W1, S1, H2, W2, S2));

        //нам нужен отдельный метод по переводу строк в массив
        int[][] arr1 = Methods.StrToArr(H1, W1, S1);
        int[][] arr2 = Methods.StrToArr(H2, W2, S2);
        //а еще нам нужен метод по тестовому выводу массива
        Methods.ArrShow(arr1);
        System.out.println();
        Methods.ArrShow(arr2);

        System.out.println();

        boolean res = false;
        //нужен метод, который по начальным координатам в массиве проверит вхождение в него подмассива
        //проход по массиву, увидели совпадение с первым элементом подмассива - запустили проверку.
        //вернуло - false - продолжаем. вернуло - true - завершаем все
        mainloop: for (int rows=0; rows<H1; rows++) { //цикл по строкам arr1
            for (int cols=0; cols<W1; cols++) { //цикл по столбцам arr1
                if (arr1[rows][cols] == arr2[0][0]) {
                    //вызов метода проверки
                    if (Methods.SubArrayExist(arr2, arr1, cols, rows)) {
                        res = true;
                        break mainloop;
                    } //else System.out.print(arr1[rows][cols] + " "); //если else continue, то мы не пропечатаем совпадение
                } //else System.out.print(arr1[rows][cols] + " ");
            }
            //System.out.println();
        }
        System.out.println("result = " + res);
        //метод проверки - пока пропишем руками идеальный вариант развития событий. Затем доьавим ограничители
        // int cols = 1;
        // int rows = 1;

        //System.out.println("result = " + Methods.SubArrayExist(arr2, arr1, cols, rows));
        /*
        int arrEqualsCounter = 0;
        int arr2Cols = 0; //для координат arr2 - столбцы
        int arr2Rows = 0; //для координат arr2 - строки
        for (int i=rows; i<=rows+(arr2.length-1) && i<arr1.length; i++) { //цикл по строкам
            arr2Cols=0;
            for (int j=cols; j<=cols+(arr2[0].length-1) && j<arr1[0].length; j++) {
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
        System.out.println("число совпадений = " + arrEqualsCounter); */
    }
}

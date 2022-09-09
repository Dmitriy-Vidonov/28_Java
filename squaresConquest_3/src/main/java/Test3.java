public class Test3 {
    //метод отображения массива в консоли
    public static void arrayDisplay(int[][] arr) {
        for (int i = 0; i < arr.length; i++) { //внешний цикл по строкам
            for (int j = 0; j < arr[0].length; j++) { //внутренний цикл по столбцам
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    //функция проставления в массив точек, полученных из conquer
    public static void setConquer() {

    }

    //функция "захвата" соседних областей исходя из переданных координат
    //возвращает координаты для проставления, стиль заполнения ячейки и счетчик countFull
    public static int[] getConquer(int x, int y,  //получаем координаты точки
                                   int counter,   //получаем счетчик заполненных ячеек countFull
                                   int ignoreF,   //получаем значение ignoreFlag
                                   int mapRows,   //получаем число строк массива
                                   int mapCols) { //получаем число столбцов массива

        int[] conquerArr = new int[10]; //массив для хранения координат ячеек для заполнения + cellFill + countFull
        int cellFill = 0; //стиль заполнения ячейки

        // Если ignoreF == 1, то ставим в ячейки 2 и наоборот
        if (ignoreF == 1) cellFill = 2;
        else cellFill = 1;

        if (x + 1 <= mapRows - 1) { //если координата x ячейки не выступает за пределы нижнего уровня map
            conquerArr[0] = x + 1;
            conquerArr[1] = y;
            counter++;
        } else {
            conquerArr[0] = -1;
            conquerArr[1] = -1;
        }
        if (x - 1 >= 0) { //проверить что не выходим за верхний диапазон
            conquerArr[2] = x - 1;
            conquerArr[3] = y;
            counter++;
        } else {
            conquerArr[2] = -1;
            conquerArr[3] = -1;
        }
        if (y + 1 <= mapCols - 1) {
            conquerArr[4] = x;
            conquerArr[5] = y + 1;
            counter++;
        } else {
            conquerArr[4] = -1;
            conquerArr[5] = -1;
        }
        if (y - 1 >= 0) {
            conquerArr[6] = x;
            conquerArr[7] = y - 1;
            counter++;
        } else {
            conquerArr[6] = -1;
            conquerArr[7] = -1;
        }

        //устанавливаем заливку ячейки
        conquerArr[8] = cellFill;
        //возвращаем значение countFull
        conquerArr[9] = counter;

        return conquerArr;
    }

    //ПРОВЕРКА РАБОТЫ ФУНКЦИИ
    public static void main(String[] args) {
        int days; //число дней
        int countFull = 0; //переменная для подсчета заполненных ячеек

        // получить на вход размеры массива N и M
        int N = 7; //число строк
        int M = 13; //число столбцов

        // создать массив NxM и заполнить его нулями
        int[][] map = new int[7][13];
        for (int n = 0; n < N; n++) { //внешний цикл по строкам
            for (int m = 0; m < M; m++) { //внутренний цикл по строкам
                map[n][m] = 0;
            }
        }

        int L = 3;
        int[] batallion = {2, 3, 3, 8, 7, 13}; //length = 6

        //проставляем начальные точки высадки
        for (int l = 0; l <= batallion.length - 2; l += 2) {
            if (map[batallion[l] - 1][batallion[l + 1] - 1] == 0) map[batallion[l] - 1][batallion[l + 1] - 1] = 1;
        }
        arrayDisplay(map); //тестовый вывод массива

        //1) надо пройтись по массиву, встретить 1, получить координаты, передать их в метод, получить заполнение ячеек
        //2) сделать цикл, по которому итеративно заполнится все поле

        //1)
        //int[] arr1;
        for (int i1 = 0; i1 < map.length; i1++) { //внешний цикл по строкам
            for (int j1 = 0; j1 < map[0].length; j1++) { //вложенный цикл по столбцам
                if (map[i1][j1] == 1) {
                    int arr1[] = getConquer(i1, j1, 0, 1, map.length, map[0].length);

                }
            }
        }
        //надо чтобы при встрече точки - сразу выполнялся conquer и потом мы шли дальше, натравливая его на другую точку

    }
}


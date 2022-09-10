public class Methods {
    //метод отображения массива в консоли
    public static void arrayDisplay(int[][] arr) {
        for (int i = 0; i < arr.length; i++) { //внешний цикл по строкам
            for (int j = 0; j < arr[0].length; j++) { //внутренний цикл по столбцам
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    //здесь счетчик countFull должен обновляться только если проставили значение в пустую ячейку
    //функция "захвата" соседних областей исходя из переданных координат
    //возвращает координаты для проставления, стиль заполнения ячейки и счетчик countFull

    public static int[] getConquerAlt(int[][] map,     //получаем массив для проверки ячеек
                                      int x1, int y1,  //получаем координаты точки
                                      int ignoreF1,   //получаем значение ignoreFlag
                                      int mapRows1,   //получаем число строк массива
                                      int mapCols1) { //получаем число столбцов массива

        int[] conquerArr = new int[10]; //массив для хранения координат ячеек для заполнения + cellFill + countFull
        int cellFill = 0; //стиль заполнения ячейки
        int counter1 = 0;   //задаем счетчик заполненных ячеек countFull

        // Если ignoreF == 1, то ставим в ячейки 2 и наоборот
        if (ignoreF1 == 1) cellFill = 2;
        else cellFill = 1;

        if (x1 + 1 <= mapRows1 - 1 && (map[x1+1][y1] == 0)) { //если координата x ячейки не выступает за пределы
                                            // нижнего уровня map и при этом равна 0, т.е. пустая
            conquerArr[0] = x1 + 1;
            conquerArr[1] = y1;
            counter1++;
        } else {
            conquerArr[0] = -1;
            conquerArr[1] = -1;
        }
        if (x1 - 1 >= 0 && (map[x1-1][y1] == 0)) { //проверить что не выходим за верхний диапазон
            conquerArr[2] = x1 - 1;
            conquerArr[3] = y1;
            counter1++;
        } else {
            conquerArr[2] = -1;
            conquerArr[3] = -1;
        }
        if (y1 + 1 <= mapCols1 - 1 && (map[x1][y1+1] == 0)) {
            conquerArr[4] = x1;
            conquerArr[5] = y1 + 1;
            counter1++;
        } else {
            conquerArr[4] = -1;
            conquerArr[5] = -1;
        }
        if (y1 - 1 >= 0 && (map[x1][y1-1] == 0)) {
            conquerArr[6] = x1;
            conquerArr[7] = y1 - 1;
            counter1++;
        } else {
            conquerArr[6] = -1;
            conquerArr[7] = -1;
        }

        //устанавливаем заливку ячейки
        conquerArr[8] = cellFill;
        //возвращаем значение countFull
        conquerArr[9] = counter1;

        return conquerArr;
    }
}


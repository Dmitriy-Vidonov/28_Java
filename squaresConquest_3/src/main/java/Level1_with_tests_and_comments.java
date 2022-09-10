public class Level1_with_tests_and_comments {
    public static void arrayDisplay(int[][] arr) {
        for (int i = 0; i < arr.length; i++) { //внешний цикл по строкам
            for (int j = 0; j < arr[0].length; j++) { //внутренний цикл по столбцам
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] getConquer(int[][] map,    //получаем массив для проверки ячеек
                                      int x1, int y1, //получаем координаты точки
                                      int ignoreF1,   //получаем значение ignoreFlag
                                      int mapRows1,   //получаем число строк массива
                                      int mapCols1) { //получаем число столбцов массива

        int[] conquerArr = new int[10]; //массив для хранения координат ячеек для заполнения + cellFill + countFull
        int cellFill; //стиль заполнения ячейки
        int counter1 = 0; //задаем счетчик заполненных ячеек countFull

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

    public static int ConquestCampaign(int N, int M, int L, int[] battalion){
        int days = 0; //число дней
        int countFull = 0; //переменная для подсчета заполненных ячеек
        int ignFlag; //флаг для игнорирования содержимого ячеек
        int mapSquare = N*M;

        // создать массив NxM и заполнить его нулями
        int[][] map = new int[N][M];
        for (int n = 0; n < N; n++) { //внешний цикл по строкам
            for (int m = 0; m < M; m++) { //внутренний цикл по строкам
                map[n][m] = 0;
            }
        }

        //проставляем начальные точки высадки
        int count = 0;
        for(int i=0; i<L; i++) { //2 цикла - получаем число циклов через i. i здесь чисто для счетчика циклов и все!
            if(map[battalion[count]-1][battalion[count+1]-1] == 0) { //проверка, что ячейка пустая, т.к. зоны высадки могут повторяться
                map[battalion[count]-1][battalion[count+1]-1] = 1;
                countFull++; //прибавление +1 только в случае заполнения ранее пустой ячейки
            }
            count+=2;
        }
        days++; //добавляем первый день после высадки  = 1

        if(countFull < mapSquare) {
            //цикл while
            while (countFull < mapSquare) {
                /********************MAIN LOOP BEGIN******************/
                // - начать проходку map (двумерного массива) поэлементно
                days++; //  - к days прибавить 1

                if(days % 2 == 0) {
                    ignFlag = 1;    //на четное число дней ignoreFlag = 1
                } else ignFlag = 2; //на нечетное число дней ignoreFlag = 2. Это по сути содержимое ячейки для игнора

                for(int i=0; i<map.length; i++) { //цикл по строкам
                    for(int j=0; j<map[0].length; j++) { //цикл по столбцам
                        if(map[i][j] == ignFlag) { //какое число в ячейке игнорируем

                            //вызов метода, передающего координаты для заполнения
                            int[] arr = getConquer(map, i, j, ignFlag, map.length, map[0].length);
                            countFull += arr[9]; //обновляем число заполненных ячеек, которое получаем после работы метода

                            //надо по полученным координатам заполнить ячейки
                            //заполнение ячеек массива значениями по координатам из getConquer()
                            for(int k=0; k<arr.length-2; k+=2) {
                                if(arr[k] != -1) {
                                    map[arr[k]][arr[k+1]] = arr[8];
                                }
                            }
                        }
                    }
                }
                /********************MAIN LOOP END******************/
            }
        } else {
            //вывод результатов
            return days;
        }
        return days;
    }
    //тестируем метод
    public static void main(String[] args) {
        int[] map = {2,2,3,4};
        System.out.println(ConquestCampaign(3,4,2,map) + " дня");
    }
}

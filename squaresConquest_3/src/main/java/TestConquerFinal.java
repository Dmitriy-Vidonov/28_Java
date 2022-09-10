public class TestConquerFinal {
    public static void main(String[] args) {
        int days = 0; //число дней
        int countFull = 0; //переменная для подсчета заполненных ячеек
        int ignFlag; //флаг для игнорирования содержимого ячеек

        // получить на вход размеры массива N и M
        int N = 3; //число строк
        int M = 4; //число столбцов
        int mapSquare = N*M;

        // создать массив NxM и заполнить его нулями
        int[][] map = new int[N][M];
        for (int n = 0; n < N; n++) { //внешний цикл по строкам
            for (int m = 0; m < M; m++) { //внутренний цикл по строкам
                map[n][m] = 0;
            }
        }

        int L = 2;
        int[] batallion = {2, 2, 3, 4};

        //проставляем начальные точки высадки
        int count = 0; //0
        for(int i=0; i<L; i++) { //2 цикла - получаем число циклов через i. i здесь чисто для счетчика циклов и все!
            if(map[batallion[count]-1][batallion[count+1]-1] == 0) { //проверка, что ячейка пустая, т.к. зоны высадки могут повторяться
                map[batallion[count]-1][batallion[count+1]-1] = 1;
                countFull++; //прибавление +1 только в случае заполнения ранее пустой ячейки
            }
            count+=2;
        }
        days++; //добавляем первый день после высадки  = 1

        Methods.arrayDisplay(map); //тестовый вывод массива
        System.out.println(); //просто отступ  ********/

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
                            int[] arr = Methods.getConquerAlt(map, i, j, ignFlag, map.length, map[0].length);
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
                Methods.arrayDisplay(map); //тестовый вывод массива
                System.out.println("дней прошло: " + days + ". Из " + mapSquare + " ячеек заполнено " + countFull);
                System.out.println(); //просто отступ
                /********************MAIN LOOP END******************/
            }
        } else {
            //вывод результатов
            Methods.arrayDisplay(map); //тестовый вывод массива
            System.out.println("дней прошло: " + days + ". Из " + mapSquare + " ячеек заполнено " + countFull);
            System.out.println(); //просто отступ  ********/
        }
    }
}

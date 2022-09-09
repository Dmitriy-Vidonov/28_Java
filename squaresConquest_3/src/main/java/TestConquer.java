public class TestConquer {
    public static void main(String[] args) {
        int days = 0; //число дней
        int countFull = 0; //переменная для подсчета заполненных ячеек

        // получить на вход размеры массива N и M
        int N = 7; //число строк
        int M = 13; //число столбцов
        int mapSquare = N*M;

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
        days++; //добавляем первый день после высадки
        //Test3.arrayDisplay(map); //тестовый вывод массива

        System.out.println("map.length = " + map.length); //строки, координата X (=7)
        System.out.println("map[0].length = " + map[0].length); //столбцы, координата Y (=13)

        days++;
        for(int i=0; i<map.length; i++) { //цикл по строкам
            for(int j=0; j<map[0].length; j++) { //цикл по столбцам
                if(map[i][j] == 1) {
                    System.out.println("x = " + i + ", y = " + j); //координаты ячеек с 1

                    //вызов ф-ции, передающей координаты
                    int arr[] = Test3.getConquer(i, j, 0, 1, map.length, map[0].length);
                    countFull += arr[9];

                    //вывод координат ячеек для заполнения + шаблон заполнения и игнор
                    for(int k=0; k<arr.length; k++) {
                        System.out.print(arr[k] + " ");
                    }
                    System.out.println();

                    //надо по полученным координатам заполнить ячейки
                    //заполнение ячеек массива значениями по координатам из conquer
                    for(int k=0; k<arr.length-2; k+=2) {
                        if(arr[k] != -1) {
                            map[arr[k]][arr[k+1]] = arr[8];
                        }
                    }
                }
            }
        }
        Test3.arrayDisplay(map); //тестовый вывод массива
        System.out.println("дней прошло: " + days + ". Из " + mapSquare + " ячеек заполнено " + countFull);
        System.out.println(); //просто отступ
        //**************************************/

        //сымитируем для верности ручками еще один цикл, но уже по двойкам
        days++;
        for(int i=0; i<map.length; i++) { //цикл по строкам
            for(int j=0; j<map[0].length; j++) { //цикл по столбцам
                if(map[i][j] == 2) {
                  //  System.out.println("x = " + i + ", y = " + j); //координаты ячеек с 1

                    //вызов ф-ции, передающей координаты
                    int arr[] = Test3.getConquer(i, j, 0, 2, map.length, map[0].length);
                    countFull += arr[9];
                    /*вывод координат ячеек для заполнения + шаблон заполнения и игнор
                    for(int k=0; k<arr.length; k++) {
                        System.out.print(arr[k] + " ");
                    }
                    System.out.println();*/

                    //надо по полученным координатам заполнить ячейки
                    //заполнение ячеек массива значениями по координатам из conquer
                    for(int k=0; k<arr.length-2; k+=2) {
                        if(arr[k] != -1) {
                            map[arr[k]][arr[k+1]] = arr[8];
                        }
                    }
                }
            }
        }
        Test3.arrayDisplay(map); //тестовый вывод массива
        System.out.println("дней прошло: " + days + ". Из " + mapSquare + " ячеек заполнено " + countFull);
        System.out.println(); //просто отступ

        //**************************************/

        //сымитируем для верности ручками еще один цикл, снова по единичкам
        days++;
        for(int i=0; i<map.length; i++) { //цикл по строкам
            for(int j=0; j<map[0].length; j++) { //цикл по столбцам
                if(map[i][j] == 1) {
                   // System.out.println("x = " + i + ", y = " + j); //координаты ячеек с 1

                    //вызов ф-ции, передающей координаты
                    int arr[] = Test3.getConquer(i, j, 0, 1, map.length, map[0].length);
                    countFull += arr[9];
                    /*вывод координат ячеек для заполнения + шаблон заполнения и игнор
                    for(int k=0; k<arr.length; k++) {
                        System.out.print(arr[k] + " ");
                    }
                    System.out.println();*/

                    //надо по полученным координатам заполнить ячейки
                    //заполнение ячеек массива значениями по координатам из conquer
                    for(int k=0; k<arr.length-2; k+=2) {
                        if(arr[k] != -1) {
                            map[arr[k]][arr[k+1]] = arr[8];
                        }
                    }
                }
            }
        }
        Test3.arrayDisplay(map); //тестовый вывод массива
        System.out.println("дней прошло: " + days + ". Из " + mapSquare + " ячеек заполнено " + countFull);
        System.out.println(); //просто отступ
    }
}

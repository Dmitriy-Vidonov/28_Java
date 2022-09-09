public class Test {

    /*метод "захват", он же conquer
     - на вход получает координаты ячейки, с которой мы вызываем эту функцию (x, y) (upd - получает массив)
     - на вход получает ignoreFlag (ignoreF)
     - на вход получает значение countFull (counter)
     - на вход получает размеры полигона (map) (mapRows, mapCols)  */ //может в нее массив передать попробовать?
    public static int conquer(int x, int y, int counter, int ignoreF, int mapRows, int mapCols) {
        int result = 0;
        int cellFill = 0;
        // - определяет, что будет помещать в ячейки (число, противоположное ignoreFlag).
        // Если ignoreFlag == 1, то ставим в ячейки 2 и наоборот. Переменная — cellFill
        if(ignoreF == 1) cellFill = 2;
        else cellFill = 1;
        int[] conquerArr = new int[8]; //массив для хранения координат ячеек для заполнения
        if(x+1 <= mapRows-1) { //если координата x ячейки не выступает за пределы нижнего уровня map
            conquerArr[0] = x+1;
            conquerArr[1] = y;
        } else{
            conquerArr[0] = -1;
            conquerArr[1] = -1;
        }
        if(x-1 >= mapRows) { //проверить что не выходим за верхний диапазон
            //заглушка
        }


        return result;
    }

    public static void main(String[] args) {
        // получить на вход размеры массива N и M
        int N = 7; //число строк
        int M = 13; //число столбцов

        // создать массив NxM и заполнить его нулями
        int[][] map = new int[7][13];
        for(int n=0; n<N; n++) { //внешний цикл по строкам
            for(int m=0; m<M; m++) { //внутренний цикл по строкам
                map[n][m] = 0;
            }
        }
        //arrayDisplay(map); //тестовый вывод массива в консоль

        // получить на вход массив batallion и переменную L
        int L = 3;
        int[] batallion = {2,3,3,8,7,13}; //length = 6
        /*
         - в цикле  по L:
         - получить координаты x и y
         - четные элементы массива использовать для заполнения координаты x, нечетные — для заполнения y
         - проверить, что полученные координаты принадлежат ячейкам, равным 0
         - если ячейка пустая (там содержится 0), то проставляем в ячейку цифру 1
         */
        for(int l=0; l<=batallion.length-2; l+=2) {
            if(map[batallion[l]-1][batallion[l+1]-1] == 0) map[batallion[l]-1][batallion[l+1]-1] = 1;
        }
        Test3.arrayDisplay(map); //тестовый вывод массива в консоль

        // - пройтись по всему массиву, вычислить число заполненных цифрой 1 ячеек
        int countFull = 0;
        for(int n=0; n<N; n++) { //внешний цикл по строкам
            for(int m=0; m<M; m++) { //внутренний цикл по строкам
                if (map[n][m] == 1) countFull++;
            }
        }
        System.out.println("countFull = " + countFull); //тестовый вывод countFull

        //  - вычислить площадь map (полигона)
        int squareMap = N*M;
        // - ввести переменную days и прибавить к ней 1
        int days = 1;

        /* - сравнить полученное при проходе массива число непустых ячеек
           (переменная countFull) с площадью map (squareMap) */
        // - посмотреть — не равна ли переменная countFull — площади map
        // - если переменная countFull == squareMap — то завершаем метод и возвращаем число дней
        if(countFull == squareMap) System.out.println("Полигон захвачен за 1 день!");
        else { // - если переменная countFull < squareMap — то:
            do { //основной цикл программы
                // - к days прибавить 1
                days++;
                int ignoreFlag = 0;
                /* - если days % 2 == 0 (число дней четное),
                   то ignoreFlag = 2 (какое содержимое ячеек будет игнорироваться при проходе)*/
                if (days % 2 == 0) ignoreFlag = 2;
                 /* - если days % 2 != 0 (число дней нечетное),
                   то ignoreFlag = 1 (какое содержимое ячеек будет игнорироваться при проходе) */
                else ignoreFlag = 1;

                /* - начать проходку map (двумерного массива) поэлементно
                 (основной цикл по строкам и вложенный цикл по столбцам — основной по N и дополнительный по M)
                 */
                for(int rows=0; rows<N; rows++) { //внешний цикл по строкам
                    for(int columns=0; columns<M; columns++) { //внутренний цикл по столбцам
                        if(map[rows][columns] != 0 && map[rows][columns] != ignoreFlag) { //проверка содержимого ячейки
                            //call conquer method
                        }
                    }
                }

            } while (countFull < squareMap);
            System.out.println("Полигон захвачен за " + days + " дней!");
        }
    }
}

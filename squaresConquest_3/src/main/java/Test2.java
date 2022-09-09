import java.util.Arrays;

public class Test2 {

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

        int L = 3;
        int[] batallion = {2,3,3,8,7,13}; //length = 6

        for(int l=0; l<=batallion.length-2; l+=2) {
            if(map[batallion[l]-1][batallion[l+1]-1] == 0) map[batallion[l]-1][batallion[l+1]-1] = 1;
        }
        Test.arrayDisplay(map);

        //алгоритм проверки - можем ли мы заполнить ячейку или нет
        int countFull = 0;
        int ignoreF = 1;
        int mapRows = N;
        int mapCols = M;
        int x,y;
        x = 2;
        y = 7;

            int result = 0;
            int cellFill = 0;
            // - определяет, что будет помещать в ячейки (число, противоположное ignoreFlag).
            // Если ignoreFlag == 1, то ставим в ячейки 2 и наоборот. Переменная — cellFill
            if(ignoreF == 1) cellFill = 2;
            else cellFill = 1;
            int[] conquerArr = new int[9]; //массив для хранения координат ячеек для заполнения
            if(x+1 <= mapRows-1) { //если координата x ячейки не выступает за пределы нижнего уровня map
                conquerArr[0] = x+1;
                conquerArr[1] = y;
                countFull++;
            } else{
                conquerArr[0] = -1;
                conquerArr[1] = -1;
            }
            if(x-1 >= 0) { //проверить что не выходим за верхний диапазон
                conquerArr[2] = x-1;
                conquerArr[3] = y;
                countFull++;
            } else {
                conquerArr[2] = -1;
                conquerArr[3] = -1;
            }
            if(y+1 <= mapCols-1) {
                conquerArr[4] = x;
                conquerArr[5] = y+1;
                countFull++;
            } else {
                conquerArr[4] = -1;
                conquerArr[5] = -1;
            }
            if(y-1 >= 0) {
                conquerArr[6] = x;
                conquerArr[7] = y-1;
                countFull++;
            } else {
                conquerArr[6] = -1;
                conquerArr[7] = -1;
            }

            //устанавливаем заливку ячейки
            conquerArr[8] = cellFill;

            System.out.println("conquer = ");

            for(int i=0; i<conquerArr.length; i++) {
                System.out.print(conquerArr[i] + " ");
            }
            System.out.println("\ncountFull = " + countFull);

            for(int k=0; k<conquerArr.length-1; k+=2) {
                if(conquerArr[k] != -1) {
                    map[conquerArr[k]][conquerArr[k+1]] = cellFill;
                }
            }
        Test.arrayDisplay(map);
    }
}

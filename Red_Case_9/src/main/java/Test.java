public class Test {
    public static void main(String[] args) {
        String str = "отдай мою кроличью лапку";
        str = str.replace(" ", ""); //убрали пробелы
        int len = str.length();
        int rows = (int) Math.sqrt(len); //число строк матрицы
        int cols = (int) Math.ceil(Math.sqrt(len)); //число столбцов матрицы
        if(rows * cols < len) rows++;

        //рассчет diff только в случае зашифровки boolean encode = true
        int diff = 0; //дополняем строку пробелами, если она не полностью входит в матрицу
        if(str.length() < cols*rows){
            diff = cols*rows-str.length();
        }

        //в случае encode = true
        for(int k=0; k<diff; k++) {
            str = str + " ";
        }
        len = str.length();

        char[][] matrix = new char[rows][cols]; //[5][5]
        int pointer=0;

        //в случае encode = true
        for(int i=0; i<rows; i++) { //цикл по строкам
            for(int j=0; j<cols; j++) {
                matrix[i][j] = str.charAt(pointer);
                pointer++;
            }
        }
        //тестовый вывод матрицы
        for(int i1=0; i1<rows; i1++) {
            for(int j1=0; j1<rows; j1++) {
                System.out.print(matrix[i1][j1]);
            }
            System.out.println();
        }
        //encode = true
        str = ""; //обнуляем строку перед заполнением из матрицы
        for(int c=0; c<cols; c++) {
            for(int d=0; d<rows; d++) {
                str += String.valueOf(matrix[d][c]); //помещаем в строку инвертированный вывод из массива
            }
            str += " "; //ставим пробел после считывания каждого столбца
        }
        str = str.replace("  ", " "); //меняем символ двойного пробела на одинарный
        str = str.substring(0, str.length()-1); //срезали последний пробел

        System.out.println(str);

        String strEncode = str; //на расшифровку даем строку, полученную в ходе зашифровки
        //strEncode = strEncode.replace(" ", "");

        boolean encode = false; //флажок на расшифровку
        //rows и cols у нас известны, матрица тех же размеров
        char[][] matrixEncode = new char[rows][cols]; //[5][5]
        int pointerEncode=0;

        int i;
        for(int j=0; j<cols; j++) {
            i=0;
            while (i<rows && pointerEncode<strEncode.length()){
                if(i < rows-1) {
                    matrixEncode[i][j] = strEncode.charAt(pointerEncode);
                    pointerEncode++;
                    i++;
                } else { //если последний элемент, который надо вставить в очередном шаге цикла...
                    if (strEncode.charAt(i) != ' ') { //...не равен пробелу, то идем дальше как обычно
                        continue;
                    } else pointerEncode++; //если последний элемент равен пробелу, значит нам надо перескочить по строке
                    break; //и завершить цикл
                }

           }
        }
        //тестовый вывод матрицы
        for(int i1=0; i1<rows; i1++) {
            for(int j1=0; j1<rows; j1++) {
                System.out.print(matrixEncode[i1][j1]);
            }
            System.out.println();
        }

        //считываем матрицу в строку
        strEncode = ""; //обнуляем итоговую строку дешифровки перед занесением данных из матрицы
        
    }
}

public class Test {
    public static void main(String[] args) {
        String str = "отдай мою лапку собакапаршивая";
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
        if(strEncode.length() < rows * cols) { //если длина строки меньше размера матрицы, то добавим в конец строки пробел
            strEncode += ' ';
        }

        int pointerEncode=0;

        int i;
        for(int j=0; j<cols-1; j++) {
            i=0;
            while (i<rows-1) {
                matrixEncode[i][j] = strEncode.charAt(pointerEncode);
                pointerEncode++;
                i++;
            }
            if(strEncode.charAt(pointerEncode) != ' ') {
                matrixEncode[rows-1][j] = strEncode.charAt(pointerEncode);
                pointerEncode+=2;
            } else {
                matrixEncode[rows-1][j] = ' ';
                pointerEncode++;
            }
            i++;
        }
        //добавим посл. столбец
        int c=0;
        while (c<rows && pointerEncode < strEncode.length()) {
            matrixEncode[c][cols-1] = strEncode.charAt(pointerEncode);
            c++;
            pointerEncode++;
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
        for(int i1=0; i1<rows; i1++) {
            for(int j1=0; j1<cols; j1++) {
                if (String.valueOf(matrixEncode[i1][j1]).matches("[a-zа-я]")) strEncode += matrixEncode[i1][j1];
            }
        }

       System.out.println("encode - " + strEncode);

       System.out.println("******TEST******");

       String stroka = "отдай мою лапку собакапаршивая";
       System.out.println("Начальная строка - " + stroka);

       String zashifrStroka = Level1.TheRabbitsFoot(stroka, true);
       System.out.println("Зашифрованная строка - " + zashifrStroka);

       String razhifrStroka = Level1.TheRabbitsFoot(zashifrStroka, false);
       System.out.println("Расшифрованная строка - " + razhifrStroka);
    }
}

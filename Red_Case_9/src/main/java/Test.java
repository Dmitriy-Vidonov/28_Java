public class Test {
    public static void main(String[] args) {
        String str = "отдай мою кроличью лапку сука";
        str = str.replace(" ", ""); //убрали пробелы
        int len = str.length();
        int rows = (int) Math.sqrt(len); //число строк матрицы
        int cols = (int) Math.ceil(Math.sqrt(len)); //число столбцов матрицы
        if(rows * cols < len) rows++;

        int diff = 0; //дополняем строку пробелами, если она не полностью входит в матрицу
        if(str.length() < cols*rows){
            diff = cols*rows-str.length();
        }

        for(int k=0; k<diff; k++) {
            str = str + " ";
        }
        len = str.length();

        char[][] matrix = new char[rows][cols]; //[5][5]
        int pointer=0;
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
        str = "";
        for(int c=0; c<cols; c++) {
            for(int d=0; d<rows; d++) {
                str += String.valueOf(matrix[d][c]); //помещаем в строку инветированный вывод из массива
            }
            str += " "; //ставим пробел после считывания каждого столбца
        }
        str = str.replace("  ", " "); //меняем символ двойного пробела на одинарный
        str = str.substring(0, str.length()-1); //срезали последний пробел

        System.out.println(str);
        System.out.println(str.length());

        
    }
}

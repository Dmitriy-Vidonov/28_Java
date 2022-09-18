public class Level1 {
    public static String TheRabbitsFoot(String s, boolean encode) {
        String encodedStr = s;
        s = s.replace(" ", "");
        int len = s.length();
        int rows = (int) Math.sqrt(len);
        int cols = (int) Math.ceil(Math.sqrt(len));
        if(rows * cols < len) rows++;
        char[][] matrix = new char[rows][cols];
        int pointer = 0;

        if (encode == true) {
            int diff = 0;
            if(s.length() < cols*rows){
                diff = cols*rows-s.length();
            }
            for(int k=0; k<diff; k++) {
                s = s + " ";
            }
            len = s.length();
            for(int i=0; i<rows; i++) { //цикл по строкам
                for(int j=0; j<cols; j++) {
                    matrix[i][j] = s.charAt(pointer);
                    pointer++;
                }
            }
            s = "";
            for(int c=0; c<cols; c++) {
                for(int d=0; d<rows; d++) {
                    s += String.valueOf(matrix[d][c]);
                }
                s += " ";
            }
            s = s.replace("  ", " ");
            s = s.substring(0, s.length()-1);
        } else {
            if(encodedStr.length() < rows * cols) {
                encodedStr += ' ';
            }
            int i;
            for(int j=0; j<cols-1; j++) {
                i=0;
                while (i<rows-1) {
                    matrix[i][j] = encodedStr.charAt(pointer);
                    pointer++;
                    i++;
                }
                if(encodedStr.charAt(pointer) != ' ') {
                    matrix[rows-1][j] = encodedStr.charAt(pointer);
                    pointer+=2;
                } else {
                    matrix[rows-1][j] = ' ';
                    pointer++;
                }
                i++;
            }
            int c=0;
            while (c<rows && pointer < encodedStr.length()) {
                matrix[c][cols-1] = encodedStr.charAt(pointer);
                c++;
                pointer++;
            }
            s = "";
            for(int i1=0; i1<rows; i1++) {
                for(int j1=0; j1<cols; j1++) {
                    if (String.valueOf(matrix[i1][j1]).matches("[a-zA-Zа-яА-ЯёЁ]")) s += matrix[i1][j1];
                }
            }
        }
        return s;
    }
}

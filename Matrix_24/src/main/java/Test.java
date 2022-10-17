public class Test {
    public static void main(String[] args) {
        //на вход получаем массив строк M строк каждая длиной N, число шагов Т >= 1
        String[] Matrix = {"123456", "234567", "345678", "456789"};
        int M = 4; //число строк
        int N = 6; //длина строк
        int T = 2; //число шагов поворота

        //0 - преобразовать это все в числовую матрицу
        int[][] intArray = new int[M][N];

        //сначало переведем матрицу в одну строку, которую мы потом раскидаем на массив
        String strMatrix = "";
        for(int i=0; i<Matrix.length; i++) {
            strMatrix += Matrix[i];
        }
        int label = 0; //каретка для хранения текущего символа строки
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                intArray[i][j] = (strMatrix.charAt(label) - '0');
                label++;
            }
        }

        for(int count=0; count<T; count++) {
            int top, left;
            int bottom = intArray.length-1;
            int right = intArray[0].length-1;
            int previousNum, currentNum;
            top = left = 0;
            while (left < right && top < bottom) {
                previousNum = intArray[top+1][left];
                for(int i=left; i<right+1; i++) {
                    currentNum = intArray[top][i];
                    intArray[top][i] = previousNum;
                    previousNum = currentNum;
                }
                top++;
                for(int i=top; i<bottom+1; i++) {
                    currentNum = intArray[i][right];
                    intArray[i][right] = previousNum;
                    previousNum = currentNum;
                }
                right--;
                for(int i=right; i>left-1; i--) {
                    currentNum=intArray[bottom][i];
                    intArray[bottom][i] = previousNum;
                    previousNum = currentNum;
                }
                bottom--;
                for(int i=bottom; i>top-1; i--) {
                    currentNum = intArray[i][left];
                    intArray[i][left] = previousNum;
                    previousNum = currentNum;
                }
                left++;
            }
        }
        Methods.ShowArray(intArray); //вывод в консоль содержимого массива

        //Поместить полученный массив в исходный массив строк
        String buffer = "";
        for(int i=0; i<M; i++) {
            buffer = "";
            for(int j=0; j<N; j++) {
                buffer += String.valueOf(intArray[i][j]);
            }
            Matrix[i] = buffer;
        }
        System.out.println();
        for(String word : Matrix) System.out.print(word + " "); System.out.println();
    }
}
/*
    //Testing
    public static void main(String[] args) {
        String[] Matrix = {"123456", "234567", "345678", "456789"};
        int M = 4; //число строк
        int N = 6; //длина строк
        int T = 2; //число шагов поворота
        MatrixTurn(Matrix, 4,6, 1);
        for (String word : Matrix) System.out.print(word + " ");
    }
*/
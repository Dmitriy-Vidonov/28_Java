public class Level1 {
   public static void MatrixTurn(String Matrix[], int M, int N, int T) {
       int[][] intArray = new int[M][N];

       String strMatrix = "";
       for(int i=0; i<Matrix.length; i++) {
           strMatrix += Matrix[i];
       }

       int label = 0;
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

       String buffer = "";
       for(int i=0; i<M; i++) {
           buffer = "";
           for(int j=0; j<N; j++) {
               buffer += String.valueOf(intArray[i][j]);
           }
           Matrix[i] = buffer;
       }
    }
}

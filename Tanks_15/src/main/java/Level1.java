import java.util.*;

public class Level1 {
    public static boolean TankRush(int H1, int W1, String S1, int H2, int W2, String S2) {
        int[][] arr1 = StrToArr(H1, W1, S1);
        int[][] arr2 = StrToArr(H2, W2, S2);

        boolean res = false;
        mainloop: for (int rows=0; rows<H1; rows++) {
            for (int cols=0; cols<W1; cols++) {
                if (arr1[rows][cols] == arr2[0][0]) {
                    if (SubArrayExist(arr2, arr1, cols, rows)) {
                        res = true;
                        break mainloop;
                    }
                }
            }
        }
        return res;
    }

    public static int[][] StrToArr(int H, int W, String S) {
        int[][] arr = new int[H][W];
        int label = 0;
        S = S.replace(" ", "");

        for (int rows=0; rows<H; rows++) {
            for (int cols=0; cols<W; cols++) {
                arr[rows][cols] = (S.charAt(label) - '0');
                label++;
            }
        }
        return arr;
    }

    public static boolean SubArrayExist(int[][] arr2, int[][] arr1, int startCols, int startRows) {
        int arrEqualsCounter, arr2Rows;
        arrEqualsCounter = arr2Rows = 0;
        boolean result = false;
        for (int i=startRows; i<=startRows+(arr2.length-1) && i<arr1.length; i++) {
            int arr2Cols=0;
            for (int j=startCols; j<=startCols+(arr2[0].length-1) && j<arr1[0].length; j++) {
                if (arr1[i][j] == arr2[arr2Rows][arr2Cols]) {
                    arrEqualsCounter++;
                }
                if (arr2Cols < arr2[0].length-1) {
                    arr2Cols++;
                }
            }
            if (arr2Rows < arr2.length-1) {
                arr2Rows++;
            }
        }
        if (arrEqualsCounter == arr2.length * arr2[0].length) {
            result = true;
        }
        return result;
    }
}

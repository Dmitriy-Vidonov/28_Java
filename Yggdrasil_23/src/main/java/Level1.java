import java.util.*;

public class Level1 {
    public static String[] TreeOfLife(int H, int W, int N, String[] tree) {
        for (int i=0; i<H; i++) {
            tree[i] = tree[i].replace(".", "0");
            tree[i] = tree[i].replace("+", "1");
        }

        String commonStr = "";
        for(int i=0; i<H; i++) commonStr+=tree[i];
        int[][] intArray = StrToIntArray(commonStr, H, W);

        for(int i=1; i<=N; i++) {
            if(i % 2 != 0) {
                Growth(intArray);
            } else {
                Growth(intArray);
                AimingForDestroy(intArray);
            }
        }
        return intArrayToDotsNPlusesStringArray(intArray);
    }
    public static int[][] StrToIntArray(String str, int H, int W) {
        int[][] intArray = new int[H][W];
        int label=0;
        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                intArray[i][j] = (str.charAt(label)) - '0';
                label++;
            }
        }
        return intArray;
    }
    public static void Growth(int[][] array) {
        for(int i=0; i<array.length; i++) {
            for(int j=0; j<array[0].length; j++) {
                array[i][j] += 1;
            }
        }
    }
    public static void AimingForDestroy(int[][] arrayAim) {
        for(int i=0; i<arrayAim.length; i++) {
            for(int j=0; j<arrayAim[0].length; j++) {
                if(arrayAim[i][j] >= 3) Destroy(arrayAim, i, j);
            }
        }
    }
    public static void Destroy(int[][] array, int i, int j) {
        if (j-1 >= 0 && array[i][j-1] != array[i][j]) {
            array[i][j-1] = 0;
        }
        if (i+1 < array.length && array[i+1][j] != array[i][j]) {
            array[i+1][j] = 0;
        }
        if (j+1 < array[0].length && array[i][j+1] != array[i][j]) {
            array[i][j+1] = 0;
        }
        if (i-1 >= 0 && array[i-1][j] != array[i][j]) {
            array[i-1][j] = 0;
        }
        array[i][j] = 0;
    }
    public static String[] intArrayToDotsNPlusesStringArray(int[][] array) {
        String[] resultStrArray = new String[array.length];
        String bufferStr = "";
        for(int i=0; i< array.length; i++) {
            for(int j=0; j<array[0].length; j++) {
                if(array[i][j] == 0) bufferStr += ".";
                else bufferStr += "+";
            }
            resultStrArray[i] = bufferStr;
            bufferStr = "";
        }
        return resultStrArray;
    }
}

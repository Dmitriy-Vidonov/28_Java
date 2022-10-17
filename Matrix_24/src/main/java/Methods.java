public class Methods {
    //вывод двумерного массива на экран
    public static void ShowArray(int[][] array) {
        for(int i=0; i< array.length; i++) {
            System.out.println();
            for(int j=0; j<array[0].length; j++) {
                System.out.print(array[i][j]);
            }
        }
    }


}

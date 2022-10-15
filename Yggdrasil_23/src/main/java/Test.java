public class Test {
    public static void main(String[] args) {
        int H = 3; //число строк
        int W = 4; //число стобцов
        String[] tree = {".+..", "..+.", ".+.."}; //массив на вход

        for (int i=0; i<H; i++) {
            tree[i] = tree[i].replace(".", "0");
            tree[i] = tree[i].replace("+", "1");
        }

       //склеить массив в одну строку, а потом ее распарсить
       String commonStr = "";
       for(int i=0; i<H; i++) commonStr+=tree[i];
       //System.out.println("commonStr = " + commonStr);

       int[][] intArray = new int[H][W];
       int label=0;
       for(int i=0; i<H; i++) {
           for(int j=0; j<W; j++) {
               intArray[i][j] = (commonStr.charAt(label)) - '0';
               label++;
           }
       }
       System.out.println("Начальное состояние массива:");
       Methods.ShowArray(intArray); //начальное состояние
       System.out.println(); System.out.println();

       Methods.Growth(intArray); //обычный рост ветвей на 1 год
       System.out.println("Первый год роста");
       Methods.ShowArray(intArray);
       System.out.println(); System.out.println();

       System.out.println("Второй год роста");
       Methods.Growth(intArray);
       Methods.ShowArray(intArray); System.out.println();

       //метод уничтожения соседних веток - так же оформить отдельно
       Methods.AimingForDestroy(intArray);
       
       Methods.ShowArray(intArray);
    }
}

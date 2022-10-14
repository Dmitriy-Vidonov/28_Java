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
       System.out.println("commonStr = " + commonStr);

       int[][] intArray = new int[H][W];
       int label=0;
       for(int i=0; i<H; i++) {
           for(int j=0; j<W; j++) {
               intArray[i][j] = (commonStr.charAt(label)) - '0';
               label++;
           }
       }

       for(int i=0; i<H; i++) {
           System.out.println();
           for(int j=0; j<W; j++) {
               System.out.print(intArray[i][j]);
           }
       }
    }
}

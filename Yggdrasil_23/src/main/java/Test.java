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
       for(int i=0; i<H; i++) commonStr+=tree[i]; //строковый массив преобразовали в строку

       int[][] intArray = Methods.StrToIntArray(commonStr, H, W);

       int N = 4;
       for(int i=1; i<=N; i++) {
           if(i % 2 != 0) {
               Methods.Growth(intArray);
           } else {
               Methods.Growth(intArray);
               Methods.AimingForDestroy(intArray);
           }
       }
       Methods.ShowArray(intArray);
       System.out.println();

       //Преобразовать полученный массив в массив строк с . и +
       String[] resultStrArray = Methods.intArrayToDotsNPlusesStringArray(intArray);

       for (String word : resultStrArray) System.out.print(word + " ");
    }
}

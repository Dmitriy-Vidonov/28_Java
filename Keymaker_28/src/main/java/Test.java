public class Test {
    //пробуем найти длину в зависимости от параметра k
    public static int pairs;
    public static int len;
    public static int quart;
    public static int LenCount(int k){
        len = 0;
        quart = 4;
        if (k <= 3) len = 1;
        else if (k > 3 && k <= 7) len = 2;
        else {
            len = 2; pairs=0;
            for(int count = 8; count <= k; count++) {
                if (pairs < 2 && quart == 4) {
                    len++;
                    pairs++;
                }
                else if (pairs == 2 && quart == 4) {
                    pairs = 0;
                    quart = 1;
                    len++;
                } else if (quart < 4) quart++;
            }
        }
        return len;
    }
    //testing
    public static void main(String[] args) {
        for(int k = 1; k <= 27; k++) System.out.println("k = " + k + " | " + LenCount(k));
    }
}

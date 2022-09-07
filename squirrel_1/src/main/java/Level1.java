import java.util.*;

public class Level1 {
    public static int squirrel(int N){
        int result = 0;
        int factorial = 1;
        for(int i=1; i<=N; i++) {
            factorial *= i;
        }

        result = factorial;
        int res = factorial / 10;
        while(res > 0) {
            res /= 10;
            result /= 10;
        }

        return result;
    }
}

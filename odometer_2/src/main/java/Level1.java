import java.util.*;

public class Level1 {
    public static int odometer(int[] oksana) {
        int result = oksana[0] * oksana[1];
        for(int i=2; i<=oksana.length-2; i+=2) {
            result += oksana[i] * (oksana[i+1] - oksana[i-1]);
        }
        return result;
    }
}
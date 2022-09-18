import java.util.*;

public class Test {
    public static void main(String[] args) {
        int[] arr = {20, 2, 30, 6, 10, 7}; //20*2 + 30*(6-2) + 10*(7-6) = 40 + 120 + 10 = 170 km
        int res = arr[0] * arr[1];
        for(int i=2; i<=arr.length-2; i+=2) {
            res += arr[i] * (arr[i+1] - arr[i-1]);
        }
        System.out.println("res = " + res);
        int[] oksana = {20, 2, 30, 6, 10, 7};
        System.out.println("километраж - " + Level1.odometer(oksana));
    }
}

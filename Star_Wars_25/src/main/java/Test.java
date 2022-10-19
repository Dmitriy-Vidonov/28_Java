import java.util.*;

public class Test {
    public static void main(String[] args) {
        int[] arrA = {5, 7, 10, 4};

        int[] array = Methods.Transform(arrA, 4);
        int len = array.length;
        int[] resArray = Methods.Transform(array, len);

        int sum = 0;
        for (int num : resArray) sum += num;
        if(sum % 2 == 0) System.out.println("true");
        else System.out.println("false");

    }
}

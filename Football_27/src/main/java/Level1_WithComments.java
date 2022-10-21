import java.util.*;

public class Level1_WithComments {
    public static boolean Football(int[] F, int N) {
        List<Integer> arrList = new ArrayList<>();
        for(int nums : F) arrList.add(nums);
        boolean result = false;

        //нашим методам на вход даем список
        if (Methods.theFirstMethod(arrList)) { //либо у нас отработал 1-й метод и все хорошо
            result = true; //или false
        } else if (Methods.theSecondMethod(arrList)) { //либо у нас отработал 2-й метод и все хорошо
            result = true; //или false
        } else { //либо у нас не отработало ни то и ни другое
            result = false;
        }

        return result;
    }
}

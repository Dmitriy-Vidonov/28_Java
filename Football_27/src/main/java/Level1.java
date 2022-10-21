import java.util.*;

public class Level1 {
    public static boolean Football(int[] F, int N) {
        List<Integer> arrList = new ArrayList<>();
        for(int nums : F) arrList.add(nums); //fill arrList with values from an array
        //int listSize = arrList.size();
        boolean result = false;

        //нашим методам на вход даем список
        if (Methods.theFirstMethod(arrList)) { //либо у нас отработал 1-й метод и все хорошо
            result = true; //или false
        } else if (/*2 метод*/result) { //либо у нас отработал 2-й метод и все хорошо
            //подаем начальный список на 2-й метод
            result = true; //или false
        } else { //либо у нас не отработало ни то и ни другое
            result = false;
        }

        return result;
    }
}

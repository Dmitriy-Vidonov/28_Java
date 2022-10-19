import java.util.List;

public class Methods {
    //проверка числа знаков = по координатам
    public static int EqualsCount(String str, int startIndex, int endIndex) {
        int res = 0;
        for(int i=startIndex; i<endIndex; i++) {
            if(str.charAt(i) == '=') {
                res++;
            }
        }
        return res;
    }
    //проверка списка на содержание только нужного значения
    public static boolean isOnlyOneDigit(List<Integer> list, int digit) {
        boolean res = true;
        for(int nums : list) if (nums != digit) res = false;
        return res;
    }
}

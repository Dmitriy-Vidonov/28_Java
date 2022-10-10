public class Methods {
    public static int compareStrings(String s1, String s2) {

        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            if ((int) s1.charAt(i) == (int) s2.charAt(i)) {
                continue;
            } else {
                return (int) s1.charAt(i) - (int) s2.charAt(i);
            }
        }
        if (s1.length() < s2.length()) {
            return (s1.length() - s2.length());
        } else if (s1.length() > s2.length()) {
            return (s1.length() - s2.length());
        } else {
            return 0;
        }
    }
    private static void getComparisonResult(int value, String s1, String s2) {
        if (value > 0) {
            System.out.println(s1 + " больше " + s2);
        } else if (value < 0) {
            System.out.println(s1 + " меньше " + s2);
        } else {
            System.out.println(s1 + " и " + s2 + " равны");
        }
    }
}

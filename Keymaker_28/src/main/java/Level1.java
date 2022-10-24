import java.util.*;

public class Level1 {
    public static String Keymaker(int k) {
            boolean[] doors = ArrayCreate(k);

            switch (k) {
                case 1:
                    Step1(doors);
                    break;
                case 2:
                    Step1(doors);
                    Step2(doors);
                    break;
                case 3:
                    Step1(doors);
                    Step2(doors);
                    Step3(doors);
                    break;
                default:
                    Step1(doors);
                    Step2(doors);
                    Step3(doors);
                    for (int step = 3; step < doors.length; step++) {
                        Change(doors, step);
                    }
                    break;
            }
            return ArrayToString(doors);
    }

    public static void Change(boolean[] array, int i) {
        if(array[i] == true) {
            array[i] = false;
        } else array[i] = true;
    }

    public static boolean[] ArrayCreate(int k) {
        boolean[] array = new boolean[k];
        for (int i = 0; i < k; i++) {
            array[i] = false;
        }
        return array;
    }

    public static String ArrayToString(boolean[] array) {
        String str = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i] == false) str += "0";
            else str += "1";
        }
        return str;
    }

    public static void Step1(boolean[] array) {
        for (int i = 0; i < array.length; i++) Change(array, i);
    }
    public static void Step2(boolean[] array) {
        for (int i = 0; i < array.length; i++) if (i % 2 != 0) Change(array, i);
    }
    public static void Step3(boolean[] array) {
        for (int i = 0; i < array.length; i++) if ((i + 1) % 3 == 0) Change(array, i);
    }
}

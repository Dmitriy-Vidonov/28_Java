import java.util.*;

public class Test {
    public static void main(String[] args) {
        String str = "XXYYZABC";
        //Перевели строку в ArrayList
        ArrayList<Character> strArray = new ArrayList<>();
        for(int i=0; i<str.length(); i++) {
            strArray.add(str.charAt(i));
        }

        //надо удалить дубликаты из массива и пройтись по недублированному массиву
        Set<Character> set = new HashSet<>(strArray); //создали set на основе ранее созданной коллекции
        strArray.clear(); //очистили изначальную коллекцию
        strArray.addAll(set); //заполнили заново уже упорядоченным списком

        List<Integer> nums = new ArrayList<>(); //список для хранения частотности букв
        for(char word : strArray) {
            int buff_count = 0;
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == word) buff_count++;
            }
            nums.add(buff_count);
        }

        Collections.sort(nums);
        System.out.print("массив чисел - ");
        for(int digit : nums) System.out.print(digit + ", "); System.out.println();

        int minEl = Collections.min(nums);
        int maxEl = Collections.max(nums);
        int minCount = 0;
        int maxCount = 0;
        for(int digit : nums) {
            if(digit == minEl) minCount++;
            else if (digit == maxEl) maxCount++;
        }
        System.out.println("число максимальных = " + maxCount);
        System.out.println("число минимальных = " + minCount);

        if((maxCount > 0 && (((maxEl - minEl) == 1) && (maxCount == 1 || minCount == 1))) || maxCount == 0) {
            System.out.println("валидно");
        } else System.out.println("не валидно");
    }
}

import java.util.*;

public class Test {
    public static void main(String[] args) {
        String str = "XXYYZA";
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
                if(str.charAt(i) == word) {
                    buff_count++;
                } else continue;
            }
            nums.add(buff_count);
        }
        System.out.print("массив чисел - ");
        for(int digit : nums) System.out.print(digit + ", "); System.out.println();

        //обработать массив чисел
        int mainDigit = nums.get(0);

        Set<Integer> set2 = new HashSet<>(nums); //создали set на основе ранее созданной коллекции
        nums.clear(); //очистили изначальную коллекцию
        nums.addAll(set2); //заполнили заново уже упорядоченным списком

        System.out.print("массив чисел2 - ");
        for(int digit : nums) System.out.print(digit + ", "); System.out.println();

        //надо обрабатывать массив типа 1,2,2,1 а не конечный 1,2. 
        if(nums.size() > 2) System.out.println("не валидно");
        else if(nums.size() == 2 && ((nums.get(0) - nums.get(1)) == (1 | -1))) System.out.println("валидно");
        else if(nums.size() == 1) System.out.println("валидно");
        else System.out.println("не валидно");
    }
}

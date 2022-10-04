public class Test {
    public static void main(String[] args) {
        String str = "*..*..*..*..*..*..*";
        char[] chArr = str.toCharArray();
        //for(char letter : chArr) System.out.print(letter + " ");
        int stars = 1;
        int dots = 0;
        int index = 1;
        while(chArr[index] != '*') {
            dots++;
            index++;
        } //dots = 2, stars = 1
        System.out.println("dots = " + dots + ", index = " + index);

        //выделить подстроку
        String subStr = str.substring(0, (dots + stars));
        System.out.println(subStr); //*..  - наш шаблончик

        //в цикле от 0 до len-1 с шагом, равным длине шаблона - проверяем вхождение подстроки в строку
        //например вхождение подстроки в часть строки
        System.out.println(str.substring(0, (dots + stars)).equals(subStr));
    }
}

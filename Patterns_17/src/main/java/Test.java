public class Test {
    public static void main(String[] args) {
        String str = "*.*";
        char[] chArr = str.toCharArray();
        //for(char letter : chArr) System.out.print(letter + " ");
        int stars = 1;
        int dots = 0;
        int index = 1;

        //осталось доработать лишь эту проверку. Она должна учитывать, что вся строка может быть звездочками
        if (chArr.length > 1 && chArr[0] == '*')  {
            while(chArr[index] != '*' && chArr.length > 1) {
                dots++;
                index++;
            } //dots = 2, stars = 1
            System.out.println("dots = " + dots + ", index = " + index);
        } else if (chArr.length == 1 && chArr[0] == '*') {
            System.out.println("Строка состоит из 1 *");
        } else {
            System.out.println("Строка изначально некорректна!");
        }

        //выделить подстроку
        String subStr = str.substring(0, (dots + stars));
        System.out.println(subStr); //*..  - наш шаблончик

        //в цикле от 0 до len-1 с шагом, равным длине шаблона - проверяем вхождение подстроки в строку
        //например вхождение подстроки в часть строки
        System.out.println(str.substring(0, (dots + stars)).equals(subStr)); //true

        //далее просто надо сдвигаться и дальше проверять - до предпоследнего символа, который должен быть *
        int StrPartStart = 0; //начало куска строки для поиска подстроки
        int StrPartEnd = dots + stars; //конец куска строки для поиска подстроки. Равен длине шаблончика - 3

        //Проверка корректности длины строки
        if ((chArr.length-1) % (dots + stars) == 0) System.out.println("Длина корректна!");
        else System.out.println("Длина некорректна!");

        int checks = 0;
        for (int i = 0; i <= chArr.length-1 && i + (dots + stars) <= chArr.length-1
                && chArr.length >= (dots + stars) && chArr[chArr.length-1] == '*'
                && chArr[0] == '*'; i += (dots + stars)) {
            //System.out.println("i = " + i);
            if (str.substring(i, i + (dots + stars)).equals(subStr) == true) {
                System.out.println("Проверка пройдена!");
                checks++;
            } else {
                System.out.println("Проверка не пройдена!");
                break;
            }
        }
        if (checks == (chArr.length-1) / (dots + stars)) System.out.println("Все проверки пройдены!");
        else System.out.println("В строке найдена ошибка!");
    }
}

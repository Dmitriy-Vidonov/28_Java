public class Level1 {
    public static String currenString = ""; //переменная как статическое поле класса

    public static String BastShoe(String command) {
        int strCommand = 0;
        String bufferString = "";
        strCommand = command.charAt(0) - '0';

        switch(strCommand) {
            case 1: //код для выполнения команды (1) Добавить(S)
                //System.out.println("исполняем 1-ю команду");
                Level1.currenString += command.substring(2,command.length());
                //System.out.println("строка = " + Level1.currenString);
                break;
            case 2:
                System.out.println("исполняем 2-ю команду");
                break;
            case 3:
                System.out.println("исполняем 3-ю команду");
                break;
            case 4:
                System.out.println("исполняем 4-ю команду");
                break;
            case 5:
                System.out.println("исполняем 5-ю команду");
                break;
            default:
                System.out.println("Без изменений - " + Level1.currenString);
        }
        return Level1.currenString;
    }
    //тестирование
    public static void main(String[] args) {
        System.out.println(BastShoe("1 Привет"));
        System.out.println(BastShoe("1 , Мир!"));
        System.out.println(BastShoe("2 ++"));
    }
}

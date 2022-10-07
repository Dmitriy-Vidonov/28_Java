public class Test {
    public static void main(String[] args) {
        //Определить команду исходя из строки на вход
        int command = 0;
        String bufferString = "";
        String inputString = "1 Привет";
        String currentString = ""; //можно по идее StringBuilder использовать, но попробуем и так
        command = inputString.charAt(0) - '0'; //перевели команду в int
        System.out.println("команда - " + command);

        //для каждой команды будет своя ветка вычислений. Для этого можно создать базовый switch-case
        switch(command) {
            case 1: //код для выполнения команды (1) Добавить(S)
                //System.out.println("исполняем 1-ю команду");
                currentString += inputString.substring(2,inputString.length());
                System.out.println("строка = " + currentString);
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
                System.out.println("Некорректная команда. Возвращаем текущую строку без измненеий!");
        }
    }
}

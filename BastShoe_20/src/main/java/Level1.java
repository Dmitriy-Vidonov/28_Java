import java.util.*;

public class Level1 {
    public static String currenString = ""; //переменная как статическое поле класса
    public static ArrayList<String> undoArray = new ArrayList<>(); //массив строк для операции Undo()
    public static int undoCounter = 1; //счетчик для расчета индекса в undoArray

    public static String BastShoe(String command){
        int strCommand = 0;
        String bufferString = "";
        strCommand = command.charAt(0) - '0';
        int toDelete = 0; //число символов на удаление
        int toShow = 0; //номер символа для выдачи
        boolean flag = true; //флаг для определения вывода возвращаемого значения
        String symbol = ""; //символ для выдачи для 3-й операции Выдать(i)

        switch(strCommand) {
            case 1: //код для выполнения команды (1) Добавить(S)
                Level1.currenString += command.substring(2,command.length());
                undoArray.add(Level1.currenString); //добавляем состояние строки в массив Undo()
                break;
            case 2: //код для выполнения команды (2) Удалить(N)
                String[] command2 = command.split(" ");
                toDelete = Integer.valueOf(command2[1]);
                if(toDelete <= Level1.currenString.length()) {
                    Level1.currenString = Level1.currenString.substring(0, Level1.currenString.length() - toDelete);
                    undoArray.add(Level1.currenString); //добавляем состояние строки в массив Undo()
                } else {
                    Level1.currenString = "";
                    undoArray.add(Level1.currenString); //добавляем состояние строки в массив Undo()
                }
                break;
            case 3: //код для выполнения команды (3) Выдать(i)
                String[] command3 = command.split(" ");
                toShow = Integer.valueOf(command3[1]);
                //нам нужно выдать i-тый символ, но при этом не трогать строку
                if(toShow >= 0 && toShow <= Level1.currenString.length()-1) {
                    symbol = String.valueOf(Level1.currenString.charAt(toShow));
                    flag = false;
                }
                break;
            case 4: //код для выполнения команды (4) Undo()
                System.out.print("Undo: ");
                if(Level1.undoCounter++ < undoArray.size()-1){
                    Level1.currenString = undoArray.get((undoArray.size()-1) - Level1.undoCounter);
                    Level1.undoCounter++;
                } else {
                    Level1.currenString = undoArray.get(0);
                }
                break;
            case 5:
                System.out.println("исполняем 5-ю команду");
                break;
            default:
                System.out.println(Level1.currenString);
        }
        if(flag)return Level1.currenString;
        else return symbol;
    }
    //тестирование
    public static void main(String[] args) {
        System.out.println(BastShoe("1 Привет"));
        System.out.println(BastShoe("1 , Мир!"));
        System.out.println(BastShoe("2 1"));
        System.out.println(BastShoe("3 1"));
        System.out.println(BastShoe("2 0"));
        System.out.println(BastShoe("3 0"));
        System.out.println(BastShoe("2 0"));
        System.out.println(BastShoe("1 ++"));
        System.out.println(BastShoe("4"));
        System.out.println(BastShoe("4"));
        System.out.println(BastShoe("4"));
        System.out.println(BastShoe("4"));
    }
}

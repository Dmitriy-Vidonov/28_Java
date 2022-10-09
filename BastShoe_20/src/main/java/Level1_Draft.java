import java.util.*;

public class Level1_Draft {
    public static String BastShoe(String command){
        int strCommand = 0;
        String bufferString = "";
        String[] commandMain = command.split(" ");
        strCommand = Integer.valueOf(commandMain[0]);
        int toDelete = 0; //число символов на удаление
        int toShow = 0; //номер символа для выдачи
        boolean flag = true; //флаг для определения вывода возвращаемого значения
        String symbol = ""; //символ для выдачи для 3-й операции Выдать(i)

        switch(strCommand) {
            case 1: //код для выполнения команды (1) Добавить(S)
                String[] command1 = command.split(" "); //разделение входной строки на 2 части
                if(undoFlag == false) { //false - обычный режим
                    currenString += command1[1];
                    undoArray.add(currenString); //добавляем состояние строки в массив Undo()
                    index++;
                    break;
                } else {
                    currenString += command1[1];
                    bufferStr = undoArray.get(index); //заносим ячейку с текущим индексом в буфер
                    undoArray.clear(); //очистка массива изменений
                    undoArray.add(bufferStr); //сначала добавляем буферную ячейку
                    undoArray.add(currenString); //затем добавляем текущее состояние строки в массив изменений
                    index=1; //индекс ставим во вторую из двух позицию
                    undoFlag = false; //обнуляем флажок
                    break;
                }
            case 2: //код для выполнения команды (2) Удалить(N)
                String[] command2 = command.split(" "); //разделение входной строки на 2 части
                toDelete = Integer.valueOf(command2[1]); //в переменную toDelete помещается строка для удаления
                if(toDelete <= currenString.length() && undoFlag == false) {
                    currenString = currenString.substring(0, currenString.length() - toDelete);
                    undoArray.add(currenString); //добавляем состояние строки в массив Undo()
                    index++;
                }
                else if(!(toDelete <= currenString.length()) && undoFlag == false){
                    currenString = "";
                    undoArray.add(currenString); //добавляем состояние строки в массив Undo()
                    index++;
                }
                else if(toDelete <= currenString.length() && undoFlag == true) {
                    currenString = currenString.substring(0, currenString.length() - toDelete);
                    bufferStr = undoArray.get(index);
                    undoArray.clear();
                    undoArray.add(bufferStr);
                    undoArray.add(currenString);
                    index=1; //индекс ставим во вторую из двух позицию
                    undoFlag = false; //обнуляем флажок
                    break;
                } else {
                    currenString = "";
                    bufferStr = undoArray.get(index);
                    undoArray.clear();
                    undoArray.add(bufferStr);
                    undoArray.add(currenString);
                    index=1;
                    undoFlag = false; //обнуляем флажок
                    break;
                }
                break;
            case 3: //код для выполнения команды (3) Выдать(i)
                String[] command3 = command.split(" ");
                toShow = Integer.valueOf(command3[1]);
                //нам нужно выдать i-тый символ, но при этом не трогать строку
                if(toShow >= 0 && toShow <= currenString.length()-1) {
                    symbol = String.valueOf(currenString.charAt(toShow));
                    flag = false;
                }
                break;
            case 4: //код для выполнения команды (4) Undo()
                undoFlag = true;
                if(index > 0) {
                    index--;
                    currenString = undoArray.get(index);
                } else currenString = undoArray.get(0);
                break;
            case 5: //код для выполнения команды (5) Redo()
                if(index >= 0 && index < undoArray.size()-1) {
                    index++;
                    currenString = undoArray.get(index);
                } else currenString = undoArray.get(undoArray.size()-1);
                break;
            default:
                return currenString;
        }
        if(flag)return currenString;
        else return symbol;
    }
    public static String currenString = ""; //переменная как статическое поле класса
    public static ArrayList<String> undoArray = new ArrayList<>(); //массив строк для операции Undo()
    public static int index = -1; //индекс для навигации по массиву undoArray[]
    public static boolean undoFlag = false; //переменная хранит статус применения метода Undo()
    public static String bufferStr = ""; //буферная строка для формирования нового массива Undo
    //тестирование
    public static void main(String[] args) {
        System.out.println(BastShoe("1 Привет"));
        System.out.println(BastShoe("1 , Мир!"));
        System.out.println(BastShoe("1 ++"));
        System.out.println(BastShoe("2 2"));
        System.out.println(BastShoe("4"));
        System.out.println(BastShoe("4"));
        System.out.println(BastShoe("1 *"));
        System.out.println(BastShoe("4"));
        System.out.println(BastShoe("4"));
        System.out.println(BastShoe("4"));
        System.out.println(BastShoe("3 6"));
        System.out.println(BastShoe("2 100"));
        System.out.println(BastShoe("1 Привет"));
        System.out.println(BastShoe("1 , Мир!"));
        System.out.println(BastShoe("1 ++"));
        System.out.println(BastShoe("4"));
        System.out.println(BastShoe("4"));
        System.out.println(BastShoe("5"));
        System.out.println(BastShoe("4"));
        System.out.println(BastShoe("5"));
        System.out.println(BastShoe("5"));
        System.out.println(BastShoe("5"));
        System.out.println(BastShoe("5"));
        System.out.println(BastShoe("4"));
        System.out.println(BastShoe("4"));
        System.out.println(BastShoe("2 2"));
        System.out.println(BastShoe("4"));
        System.out.println(BastShoe("5"));
        System.out.println(BastShoe("5"));
        System.out.println(BastShoe("5"));
        System.out.println(BastShoe("10 89"));

        for(String word : undoArray) System.out.print(word + " | ");
    }
}

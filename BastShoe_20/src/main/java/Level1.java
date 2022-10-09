import java.util.*;

public class Level1 {
    public static String currenString = ""; //переменная как статическое поле класса
    public static ArrayList<String> undoArray = new ArrayList<>(); //массив строк для операции Undo()
    public static int index = -1; //индекс для навигации по массиву undoArray[]
    public static boolean undoFlag = false; //переменная хранит статус применения метода Undo()
    public static String bufferStr = ""; //буферная строка для формирования нового массива Undo

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
                if(undoFlag == false) { //false - обычный режим
                    Level1.currenString += command.substring(2,command.length());
                    undoArray.add(Level1.currenString); //добавляем состояние строки в массив Undo()
                    index++;
                    break;
                } else {
                    Level1.currenString += command.substring(2,command.length()); //сначала обновляем текущую строку
                    bufferStr = Level1.undoArray.get(index); //заносим ячейку с текущим индексом в буфер
                    undoArray.clear(); //очистка массива изменений
                    undoArray.add(bufferStr); //сначала добавляем буферную ячейку
                    undoArray.add(Level1.currenString); //затем добавляем текущее состояние строки в массив изменений
                    index=1; //индекс ставим во вторую из двух позицию
                    undoFlag = false; //обнуляем флажок
                    break;
                }
            case 2: //код для выполнения команды (2) Удалить(N)
                String[] command2 = command.split(" "); //разделение входной строки на 2 части
                toDelete = Integer.valueOf(command2[1]); //в переменную toDelete помещается строка для удаления
                if(toDelete <= Level1.currenString.length() && undoFlag == false) {
                    Level1.currenString = Level1.currenString.substring(0, Level1.currenString.length() - toDelete);
                    undoArray.add(Level1.currenString); //добавляем состояние строки в массив Undo()
                    index++;
                }
                else if(!(toDelete <= Level1.currenString.length()) && undoFlag == false){
                    Level1.currenString = "";
                    undoArray.add(Level1.currenString); //добавляем состояние строки в массив Undo()
                    index++;
                }
                else if(toDelete <= Level1.currenString.length() && undoFlag == true) {
                    Level1.currenString = Level1.currenString.substring(0, Level1.currenString.length() - toDelete);
                    bufferStr = Level1.undoArray.get(index);
                    undoArray.clear();
                    undoArray.add(bufferStr);
                    undoArray.add(Level1.currenString);
                    index=1; //индекс ставим во вторую из двух позицию
                    undoFlag = false; //обнуляем флажок
                    break;
                } else {
                    Level1.currenString = "";
                    bufferStr = Level1.undoArray.get(index);
                    undoArray.clear();
                    undoArray.add(bufferStr);
                    undoArray.add(Level1.currenString);
                    index=1;
                    undoFlag = false; //обнуляем флажок
                    break;
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
                undoFlag = true;
                if(index > 0) {
                    index--;
                    Level1.currenString = undoArray.get(index);
                } else Level1.currenString = undoArray.get(0);
                break;
            case 5: //код для выполнения команды (5) Redo()
                System.out.print("Redo: ");
                if(index >= 0 && index < undoArray.size()-1) {
                    index++;
                    Level1.currenString = undoArray.get(index);
                } else Level1.currenString = undoArray.get(undoArray.size()-1);
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

        for(String word : undoArray) System.out.print(word + " | ");
    }
}

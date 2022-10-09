import java.util.*;

public class Level1 {
    public static String BastShoe(String command){
        int strCommand = 0;
        String bufferString = "";
        String[] commandMain = command.split(" ");
        strCommand = Integer.valueOf(commandMain[0]);
        int toDelete = 0;
        int toShow = 0;
        boolean flag = true;
        String symbol = "";

        switch(strCommand) {
            case 1:
                String[] command1 = command.split(" ");
                if(undoFlag == false) {
                    currenString += command1[1];
                    undoArray.add(currenString);
                    index++;
                    break;
                } else {
                    currenString += command1[1];
                    bufferStr = undoArray.get(index);
                    undoArray.clear();
                    undoArray.add(bufferStr);
                    undoArray.add(currenString);
                    index=1;
                    undoFlag = false;
                    break;
                }
            case 2:
                String[] command2 = command.split(" ");
                toDelete = Integer.valueOf(command2[1]);
                if(toDelete <= currenString.length() && undoFlag == false) {
                    currenString = currenString.substring(0, currenString.length() - toDelete);
                    undoArray.add(currenString);
                    index++;
                }
                else if(!(toDelete <= currenString.length()) && undoFlag == false){
                    currenString = "";
                    undoArray.add(currenString);
                    index++;
                }
                else if(toDelete <= currenString.length() && undoFlag == true) {
                    currenString = currenString.substring(0, currenString.length() - toDelete);
                    bufferStr = undoArray.get(index);
                    undoArray.clear();
                    undoArray.add(bufferStr);
                    undoArray.add(currenString);
                    index=1;
                    undoFlag = false;
                    break;
                } else {
                    currenString = "";
                    bufferStr = undoArray.get(index);
                    undoArray.clear();
                    undoArray.add(bufferStr);
                    undoArray.add(currenString);
                    index=1;
                    undoFlag = false;
                    break;
                }
                break;
            case 3:
                String[] command3 = command.split(" ");
                toShow = Integer.valueOf(command3[1]);
                if(toShow >= 0 && toShow <= currenString.length()-1) {
                    symbol = String.valueOf(currenString.charAt(toShow));
                    flag = false;
                }
                break;
            case 4:
                undoFlag = true;
                if(index > 0) {
                    index--;
                    currenString = undoArray.get(index);
                } else currenString = undoArray.get(0);
                break;
            case 5:
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
    public static String currenString = "";
    public static ArrayList<String> undoArray = new ArrayList<>();
    public static int index = -1;
    public static boolean undoFlag = false;
    public static String bufferStr = "";
}

public class Test3 {
    public static void main(String[] args) {
        String strReplace = "нкмл";
        String bufferStr = "";
        char temp;
        temp = strReplace.charAt(1); //к
        char[] tempArr = strReplace.toCharArray();
        temp = tempArr[1];//к
        tempArr[1] = tempArr[0];
        tempArr[0] = temp;
        bufferStr = String.valueOf(tempArr);

        System.out.println("buffer str = " + bufferStr);
    }
}

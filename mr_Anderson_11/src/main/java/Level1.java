import java.util.*;

public class Level1 {
   public static String BigMinus(String s1, String s2) {
       String num1, num2;
       num1 = s1;
       num2 = s2;

       int len1, len2, countLen, countLetter;
       len1 = num1.length();
       len2 = num2.length();
       countLen = len1;
       countLetter = 0;

       if(num1.length() > num2.length()){
       } else if (num1.length() == num2.length()) {
           while (countLen > 0) {
               if(Integer.valueOf(num1.charAt(countLetter)-'0') > Integer.valueOf(num2.charAt(countLetter)-'0')) {
                   break;
               } else if (Integer.valueOf(num1.charAt(countLetter)-'0') < Integer.valueOf(num2.charAt(countLetter)-'0')) {
                   String buffer = num1;
                   num1 = num2;
                   num2 = buffer;
                   break;
               } else {
                   countLen--;
                   countLetter++;
               }
           }
       } else {
           String buffer = num1;
           num1 = num2;
           num2 = buffer;
       }
       if(countLen == 0) {
       }

       len1 = num1.length();
       len2 = num2.length();

       int[] num1Array = new int[len1];
       int[] num2Array = new int[len2];

       for(int i=0; i<len1; i++) {
           num1Array[i] = Integer.valueOf(num1.charAt(i)-'0');
       }

       for(int i=0; i<len2; i++) {
           num2Array[i] = Integer.valueOf(num2.charAt(i)-'0');
       }

       int resArraLen = len1;
       if(len2 > len1) resArraLen = len2;

       int[][] resArray = new int[3][resArraLen];

       int countNum1 = len1-1;
       for(int i=resArraLen-1; i>=resArraLen-len1; i--) {
           resArray[0][i] = num1Array[countNum1];
           countNum1--;
       }

       int countNum2 = len2-1;
       for(int i=resArraLen-1; i>=resArraLen-len2; i--) {
           resArray[1][i] = num2Array[countNum2];
           countNum2--;
       }

       for(int i=resArraLen-1; i>=0; i--) {
           if(resArray[0][i] < resArray[1][i]) {
               resArray[2][i] = resArray[0][i] + 10 - resArray[1][i];
               resArray[0][i-1] -= 1;
           } else {
               resArray[2][i] = resArray[0][i] - resArray[1][i];
           }
       }

       String result = "";
       int i=0;
       while (resArray[2][i] == 0) {
           i++;
           break;
       }

       if(i==1) i = 0;
       for(int j=i; j<resArraLen; j++) {
           result += resArray[2][j];
       }
       return result;
   }
}

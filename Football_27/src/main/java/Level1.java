import java.util.*;
public class Level1 {
    public static boolean Football(int[] F, int N) {
        List<Integer> arrList = new ArrayList<>();
        for(int nums : F) arrList.add(nums);
        boolean result = false;

        if (theFirstMethod(arrList)) {
            result = true;
        } else if (theSecondMethod(arrList)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public static boolean isListSorted(List<Integer> arrList) {
        List tmp = new ArrayList(arrList);
        Collections.sort(tmp);
        boolean sorted = tmp.equals(arrList);
        return sorted;
    }

    public static void ElementsReplace(List<Integer> listToReplace, int firstIndex, int secondIndex) {
        int buffer = listToReplace.get(firstIndex);
        listToReplace.set(firstIndex, listToReplace.get(secondIndex));
        listToReplace.set(secondIndex, buffer);
    }

    public static boolean theFirstMethod(List<Integer> firstList) {
        int listSize = firstList.size();
        int buffer, firstIndex, secondIndex;
        buffer = firstIndex = secondIndex = 0;

        for (int i=0; i<listSize; i++) {
            if (firstList.get(i) == Collections.max(firstList) && i != listSize - 1) {
                buffer = firstList.get(listSize - 1);
                firstList.set(listSize - 1, firstList.get(i));
                firstList.set(i, buffer);
                break;
            } else if ((i >= 1 && i < listSize - 1) && firstList.get(i) < firstList.get(i-1)
                    && firstList.get(i) < firstList.get(i+1)) {
                firstIndex = i;
            } else if ((i >= 1 && i < listSize - 1) && firstList.get(i) > firstList.get(i-1)
                    && firstList.get(i) > firstList.get(i+1)) {
                secondIndex = i;
            }
        }
        ElementsReplace(firstList, firstIndex, secondIndex);

        return isListSorted(firstList);
    }

    public static boolean theSecondMethod(List<Integer> secondList) {
        int listSize = secondList.size();
        int startIndex, endIndex;
        startIndex = endIndex = 0;
        boolean startIndexInstalled = false;
        boolean endIndexInstalled = false;

        List<Integer> tmpList = new ArrayList<>(secondList);
        Collections.reverse(tmpList);

        if (isListSorted(tmpList)) {
            Collections.sort(secondList);
        } else {
            for (int i = 1; i < listSize - 1; i++) {
                if (secondList.get(i) < secondList.get(i-1) && startIndexInstalled == false
                        && endIndexInstalled == false) {
                    startIndex = i-1;
                    startIndexInstalled = true;
                } else if (secondList.get(i) < secondList.get(i+1) && startIndexInstalled == true
                        && endIndexInstalled == false) {
                    endIndex = i;
                    endIndexInstalled = true;
                }
            }

            List<Integer> bufferList = new ArrayList<>();
            for (int count = startIndex; count <= endIndex; count++) {
                bufferList.add(secondList.get(count));
            }
            Collections.reverse(bufferList);

            int buffercount = 0;
            for (int i = startIndex; i <= endIndex; i++) {
                secondList.set(i, bufferList.get(buffercount));
                buffercount++;
            }
        }
        return isListSorted(secondList);
    }
}

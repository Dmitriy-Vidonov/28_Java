public class Level1 {
    public static String MassVote(int N, int[] Votes) {
        float maxElem = Votes[0];
        for(int i=0; i<Votes.length; i++) {
            if(maxElem < Votes[i]) {
                maxElem = Votes[i];
            }
        }

        float sum = 0;
        for(int num : Votes) sum += num;
        float percentage = ((maxElem / sum) * 100);

        int index, isDouble;
        index = isDouble = 0;
        for(int i=0; i<Votes.length; i++) {
            if(Votes[i] == maxElem) {
                isDouble++;
            }
        }

        for (index=0; index<Votes.length; index++) {
            if (Votes[index] == maxElem) break;
        }
        index++;

        String resultString = "";
        if(isDouble > 1) {
            resultString = "no winner";
        } else {
            if(percentage > 50) {
                resultString = ("majority winner " + index);
            } else {
                resultString = ("minority winner " + index);
            }
        }
        return resultString;
    }
}

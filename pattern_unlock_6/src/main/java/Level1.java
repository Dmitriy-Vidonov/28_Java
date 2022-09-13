public class Level1 {
    public static String PatternUnlock(int N, int[] hits) {
        double diag = (float) Math.sqrt(2);
        double sum = 0;

        for(int i=0; i<(N-1); i++) {
            switch (hits[i]) {
                case 1:
                    switch (hits[i+1]) {
                        case 6, 2, 9:
                            sum++;
                            break;
                        case 5, 8:
                            sum+=diag;
                            break;
                        default: sum+=0;
                    } break;
                case 2:
                    switch (hits[i+1]) {
                        case 1, 3, 5, 8:
                            sum++;
                            break;
                        case 6, 9, 7, 4:
                            sum+=diag;
                            break;
                        default: sum+=0;
                    } break;
                case 3:
                    switch (hits[i+1]) {
                        case 4, 2, 7:
                            sum++;
                            break;
                        case 5, 8:
                            sum+=diag;
                            break;
                        default: sum+=0;
                    } break;
                case 4:
                    switch (hits[i+1]) {
                        case 5, 3:
                            sum++;
                            break;
                        case 2:
                            sum+=diag;
                            break;
                        default: sum+=0;
                    } break;
                case 5:
                    switch (hits[i+1]) {
                        case 6, 4, 2:
                            sum++;
                            break;
                        case 1, 3:
                            sum+=diag;
                            break;
                        default: sum+=0;
                    } break;
                case 6:
                    switch (hits[i+1]) {
                        case 1, 5:
                            sum++;
                            break;
                        case 2:
                            sum+=diag;
                            break;
                        default: sum+=0;
                    } break;
                case 7:
                    switch (hits[i+1]) {
                        case 8, 3:
                            sum++;
                            break;
                        case 2:
                            sum+=diag;
                            break;
                        default: sum+=0;
                    } break;
                case 8:
                    switch (hits[i+1]) {
                        case 9, 7, 2:
                            sum++;
                            break;
                        case 1, 3:
                            sum+=diag;
                            break;
                        default: sum+=0;
                    } break;
                case 9:
                    switch (hits[i+1]) {
                        case 1, 8:
                            sum++;
                            break;
                        case 2:
                            sum+=diag;
                            break;
                        default: sum+=0;
                    } default: sum+=0;
            }
        }
        int res = Integer.parseInt(Integer.toString((int)Math.round(sum * 100000))
                .replace("0", ""));

        return Integer.toString(res);
    }
}

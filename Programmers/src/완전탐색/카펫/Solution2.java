package 완전탐색.카펫;

import java.util.Arrays;

public class Solution2 {

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        for(int i = 3; i < sum; i++) {
            int j = sum / i;
            if( sum % i == 0 && j >= 3) {
                int w = Math.max(i, j);
                int h = Math.min(i, j);
                int center = (w-2) * (h-2);
                if(center == yellow) {
                    answer[0] = w;
                    answer[1] = h;
                    return answer;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 2)));
    }
}

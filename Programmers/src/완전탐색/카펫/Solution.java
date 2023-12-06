package 완전탐색.카펫;

import java.util.Arrays;

public class Solution {

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int x = 2;
        int temp = 0;
        int w = 0;
        int y = 0;
        for(int i = 2; i < Math.sqrt(yellow); i += 2) {
            if( temp % 2 != 0 ) break;
            temp = yellow / 2;
        }

        answer[0] = x + 2;
        answer[1] = ( yellow / x ) + 2;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(24, 24)));
    }

}

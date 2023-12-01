package 완전탐색.최소직사각형;

public class Solution {

    public static int solution(int[][] sizes) {
        int answer = 0;
        int maxW = 0, maxH = 0;
        for(int i = 0; i < sizes.length; i++) {
            int w = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);
            maxW = Math.max(maxW, w);
            maxH = Math.max(maxH, h);
        }
        answer = maxW * maxH;
        return answer;
    }

    public static void main(String[] args) {
        int answer = solution(
                new int[][] {
                    {60, 50},
                    {30, 70},
                    {60, 30},
                    {80, 40}
                }
        );
        System.out.println(answer);
    }
}

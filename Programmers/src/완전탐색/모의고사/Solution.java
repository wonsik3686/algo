package 완전탐색.모의고사;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public static int[] solution(int[] answers) {
        int[][] p = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int [][] psc = {
                {1, 0},
                {2, 0},
                {3, 0}
        };
        for(int i = 0; i < answers.length; i++) {
            for(int j = 0; j < 3; j++) {
                int idx = i % p[j].length;
                if(answers[i] == p[j][ idx ]) psc[j][1]++;
            }
        }
        Arrays.sort(psc, Comparator.comparingInt(o -> -o[1]));
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < psc.length; i++) {
            list.add(psc[i][0]);
            if(i == psc.length - 1) break;
            if(psc[i][1] != psc[i+1][1]) break;
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = solution(
                new int[]{1,3,2,4,2}
        );
        System.out.println(Arrays.toString(result));
    }
}

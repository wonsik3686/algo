package sort.K번째수;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] part;

        for (int i = 0; i < commands.length; i++) {
            part = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
                //System.out.println(commands[i][0]-1 + " " + commands[i][1]);
                //System.out.println(Arrays.toString(part));
            Arrays.sort(part);
                //System.out.println(Arrays.toString(part));
                //System.out.println(commands[i][2]-1);
            answer[i] = part[commands[i][2]-1];
                //System.out.println(answer[i]);
        }

        return answer;
    }


    @Test
    @DisplayName("1")
    public void test() {

        Assertions.assertArrayEquals(solution(new int[]{1, 5, 2, 6, 3, 7, 4},
                                            new int[][] {{2,5,3}, {4,4,1}, {1,7,3}})
                                            , new int[] {5,6,3});

    }

}

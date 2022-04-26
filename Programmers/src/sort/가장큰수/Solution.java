package sort.가장큰수;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {

    class Num implements Comparable<Num> {

        int origin;
        int front;

        public Num(int number) {
            this.origin = number;
            if (number < 10) {
                this.front = number;
            } else if (number >= 10 && number < 100) {
                this.front = number / 10;
            } else if (number >= 100 & number < 1000) {
                this.front = number / 100;
            } else {
                this.front = number / 1000;
            }
        }

        @Override
        public int compareTo(Num num) {

            return (num.front - this.front);
        }
    }

    public String solution(int[] numbers) {
        String answer = "";

        Num[] nums = new Num[numbers.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new Num(numbers[i]);
        }

        Arrays.sort(nums);

        for (Num n:
             nums) {
            System.out.println(n.origin);
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder sb0 = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {

            if (nums[i].origin == 0) {
                sb0.append(nums[i].origin);
            } else {
                sb.append(nums[i].origin);
            }
        }
        sb.append(sb0);
        return sb.toString();
    }



    @Test
    @DisplayName("test1")
    public void test1() {

        Assertions.assertEquals(solution(new int[] {6, 10, 2}), "6210");
        Assertions.assertEquals(solution(new int[] {3, 30, 34, 5, 9}), "9534330");

    }
}

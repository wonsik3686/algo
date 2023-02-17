package Hash.포켓몬;

import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.solution(new int[] {1, 2, 3, 3}));
    }

    public int solution(int[] nums) {

        int answer = 0;

        int countType = nums.length/2;
        HashSet<Integer> hashSet = new HashSet<Integer>();

        for(int i = 0; i < nums.length; i++) {
            hashSet.add((nums[i]));
        }

        if ( countType < hashSet.size() ) {
            answer = countType;
        } else {
            answer = hashSet.size();
        }

        return answer;

    }

}


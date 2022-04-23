package DFS_BFS.단어변환;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Solution {

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int n = begin.length();

        boolean[] isMatching = new boolean[n];
        boolean[] isChecked = new boolean[words.length];
        boolean isFullSame = false; // begin == target

        for (int i = 0; i < n; i++) {
            if (begin.charAt(i) == target.charAt(i)) {
                isMatching[i] = true;
            }
        }

        while (!begin.equals(target)) {
            answer++;
//            System.out.println("time: " + answer);
            int endCount = 0;
            for (int i = 0; i < words.length; i++) {
                endCount = i+1;
                if (isChecked[i]) continue;

                int cnt = 0;
                boolean isSame = false;

                for (int j = 0; j < n; j++) {   // 글자 하나씩 체크
                    if (begin.charAt(j) == words[i].charAt(j)) {
                        cnt++;
                    } else {    // 틀린 글자가 있다면
                        if (target.charAt(j) == words[i].charAt(j)) {
                            isSame = true;
                        } else {
                            break;  // 틀린 글자가 target 글자와 다르면 빠져나감
                        }
                    }
                }

                if (cnt == n-1 && isSame) { // 바꿀만한 word라면
                    begin = words[i];
//                    System.out.println(begin);
                    isChecked[i] = true;
                    if (begin.equals(target)) {
                        isFullSame = true;
                    }
                    break;
                }
            }
            if (isFullSame) break;
            if (endCount == words.length) break;
        }   // end while
        if (!isFullSame) answer = 0;
        return answer;
    }

    @DisplayName(value = "1")
    @Test
    public void test() {
        Assertions.assertEquals(solution("hit", "cog",
                new String[] {"hot", "dot", "dog", "lot", "log", "cog"}), 4);
    }

    @DisplayName(value = "2")
    @Test
    public void test2() {
        Assertions.assertEquals(solution("hit", "cog",
                new String[]{"hot", "dot", "dog", "lot", "log"}), 0);
    }
}

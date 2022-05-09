package Hash.완주하지못한선수;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Solution {

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap hashMap = new HashMap();

        for (int i = 0; i < completion.length; i++) {
            hashMap.put(completion[i], i);
        }
        for (int i = 0; i < participant.length; i++) {
            Integer temp = null;
            try {
                temp = (int) hashMap.remove(participant[i]);
            } catch (NullPointerException e) {
                answer = participant[i];
            }
        }
        return answer;
    }

    @Test
    @DisplayName("test1")
    public void test1() {

        Assertions.assertEquals(solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}), "leo");

        Assertions.assertEquals(solution(new String[] {"marina", "josipa", "nikola", "vinko", "filipa"},
                new String[] {"josipa", "filipa", "marina", "nikola"}), "vinko");

        Assertions.assertEquals(solution(new String[] {"mislav", "stanko", "mislav", "ana"}, new String[] {"stanko", "ana", "mislav"}), "mislav");
    }

}

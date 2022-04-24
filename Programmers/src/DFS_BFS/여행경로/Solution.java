package DFS_BFS.여행경로;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String[] solution(String[][] tickets) {
        String[] answer = {};

        boolean[] isVisited;    // 사용한 티켓
        List<String> visitList; // 방문 순서 기록
        String cur; // 현재 있는 공항

        cur = "ICN";
        isVisited = new boolean[tickets.length];
        visitList = new ArrayList<String>();
        visitList.add(cur);

        int visitedCnt = 0;

        while(visitedCnt < tickets.length) {

            int idx = -1;   // 가야할 공항 체크
            String target = "ZZZ";  // 목표 공항
            visitedCnt++;   // 티켓 사용 개수 증가

            for (int i = 0; i < tickets.length; i++) {

                if (isVisited[i] == true) continue;

                if (tickets[i][0].equals(cur)) {    // 현재 있는 공항에서 사용할 수 있는 티켓이면
                    if (tickets[i][1].compareTo(target) < 0) {  // 목표 공항이 사전적으로 앞서있다면
                        idx = i;
                        target = tickets[i][1];
                    }
                }

            }

            isVisited[idx] = true;
            cur = tickets[idx][1];
            visitList.add(cur);
//            System.out.println(cur + " ");
        }

        answer = visitList.toArray(new String[visitList.size()]);
//        for (int i = 0; i < answer.length; i++) {
//            System.out.print(answer[i] + " ");
//        }
        return answer;
    }


    /**
     * compareTo()는 두개의 문자열을 비교
     * 어떤 문자가 사전적인 순서로 앞에 있는지도 리턴
     * 0 : 두개의 문자열이 동일
     * 양수 : compareTo()를 호출하는 객체가 인자보다 사전적으로 순서가 앞설 때
     * 음수 : 인자가 객체보다 사전적으로 순서가 앞설 때
     */


    @Test
    @DisplayName("test1")
    public void test1() {

        Assertions.assertEquals(new String[]{"ICN", "JFK", "HND", "IAD"},
                        solution(new String[][] {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}));

    }

    @Test
    @DisplayName("test2")
    public void test2() {

        Assertions.assertEquals(new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"},
                solution(new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"},
                        {"ATL", "ICN"}, {"ATL","SFO"}}));

    }
}

package 완전탐색.전력망을둘로나누기;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 두 개의 전력망으로 나누어야 함.
 * 3 개면 안됨.
 * count 의 합이 전체 정점 개수오 같지 않으면 결과에 반영하지 않아야 함.
 *
 * bfs 탐색 시작 정점은 없앤 간선의 양 정점으로 두면 됨.
 */
public class Solution2 {

    static boolean[] visited;
    static LinkedList<Integer>[] graph;
    static Integer min = Integer.MAX_VALUE;


    public static int solution(int n, int[][] wires) {
        int answer = -1;

        graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for(int i = 1; i <= wires.length; i++) {
            graph[wires[i - 1][0]].add(wires[i - 1][1]);
            graph[wires[i - 1][1]].add(wires[i - 1][0]);
        }
        visited = new boolean[n + 1];

        for(int i = 1; i <= wires.length; i++) {
            // 간선
            Integer tempA = wires[i - 1][0];
            Integer tempB = wires[i - 1][1];
            graph[tempA].remove(tempB);
            graph[tempB].remove(tempA);
            int countA = bfs(tempA);
            int countB = bfs(tempB);
            if(countA + countB == n) {
                min = Math.min(min, Math.abs(countA - countB));
            }
            graph[tempA].add(tempB);
            graph[tempB].add(tempA);
        }
        answer = min;

        return answer;
    }

    public static int bfs(int v) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        count++;
        visited[v] = true;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.println(temp);
            for (int nextV: graph[temp]) {
                if(!visited[nextV]) {
                    queue.add(nextV);
                    count++;
                    visited[nextV] = true;
                }
            }
        }
        for(int i = 0; i < visited.length; i++) visited[i] = false;
        return count;
    }

//    public static void bfs(int v) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(v);
//        visited[v] = true;
//        while (!queue.isEmpty()) {
//            int temp = queue.poll();
//            System.out.println(temp);
//            for (int nextV: graph[temp]) {
//                if(!visited[temp]) {
//                    queue.add(nextV);
//                    visited[nextV] = true;
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
//        System.out.println(solution(
//                9,
//                new int[][] {
//                        {1, 3},
//                        {2, 3},
//                        {3, 4},
//                        {4, 5},
//                        {4, 6},
//                        {4, 7},
//                        {7, 8},
//                        {7, 9}
//                }
//        ));
        System.out.println(solution(
                9,
                new int[][] {
                        {1, 3},
                        {2, 3},
                        {3, 4},
                        {4, 5},
                        {4, 6},
                        {4, 7},
                        {7, 8},
                        {7, 9}
                }
        ));
    }
}

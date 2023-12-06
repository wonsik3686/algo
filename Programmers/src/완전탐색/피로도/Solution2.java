package 완전탐색.피로도;

public class Solution2 {

    public static boolean[] visited;
    public static int max = 0;

    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, 0, dungeons, visited);
        return max;
    }

    public static void dfs(int k, int count, int[][] dungeons, boolean[] visited) {
        max = Math.max(max, count);
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], count + 1, dungeons, visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(
                80,
                new int[][] {
                    {80, 20},
                    {50, 40},
                    {30, 10}
                }
        ));
    }
}
/**
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.04ms, 76.4MB)
 * 테스트 2 〉	통과 (0.03ms, 76MB)
 * 테스트 3 〉	통과 (0.04ms, 76.7MB)
 * 테스트 4 〉	통과 (0.09ms, 73.4MB)
 * 테스트 5 〉	통과 (0.30ms, 68.6MB)
 * 테스트 6 〉	통과 (0.71ms, 74.7MB)
 * 테스트 7 〉	통과 (1.65ms, 76MB)
 * 테스트 8 〉	통과 (3.25ms, 75.3MB)
 * 테스트 9 〉	통과 (0.04ms, 73.6MB)
 * 테스트 10 〉	통과 (0.53ms, 83.1MB)
 * 테스트 11 〉	통과 (0.07ms, 76.7MB)
 * 테스트 12 〉	통과 (0.72ms, 73.3MB)
 * 테스트 13 〉	통과 (0.17ms, 74.6MB)
 * 테스트 14 〉	통과 (0.06ms, 74.8MB)
 * 테스트 15 〉	통과 (0.05ms, 76MB)
 * 테스트 16 〉	통과 (0.06ms, 73.2MB)
 * 테스트 17 〉	통과 (0.10ms, 75MB)
 * 테스트 18 〉	통과 (0.04ms, 65.6MB)
 * 테스트 19 〉	통과 (0.04ms, 75.9MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
package DFS_BFS.maxMoving;

import java.awt.*;

public class 최대이동 {

    static int[][] staticMap;
    static int[] dr = new int[] { -1, 1, 0, 0};
    static int[] dc = new int[] { 0, 0, -1, 1};
    static int max;

    public static void main(String[] args) {

        int[][] input = new int[][]
                {
                        {4, 4, 3, 3},
                        {4, 2, 2, 1},
                        {1, 1, 1, 1},
                        {2, 1, 3, 1}
                };

        System.out.println(solution(input));

    }

    public static int solution(int[][] map) {
        staticMap = map;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                dfs(new Point(i, j), 0);
            }
        }

        return max;
    }

    public static void dfs(Point pos, int cnt) {

        for(int d = 0; d < 4; d++) {
            int nc = pos.x + dc[d];
            int nr = pos.y + dr[d];

            if(nc < 0 || nc >= 4 || nr < 0 || nc >= 4) {
                isMax(cnt);
                continue;
            }

            dfs(new Point(nc, nr), cnt + 1);
        }
        isMax(cnt);
    }

    public static void isMax(int i) {
        max = Math.max(max, i);
    }
}

package DFS_BFS.단어변환;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {

    static class Node {
        String next;
        int edge;

        public Node(String next, int edge) {
            this.next = next;
            this.edge = edge;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int n = words.length;
        int ans = 0;

        Queue<Node> q = new LinkedList<>();

        boolean[] visited = new boolean[n];
        q.add(new Node(begin, 0));

        while (!q.isEmpty()) {

            Node cur = q.poll();
            if (cur.next.equals((target))) {
                ans = cur.edge;
                break;
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i] && isNext(cur.next, words[i])) {
                    visited[i] = true;
                    q.add(new Node(words[i], cur.edge + 1));
                }
            }
        }
        return ans;
    }

    static boolean isNext(String cur, String n) {

        int cnt = 0;
        for (int i = 0; i < n.length(); i++) {
            if (cur.charAt(i) != n.charAt(i)) {
                if (++ cnt > 1) return false;
            }
        }

        return true;
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

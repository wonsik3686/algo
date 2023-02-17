package DFS.BOJ_11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class Node {
        int num;
        int prev;
        boolean isVisited;

        Node(int prev, int num, boolean isVisited) {
            this.num = num;
            this.prev = prev;
            this.isVisited = isVisited;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(in.readLine());
        ArrayList<Node> list = new ArrayList<Node>();

        for (int i = 0; i < n-1 ; i++) {
            st = new StringTokenizer(in.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), true));
        }

        Comparator<Node> compareByNum = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.num - o2.num;
            }
        };

        Collections.sort(list, compareByNum);

        for(int i = 0; i < n - 1; i++) {
            sb.append(list.get(i).prev + "\n");
        }
        System.out.println(sb.toString());
    }
}

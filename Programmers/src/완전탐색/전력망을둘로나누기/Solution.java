package 완전탐색.전력망을둘로나누기;

import java.util.ArrayList;

/**
 *  X
 *
 * n 송전탑 ( vertex 정점 )
 * 트리
 * wires 전선 전보 ( edges 간선 )
 * 2 <= n <= 100
 * wires = n - 1  2d array
 * [ v1, v2 ] v1: 송전탑 1, v2: 송전탑 2
 *
 */
public class Solution {

    public static int solution(int n, int[][] wires) {
        int answer = -1;
        graph(n, wires);
        return answer;
    }

    public static void graph(int nodeCount, int[][] edges) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nodeCount; i++) {
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++) {
            list.get(edges[i][0]).add(edges[i][1]);
        }

    }

    public static void gra() {

        int[][] edges = new int[][] {
                {1, 2},
                {1, 3},
                {1, 4},
                {2, 3},
                {2, 5},
                {4, 5},
        };
        int n = 5;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        for(int i = 1; i < list.size(); i++) {
            for(int j = 0; j < list.get(i).size(); j++) {
                System.out.println(list.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        solution(
                0,
                new int[][] {
                        {0, 0}
                }
        );
    }
}

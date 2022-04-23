package DevMatching.one;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

     public static int[][] map,answerS;
    public static boolean[] visited;
    public static int N, mapN;
    public static List<int[]> answerList;

    public static void main(String[] args) {

        int[][] dist = {
                {0,5,2,4,1},
                {5,0,3,9,6},
                {2,3,0,6,3},
                {4,9,6,0,3},
                {1,6,3,3,0}
        };

        int[][] an = solution(dist);

//        for (int[] n:
//                an) {
//            System.out.println(Arrays.toString(n));
//        }

        for (int i = 0; i < mapN; i++) {
            System.out.println(Arrays.toString(an[i]));
        }
    }



    public static int[][] solution(int[][] dist) {


        N = dist[0].length;
        visited = new boolean[N];
        map = dist;

        answerList = new ArrayList<int[]>();
        answerS = new int[N][99];

        int[] arr = new int[N];
        Arrays.fill(arr, -1);

        recur(0, 0, new int[N]);


        int[][] answer = new int[mapN][N];

        for (int i = 0; i < mapN; i++) {
            answer[i] = new int[N];
            for (int j = 0; j < N; j++) {
                answer[i][j] = answerS[i][j];
            }

            //System.out.println(Arrays.toString(answerList.get(i)));
            //System.out.println(Arrays.toString(answer[i]));
        }

        return answer;
    }

    public static void recur(int num, int cnt, int[] arr) {

        if (cnt == N) {
//            answerS[mapN++] = arr;
            //answerList.add(mapN ,arr);
            //answerS[mapN] = arr;

            for (int i = 0; i < N; i++) {
                answerS[mapN][i] = arr[i];
            }

            mapN++;
            //System.out.println(Arrays.toString(arr));
            //System.out.println(Arrays.toString(answerList.));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] != true) {

                if (cnt == 0 || cnt == 1) {
                    arr[cnt] = i;
                    visited[i] = true;
                    recur(i, cnt + 1, arr);
                    visited[i] = false;
                } else {
                    arr[cnt] = i; // temp in
                    //ArrayList<Integer> lenList = new ArrayList<>();
                    int tLen = 0;
                    for (int j = 0; j < cnt; j++) {
                        //lenList.add(map[arr[j]][arr[j+1]]);
                        tLen += map[arr[j]][arr[j+1]];
                    }


                    if (tLen == map[arr[0]][arr[cnt]]) {
                        //arr[cnt] = i;
                        visited[i] = true;
                        recur(i, cnt + 1, arr);
                        visited[i] = false;
                    } else {
                        arr[cnt] = -1; // temp out
                    }
                }


            }
        }

    }

}

package 완전탐색.피로도;

import java.util.ArrayList;

/**
 * 피로도
 * 
 * 피로도 시스템 ( 0 이상 정수 )
 * 최소 피로도
 * 소모 피로도
 * 
 * 하루 동안 최대 던전 수
 *
 * k 현재 피로도, dungeons [ [ 최소 피로도, 소모 피로도 ], ... ] ]
 *
 * 순열. nPr
 */
public class Solution {

    public static ArrayList<int[]> candList = new ArrayList<>();

    public static int solution(int k, int[][] dungeons) {
        int[] cand = new int[dungeons.length];
        for(int i = 0; i < cand.length; i++) cand[i] = i;
        for(int i = 0; i < cand.length; i++)
            perm(cand, new int[cand.length], new boolean[cand.length], cand.length, 0, i + 1);
        int max = 0;
        for (int i = 0; i < candList.size(); i++) {
            max = Math.max(getMaxDunjeons(k, dungeons, candList.get(i)), max);
        }
        return max;
    }

    public static void perm(int[] arr, int[] output, boolean[] visiited, int n, int depth, int r) {
        if( depth == r ) {
            candList.add(output.clone());   // output 으로 넣으면 주소값이 들어가 output 의 마지막 값으로 통일됨.
            return;
        }
        for(int i = 0 ; i < n; i++) {
            if(!visiited[i]) {
                visiited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visiited, n, depth + 1, r);
//                output[depth] = 0;
                visiited[i] = false;
            }
        }
    }

    public static int getMaxDunjeons(int p, int[][] dungeons, int[] sequence) {
        int count = 0;
        int piro = p;
        for(int i = 0; i < dungeons.length; i++) {
            if(piro < dungeons[sequence[i]][0]) continue;
            piro -= dungeons[sequence[i]][1];
            if(piro < 0) break;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int ans = solution(
                80, 
                new int[][] {
                        {80, 20},
                        {50, 40},
                        {30, 10}
                }
        );
        System.out.println(ans);
    }
}
/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.09ms, 72.5MB)
 * 테스트 2 〉	통과 (0.12ms, 75.3MB)
 * 테스트 3 〉	통과 (0.33ms, 67.6MB)
 * 테스트 4 〉	통과 (0.39ms, 78.2MB)
 * 테스트 5 〉	통과 (2.04ms, 76.1MB)
 * 테스트 6 〉	통과 (14.05ms, 81.4MB)
 * 테스트 7 〉	통과 (41.50ms, 90.1MB)
 * 테스트 8 〉	통과 (26.62ms, 81.3MB)
 * 테스트 9 〉	통과 (0.49ms, 76.2MB)
 * 테스트 10 〉	통과 (8.09ms, 85.1MB)
 * 테스트 11 〉	통과 (0.10ms, 77.2MB)
 * 테스트 12 〉	실패 (37.20ms, 93.2MB)
 * 테스트 13 〉	통과 (33.72ms, 88.7MB)
 * 테스트 14 〉	통과 (31.28ms, 99.2MB)
 * 테스트 15 〉	통과 (31.97ms, 88.1MB)
 * 테스트 16 〉	통과 (5.47ms, 73.7MB)
 * 테스트 17 〉	통과 (34.79ms, 73.3MB)
 * 테스트 18 〉	통과 (0.10ms, 75.6MB)
 * 테스트 19 〉	통과 (0.40ms, 79.4MB)
 * 채점 결과
 * 정확성: 94.7
 * 합계: 94.7 / 100.0
 */

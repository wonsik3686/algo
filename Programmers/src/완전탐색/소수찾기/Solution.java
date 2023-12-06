package 완전탐색.소수찾기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 시도 1
 */
public class Solution {

    public static ArrayList<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println(solution("123"));
    }

    public static int solution(String numbers) {
        int answer = 0;
        int[] arr = Stream.of(numbers.split("")).mapToInt(Integer::parseInt).toArray();
        int[] output = new int[numbers.length()];
        boolean[] visited = new boolean[numbers.length()];
        for(int i = 1; i <= numbers.length(); i++)
            perm(arr, output, visited, 0, numbers.length(), i);
        answer = resultList.size();
        return answer;
    }

    /**
     * permutation: 순서를 지키며 n 개 중에서 r 개를 뽑는 경우. 순열. nPr
     * @param arr
     * @param output
     * @param visited
     * @param depth
     * @param n 전체 원소 수
     * @param r 뽑을 원소 수
     */
    public static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if(depth == r) {
            System.out.println(Arrays.toString(output) + " - " + r);
            StringBuilder param = new StringBuilder();
            for(int i = 0; i < depth; i++) {
                param.append(output[i]);
            }
            Integer num = Integer.parseInt(param.toString());
            if(isPrime(num)) {
                if(!resultList.contains(num)) resultList.add(num);
            }
            return;
        }
        for(int i = 0; i < n; i++){
            if(depth == 0 && arr[i] == 0) continue;
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                output[depth] = 0;
                visited[i] = false;
            }
        }
    }

    public static boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i = 2; i < Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}

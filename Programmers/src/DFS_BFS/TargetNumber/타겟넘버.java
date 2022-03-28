package DFS_BFS.TargetNumber;

public class 타겟넘버 {

    static int staticTarget, answer;
    static int[] staticNumbers;

    public static void main(String[] args) {
        solution(new int[] {4, 1, 2, 1}, 2);
        System.out.println(answer);
    }


    public static int solution(int[] numbers, int target) {

        staticNumbers = numbers;
        staticTarget = target;

        dfs(0, 0);

        return answer;
    }

    public static void dfs(int depth, int sum) {

        if(depth == staticNumbers.length) {
            if (sum == staticTarget) answer++;
        } else {
            dfs(depth + 1, sum + staticNumbers[depth]);
            dfs(depth + 1, sum - staticNumbers[depth]);
        }

    }

}

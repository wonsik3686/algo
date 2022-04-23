package D3.농작물;

import java.io.*;

public class Soiution {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("res/0804.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= TC; tc++) {

            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(i) - '0';
                }
            }
            int sum = 0;
            int p = N / 2;
            int rr = -1;
            for (int i = 1; i <= (N/2 + 1); i++) {
                ++rr;
                for (int j = 0; j < (2 * i) - 1; j++) {
                    sum += map[rr][p+j];
                }
                --p;
            }
            p+=2;
            int restt = (N/2) + 2;
            for (int i = (N/2); i > 0; i--) {
                ++rr;
                for (int j = 0; j < (2 * i) - 1; j++ )
                    sum += map[rr][p+j];
                ++p;
            }
            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }
        System.out.println(sb.toString());
    }
}

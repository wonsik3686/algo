package Recur.BOJ_10870_피보나치수5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10870_피보나치수5 {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        System.out.println(recur(N));
    }

    public static int recur(int n) {

        if(n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        }

        return recur(n-1) + recur(n-2);
    }
}

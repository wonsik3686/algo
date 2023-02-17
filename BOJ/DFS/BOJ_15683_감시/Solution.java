package DFS.BOJ_15683_감시;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    static class Element {

        int sort;
        int direction;

    }

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    }



    private int getSharpCount(Integer[][] arr) {

        int count = 0;

        for(Integer[] i: arr) {
           for(Integer j: i) {
               if(j == 7) {
                   count++;
               }
           }
        }

        return count;
    }
}

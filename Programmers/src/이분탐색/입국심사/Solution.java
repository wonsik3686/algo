package 이분탐색.입국심사;

import java.util.Arrays;

public class Solution {

    public static long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);
        long low = times[0];
        long high = times[times.length - 1] * (long)n;
        while( low <= high ) {
            long mid = ( low + high ) / 2;
            long sum = 0;
            for( int time: times ) {
                sum += mid / time;
            }
            if ( sum >= n ) {
                answer = Math.min(answer, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    private static int binarySearch(short[] a, int fromIndex, int toIndex,
                                     short key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            short midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }

    public static void main(String[] args) {
        System.out.println(
                solution(
                    6,
                     new int[] {
                             7, 10
                     }
                )
        );
    }
}

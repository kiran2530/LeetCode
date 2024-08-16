/*
 *  624. Maximum Distance in Arrays
        You are given m arrays, where each array is sorted in ascending order.
        You can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be their absolute difference |a - b|.
        Return the maximum distance.

    Example 1:
        Input: arrays = [[1,2,3],[4,5],[1,2,3]]
        Output: 4
        Explanation: One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
        
        Example 2:
        Input: arrays = [[1],[1]]
        Output: 0
    
    Constraints:
        m == arrays.length
        2 <= m <= 10^5
        1 <= arrays[i].length <= 500
        -104 <= arrays[i][j] <= 10^4
        arrays[i] is sorted in ascending order.
        There will be at most 105 integers in all the arrays.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _16_08_24_leetcode_624 {
    public static int maxDistance(List<List<Integer>> arrays) {
        int distance = 0;
        int low = arrays.get(0).get(0);
        int high = arrays.get(0).get(arrays.get(0).size()-1);
        for (int i = 1; i < arrays.size(); i++) {
            distance = Math.max(distance, Math.abs(arrays.get(i).get(arrays.get(i).size()-1) - low));
            distance = Math.max(distance, Math.abs(high - arrays.get(i).get(0)));
            low = Math.min(low, arrays.get(i).get(0));
            high = Math.max(high, arrays.get(i).get(arrays.get(i).size() - 1));
        }
        return distance;
    }
    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter No of sublist : ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter No of elements in " + (i+1) + " sublist : ");
            int m = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                list.add(sc.nextInt());
            }

            arrays.add(list);
        }

        System.out.println("Max distance : " + maxDistance(arrays));

        sc.close();
    }
}
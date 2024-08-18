/*
 *  264. Ugly Number II
        An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
        Given an integer n, return the nth ugly number.

    Example 1:
        Input: n = 10
        Output: 12
        Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
    
    Example 2:
        Input: n = 1
        Output: 1
        Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
        

    Constraints:
        1 <= n <= 1690
 */

public class _18_08_24_leetcode_264 {
    public static int nthUglyNumber(int n) {
        int[] nums = new int[1690];
        int i2 = 0, i3 = 0, i5 = 0;
        nums[0] = 1;

        for (int i = 1; i < 1690; i++) {
            nums[i] = Math.min(Math.min(2 * nums[i2], 3 * nums[i3]), 5 * nums[i5]);

            if(nums[i] == 2*nums[i2])
                i2++;
            if(nums[i] == 3*nums[i3])
                i3++;
            if(nums[i] == 5*nums[i5])
                i5++;
        }

        return nums[n-1];
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println(nthUglyNumber(n));
    }
}
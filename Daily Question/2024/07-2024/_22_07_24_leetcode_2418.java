import java.util.Arrays;
import java.util.HashMap;

/**
 *  _22-07-24_leetcode-2418
 *  2418. Sort the People
        You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.

        For each index i, names[i] and heights[i] denote the name and height of the ith person.

        Return names sorted in descending order by the people's heights.

    Example 1:
        Input: names = ["Mary","John","Emma"], heights = [180,165,170]
        Output: ["Mary","Emma","John"]
        Explanation: Mary is the tallest, followed by Emma and John.
    
    Example 2:
        Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
        Output: ["Bob","Alice","Bob"]
        Explanation: The first Bob is the tallest, followed by Alice and the second Bob.
    
    Constraints:
        n == names.length == heights.length
        1 <= n <= 103
        1 <= names[i].length <= 20
        1 <= heights[i] <= 105
        names[i] consists of lower and upper case English letters.
        All the values of heights are distinct.
 */
public class _22_07_24_leetcode_2418 {
    public static String[] sortPeople(String[] names, int[] heights) {
        String[] sortNames = new String[names.length];

        HashMap<Integer, String> list = new HashMap<>();

        for(int i =0; i< heights.length; i++) {
            list.put(heights[i], names[i]);
        }

        Arrays.sort(heights);

        int k = 0;
        for(int i =heights.length-1; i>= 0; i--) {
            sortNames[k++] = list.get(heights[i]);
        }

        return sortNames;
    }
    public static void main(String[] args) {
        String[] names = {"Mary","John","Emma"};
        int[] heights = {180,165,170};

        String[] sortNames = sortPeople(names, heights);
        for(int i =0; i< heights.length; i++) {
            System.out.println(sortNames[i]); 
        }
    }
}
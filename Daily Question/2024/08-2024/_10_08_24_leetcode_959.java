/*
 *  959. Regions Cut By Slashes
        An n x n grid is composed of 1 x 1 squares where each 1 x 1 square consists of a '/', '\', or blank space ' '. These characters divide the square into contiguous regions.
        Given the grid grid represented as a string array, return the number of regions.
        Note that backslash characters are escaped, so a '\' is represented as '\\'.

    Example 1:
        Input: grid = [" /","/ "]
        Output: 2
        
    Example 2:
        Input: grid = [" /","  "]
        Output: 1
        
    Example 3:
        Input: grid = ["/\\","\\/"]
        Output: 5
        Explanation: Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.
        
    Constraints : 
        n == grid.length == grid[i].length
        1 <= n <= 30
        grid[i][j] is either '/', '\', or ' '.
 */

public class _10_08_24_leetcode_959 {
    private static int solveDFS(int[][] dp, int i, int j) {
        // edge
        if (Math.min(i, j) < 0 || Math.max(i, j) >= dp.length || dp[i][j] != 0) {
            return 0;
        }

        dp[i][j] = 1;
        return (1 + solveDFS(dp, i, j + 1) + solveDFS(dp, i, j - 1)
                + solveDFS(dp, i + 1, j) + solveDFS(dp, i - 1, j));
    }

    public static int regionsBySlashes(String[] grid) {
        int n = grid.length;

        int[][] dp = new int[n * 3][n * 3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '/') {
                    dp[i * 3][j * 3 + 2] = dp[i * 3 + 1][j * 3 + 1] = dp[i * 3 + 2][j * 3] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    dp[i * 3][j * 3] = dp[i * 3 + 1][j * 3 + 1] = dp[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n * 3; i++) {
            for (int j = 0; j < 3 * n; j++) {
                res += solveDFS(dp, i, j) > 0 ? 1 : 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] grid = {" /","/ "};
        // String[] grid = {"/\\","\\/"};

        System.out.println(regionsBySlashes(grid));
    }
}

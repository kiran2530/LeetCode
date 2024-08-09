/*
 *  840. Magic Squares In Grid
        A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
        Given a row x col grid of integers, how many 3 x 3 contiguous magic square subgrids are there?
        Note: while a magic square can only contain numbers from 1 to 9, grid may contain numbers up to 15.

    Example 1:
        Input: grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]]
        Output: 1
        Explanation: 
        The following subgrid is a 3 x 3 magic square
        In total, there is only one magic square inside the given grid.
    
    Example 2:
        Input: grid = [[8]]
        Output: 0
        
    Constraints:
        row == grid.length
        col == grid[i].length
        1 <= row, col <= 10
        0 <= grid[i][j] <= 15
 */
public class _09_08_24_leetcode_840 {

    public static boolean isMagicSquare(int[][] grid, int i, int j) {
        // Check distinct elements or not
        boolean[] seen = new boolean[10];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                int num = grid[i + x][j + y];
                if (num < 1 || num > 9 || seen[num]) return false;
                seen[num] = true;
            }
        }

        int sum = grid[i][j] + grid[i][j+1] + grid[i][j+2];  // First row sum
        
        // Check rows
        for (int x = 0; x < 3; x++) {
            if (sum != grid[i + x][j] + grid[i + x][j + 1] + grid[i + x][j + 2]) return false;
        }

        // Check columns
        for (int y = 0; y < 3; y++) {
            if (sum != grid[i][j + y] + grid[i + 1][j + y] + grid[i + 2][j + y]) return false;
        }

        // Check diagonals
        if (sum != grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2]) return false;
        if (sum != grid[i+2][j] + grid[i+1][j+1] + grid[i][j+2]) return false;

        return true;
    }

    public static int numMagicSquaresInside(int[][] grid) {
        int rowLength = grid.length, colLength = grid[0].length;
        if(rowLength < 3 || colLength < 3 )
            return 0;
        
        int magicSquares = 0;

        for(int row = 0; row < rowLength-2; row++) {
            for(int col = 0; col < colLength-2; col++) {
                if(isMagicSquare(grid, row, col))
                    magicSquares++;
            }
        }

        return magicSquares;
    }
    public static void main(String[] args) {
        int[][] grid = {{4,3,8,4},{9,5,1,9},{2,7,6,2}};
        System.out.println(numMagicSquaresInside(grid));
    }
}

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        // grid = [[1,3],
        //         [2,2]]

        int n = grid.length;
        // n = 2

        int repeated = -1;
        int missing = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int num = Math.abs(grid[i][j]);
                // i=0,j=0 → num=1
                // i=0,j=1 → num=3
                // i=1,j=0 → num=2
                // i=1,j=1 → grid[1][1]=2 → num=2

                int row = (num - 1) / n;
                int col = (num - 1) % n;
                // num=1 → row=0, col=0
                // num=3 → row=1, col=0
                // num=2 → row=0, col=1
                // num=2 → row=0, col=1

                if (grid[row][col] < 0) {
                    repeated = num;
                    // last 2 → grid[0][1] already negative
                    // repeated = 2

                } else {
                    grid[row][col] *= -1;
                    // 1 → grid[0][0] = -1
                    // 3 → grid[1][0] = -2
                    // 2 → grid[0][1] = -3
                }
            }
        }

        for (int num = 1; num <= n * n; num++) {

            int row = (num - 1) / n;
            int col = (num - 1) % n;

            if (grid[row][col] > 0) {
                missing = num;
                // num=4 → grid[1][1] = 2 positive
                // missing = 4
            }
        }

        return new int[]{repeated, missing};
        // [2,4]
    }
}
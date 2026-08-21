class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;
        int repeated = -1;
        int missing = -1;

        // grid = [[1,3],
        //         [2,2]]

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int num = Math.abs(grid[i][j]);
                // abs zaroori hai
                // kyunki kuch values already negative ho chuki hongi

                int row = (num - 1) / n;
                int col = (num - 1) % n;

                if (grid[row][col] < 0) {
                    repeated = num;
                    // pehle se negative
                    // matlab duplicate

                } else {
                    grid[row][col] *= -1;
                    // first time mila to negative mark
                }
            }
        }

        for (int num = 1; num <= n * n; num++) {

            int row = (num - 1) / n;
            int col = (num - 1) % n;

            if (grid[row][col] > 0) {
                missing = num;
                // jo mark nahi hua wahi missing
            }
        }

        return new int[]{repeated, missing};
    }
}
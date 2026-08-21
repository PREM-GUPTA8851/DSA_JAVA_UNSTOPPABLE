class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;
        // Example:
        // grid = [[1,3],
        //         [2,2]]
        //
        // n = 2
        // numbers hone chahiye = 1 to n*n
        // = 1 to 4

        int[] freq = new int[n * n + 1];
        // freq = [0,0,0,0,0]

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                freq[grid[i][j]]++;
                // grid[0][0] = 1
                // freq[1]++
            }
        }

        int repeated = -1;
        int missing = -1;

        for (int i = 1; i <= n * n; i++) {

            if (freq[i] == 2) {
                repeated = i;
                // 2 baar mila
            }

            if (freq[i] == 0) {
                missing = i;
                // ek baar bhi nahi mila
            }
        }

        return new int[]{repeated, missing};
        // [2, 4]
    }
}
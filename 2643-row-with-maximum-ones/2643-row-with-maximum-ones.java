class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int ans = 0, maxOnes = 0;

        // TC: [[0,1],[1,0]] -> Expected: [0,1]

        for (int row = 0; row < mat.length; row++) {
            int count = 0;

            // Current row ke saare 1 count kar rahe hain
            for (int col = 0; col < mat[row].length; col++) {
                if (mat[row][col] == 1) count++;
            }

            // Strictly greater use kar rahe hain,
            // taaki tie hone par smallest row index hi rahe
            if (count > maxOnes) {
                maxOnes = count;
                ans = row;
            }
        }

        return new int[]{ans, maxOnes};
    }
}
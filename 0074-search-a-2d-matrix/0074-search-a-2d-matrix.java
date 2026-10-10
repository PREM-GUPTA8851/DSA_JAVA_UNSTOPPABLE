
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // TC: matrix = [[1,3,5],[7,9,11]], target = 9
        // Total elements = 2 * 3 = 6, valid indexes = 0 to 5

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1; // left = 0, right = 5

        // Binary search poori matrix ko ek sorted array ki tarah treat karega
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // First iteration: mid = 0 + (5 - 0) / 2 = 2

            int row = mid / cols;
            int col = mid % cols;
            // mid = 2: row = 2 / 3 = 0, col = 2 % 3 = 2
            // matrix[0][2] = 5

            // Target mil gaya toh true return kar denge
            if (matrix[row][col] == target) {
                return true;
            }

            // Current element chhota hai, toh right side search karenge
            else if (matrix[row][col] < target) {
                left = mid + 1;
                // 5 < 9, isliye left = 2 + 1 = 3
            }

            // Current element bada hai, toh left side search karenge
            else {
                right = mid - 1;
            }

            // Second iteration: left = 3, right = 5
            // mid = 4, row = 4 / 3 = 1, col = 4 % 3 = 1
            // matrix[1][1] = 9, target mil gaya, return true
        }

        return false; // Target poori matrix mein nahi mila
    }
}

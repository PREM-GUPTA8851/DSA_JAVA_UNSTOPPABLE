## 01. Search in a Row-Column Sorted

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/search-in-a-matrix17201720/1?utm=codolio)

### Problem Description

**Task:** Given a 2D integer matrix mat[][] of size n x m, where every row and column is sorted in increasing order and a number x, return true if the element x is present in the matrix. Otherwise, return false.Examples:Input: mat[][] = [[3, 30, 38], [20, 52, 54], [35, 60, 69]], x = 62

#### Examples

##### Example 1

- **Output:**
```text
true
```
- **Explanation:** 3 is present in the matrix.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n + m)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (4)

#### Solution 1 (Java)

- **Submitted:** 2026-10-10 21:48:36
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public static boolean matSearch(int matrix[][], int target) {
        // TC: GFG matrix, har row aur column sorted hai
// Input: mat[][] = [[3, 30, 38], [20, 52, 54], [35, 60, 62]], x = 62
        int rows = matrix.length; // 3
        int cols = matrix[0].length; // 3

        int row = 0;
        int col = cols - 1; // Top-right corner se start

        // Jab tak row aur col valid hain
        while (row < rows && col >= 0) {
            // 0 < 3 && col >= 0
            int current = matrix[row][col];
// c = m[0][2] = 38 < 62 --> next row m jao column same rehne do
// c = m[1][2] = 54 < 62 --> next row m jao column same
// c = m[2][2] = 62 < 62 --> // Target mil gaya
            if (current == target) {
                return true;
            }

            // Current target se bada hai, toh left jayenge
            else if (current > target) {
                col--;
            }

            // Current target se chhota hai, toh neeche jayenge
            else {
                row++;
            }
        }

        return false;
    }
}
```

*Generated on: 10/10/2026, 9:48:51 pm*

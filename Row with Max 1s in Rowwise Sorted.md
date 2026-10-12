## 01. Row with Max 1s in Rowwise Sorted

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1?utm=codolio)

### Problem Description

**Task:** Given a 2D binary array arr[][] consisting of only 1s and 0s. Each row of the array is sorted in non-decreasing order. Find and return the index of the first row that contains the maximum number of 1s. If no such row exists, return -1.Note: The array follows 0-based indexing.Examples:Input: arr[][] = [[0,1,1,1], [0,0,1,1], [1,1,1,1]]

#### Examples

##### Example 1

- **Output:**
```text
-1
```
- **Explanation:** No row contains any 1s, so the output is -1.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n + m)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (10)

#### Solution 1 (Java)

- **Submitted:** 2026-10-12 17:01:17
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int rowWithMax1s(int[][] arr) {
        // code here
        // logic is row with increasing order 
        int rows = arr.length;
        int cols = arr[0].length;
        
        int row = 0;
        int col = cols - 1;
        int ans = -1;
        while(row < rows && col >= 0){
            if(arr[row][col] == 1){
                ans = row;
                col--;
            }else{
                row++;
            }
        }
        return ans;
        // check it's current column if one is there 
        // if not we do check in next row if there also not return  current row 
    }
};
```

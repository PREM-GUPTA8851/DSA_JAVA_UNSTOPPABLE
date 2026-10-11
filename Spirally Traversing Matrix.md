## 01. Spirally Traversing Matrix

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1?utm=codolio)

### Problem Description

**Task:** Given a rectangular matrix mat[][] of size n x m, and return a 1D array containing all its elements in spiral order.Examples:Input: mat[][] = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]

#### Examples

##### Example 1

- **Output:**
```text
[32, 44, 27, 23, 62, 50, 28, 54]
```
- **Explanation:** Applying same technique as shown above, output will be [32, 44, 27, 23, 62, 50, 28, 54].Constraints:1 ≤ n, m ≤10000 ≤ mat[i][j] ≤100

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n * m)
- **Expected Auxiliary Space Complexity:** O(n * m)

### Accepted Solutions (10)

#### Solution 1 (Java)

- **Submitted:** 2026-10-11 23:07:23
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
        // code here
        	int starting_column = 0;
		int starting_row = 0;
		int ending_column = mat[0].length -1; // 3
		int ending_row = mat.length -1; //3
		
		int total_elements = mat[0].length * mat.length;
		int count =0;
		
		ArrayList<Integer> ans = new ArrayList<>();
		
		while(count < total_elements){
		// pehle starting column --> ending column
		for(int i = starting_column; i <= ending_column && count < total_elements; i++){
		    ans.add(mat[starting_row][i]);// 1,2,3,4 // 13,14
		    count++;
		}
		starting_row++;//1
		
		// starting row --> ending row
		for(int i = starting_row; i <= ending_row && count < total_elements; i++){
		    ans.add(mat[i][ending_column]);// 5,6,7
		    count++;
		}
		ending_column--;
		// ending column --> starting column
		for(int i = ending_column; i >= starting_column && count < total_elements; i--){
		    ans.add(mat[ending_row][i]); //8,9,10
		    count++;
		}
		ending_row--;
		// ending row --> starting row
		for(int i = ending_row; i >= starting_row && count < total_elements; i--){
		    ans.add(mat[i][starting_column]); // 11,12
		    count++;
		}
		starting_column++;
		}
		return ans;
    }
}
```

*Generated on: 11/10/2026, 11:17:33 pm*

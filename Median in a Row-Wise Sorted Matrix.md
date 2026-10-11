## 01. Median in a Row-Wise Sorted Matrix

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1?utm=codolio)

### Problem Description

**Task:** Given a row-wise sorted matrix mat[][] of size n x m, where the number of rows and columns is always odd. Return the median of the matrix.Examples:Input: mat[][] = [[1, 3, 5], [2, 6, 9], [3, 6, 9]]

#### Examples

##### Example 1

- **Output:**
```text
5
```
- **Explanation:** Sorting matrix elements gives us [1, 2, 3, 3, 5, 6, 6, 9, 9]. Hence, 5 is median.

##### Example 2

- **Input:**
```text
mat[][] = [[2, 4, 9], [3, 6, 7], [4, 7, 10]]
```
- **Output:**
```text
4
```
- **Explanation:** Sorting matrix elements gives us [3, 4, 8]. Hence, 4 is median.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n log m * log(maxVal – minVal))
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (10)

#### Solution 1 (Java)

- **Submitted:** 2026-10-11 23:59:08
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int median(int[][] mat) {
    	/*
		Input: mat[][] = [[1, 3, 5], [2, 6, 9], [3, 6, 9]]
		Output: 5
		Explanation: Sorting matrix elements gives us [1, 2, 3, 3, 5, 6, 6, 9, 9]. Hence, 5 is median.
		*/
		// apne ko find krna h aesa element jis element k peeche 4 element aur ho
		// sbse pehle total req elements nikal le jisme 
		//hr baar aapn ko uske half elements chahiye honge
		int req = (mat.length * mat[0].length)/ 2;
		
		// median k pehle req elements hone chahiye 
		int min_ = Integer.MAX_VALUE;
		int max_ = Integer.MIN_VALUE;
		
		for(int[] row: mat){
		    min_ = Math.min(min_, row[0]);
		    max_ = Math.max(max_, row[mat[0].length - 1]);
		}
		
		// we have search space pattern as well
		int start = min_;
		int end = max_;
		while(start < end){
		    int mid = start + (end - start) / 2;
		    
		    int count = 0;
		    for(int[] row: mat){
		        count += Up(row, mid);
		    }
		    
		    if(count <= req){
		        start = mid + 1;
		    }
		    else {
		        end = mid;
		    }
		    
		}
		return start;
		
	}
	// us particular row m kitne elements h jo ki mid se chote aur equal h hume vo count krne h 
	public int Up(int[] row, int target){
	    int low = 0;
	    int high = row.length;// 3
	    while(low < high){
	        int mid_ = low + (high - low)/ 2;
	        if(row[mid_] <= target){
	            low = mid_ + 1;
	        }
	        else {
	            high = mid_;
	        }
	    }
	    return low;
	}
}
```

*Generated on: 12/10/2026, 12:01:59 am*

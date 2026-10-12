## 01. Kth Smallest in Matrix

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/kth-element-in-matrix/1?utm=codolio)

### Problem Description

**Task:** Given a matrix mat[][] of size n*n, where each row and column is sorted in non-decreasing order. Find the kth smallest element in the matrix.Examples:Input: mat[][] = [[16, 28, 60, 64], k = 3 [22, 41, 63, 91], [27, 50, 87, 93], [36, 78, 87, 94]]

#### Examples

##### Example 1

- **Output:**
```text
30
```
- **Explanation:** 30 is the 7^th smallest element.Constraints:1 ≤ n ≤ 5001 ≤ mat[i][j] ≤ 10⁴¹ ≤ k ≤ n*n

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n × log(max(mat) - min(mat)))
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (5)

#### Solution 1 (Java)

- **Submitted:** 2026-10-12 21:14:58
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int kthSmallest(int[][] mat, int k) {
       
    int req = k - 1;

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

#### Solution 2 (Java)

- **Submitted:** 2026-10-12 21:14:35
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int kthSmallest(int[][] mat, int k) {
       
    int req = k - 1;

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

#### Solution 3 (Java)

- **Submitted:** 2026-06-27 19:20:01
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // code here
int n = matrix.length;
        int m = matrix[0].length;

        // Smallest value
        int low = matrix[0][0];

        // Largest value
        int high = matrix[n - 1][m - 1];

        while (low < high) {

            int mid = low + (high - low) / 2;

            int count = 0;

            // Count elements <= mid
            for (int[] row : matrix) {
                count += upperBound(row, mid);
            }

            if (count < k) {
                // kth smallest right side me hoga
                low = mid + 1;
            } else {
                // answer left side ya mid ho sakta hai
                high = mid;
            }
        }

        return low;
    }

    // Returns count of elements <= x
    private int upperBound(int[] arr, int x) {

        int l = 0;
        int h = arr.length;

        while (l < h) {

            int mid = l + (h - l) / 2;

            if (arr[mid] <= x)
                l = mid + 1;
            else
                h = mid;
        }

        return l;
    }
}
```

#### Solution 4 (Java)

- **Submitted:** 2026-06-27 19:19:54
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // code here
int n = matrix.length;
        int m = matrix[0].length;

        // Smallest value
        int low = matrix[0][0];

        // Largest value
        int high = matrix[n - 1][m - 1];

        while (low < high) {

            int mid = low + (high - low) / 2;

            int count = 0;

            // Count elements <= mid
            for (int[] row : matrix) {
                count += upperBound(row, mid);
            }

            if (count < k) {
                // kth smallest right side me hoga
                low = mid + 1;
            } else {
                // answer left side ya mid ho sakta hai
                high = mid;
            }
        }

        return low;
    }

    // Returns count of elements <= x
    private int upperBound(int[] arr, int x) {

        int l = 0;
        int h = arr.length;

        while (l < h) {

            int mid = l + (h - l) / 2;

            if (arr[mid] <= x)
                l = mid + 1;
            else
                h = mid;
        }

        return l;
    }
}
```

#### Solution 5 (Java)

- **Submitted:** 2026-06-27 19:19:45
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // code here
int n = matrix.length;
        int m = matrix[0].length;

        // Smallest value
        int low = matrix[0][0];

        // Largest value
        int high = matrix[n - 1][m - 1];

        while (low < high) {

            int mid = low + (high - low) / 2;

            int count = 0;

            // Count elements <= mid
            for (int[] row : matrix) {
                count += upperBound(row, mid);
            }

            if (count < k) {
                // kth smallest right side me hoga
                low = mid + 1;
            } else {
                // answer left side ya mid ho sakta hai
                high = mid;
            }
        }

        return low;
    }

    // Returns count of elements <= x
    private int upperBound(int[] arr, int x) {

        int l = 0;
        int h = arr.length;

        while (l < h) {

            int mid = l + (h - l) / 2;

            if (arr[mid] <= x)
                l = mid + 1;
            else
                h = mid;
        }

        return l;
    }
}
```

*Generated on: 12/10/2026, 9:21:46 pm*
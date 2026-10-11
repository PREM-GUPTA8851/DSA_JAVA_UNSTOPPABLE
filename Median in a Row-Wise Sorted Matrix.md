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

#### Solution 2 (Java)

- **Submitted:** 2026-06-27 22:03:15
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int median(int[][] mat) {
        // median find krne k logic 
        // median se pehle element total element k half hone chahiye
        // to total elements
        int row_size = mat.length ;
        int col_size = mat[0].length;
        
        int total_elements = row_size * col_size;
        int req = total_elements/2;
        int min_value = Integer.MAX_VALUE;
        int max_value = Integer.MIN_VALUE;
        
        for(int[] row: mat){
            min_value = Math.min(min_value, row[0]);
            max_value = Math.max(max_value, row[col_size - 1]);
        }
        
        int start = min_value;
        int end = max_value;
        while(start < end){
            int mid = start + (end - start) / 2; // 5
            int count = 0;
            // ab hr row m 5 se chota element count krenge 
            for(int[] row: mat){
                count += upper_bound(row, mid);
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
    
    int upper_bound(int[] row, int m){
            int low = 0; 
            int high = row.length;
            while(low < high){
                int mid = (low + high)/2;
                if(row[mid] <= m){
                    low = mid + 1;
                }else {
                    high = mid;
                }
            }
            return low;
        }
}
```

#### Solution 3 (Java)

- **Submitted:** 2026-06-27 22:03:09
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int median(int[][] mat) {
        // median find krne k logic 
        // median se pehle element total element k half hone chahiye
        // to total elements
        int row_size = mat.length ;
        int col_size = mat[0].length;
        
        int total_elements = row_size * col_size;
        int req = total_elements/2;
        int min_value = Integer.MAX_VALUE;
        int max_value = Integer.MIN_VALUE;
        
        for(int[] row: mat){
            min_value = Math.min(min_value, row[0]);
            max_value = Math.max(max_value, row[col_size - 1]);
        }
        
        int start = min_value;
        int end = max_value;
        while(start < end){
            int mid = start + (end - start) / 2; // 5
            int count = 0;
            // ab hr row m 5 se chota element count krenge 
            for(int[] row: mat){
                count += upper_bound(row, mid);
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
    
    int upper_bound(int[] row, int m){
            int low = 0; 
            int high = row.length;
            while(low < high){
                int mid = (low + high)/2;
                if(row[mid] <= m){
                    low = mid + 1;
                }else {
                    high = mid;
                }
            }
            return low;
        }
}
```

#### Solution 4 (Java)

- **Submitted:** 2026-06-27 22:03:02
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int median(int[][] mat) {
        // median find krne k logic 
        // median se pehle element total element k half hone chahiye
        // to total elements
        int row_size = mat.length ;
        int col_size = mat[0].length;
        
        int total_elements = row_size * col_size;
        int req = total_elements/2;
        int min_value = Integer.MAX_VALUE;
        int max_value = Integer.MIN_VALUE;
        
        for(int[] row: mat){
            min_value = Math.min(min_value, row[0]);
            max_value = Math.max(max_value, row[col_size - 1]);
        }
        
        int start = min_value;
        int end = max_value;
        while(start < end){
            int mid = start + (end - start) / 2; // 5
            int count = 0;
            // ab hr row m 5 se chota element count krenge 
            for(int[] row: mat){
                count += upper_bound(row, mid);
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
    
    int upper_bound(int[] row, int m){
            int low = 0; 
            int high = row.length;
            while(low < high){
                int mid = (low + high)/2;
                if(row[mid] <= m){
                    low = mid + 1;
                }else {
                    high = mid;
                }
            }
            return low;
        }
}
```

#### Solution 5 (Java)

- **Submitted:** 2026-06-27 22:02:56
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int median(int[][] mat) {
        // median find krne k logic 
        // median se pehle element total element k half hone chahiye
        // to total elements
        int row_size = mat.length ;
        int col_size = mat[0].length;
        
        int total_elements = row_size * col_size;
        int req = total_elements/2;
        int min_value = Integer.MAX_VALUE;
        int max_value = Integer.MIN_VALUE;
        
        for(int[] row: mat){
            min_value = Math.min(min_value, row[0]);
            max_value = Math.max(max_value, row[col_size - 1]);
        }
        
        int start = min_value;
        int end = max_value;
        while(start < end){
            int mid = start + (end - start) / 2; // 5
            int count = 0;
            // ab hr row m 5 se chota element count krenge 
            for(int[] row: mat){
                count += upper_bound(row, mid);
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
    
    int upper_bound(int[] row, int m){
            int low = 0; 
            int high = row.length;
            while(low < high){
                int mid = (low + high)/2;
                if(row[mid] <= m){
                    low = mid + 1;
                }else {
                    high = mid;
                }
            }
            return low;
        }
}
```

#### Solution 6 (Java)

- **Submitted:** 2026-06-27 00:36:25
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int median(int[][] mat) {

        int n = mat.length; // 3
        int m = mat[0].length; // 3
        int low = Integer.MAX_VALUE; //10
        int high = Integer.MIN_VALUE; // 0

        for (int[] row : mat) {
            low = Math.min(low, row[0]); // 1 
            high = Math.max(high, row[m - 1]); //9
        }

        int req = (n * m) / 2; // 9/2=4

        while (low < high) {
            int mid = low + (high - low) / 2;
            // mid =  1 + (8/2) = 5
            int count = 0;
            for (int[] row : mat)
                count += upperBound(row, mid);
                // count = 0 + ub(r, 5)

            if (count <= req)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    int upperBound(int[] arr, int x) {
        int l = 0, h = arr.length; // 3
        while (l < h) {
            int mid = (l + h) / 2; // 1
            if (arr[mid] <= x) l = mid + 1;
            else h = mid;
        }
        return l;
    }
}
```

#### Solution 7 (Java)

- **Submitted:** 2026-06-27 00:35:44
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int median(int[][] mat) {

        int n = mat.length; // 3
        int m = mat[0].length; // 3
        int low = Integer.MAX_VALUE; //10
        int high = Integer.MIN_VALUE; // 0

        for (int[] row : mat) {
            low = Math.min(low, row[0]); // 1 
            high = Math.max(high, row[m - 1]); //9
        }

        int req = (n * m) / 2; // 9/2=4

        while (low < high) {
            int mid = low + (high - low) / 2;
            // mid =  1 + (8/2) = 5
            int count = 0;
            for (int[] row : mat)
                count += upperBound(row, mid);
                // count = 0 + ub(r, 5)

            if (count <= req)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    int upperBound(int[] arr, int x) {
        int l = 0, h = arr.length; // 3
        while (l < h) {
            int mid = (l + h) / 2; // 1
            if (arr[mid] <= x) l = mid + 1;
            else h = mid;
        }
        return l;
    }
}
```

#### Solution 8 (Java)

- **Submitted:** 2026-06-27 00:32:24
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int median(int[][] mat) {

        int n = mat.length; // 3
        int m = mat[0].length; // 3
        int low = Integer.MAX_VALUE; //10
        int high = Integer.MIN_VALUE; // 0

        for (int[] row : mat) {
            low = Math.min(low, row[0]); // 1 
            high = Math.max(high, row[m - 1]); //9
        }

        int req = (n * m) / 2; // 9/2=4

        while (low < high) {
            int mid = low + (high - low) / 2;
            // mid =  1 + (8/2) = 5
            int count = 0;
            for (int[] row : mat)
                count += upperBound(row, mid);
                // count = 0 + ub(r, 5)

            if (count <= req)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    int upperBound(int[] arr, int x) {
        int l = 0, h = arr.length; // 3
        while (l < h) {
            int mid = (l + h) / 2; // 1
            if (arr[mid] <= x) l = mid + 1;
            else h = mid;
        }
        return l;
    }
}
```

#### Solution 9 (Java)

- **Submitted:** 2026-06-27 00:22:30
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int median(int[][] mat) {

        int n = mat.length; // 3
        int m = mat[0].length; // 3
        int low = Integer.MAX_VALUE; //10
        int high = Integer.MIN_VALUE; // 0

        for (int[] row : mat) {
            low = Math.min(low, row[0]); // 1 
            high = Math.max(high, row[m - 1]); //9
        }

        int req = (n * m) / 2; // 9/2=4

        while (low < high) {
            int mid = low + (high - low) / 2;
            // mid =  1 + (8/2) = 5
            int count = 0;
            for (int[] row : mat)
                count += upperBound(row, mid);
                // count = 0 + ub(r, 5)

            if (count <= req)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    int upperBound(int[] arr, int x) {
        int l = 0, h = arr.length; // 3
        while (l < h) {
            int mid = (l + h) / 2; // 1
            if (arr[mid] <= x) l = mid + 1;
            else h = mid;
        }
        return l;
    }
}
```

#### Solution 10 (Java)

- **Submitted:** 2026-06-26 15:29:34
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int median(int[][] mat) {

        int n = mat.length; // 3
        int m = mat[0].length; // 3
        int low = Integer.MAX_VALUE; //10
        int high = Integer.MIN_VALUE; // 0

        for (int[] row : mat) {
            low = Math.min(low, row[0]); // 1 
            high = Math.max(high, row[m - 1]); //9
        }

        int req = (n * m) / 2; // 9/2=4

        while (low < high) {
            int mid = low + (high - low) / 2;
            // mid =  1 + (8/2) = 5
            int count = 0;
            for (int[] row : mat)
                count += upperBound(row, mid);
                // count = 0 + ub(r, 5)

            if (count <= req)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    int upperBound(int[] arr, int x) {
        int l = 0, h = arr.length; // 3
        while (l < h) {
            int mid = (l + h) / 2; // 1
            if (arr[mid] <= x) l = mid + 1;
            else h = mid;
        }
        return l;
    }
}
```

*Generated on: 12/10/2026, 12:01:59 am*
## 01. Zero Sum Subarray

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1?utm=codolio)

### Problem Description

**Task:** Given an array of integers, arr[]. Find if there is a subarray (of size at least one) with 0 sum. Return true/false depending upon whether there is a subarray present with 0-sum or not. Examples:Input: arr[] = [4, 2, -3, 1, 6]

#### Examples

##### Example 1

- **Output:**
```text
false
```
- **Explanation:** 0 is one of the elements in the array so there exist a subarray with sum 0.Input: arr = [1, 2, -1]

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(n)

### Accepted Solutions (11)

#### Solution 1 (Java)

- **Submitted:** 2026-10-08 22:43:23
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public boolean subArrayExists(int arr[]) {

        HashSet<Integer> set = new HashSet<>();

        int sum = 0;

        // TC: [4, 2, -3, 1, 6]
        for (int num : arr) {

            sum += num;

            // sum 0 hai -> starting se subarray ka sum 0
            if (sum == 0)
                return true;

            // same prefix sum dobara mila
            // beech ka subarray sum 0 hoga
            if (set.contains(sum))
                return true;

            set.add(sum);
        }

        return false;
    }
}
```


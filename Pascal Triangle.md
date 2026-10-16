## 01. Pascal Triangle

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/pascal-triangle0652/1)

### Problem Description

**Task:** Given a positive integer n, return the n^th row of pascal's triangle.Pascal's triangle is a triangular array of the binomial coefficients formed by summing up the elements of previous row.

#### Examples

##### Example 1

- **Input:**
```text
n = 4
```
- **Output:**
```text
[1, 3, 3, 1]
```
- **Explanation:** 4^th row of pascal's triangle is [1, 3, 3, 1].

##### Example 2

- **Input:**
```text
n = 5
```
- **Output:**
```text
[1, 4, 6, 4, 1]
```
- **Explanation:** 5^th row of pascal's triangle is [1, 4, 6, 4, 1].

##### Example 3

- **Input:**
```text
n = 1
```
- **Output:**
```text
[1]
```
- **Explanation:** 1^st row of pascal's triangle is [1].

#### Constraints

- **1.** `1 ≤ n ≤ 30`

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(n)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-10-16 23:32:01
- **Status:** Correct
- **Marks:** 4

```java
class Solution {
    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        long c = 1;
        // formula for next BC(n, r+1) = BC(n, r) * (n - r)/(r + 1)
        for(int r = 0; r <= n - 1; r++){
            ans.add((int)c);
            c = c *  (n - r - 1)/(r + 1);
        }
        return ans;
    }
}
```

*Generated on: 16/10/2026, 11:32:16 pm*
## 01. nCr

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/ncr1019/1?utm_source=chatgpt.com)

### Problem Description

**Task:** Given two integers n and r, find the value of the binomial coefficient nCrA binomial coefficient nCr can be defined as the coefficient of x^r in the expansion of (1 + x)^n that gives the number of ways to choose r objects from a set of n objects without considering the order.The binomial coefficient nCr is calculated as : C(n,r) = n! / r! * (n-r) !Note: If r is greater than n, return 0. It is guaranteed that the value of ^nC_r will fit within a 32-bit integer.Examples:Input: n = 5, r = 2

#### Examples

##### Example 1

- **Output:**
```text
0 Explaination: Since r is greater than n, thus 2C4 = 0Input: n = 5, r = 0Output: 1 Explaination: The value of ^5C_0 is calculated as 5! / ((5−0)! * 0!) = 5! / (5! * 0!) = 1.
```

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(min(r, n-r))
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (3)

#### Solution 1 (Java)

- **Submitted:** 2026-10-17 17:18:08
- **Status:** Correct
- **Marks:** 0

```java
public class Solution {
    public int nCr(int n, int r) {
        if (r > n) return 0;

        r = Math.min(r, n - r); // r = min(2, 5-2) = 2

        int[] dp = new int[r + 1]; // dp = [0, 0, 0]
        dp[0] = 1;                 // dp = [1, 0, 0]

        for (int i = 1; i <= n; i++) {

            // i = 1: j = min(1,2) = 1
            // j = 1: dp[1] = dp[1] + dp[0] = 0 + 1 = 1
            // dp = [1, 1, 0]

            // i = 2: j = min(2,2) = 2 se 1 tak backward
            // j = 2: dp[2] = dp[2] + dp[1] = 0 + 1 = 1
            // dp = [1, 1, 1]
            // j = 1: dp[1] = dp[1] + dp[0] = 1 + 1 = 2
            // dp = [1, 2, 1]

            // i = 3: j = 2 se 1 tak backward
            // j = 2: dp[2] = 1 + 2 = 3
            // dp = [1, 2, 3]
            // j = 1: dp[1] = 2 + 1 = 3
            // dp = [1, 3, 3]

            // i = 4: j = 2 se 1 tak backward
            // j = 2: dp[2] = 3 + 3 = 6
            // dp = [1, 3, 6]
            // j = 1: dp[1] = 3 + 1 = 4
            // dp = [1, 4, 6]

            // i = 5: j = 2 se 1 tak backward
            // j = 2: dp[2] = 6 + 4 = 10
            // dp = [1, 4, 10]
            // j = 1: dp[1] = 4 + 1 = 5
            // dp = [1, 5, 10]

            for (int j = Math.min(i, r); j >= 1; j--) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[r]; // dp[2] = 10
    }
}
```

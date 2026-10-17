## 01. Matrix Chain Multiplication

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1?utm_source=chatgpt.com)

### Problem Description

**Task:** Given an array arr[] which represents the dimensions of a sequence of matrices where the i^th matrix has the dimensions (arr[i-1] x arr[i]) for i >= 1, find the most efficient way to multiply these matrices together. The efficient way is the one that involves the least number of multiplications.Examples:Input: arr[] = [2, 1, 3, 4]

#### Examples

##### Example 1

- **Output:**
```text
0Explanation: As there is only one matrix so, there is no cost of multiplication.
```
- **Explanation:** There are 4 matrices of dimensions 1 × 2, 2 × 3, 3 × 4, 4 × 3. Let this 4 input matrices be M1, M2, M3 and M4. The minimum number of multiplications are obtained by ((M1 x M2) x M3) x M4). The minimum number is (1 x 2 x 3) + (1 x 3 x 4) + (1 x 4 x 3) = 30.Input: arr[] = [3, 4]

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n^3)
- **Expected Auxiliary Space Complexity:** O(n^2)

### Accepted Solutions (3)

#### Solution 1 (Java)

- **Submitted:** 2026-10-17 23:16:33
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
	static int matrixMultiplication(int p[]) {
          int n = p.length - 1;
          // p = {10,30,5,60}, n = 4-1 = 3 matrices

          int[][] dp = new int[n + 1][n + 1];
          // dp[4][4] banega; initially sab values 0
          // dp[i][j] = Ai se Aj tak multiply karne ki minimum cost

          // len=1: single matrix ki multiplication cost 0 hoti hai
          // Isliye dp[i][i] = 0 already hai

          for (int len = 2; len <= n; len++) {
              // len=2: pehle 2 matrices, phir len=3: teeno matrices

              for (int i = 1; i <= n - len + 1; i++) {
                  int j = i + len - 1;
                  // len=2, i=1 -> j=2 (A1,A2)
                  // len=2, i=2 -> j=3 (A2,A3)
                  // len=3, i=1 -> j=3 (A1,A2,A3)

                  dp[i][j] = Integer.MAX_VALUE;
                  // Abhi minimum cost infinity maani

                  for (int k = i; k < j; k++) {
                      // k batata hai chain ko kahan split karna hai

                      int cost = dp[i][k] + dp[k + 1][j]
                               + p[i - 1] * p[k] * p[j];

                      // len=2, i=1, j=2, k=1:
                      // dp[1][1] + dp[2][2] + p[0]*p[1]*p[2]
                      // = 0 + 0 + 10*30*5 = 1500
                      // dp[1][2] = min(INFINITY,1500) = 1500

                      // len=2, i=2, j=3, k=2:
                      // dp[2][2] + dp[3][3] + p[1]*p[2]*p[3]
                      // = 0 + 0 + 30*5*60 = 9000
                      // dp[2][3] = 9000

                      // len=3, i=1, j=3:
                      // Split k=1: (A1) + (A2*A3)
                      // = dp[1][1] + dp[2][3] + 10*30*60
                      // = 0 + 9000 + 18000 = 27000

                      // Split k=2: (A1*A2) + (A3)
                      // = dp[1][2] + dp[3][3] + 10*5*60
                      // = 1500 + 0 + 3000 = 4500

                      dp[i][j] = Math.min(dp[i][j], cost);
                      // dp[1][3] = min(27000,4500) = 4500
                  }
              }
          }

          return dp[1][n];
          // return dp[1][3] = 4500
      }
  }
```

#### Solution 2 (Java)

- **Submitted:** 2026-10-17 23:08:31
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;

        // dp[i][j] = matrices i se j tak multiply karne ki minimum cost
        int[][] dp = new int[n][n];

        // len = chain mein kitni matrices consider kar rahe hain
        for (int len = 2; len < n; len++) {

            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;

                dp[i][j] = Integer.MAX_VALUE;

                // Har possible partition point try karo
                for (int k = i; k < j; k++) {

                    int cost = dp[i][k]
                             + dp[k + 1][j]
                             + arr[i - 1] * arr[k] * arr[j];

                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[1][n - 1];
    }
}
```

#### Solution 3 (Java)

- **Submitted:** 2026-10-17 23:08:12
- **Status:** Correct
- **Marks:** 8

```java
class Solution {
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;

        // dp[i][j] = matrices i se j tak multiply karne ki minimum cost
        int[][] dp = new int[n][n];

        // len = chain mein kitni matrices consider kar rahe hain
        for (int len = 2; len < n; len++) {

            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;

                dp[i][j] = Integer.MAX_VALUE;

                // Har possible partition point try karo
                for (int k = i; k < j; k++) {

                    int cost = dp[i][k]
                             + dp[k + 1][j]
                             + arr[i - 1] * arr[k] * arr[j];

                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[1][n - 1];
    }
}
```

*Generated on: 17/10/2026, 11:17:35 pm*
## 01. Balanced Splits of a Binary String

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/split-the-binary-string-into-substrings-with-equal-number-of-0s-and-1s/1?utm=codolio)

### Problem Description

**Task:** Given binary string s . find the maximum number of substrings it can be splitted into such that all substrings have equal number of 0s and 1s. If it is not possible to split s satisfying the conditions then return -1.Examples:Input: s = "0100110101"

#### Examples

##### Example 1

- **Output:**
```text
4 The required substrings are 01, 0011, 01 and 01.
```

##### Example 2

- **Input:**
```text
s = "0111100010"
```
- **Output:**
```text
-1
```

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (10)

#### Solution 1 (Java)

- **Submitted:** 2026-11-03 23:23:53
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public static int maxSubStr(String s) {
        // ek variable lenge jisme aapn 0 aaega to increase krene 
        // aur 1 aae to decrease krenge 
        int balance = 0;
        // jb 0 aur 1 ko freq barabar ho jae tb count ko increase krenge 
        int count = 0;
        
        
              for (int i = 0; i < s.length(); i++) {

                  char ch = s.charAt(i);

                  if (ch == '0') {
                      balance++;  // 0 mila toh +1
                  } else {
                      balance--;  // 1 mila toh -1
                  }

                  if (balance == 0) {
                      count++;    // Ek balanced string complete
                  }
              }
// agar balance ki value at last 0 n hui to fhr means
//koi invalid number extra add on h to fhr aapn -1 return krenge 
              return balance != 0 ? -1 : count; //  4
    }
}
```

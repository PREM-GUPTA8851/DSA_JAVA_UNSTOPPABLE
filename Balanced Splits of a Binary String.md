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

#### Solution 2 (Java)

- **Submitted:** 2026-11-03 23:18:25
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public static int maxSubStr(String s) {
        int balance = 0;
        int count = 0;

              // Example: s = "RLRRLLRLRL"
              //
              // R  L  R  R  L  L  R  L  R  L
              // +1 -1 +1 +1 -1 -1 +1 -1 +1 -1
              //
              // balance: 1  0  1  2  1  0  1  0  1  0
              // count:   0  1  1  1  1  2  2  3  3  4
              //
              // Jab balance == 0 hota hai, ek balanced
              // substring mil jaati hai aur count increase hota hai.

              for (int i = 0; i < s.length(); i++) {

                  char ch = s.charAt(i);

                  if (ch == '0') {
                      balance++;  // R mila toh +1
                  } else {
                      balance--;  // L mila toh -1
                  }

                  if (balance == 0) {
                      count++;    // Ek balanced string complete
                  }
              }

              return balance != 0 ? -1 : count; //  4
    }
}
```

#### Solution 3 (Java)

- **Submitted:** 2026-11-03 23:18:15
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public static int maxSubStr(String s) {
        int balance = 0;
        int count = 0;

              // Example: s = "RLRRLLRLRL"
              //
              // R  L  R  R  L  L  R  L  R  L
              // +1 -1 +1 +1 -1 -1 +1 -1 +1 -1
              //
              // balance: 1  0  1  2  1  0  1  0  1  0
              // count:   0  1  1  1  1  2  2  3  3  4
              //
              // Jab balance == 0 hota hai, ek balanced
              // substring mil jaati hai aur count increase hota hai.

              for (int i = 0; i < s.length(); i++) {

                  char ch = s.charAt(i);

                  if (ch == '0') {
                      balance++;  // R mila toh +1
                  } else {
                      balance--;  // L mila toh -1
                  }

                  if (balance == 0) {
                      count++;    // Ek balanced string complete
                  }
              }

              return balance != 0 ? -1 : count; //  4
    }
}
```

#### Solution 4 (Java)

- **Submitted:** 2026-07-31 00:23:46
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public static int maxSubStr(String s) {
        if(s.length() % 2 != 0) return -1;
        // odd length hogi to not possible 
        
        int count = 0;
        int z = 0, o = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0') z++;
            else o++;
        } 
        
        // firstly check if possible 
        if(z == o) {
            for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0') z++;
            else o++;
            if(z == o) count++;
        }
        return count;
        }
        
        return -1;
    }
}
```

#### Solution 5 (Java)

- **Submitted:** 2026-07-31 00:21:12
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public static int maxSubStr(String s) {
        if(s.length() % 2 != 0) return -1;
        // odd length hogi to not possible 
        
        int count = 0;
        int z = 0, o = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0') z++;
            else o++;
        } 
        
        // firstly check if possible 
        if(z == o) {
            for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0') z++;
            else o++;
            if(z == o) count++;
        }
        return count;
        }
        
        return -1;
    }
}
```

#### Solution 6 (Java)

- **Submitted:** 2026-07-23 18:19:14
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public static int maxSubStr(String s) {

        // Dry Run :--
        // Input : s = "0100110101"

        int zero = 0;
        int one = 0;
        int count = 0;

        // i = 0
        // s.charAt(0) = '0'
        // zero = 1
        // one = 0
        // zero != one

        // i = 1
        // s.charAt(1) = '1'
        // zero = 1
        // one = 1
        // zero == one 
        // count = 1
        // zero = 0
        // one = 0

        // ------------------------------

        // i = 2
        // s.charAt(2) = '0'
        // zero = 1

        // i = 3
        // s.charAt(3) = '0'
        // zero = 2

        // i = 4
        // s.charAt(4) = '1'
        // one = 1

        // i = 5
        // s.charAt(5) = '1'
        // one = 2
        // zero == one 
        // count = 2
        // zero = 0
        // one = 0

        // ------------------------------

        // i = 6
        // s.charAt(6) = '0'
        // zero = 1

        // i = 7
        // s.charAt(7) = '1'
        // one = 1
        // zero == one 
        // count = 3
        // zero = 0
        // one = 0
        
        // i = 8
        // s.charAt(8) = '0'
        // zero = 1

        // i = 9
        // s.charAt(9) = '1'
        // one = 1
        // zero == one 
        // count = 4
        // zero = 0
        // one = 0

        // Loop End

        // zero == one
        // return count = 4

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '0')
                zero++;
            else
                one++;

            if (zero == one) {
                count++;
                // zero = 0;
                // one = 0;
            }
        }

        if (zero != one)
            return -1;

        return count;
    }
}
```

#### Solution 7 (Java)

- **Submitted:** 2026-07-23 18:12:01
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public static int maxSubStr(String s) {

        // Dry Run :--
        // Input : s = "0100110101"

        int zero = 0;
        int one = 0;
        int count = 0;

        // i = 0
        // s.charAt(0) = '0'
        // zero = 1
        // one = 0
        // zero != one

        // i = 1
        // s.charAt(1) = '1'
        // zero = 1
        // one = 1
        // zero == one 
        // count = 1
        // zero = 0
        // one = 0

        // ------------------------------

        // i = 2
        // s.charAt(2) = '0'
        // zero = 1

        // i = 3
        // s.charAt(3) = '0'
        // zero = 2

        // i = 4
        // s.charAt(4) = '1'
        // one = 1

        // i = 5
        // s.charAt(5) = '1'
        // one = 2
        // zero == one 
        // count = 2
        // zero = 0
        // one = 0

        // ------------------------------

        // i = 6
        // s.charAt(6) = '0'
        // zero = 1

        // i = 7
        // s.charAt(7) = '1'
        // one = 1
        // zero == one 
        // count = 3
        // zero = 0
        // one = 0
        
        // i = 8
        // s.charAt(8) = '0'
        // zero = 1

        // i = 9
        // s.charAt(9) = '1'
        // one = 1
        // zero == one 
        // count = 4
        // zero = 0
        // one = 0

        // Loop End

        // zero == one
        // return count = 4

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '0')
                zero++;
            else
                one++;

            if (zero == one) {
                count++;
                // zero = 0;
                // one = 0;
            }
        }

        if (zero != one)
            return -1;

        return count;
    }
}
```

#### Solution 8 (Java)

- **Submitted:** 2026-07-23 18:08:29
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public static int maxSubStr(String s) {

        // Dry Run :--
        // Input : s = "0100110101"

        int zero = 0;
        int one = 0;
        int count = 0;

        // i = 0
        // s.charAt(0) = '0'
        // zero = 1
        // one = 0
        // zero != one

        // i = 1
        // s.charAt(1) = '1'
        // zero = 1
        // one = 1
        // zero == one 
        // count = 1
        // zero = 0
        // one = 0

        // ------------------------------

        // i = 2
        // s.charAt(2) = '0'
        // zero = 1

        // i = 3
        // s.charAt(3) = '0'
        // zero = 2

        // i = 4
        // s.charAt(4) = '1'
        // one = 1

        // i = 5
        // s.charAt(5) = '1'
        // one = 2
        // zero == one 
        // count = 2
        // zero = 0
        // one = 0

        // ------------------------------

        // i = 6
        // s.charAt(6) = '0'
        // zero = 1

        // i = 7
        // s.charAt(7) = '1'
        // one = 1
        // zero == one 
        // count = 3
        // zero = 0
        // one = 0
        
        // i = 8
        // s.charAt(8) = '0'
        // zero = 1

        // i = 9
        // s.charAt(9) = '1'
        // one = 1
        // zero == one 
        // count = 4
        // zero = 0
        // one = 0

        // Loop End

        // zero == one
        // return count = 4

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '0')
                zero++;
            else
                one++;

            if (zero == one) {
                count++;
                // zero = 0;
                // one = 0;
            }
        }

        if (zero != one)
            return -1;

        return count;
    }
}
```

#### Solution 9 (Java)

- **Submitted:** 2026-07-23 18:06:31
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public static int maxSubStr(String s) {

        // Dry Run :--
        // Input : s = "0100110101"

        int zero = 0;
        int one = 0;
        int count = 0;

        // i = 0
        // s.charAt(0) = '0'
        // zero = 1
        // one = 0
        // zero != one

        // i = 1
        // s.charAt(1) = '1'
        // zero = 1
        // one = 1
        // zero == one 
        // count = 1
        // zero = 0
        // one = 0

        // ------------------------------

        // i = 2
        // s.charAt(2) = '0'
        // zero = 1

        // i = 3
        // s.charAt(3) = '0'
        // zero = 2

        // i = 4
        // s.charAt(4) = '1'
        // one = 1

        // i = 5
        // s.charAt(5) = '1'
        // one = 2
        // zero == one 
        // count = 2
        // zero = 0
        // one = 0

        // ------------------------------

        // i = 6
        // s.charAt(6) = '0'
        // zero = 1

        // i = 7
        // s.charAt(7) = '1'
        // one = 1
        // zero == one 
        // count = 3
        // zero = 0
        // one = 0
        
        // i = 8
        // s.charAt(8) = '0'
        // zero = 1

        // i = 9
        // s.charAt(9) = '1'
        // one = 1
        // zero == one 
        // count = 4
        // zero = 0
        // one = 0

        // Loop End

        // zero == one
        // return count = 4

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '0')
                zero++;
            else
                one++;

            if (zero == one) {
                count++;
                // zero = 0;
                // one = 0;
            }
        }

        if (zero != one)
            return -1;

        return count;
    }
}
```

#### Solution 10 (Java)

- **Submitted:** 2026-07-23 18:02:59
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public static int maxSubStr(String s) {

        // Dry Run :--
        // Input : s = "0100110101"

        int zero = 0;
        int one = 0;
        int count = 0;

        // i = 0
        // s.charAt(0) = '0'
        // zero = 1
        // one = 0
        // zero != one

        // i = 1
        // s.charAt(1) = '1'
        // zero = 1
        // one = 1
        // zero == one 
        // count = 1
        // zero = 0
        // one = 0

        // ------------------------------

        // i = 2
        // s.charAt(2) = '0'
        // zero = 1

        // i = 3
        // s.charAt(3) = '0'
        // zero = 2

        // i = 4
        // s.charAt(4) = '1'
        // one = 1

        // i = 5
        // s.charAt(5) = '1'
        // one = 2
        // zero == one 
        // count = 2
        // zero = 0
        // one = 0

        // ------------------------------

        // i = 6
        // s.charAt(6) = '0'
        // zero = 1

        // i = 7
        // s.charAt(7) = '1'
        // one = 1
        // zero == one 
        // count = 3
        // zero = 0
        // one = 0
        
        // i = 8
        // s.charAt(8) = '0'
        // zero = 1

        // i = 9
        // s.charAt(9) = '1'
        // one = 1
        // zero == one 
        // count = 4
        // zero = 0
        // one = 0

        // Loop End

        // zero == one
        // return count = 4

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '0')
                zero++;
            else
                one++;

            if (zero == one) {
                count++;
                zero = 0;
                one = 0;
            }
        }

        if (zero != one)
            return -1;

        return count;
    }
}
```

*Generated on: 3/11/2026, 11:35:13 pm*
## 01. Longest Palindromic Substring

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/longest-palindrome-in-a-string1956/1?utm=codolio)

### Problem Description

**Task:** Given a string s, return the longest palindromic substring in s. If there are multiple answers, return the one that appears first in the given string s.

> **Note:** Substring is a contiguous sequence of characters within a string, i.e. s[ i . . . . j ] where 0 ≤ i ≤ j < len(s).

#### Examples

##### Example 1

- **Input:**
```text
s = "forgeeksskeegfor"
```
- **Output:**
```text
geeksskeeg
```
- **Explanation:** There are several possible palindromic substrings like "kssk", "ss", "eeksskee" etc. But the substring "geeksskeeg" is the longest among all.

##### Example 2

- **Input:**
```text
s = "abacac"
```
- **Output:**
```text
aba
```
- **Explanation:** The palindromic substrings "aba", "aca" and "cac" all have the same length. Since "aba" appears first, it is the answer.

##### Example 3

- **Input:**
```text
s = "geeks"
```
- **Output:**
```text
ee
```
- **Explanation:** The longest palindromic substring present in the given string is "ee".

#### Constraints

- **1.** `1 ≤ |s| ≤ 10³`

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(n)

### Accepted Solutions (2)

#### Solution 1 (Java)

- **Submitted:** 2026-10-26 22:16:01
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public String getLongestPal(String s) {
          if (s == null || s.length() < 2) {
                    return s;
                }

            int start = 0;
            int maxLen = 1;
        // using the algo expand around centre 
                for (int i = 0; i < s.length(); i++) {
                    // Odd-length palindrome
                    int len1 = expand(s, i, i);

                    // Even-length palindrome
                    int len2 = expand(s, i, i + 1);

                    int len = Math.max(len1, len2);
        // if length greater than maxlength 
                    if (len > maxLen) {
                        maxLen = len;
                        start = i - (len - 1) / 2;
                    }
                }

                return s.substring(start, start + maxLen);
            }
        // expand around centre 
        // bab--> i = 1 point at a 
        // a == a--> left --; right++; --> b == b 
        // left-- --> left = -1; 
            private int expand(String s, int left, int right) {
                while (left >= 0 && right < s.length()
                        && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                }

                return right - left - 1;
    }
}
```

#### Solution 2 (Java)

- **Submitted:** 2026-10-26 22:15:26
- **Status:** Correct
- **Marks:** 4

```java
class Solution {
    public String getLongestPal(String s) {
          if (s == null || s.length() < 2) {
                    return s;
                }

            int start = 0;
            int maxLen = 1;
        // using the algo expand around centre 
                for (int i = 0; i < s.length(); i++) {
                    // Odd-length palindrome
                    int len1 = expand(s, i, i);

                    // Even-length palindrome
                    int len2 = expand(s, i, i + 1);

                    int len = Math.max(len1, len2);
        // if length greater than maxlength 
                    if (len > maxLen) {
                        maxLen = len;
                        start = i - (len - 1) / 2;
                    }
                }

                return s.substring(start, start + maxLen);
            }
        // expand around centre 
        // bab--> i = 1 point at a 
        // a == a--> left --; right++; --> b == b 
        // left-- --> left = -1; 
            private int expand(String s, int left, int right) {
                while (left >= 0 && right < s.length()
                        && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                }

                return right - left - 1;
    }
}
```

*Generated on: 26/10/2026, 10:16:14 pm*
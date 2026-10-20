## 01. String Rotation Check

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/check-if-strings-are-rotations-of-each-other-or-not-1587115620/1)

### Problem Description

**Task:** Given two strings s1 and s2, of equal lengths. The task is to check if s2 is a rotated version of the string s1.Note: A string is a rotation of another if it can be formed by moving characters from the start to the end (or vice versa) without rearranging them.Examples :Input: s1 = "abcd", s2 = "cdab"Output: true

#### Examples

##### Example 1

- **Explanation:** After 2 right rotations, s1 will become equal to s2.

##### Example 2

- **Input:**
```text
s1 = "aab", s2 = "aba"Output: true
```
- **Explanation:** Strings are not rotations of each other.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(n)

### Accepted Solutions (5)

#### Solution 1 (Java)

- **Submitted:** 2026-10-20 21:47:19
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public boolean areRotations(String s1, String s2) {


        int n = s1.length();

        // Equal length is already guaranteed by the question
        if (n == 0) return true;

        // Rotation must appear in the doubled string
        String text = s1 + s1;

        // Build LPS array for pattern s2
        int[] lps = new int[n];
        int len = 0;
        int i = 1;

        while (i < n) {
            if (s2.charAt(i) == s2.charAt(len)) {
                lps[i] = ++len;
                i++;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }

        // Search s2 in s1 + s1 using KMP
        i = 0;
        int j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == s2.charAt(j)) {
                i++;
                j++;

                if (j == n) return true;
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }

        return false;
    }
}
```

#### Solution 2 (Java)

- **Submitted:** 2026-10-20 00:10:20
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public boolean areRotations(String s1, String s2) {

        int n = s1.length();

        // Equal length is already guaranteed by the question
        if (n == 0) return true;

        // Rotation must appear in the doubled string
        String text = s1 + s1;

        // Build LPS array for pattern s2
        int[] lps = new int[n];
        int len = 0;
        int i = 1;

        while (i < n) {
            if (s2.charAt(i) == s2.charAt(len)) {
                lps[i] = ++len;
                i++;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }

        // Search s2 in s1 + s1 using KMP
        i = 0;
        int j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == s2.charAt(j)) {
                i++;
                j++;

                if (j == n) return true;
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }

        return false;
    }
}
```

#### Solution 3 (Java)

- **Submitted:** 2026-10-20 00:05:44
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public boolean areRotations(String s1, String s2) {

        int n = s1.length();

        // Equal length is already guaranteed by the question
        if (n == 0) return true;

        // Rotation must appear in the doubled string
        String text = s1 + s1;

        // Build LPS array for pattern s2
        int[] lps = new int[n];
        int len = 0;
        int i = 1;

        while (i < n) {
            if (s2.charAt(i) == s2.charAt(len)) {
                lps[i] = ++len;
                i++;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }

        // Search s2 in s1 + s1 using KMP
        i = 0;
        int j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == s2.charAt(j)) {
                i++;
                j++;

                if (j == n) return true;
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }

        return false;
    }
}
```

#### Solution 4 (Java)

- **Submitted:** 2026-07-04 16:27:47
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
  public:
    bool areRotations(string &s1, string &s2) {
        
        if (s1.length() != s2.length())
            return false;

        string temp = s1 + s1;

        return temp.find(s2) != string::npos;
    }
};
```

#### Solution 5 (Java)

- **Submitted:** 2026-07-04 14:16:32
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
  public:
    bool areRotations(string &s1, string &s2) {
        
        if (s1.length() != s2.length())
            return false;

        string temp = s1 + s1;

        return temp.find(s2) != string::npos;
    }
};
```

*Generated on: 20/10/2026, 9:48:06 pm*
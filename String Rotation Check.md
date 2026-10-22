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

- **Submitted:** 2026-10-23 00:25:10
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public boolean areRotations(String s1, String s2) {
       /*
         Input: s1 = "aab", s2 = "aba"
         Output: true
         Explanation: After 1 left rotation, s1 will become equal to s2.
       
        Input: s1 = "abcd", s2 = "acbd"
        Output: false
        Explanation: Strings are not rotations of each other.
        
        
       */
        int n = s1.length();
// n = 3
// n = 4
        // Equal length is already guaranteed by the question
        
        if (n == 0) return true;

        // Rotation must appear in the doubled string
        String text = s1 + s1;
// text = aabaab
// text = abcdabcd
        // Build LPS array for pattern s2
        // lps = [0,0,0]
        // lps = [0,0,00,]
        int[] lps = new int[n];
        int len = 0;
        int i = 1;

        while (i < n) {
            // i--> 1 < 3
            // i --> 2 < 3
            // s2.charAt(2) == s2.charAt(0) = a = a)equal in this case
            
            
    
            if (s2.charAt(i) == s2.charAt(len)) {
                // s2.charAt(1) = b = s2.charAt(0) = a
                // b != a
                lps[i] = ++len;
                // lps[2] = 1
                i++;
                // 3
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                // lps[1] = 0
                i++;
                // 2
            }
        }
// lps[] = [0,0,1]-->aba
        // Search s2 in s1 + s1 using KMP
        i = 0;
        int j = 0;
// i < 6
        while (i < text.length()) {
            // text -->aabaab; 
            //    s2--> aba
            // text.charAt(0) == a = a--> equal --> i , j = 1
            // a== a; b==b;a==a --> j == 3 --> true;
            if (text.charAt(i) == s2.charAt(j)) {
                i++;
                j++;

                if (j == n) return true;
            } else if (j > 0) {
                j = lps[j - 1];
                // j = lps[1 - 1] = lps[0] = 0
            } else {
                i++;
            }
        }

        return false;
    }
}
```

#### Solution 2 (Java)

- **Submitted:** 2026-10-22 21:40:37
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

#### Solution 4 (Java)

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

#### Solution 5 (Java)

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

*Generated on: 23/10/2026, 12:26:12 am*
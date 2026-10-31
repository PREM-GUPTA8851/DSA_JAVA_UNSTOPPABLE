## 01. Longest Palindrome in String

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1?utm=codolio)

### Problem Description

**Task:** Given a string s, your task is to find the longest palindromic substring within s. If there are multiple palindromic substrings with the same length, return the first occurrence of the longest palindromic substring from left to right.Examples :Input: s = “forgeeksskeegfor”

#### Examples

##### Example 1

- **Output:**
```text
“a”
```
- **Explanation:** "a", "b" and "c" are longest palindromic substrings of same length. So, the first occurrence is returned.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n^2)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (8)

#### Solution 1 (Java)

- **Submitted:** 2026-10-31 22:44:01
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
	static String longestPalindrome(String s) {
		// TC:-- Geeks --> ee (even length palimdrom)
		// TC:-- aba --> aba (odd length palimdrome)
		// taking expand around centre concept here
		// e == e(left at e ; right at left + 1)
		// b == b(left; right--> at same) --> a == a(left --; right++)
		// in this case i = 1
		// start = i -(len -1)/2 = 1 - 1 = 0
		// return the length == 3 +1 -1 = 3 (length)  = 3
		// now take substring from start so aapn ko start bhi update krna hoga
		// 		at final return the substring from start and start + maxlen
		
		int start = 0;
		int maxLen = 1;
		// firstly iterate from 0 till string length
		for (int i = 0; i < s.length(); i++) {
			// then at every iteration check odd length palimdrome
			int len1 = palimdrome(s, i, i);
			// then store length of even length palimdrome
			int len2 = palimdrome(s, i, i + 1);
			// compare their lengths
			int len = Math.max(len1, len2);
			
			if (len > maxLen) {
				maxLen = len;
				start = i - (len - 1) / 2;
			}
			
		}
		return s.substring(start, start + maxLen);
		
	}
	static int palimdrome(String s, int left, int right){
	    while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
	        left--;
	        right++;
	    }
	    return right - left - 1;
	}
}
```

#### Solution 2 (Java)

- **Submitted:** 2026-10-31 22:43:56
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
	static String longestPalindrome(String s) {
		// TC:-- Geeks --> ee (even length palimdrom)
		// TC:-- aba --> aba (odd length palimdrome)
		// taking expand around centre concept here
		// e == e(left at e ; right at left + 1)
		// b == b(left; right--> at same) --> a == a(left --; right++)
		// in this case i = 1
		// start = i -(len -1)/2 = 1 - 1 = 0
		// return the length == 3 +1 -1 = 3 (length)  = 3
		// now take substring from start so aapn ko start bhi update krna hoga
		// 		at final return the substring from start and start + maxlen
		
		int start = 0;
		int maxLen = 1;
		// firstly iterate from 0 till string length
		for (int i = 0; i < s.length(); i++) {
			// then at every iteration check odd length palimdrome
			int len1 = palimdrome(s, i, i);
			// then store length of even length palimdrome
			int len2 = palimdrome(s, i, i + 1);
			// compare their lengths
			int len = Math.max(len1, len2);
			
			if (len > maxLen) {
				maxLen = len;
				start = i - (len - 1) / 2;
			}
			
		}
		return s.substring(start, start + maxLen);
		
	}
	static int palimdrome(String s, int left, int right){
	    while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
	        left--;
	        right++;
	    }
	    return right - left - 1;
	}
}
```

#### Solution 3 (Java)

- **Submitted:** 2026-10-31 22:43:37
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
	static String longestPalindrome(String s) {
		// TC:-- Geeks --> ee (even length palimdrom)
		// TC:-- aba --> aba (odd length palimdrome)
		// taking expand around centre concept here
		// e == e(left at e ; right at left + 1)
		// b == b(left; right--> at same) --> a == a(left --; right++)
		// in this case i = 1
		// start = i -(len -1)/2 = 1 - 1 = 0
		// return the length == 3 +1 -1 = 3 (length)  = 3
		// now take substring from start so aapn ko start bhi update krna hoga
		// 		at final return the substring from start and start + maxlen
		
		int start = 0;
		int maxLen = 1;
		// firstly iterate from 0 till string length
		for (int i = 0; i < s.length(); i++) {
			// then at every iteration check odd length palimdrome
			int len1 = palimdrome(s, i, i);
			// then store length of even length palimdrome
			int len2 = palimdrome(s, i, i + 1);
			// compare their lengths
			int len = Math.max(len1, len2);
			
			if (len > maxLen) {
				maxLen = len;
				start = i - (len - 1) / 2;
			}
			
		}
		return s.substring(start, start + maxLen);
		
	}
	static int palimdrome(String s, int left, int right){
	    while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
	        left--;
	        right++;
	    }
	    return right - left - 1;
	}
}
```

#### Solution 4 (Java)

- **Submitted:** 2026-07-15 00:04:32
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    static String longestPalindrome(String s) {
        // longest palimdrome substring 
        int n = s.length();
        if(n <= 1){
            return s;
        }
        
        int start = 0;
        int maxLength = 1;
        // used the concept expand around centre
        for(int i = 0; i < n; i++){
            
        // substring --> odd_length  --> aba
        int left = i;
        int right = i;
        
    while((left >= 0 && right < n) && (s.charAt(left) == s.charAt(right))){
            if(right - left + 1 > maxLength){
                maxLength = right - left + 1;
                start = left;
            }
            
            left--;
            right++;
    }
        // even length --> abba
    left = i;
    right = i + 1;
    while((left >= 0 && right < n) && (s.charAt(left) == s.charAt(right))){
            if(right - left + 1 > maxLength){
                maxLength = right - left + 1;
                start = left;
            }
            left--;
            right++;
    }
    
        }
        return s.substring(start, start + maxLength);
    }
}
```

#### Solution 5 (Java)

- **Submitted:** 2026-07-15 00:04:21
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    static String longestPalindrome(String s) {
        // code here
        int n = s.length();

        if (n <= 1) return s;

        int start = 0;      // Starting index of longest palindrome
        int maxLen = 1;     // Current maximum length

        // Check every character as center
        // i = 0
        // i = 1
        // i = 2
        // i = 3
        // i = 4

        for (int i = 0; i < n; i++) {

            // ---------------- ODD LENGTH ----------------
            int left = i;
            int right = i;

            // s = "babad"

            // i = 0
            // left = 0 , right = 0

            // i = 1
            // left = 1 , right = 1

            // i = 2
            // left = 2 , right = 2

            while (left >= 0 && right < n &&
                    s.charAt(left) == s.charAt(right)) {

                // i = 0
                // left = 0 right = 0
                // length = 1

                // i = 1
                // left = 1 right = 1
                // length = 1

                // left = 0 right = 2
                // substring = "bab"
                // length = 3

                // i = 2
                // left = 2 right = 2
                // length = 1

                // left = 1 right = 3
                // substring = "aba"
                // length = 3

                if (right - left + 1 > maxLen) {

                    maxLen = right - left + 1;
                    // maxLen = 3

                    start = left;
                    // start = 0
                }

                left--;
                // left = -1
                // left = -1
                // left = 0

                right++;
                // right = 1
                // right = 3
                // right = 4
            }

            // ---------------- EVEN LENGTH ----------------

            left = i;
            right = i + 1;

            // i = 0
            // left = 0 right = 1

            // i = 1
            // left = 1 right = 2

            // i = 2
            // left = 2 right = 3

            while (left >= 0 && right < n &&
                    s.charAt(left) == s.charAt(right)) {

                // "babad" me koi even palindrome nahi milega

                if (right - left + 1 > maxLen) {

                    maxLen = right - left + 1;
                    start = left;
                }

                left--;
                right++;
            }
        }

        return s.substring(start, start + maxLen);

        // start = 0
        // maxLen = 3

        // substring(0,3)

        // Answer = "bab"
    }
}
```

#### Solution 6 (Java)

- **Submitted:** 2026-07-14 20:19:45
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    static String longestPalindrome(String s) {
        // code here
        int n = s.length();

        if (n <= 1) return s;

        int start = 0;      // Starting index of longest palindrome
        int maxLen = 1;     // Current maximum length

        // Check every character as center
        // i = 0
        // i = 1
        // i = 2
        // i = 3
        // i = 4

        for (int i = 0; i < n; i++) {

            // ---------------- ODD LENGTH ----------------
            int left = i;
            int right = i;

            // s = "babad"

            // i = 0
            // left = 0 , right = 0

            // i = 1
            // left = 1 , right = 1

            // i = 2
            // left = 2 , right = 2

            while (left >= 0 && right < n &&
                    s.charAt(left) == s.charAt(right)) {

                // i = 0
                // left = 0 right = 0
                // length = 1

                // i = 1
                // left = 1 right = 1
                // length = 1

                // left = 0 right = 2
                // substring = "bab"
                // length = 3

                // i = 2
                // left = 2 right = 2
                // length = 1

                // left = 1 right = 3
                // substring = "aba"
                // length = 3

                if (right - left + 1 > maxLen) {

                    maxLen = right - left + 1;
                    // maxLen = 3

                    start = left;
                    // start = 0
                }

                left--;
                // left = -1
                // left = -1
                // left = 0

                right++;
                // right = 1
                // right = 3
                // right = 4
            }

            // ---------------- EVEN LENGTH ----------------

            left = i;
            right = i + 1;

            // i = 0
            // left = 0 right = 1

            // i = 1
            // left = 1 right = 2

            // i = 2
            // left = 2 right = 3

            while (left >= 0 && right < n &&
                    s.charAt(left) == s.charAt(right)) {

                // "babad" me koi even palindrome nahi milega

                if (right - left + 1 > maxLen) {

                    maxLen = right - left + 1;
                    start = left;
                }

                left--;
                right++;
            }
        }

        return s.substring(start, start + maxLen);

        // start = 0
        // maxLen = 3

        // substring(0,3)

        // Answer = "bab"
    }
}
```

#### Solution 7 (Java)

- **Submitted:** 2026-07-14 20:19:30
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    static String longestPalindrome(String s) {
        // code here
        int n = s.length();

        if (n <= 1) return s;

        int start = 0;      // Starting index of longest palindrome
        int maxLen = 1;     // Current maximum length

        // Check every character as center
        // i = 0
        // i = 1
        // i = 2
        // i = 3
        // i = 4

        for (int i = 0; i < n; i++) {

            // ---------------- ODD LENGTH ----------------
            int left = i;
            int right = i;

            // s = "babad"

            // i = 0
            // left = 0 , right = 0

            // i = 1
            // left = 1 , right = 1

            // i = 2
            // left = 2 , right = 2

            while (left >= 0 && right < n &&
                    s.charAt(left) == s.charAt(right)) {

                // i = 0
                // left = 0 right = 0
                // length = 1

                // i = 1
                // left = 1 right = 1
                // length = 1

                // left = 0 right = 2
                // substring = "bab"
                // length = 3

                // i = 2
                // left = 2 right = 2
                // length = 1

                // left = 1 right = 3
                // substring = "aba"
                // length = 3

                if (right - left + 1 > maxLen) {

                    maxLen = right - left + 1;
                    // maxLen = 3

                    start = left;
                    // start = 0
                }

                left--;
                // left = -1
                // left = -1
                // left = 0

                right++;
                // right = 1
                // right = 3
                // right = 4
            }

            // ---------------- EVEN LENGTH ----------------

            left = i;
            right = i + 1;

            // i = 0
            // left = 0 right = 1

            // i = 1
            // left = 1 right = 2

            // i = 2
            // left = 2 right = 3

            while (left >= 0 && right < n &&
                    s.charAt(left) == s.charAt(right)) {

                // "babad" me koi even palindrome nahi milega

                if (right - left + 1 > maxLen) {

                    maxLen = right - left + 1;
                    start = left;
                }

                left--;
                right++;
            }
        }

        return s.substring(start, start + maxLen);

        // start = 0
        // maxLen = 3

        // substring(0,3)

        // Answer = "bab"
    }
}
```

#### Solution 8 (Java)

- **Submitted:** 2026-07-14 20:16:09
- **Status:** Correct
- **Marks:** 4

```java
class Solution {
    static String longestPalindrome(String s) {
        // code here
        int n = s.length();

        if (n <= 1) return s;

        int start = 0;      // Starting index of longest palindrome
        int maxLen = 1;     // Current maximum length

        // Check every character as center
        // i = 0
        // i = 1
        // i = 2
        // i = 3
        // i = 4

        for (int i = 0; i < n; i++) {

            // ---------------- ODD LENGTH ----------------
            int left = i;
            int right = i;

            // s = "babad"

            // i = 0
            // left = 0 , right = 0

            // i = 1
            // left = 1 , right = 1

            // i = 2
            // left = 2 , right = 2

            while (left >= 0 && right < n &&
                    s.charAt(left) == s.charAt(right)) {

                // i = 0
                // left = 0 right = 0
                // length = 1

                // i = 1
                // left = 1 right = 1
                // length = 1

                // left = 0 right = 2
                // substring = "bab"
                // length = 3

                // i = 2
                // left = 2 right = 2
                // length = 1

                // left = 1 right = 3
                // substring = "aba"
                // length = 3

                if (right - left + 1 > maxLen) {

                    maxLen = right - left + 1;
                    // maxLen = 3

                    start = left;
                    // start = 0
                }

                left--;
                // left = -1
                // left = -1
                // left = 0

                right++;
                // right = 1
                // right = 3
                // right = 4
            }

            // ---------------- EVEN LENGTH ----------------

            left = i;
            right = i + 1;

            // i = 0
            // left = 0 right = 1

            // i = 1
            // left = 1 right = 2

            // i = 2
            // left = 2 right = 3

            while (left >= 0 && right < n &&
                    s.charAt(left) == s.charAt(right)) {

                // "babad" me koi even palindrome nahi milega

                if (right - left + 1 > maxLen) {

                    maxLen = right - left + 1;
                    start = left;
                }

                left--;
                right++;
            }
        }

        return s.substring(start, start + maxLen);

        // start = 0
        // maxLen = 3

        // substring(0,3)

        // Answer = "bab"
    }
}
```

*Generated on: 31/10/2026, 10:45:41 pm*
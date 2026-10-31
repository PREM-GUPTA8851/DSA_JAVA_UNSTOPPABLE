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

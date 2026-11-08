## 01. Longest Prefix Suffix

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/longest-prefix-suffix2527/1?utm=codolio)

### Problem Description

**Task:** Given a string s, of lowercase english alphabets, find the length of the longest proper prefix which is also a suffix.Note: Prefix and suffix can be overlapping but they should not be equal to the entire string.Examples :Input: s = "abab"

#### Examples

##### Example 1

- **Output:**
```text
3
```
- **Explanation:** "aaa" is the longest prefix and suffix.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (3)

#### Solution 1 (Java)

- **Submitted:** 2026-11-09 00:01:16
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
	public int getLPSLength(String s) {
		// TC:-- a a b c d a a b c
		// i :-- 0 1 2 3 4 5 6 7 8
		// lps -- 0 1 0 0 0 1 2 3 4
		
		// 0 len k lps always 0 hota h
		// isliye hum 1 se start krte h check krna lps
		int i = 1;
		int len = 0;
		
		int[] lps = new int[s.length()];
		
		while (i < s.length()) {
			// jb match ho jae tb
			if (s.charAt(i) == s.charAt(len)) {
				lps[i] = ++len;
				i++;
			}
			// agar match nhi kiya to we are trying to match
			// so we move to back
			else if (len != 0) {
				len = lps[len - 1];
			}
			// jb match n kre 0 krke aange bdho
			else {
				lps[i] = 0;
				i++;
			}
		}
		return len;
		
	}
}
```

#### Solution 2 (Java)

- **Submitted:** 2026-11-08 22:02:24
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int getLPSLength(String pat) {
        // abab

                int m = pat.length();  // m = 4


                int[] lps = new int[m];

                // Step 1: LPS array
                int len = 0;
                int i = 1;

            // LPS DRY RUN:
            // i=1: pat[1]='b' != pat[0]='a'
                //      len=0 -> else executes
                //      lps[1]=0, i=2
                //
                // i=2: pat[2]='a' == pat[0]='a'
                //      if executes -> len=1
                //      lps[2]=1, i=3
                //
                // i=3: pat[3]='b' == pat[1]='b'
                //      if executes -> len=2
                //      lps[3]=2, i=4
                //
                // Final LPS = [0, 0, 1, 2]

                while (i < m) {

                    if (pat.charAt(i) == pat.charAt(len)) {
                        len++;
                        lps[i] = len;
                        i++;
                    } 
                    else if (len != 0) {
                        len = lps[len - 1];
                    } 
                    else {
                        lps[i] = 0;
                        i++;
                    }
                }
    return len;
    }
}
```

#### Solution 3 (Java)

- **Submitted:** 2026-11-08 22:01:59
- **Status:** Correct
- **Marks:** 8

```java
class Solution {
    public int getLPSLength(String pat) {
    //  ArrayList<Integer> ans = new ArrayList<>();

                // int n = txt.length();  // n = 11
                int m = pat.length();  // m = 4

                // if (m > n) return ans;

                int[] lps = new int[m];

                // Step 1: LPS array
                int len = 0;
                int i = 1;

            // LPS DRY RUN:
            // i=1: pat[1]='b' != pat[0]='a'
                //      len=0 -> else executes
                //      lps[1]=0, i=2
                //
                // i=2: pat[2]='a' == pat[0]='a'
                //      if executes -> len=1
                //      lps[2]=1, i=3
                //
                // i=3: pat[3]='b' == pat[1]='b'
                //      if executes -> len=2
                //      lps[3]=2, i=4
                //
                // Final LPS = [0, 0, 1, 2]

                while (i < m) {

                    if (pat.charAt(i) == pat.charAt(len)) {
                        len++;
                        lps[i] = len;
                        i++;
                    } 
                    else if (len != 0) {
                        len = lps[len - 1];
                    } 
                    else {
                        lps[i] = 0;
                        i++;
                    }
                }
    return len;
    }
}
```

*Generated on: 9/11/2026, 12:01:37 am*
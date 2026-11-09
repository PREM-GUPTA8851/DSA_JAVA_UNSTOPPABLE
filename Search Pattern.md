## 01. Search Pattern

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/search-pattern0205/1)

### Problem Description

**Task:** Given two strings, a text string txt and a pattern string pat, both consisting of lowercase English alphabets. Return the starting indices (0-based) of all the occurrences of the pattern string pat in the text string txt.Note: Return an empty list in case of no occurrences of pattern.Examples:Input: txt = "geeksforgeeks", pat = "geek"

#### Examples

##### Example 1

- **Output:**
```text
[0, 8]
```
- **Explanation:** The string "geek" occurs twice in txt, one starts at index 0 and the other at index 8.

##### Example 2

- **Input:**
```text
txt = "abesdu", pat = "edu"
```
- **Output:**
```text
[0, 9, 12]
```

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n + m)
- **Expected Auxiliary Space Complexity:** O(m)

### Accepted Solutions (2)

#### Solution 1 (Java)

- **Submitted:** 2026-11-09 23:24:20
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
	ArrayList<Integer> search(String pat, String txt) {
		// TC:--g e e k
		// i:-- 0 1 2 3
		// lps-  0 0 0 0
		// 0 size k lps always 0 hi hota h isliye aapn 1 se
		// start krte h
		
		// tc:-- a a b a a c a a d a  a  b  a  a  b a
		// i:--  0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
		// now we create an lps for patt
		// patt--> a a b a
		// i ----> 0 1 2 3
		// lps --> 0 1 0 1
		int[] lps = new int[pat.length()];
		ArrayList<Integer> ans = new ArrayList<>();
		int len = 0; // initial aapn lekr chlenge ki lps abhi tk 0 len k mila h
		int i = 1;
		
		while (i < pat.length()){
		    // jb match kr jae tb
		    if(pat.charAt(i) == pat.charAt(len)){
		        lps[i] = ++len;
		        i++;
		    }
		    // agar len 0 n hui aur aange mismatch hua tb
		    // aapn back jaakr fhr se prefix suffix k match k try krte h
		    else if(len != 0){
		        len = lps[len - 1];
		    }
		  //  at last mismatch hote hote vo fhr if match n hua tb
		  else{
		      lps[i] = 0;
		      i++;
		  }
		}
		//i
		// tc:-- a a b a a c a a d a  a  b  a  a  b a
		// i:--  0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
		// now we create an lps for patt
		// patt--> a a b a --> j
		// i ----> 0 1 2 3
		// lps --> 0 1 0 1
		// now ab pattern match krenge text k andr
    int j = 0; // pattern k liye ho gya
    i = 0;// text k liye ho gya
		while(i < txt.length()){
		    // jb hamara pattern k character text k character se match kr jae
		    if(txt.charAt(i) == pat.charAt(j)){
		        i++;
		        j++;
		        // geek == geek --> i,j --> at 4
		    }
		    // jb duplicates mismatch create kre aur patt k index non zero ho tb aapn uske pehle wala character k side jaate h check krne ky fhr se new pattern exist krta h y nhi
		    else if(j != 0){
		        j = lps[j - 1];
		    }
		    else {
		        // jb mismatch ho tb text k index increment krte h 
		        i++;
		    }
		    if(j == pat.length()){
		        ans.add(i - j);// uska find wala index add kr denge 
		        // ans --> 0,
		        j = lps[j - 1];
		    }
		}
		return ans;
		}
}
```

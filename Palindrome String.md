## 01. Palindrome String

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/palindrome-string0817/1?utm=codolio)

### Problem Description

**Task:** Given a string s, find if it is a palindrome. A string is considered a palindrome if it reads the same forwards and backwards.

#### Examples

##### Example 1

- **Input:**
```text
s = "abba"
```
- **Output:**
```text
true
```
- **Explanation:** "abba" reads the same forwards and backwards, so it is a palindrome.

##### Example 2

- **Input:**
```text
s = "abc"
```
- **Output:**
```text
false
```
- **Explanation:** "abc" does not read the same forwards and backwards, so it is not a palindrome.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (5)

#### Solution 1 (Java)

- **Submitted:** 2026-10-19 21:50:10
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
	boolean isPalindrome(String s) {
		// palimdrome string means left and right se 
		// character's equal
		
		// take two pointer's left and right
		int left = 0;
		int right = s.length() -1;
		while(left <= right){
		// check character at these two pointer's 
		// if mis_match return false & increment first pointer and decrement 
		// second pointer then again check till both 
		// first pointer <= second pointer
		if(s.charAt(left) != s.charAt(right)) return false;
		left++;
		right--;
		}
		return true;
		}
	}
```

#### Solution 2 (Java)

- **Submitted:** 2026-10-19 21:49:12
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
	boolean isPalindrome(String s) {
		// palimdrome string means left and right se 
		// character's equal
		
		// take two pointer's left and right
		int left = 0;
		int right = s.length() -1;
		while(left <= right){
		// check character at these two pointer's 
		// if match increment first pointer and decrement 
		// second pointer then again check till both 
		// first pointer <= second pointer
		if(s.charAt(left) != s.charAt(right)) return false;
		left++;
		right--;
		// else part unmatched case --> return false;
		}
		return true;
		}
	}
```

#### Solution 3 (Java)

- **Submitted:** 2026-06-29 12:13:50
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    boolean isPalindrome(String s) {
        // code here
        int first = 0;
        int last = s.length() -1;
        // jb tk first < last
        while(first < last){
            
        // agar non-alphanumeric agar mila to skip kiya jae
        if(!Character.isLetterOrDigit(s.charAt(first))){
            first++;
            continue;
        }
        if(!Character.isLetterOrDigit(s.charAt(last))){
            last--;
            continue;
        }

        // tb tk pehle character ko lowercase me kiya jae 
            char fi = Character.toLowerCase(s.charAt(first));
            char la = Character.toLowerCase(s.charAt(last));
        //  tb tk agar koi element mimatch mila return false
        if(fi != la){
            return false;
        }
        first++;
        last--;
        }
        return true;
    }
}
```

#### Solution 4 (Java)

- **Submitted:** 2026-06-29 12:13:46
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    boolean isPalindrome(String s) {
        // code here
        int first = 0;
        int last = s.length() -1;
        // jb tk first < last
        while(first < last){
            
        // agar non-alphanumeric agar mila to skip kiya jae
        if(!Character.isLetterOrDigit(s.charAt(first))){
            first++;
            continue;
        }
        if(!Character.isLetterOrDigit(s.charAt(last))){
            last--;
            continue;
        }

        // tb tk pehle character ko lowercase me kiya jae 
            char fi = Character.toLowerCase(s.charAt(first));
            char la = Character.toLowerCase(s.charAt(last));
        //  tb tk agar koi element mimatch mila return false
        if(fi != la){
            return false;
        }
        first++;
        last--;
        }
        return true;
    }
}
```

#### Solution 5 (Java)

- **Submitted:** 2026-06-29 12:13:39
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    boolean isPalindrome(String s) {
        // code here
        int first = 0;
        int last = s.length() -1;
        // jb tk first < last
        while(first < last){
            
        // agar non-alphanumeric agar mila to skip kiya jae
        if(!Character.isLetterOrDigit(s.charAt(first))){
            first++;
            continue;
        }
        if(!Character.isLetterOrDigit(s.charAt(last))){
            last--;
            continue;
        }

        // tb tk pehle character ko lowercase me kiya jae 
            char fi = Character.toLowerCase(s.charAt(first));
            char la = Character.toLowerCase(s.charAt(last));
        //  tb tk agar koi element mimatch mila return false
        if(fi != la){
            return false;
        }
        first++;
        last--;
        }
        return true;
    }
}
```

*Generated on: 19/10/2026, 9:51:04 pm*
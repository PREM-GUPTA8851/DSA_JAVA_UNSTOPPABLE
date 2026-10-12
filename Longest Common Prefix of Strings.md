## 01. Longest Common Prefix of Strings

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/longest-common-prefix-in-an-array5129/1?utm=codolio)

### Problem Description

**Task:** Given an array of strings arr[]. Return the longest common prefix among each and every strings present in the array. If there's no prefix common in all the strings, return "".Examples :Input: arr[] = ["geeksforgeeks", "geeks", "geek", "geezer"]

#### Examples

##### Example 1

- **Output:**
```text
""
```
- **Explanation:** There's no common prefix in the given strings.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n*min(|arri|))
- **Expected Auxiliary Space Complexity:** O(min(|arri|))

### Accepted Solutions (5)

#### Solution 1 (Java)

- **Submitted:** 2026-10-13 00:18:38
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public String longestCommonPrefix(String arr[]) {
        String prefix = arr[0]; // geeksforgeeks
        
        for(int i = 1; i < arr.length; i++){
            
            String result = arr[i];
            
            
            
            while(!result.startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        
        return prefix;
    }
}
```

#### Solution 2 (Java)

- **Submitted:** 2026-08-13 00:17:40
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public String longestCommonPrefix(String arr[]) {
    // logic is pehle aapn ek word pkd lete h then baki check krte jaate h 
    // ki baki word us first word se start hote h y nhi 
    // jb tk n ho rha tb tk prefix wali length ko aapn small krte jaenge.
        String prefix = arr[0]; // geeksforgeeks
        
        for(int i = 1; i < arr.length; i++){
            while(!arr[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
```

#### Solution 3 (Java)

- **Submitted:** 2026-08-13 00:17:29
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public String longestCommonPrefix(String arr[]) {
    // logic is pehle aapn ek word pkd lete h then baki check krte jaate h 
    // ki baki word us first word se start hote h y nhi 
    // jb tk n ho rha tb tk prefix wali length ko aapn small krte jaenge.
        String prefix = arr[0]; // geeksforgeeks
        
        for(int i = 1; i < arr.length; i++){
            while(!arr[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
```

#### Solution 4 (Java)

- **Submitted:** 2026-08-13 00:17:20
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public String longestCommonPrefix(String arr[]) {
    // logic is pehle aapn ek word pkd lete h then baki check krte jaate h 
    // ki baki word us first word se start hote h y nhi 
    // jb tk n ho rha tb tk prefix wali length ko aapn small krte jaenge.
        String prefix = arr[0]; // geeksforgeeks
        
        for(int i = 1; i < arr.length; i++){
            while(!arr[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
```

#### Solution 5 (Java)

- **Submitted:** 2026-08-13 00:17:10
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public String longestCommonPrefix(String arr[]) {
    // logic is pehle aapn ek word pkd lete h then baki check krte jaate h 
    // ki baki word us first word se start hote h y nhi 
    // jb tk n ho rha tb tk prefix wali length ko aapn small krte jaenge.
        String prefix = arr[0]; // geeksforgeeks
        
        for(int i = 1; i < arr.length; i++){
            while(!arr[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
```

*Generated on: 13/10/2026, 12:19:44 am*
## 01. Reverse Using Stack

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/reverse-a-string-using-stack/1?utm=codolio)

### Problem Description

**Task:** You are given a string s , the task is to reverse the string using stack.

#### Examples

##### Example 1

- **Input:**
```text
s = "GeeksforGeeks"
```
- **Output:**
```text
skeeGrofskeeG
```

##### Example 2

- **Input:**
```text
s = "Geek"
```
- **Output:**
```text
keeG
```

#### Constraints

- **1.** `1 ≤ s.length() ≤ 100`

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(n)

### Accepted Solutions (4)

#### Solution 1 (Java)

- **Submitted:** 2026-10-12 22:36:54
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public String reverse(String S) {
        Stack<Character> ans = new Stack<>();
        
        for(int i = 0; i < S.length(); i++){
            ans.push(S.charAt(i));
        }
        
        StringBuilder result = new StringBuilder();
        
        while(!ans.isEmpty()){
            result.append(ans.pop());
        }
        return result.toString();
    }
}
```

#### Solution 2 (Java)

- **Submitted:** 2026-06-29 11:04:14
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public String reverse(String S) {
        Stack<Character> ans = new Stack<>();
        
        // ab elements ko stack m push kro
        for(int i = 0; i < S.length(); i++){
            ans.push(S.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!ans.empty()){
            sb.append(ans.pop());
    }
    return sb.toString();
    }
}
```

#### Solution 3 (Java)

- **Submitted:** 2026-06-29 10:59:51
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public String reverse(String S) {
        Stack<Character> ans = new Stack<>();
        
        // ab elements ko stack m push kro
        for(int i = 0; i < S.length(); i++){
            ans.push(S.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!ans.empty()){
            sb.append(ans.pop());
    }
    return sb.toString();
    }
}
```

#### Solution 4 (Java)

- **Submitted:** 2026-06-29 10:59:41
- **Status:** Correct
- **Marks:** 2

```java
class Solution {
    public String reverse(String S) {
        Stack<Character> ans = new Stack<>();
        
        // ab elements ko stack m push kro
        for(int i = 0; i < S.length(); i++){
            ans.push(S.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!ans.empty()){
            sb.append(ans.pop());
    }
    return sb.toString();
    }
}
```

*Generated on: 12/10/2026, 10:37:16 pm*
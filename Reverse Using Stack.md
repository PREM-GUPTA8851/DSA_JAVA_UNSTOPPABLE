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

*Generated on: 12/10/2026, 10:37:16 pm*

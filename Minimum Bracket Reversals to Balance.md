## 01. Minimum Bracket Reversals to Balance

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/count-the-reversals0401/1?utm=codolio)

### Problem Description

**Task:** Given a string s consisting of only opening and closing curly brackets '{' and '}', find out the minimum reversals required to convert the string into a balanced expression. A reversal means changing '{' to '}' or vice-versa.Examples:

#### Examples

##### Example 1

- **Input:**
```text
s = "}{{}}{{{"
```
- **Output:**
```text
3
```
- **Explanation:** One way to balance is: "{{{}}{}}". There is no balanced sequence that can be formed in lesser reversals.

##### Example 2

- **Input:**
```text
s = "{{}{{{}{{}}{{"
```
- **Output:**
```text
-1
```
- **Explanation:** There's no way we can balance this sequence of braces.

#### Constraints

- **1.** `1 ≤ |s| ≤ 10⁵`

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (2)

#### Solution 1 (Java)

- **Submitted:** 2026-11-14 23:41:43
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int countMinReversals(String s) {
        int n = s.length();

        // Agar length odd hai, balanced brackets banana
        // possible nahi hai, kyunki har bracket ka pair hona chahiye.
        if (n % 2 != 0) {
            return -1;
        }

        int open = 0;  // Unmatched '{' count
        int close = 0; // Unmatched '}' count

        // Dry run: s = "}}{{"
        // Initially: open = 0, close = 0
        //
        // i = 0, ch = '}'
        // open = 0, matching '{' nahi mila
        // close = 1
        //
        // i = 1, ch = '}'
        // open = 0, matching '{' nahi mila
        // close = 2
        //
        // i = 2, ch = '{'
        // open = 1, close = 2
        //
        // i = 3, ch = '{'
        // open = 2, close = 2
        //
        // Loop ke baad:
        // open = 2, close = 2

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '{') {
                open++;
            } else {
                // Agar unmatched '{' available hai,
                // toh current '}' ke saath pair bana do.
                if (open > 0) {
                    open--;
                } else {
                    // Matching '{' nahi mila,
                    // isliye unmatched '}' count badhao.
                    close++;
                }
            }
        }

        // Dry run:
        // open = 2, close = 2
        //
        // Unmatched '{' ko fix karne ke liye:
        // (open + 1) / 2 = (2 + 1) / 2 = 1
        //
        // Unmatched '}' ko fix karne ke liye:
        // (close + 1) / 2 = (2 + 1) / 2 = 1
        //
        // Total reversals = 1 + 1 = 2

        return (open + 1) / 2 + (close + 1) / 2;
    }
}
```

#### Solution 2 (Java)

- **Submitted:** 2026-11-14 00:29:56
- **Status:** Correct
- **Marks:** 4

```java
class Solution {
    public int countMinReversals(String s) {
        int n = s.length();

        // Agar length odd hai, balanced brackets banana
        // possible nahi hai, kyunki har bracket ka pair hona chahiye.
        if (n % 2 != 0) {
            return -1;
        }

        int open = 0;  // Unmatched '{' count
        int close = 0; // Unmatched '}' count

        // Dry run: s = "}}{{"
        // Initially: open = 0, close = 0
        //
        // i = 0, ch = '}'
        // open = 0, matching '{' nahi mila
        // close = 1
        //
        // i = 1, ch = '}'
        // open = 0, matching '{' nahi mila
        // close = 2
        //
        // i = 2, ch = '{'
        // open = 1, close = 2
        //
        // i = 3, ch = '{'
        // open = 2, close = 2
        //
        // Loop ke baad:
        // open = 2, close = 2

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '{') {
                open++;
            } else {
                // Agar unmatched '{' available hai,
                // toh current '}' ke saath pair bana do.
                if (open > 0) {
                    open--;
                } else {
                    // Matching '{' nahi mila,
                    // isliye unmatched '}' count badhao.
                    close++;
                }
            }
        }

        // Dry run:
        // open = 2, close = 2
        //
        // Unmatched '{' ko fix karne ke liye:
        // (open + 1) / 2 = (2 + 1) / 2 = 1
        //
        // Unmatched '}' ko fix karne ke liye:
        // (close + 1) / 2 = (2 + 1) / 2 = 1
        //
        // Total reversals = 1 + 1 = 2

        return (open + 1) / 2 + (close + 1) / 2;
    }
}
```

*Generated on: 14/11/2026, 11:42:01 pm*
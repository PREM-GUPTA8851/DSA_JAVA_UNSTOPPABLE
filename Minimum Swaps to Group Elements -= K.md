## 01. Minimum Swaps to Group Elements <= K

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1?utm=codolio)

### Problem Description

**Task:** Given an array arr and a number k. One can apply a swap operation on the array any number of times, i.e choose any two index i and j (i < j) and swap arr[i], arr[j] . Find the minimum number of swaps required to bring all the numbers less than or equal to k together, i.e. make them a contiguous subarray.

#### Examples

##### Example 1

- **Input:**
```text
arr[] = [2, 1, 5, 6, 3], k = 3
```
- **Output:**
```text
1
```
- **Explanation:** To bring elements 2, 1, 3 together, swap index 2 with 4 (0-based indexing), i.e. element arr[2] = 5 with arr[4] = 3 such that final array will be- arr[] = [2, 1, 3, 6, 5]

##### Example 2

- **Input:**
```text
arr[] = [2, 7, 9, 5, 8, 7, 4], k = 6
```
- **Output:**
```text
2
```
- **Explanation:** To bring elements 2, 5, 4 together, swap index 0 with 2 (0-based indexing) and index 4 with 6 (0-based indexing) such that final array will be- arr[] = [9, 7, 2, 5, 4, 7, 8]

##### Example 3

- **Input:**
```text
arr[] = [2, 4, 5, 3, 6, 1, 8], k = 6
```
- **Output:**
```text
0
```

#### Constraints

- **1.** `1 ≤ arr.size() ≤ 10⁶¹ ≤ arr[i] ≤ 10⁶¹ ≤ k ≤ 10⁶`

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (15)

#### Solution 1 (Java)

- **Submitted:** 2026-10-09 22:30:59
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    int minSwap(int[] arr, int k) {

        //Count karo kitne elements ko ek saath lana hai
    // 1 10 2 3 20 4 5
    // k = 5
        int windowSize = 0;
        for (int num : arr) {
            if (num <= k) windowSize++;
        }
    // ws = 5
        //Pehli window me kitne bad elements hain
        int badCount = 0;
        for (int i = 0; i < windowSize; i++) {
            if (arr[i] > k) badCount++;
        }
        
        // badCount = 2, matlab 2 swaps chahiye

        //Abhi tak ka minimum swaps store karo
        int minSwaps = badCount; // minSwaps = 2

        // // Block 4: Window ko right side slide karo
        for (int i = windowSize; i < arr.length; i++) {

            // Naya element enter ho raha hai
            if (arr[i] > k) badCount++;
            // i=3: 5 good, count=2
            // i=4: 8 bad, count=3
            // i=5: 7 bad, count=3
            // i=6: 4 good, count=2

            // Purana element window se nikal raha hai
            if (arr[i - windowSize] > k) badCount--;
            // i=3: 2 good, count=2
            // i=4: 7 bad tha, count=2
            // i=5: 9 bad tha, count=2
            // i=6: 5 good, count=2

            // Minimum bad elements wali window save karo
            minSwaps = Math.min(minSwaps, badCount);
            // Har baar minimum = 2
        }

        return minSwaps; // 2
    }
}
```

*Generated on: 9/10/2026, 10:43:37 pm*

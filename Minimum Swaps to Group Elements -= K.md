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

#### Solution 2 (Java)

- **Submitted:** 2026-10-09 22:14:36
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    int minSwap(int[] arr, int k) {

        // TC: [2, 1, 5, 6, 3], k=3
        // <=3 = 3 elements, so window size = 3

        int w = 0;
        for (int x : arr)
            if (x <= k) w++;
        // w=3

        int bad = 0;
        for (int i = 0; i < w; i++)
            if (arr[i] > k) bad++;
        // [2,1,5] -> 5 bad -> bad=1
        // ans=1

        int ans = bad;

        for (int i = w; i < arr.length; i++) {

            if (arr[i] > k) bad++;
            // i=3 -> 6 bad -> bad=2

            if (arr[i-w] > k) bad--;
            // 2 window se nikla -> bad=1
            // window = [1,5,6]

            ans = Math.min(ans, bad);
            // ans=1

            // i=4 -> 3 aaya, good
            // 1 window se nikla, good
            // bad=1
            // window = [5,6,3]
            // ans=1
        }

        return ans; // 1 swap

    }
}

// Implement Algorithm: **Sliding Window Minimum Swaps** 🔥
```

#### Solution 3 (Java)

- **Submitted:** 2026-10-09 00:34:53
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    int minSwap(int[] arr, int k) {

        // TC: [2, 1, 5, 6, 3], k=3
        // <=3 = 3 elements, so window size = 3

        int w = 0;
        for (int x : arr)
            if (x <= k) w++;
        // w=3

        int bad = 0;
        for (int i = 0; i < w; i++)
            if (arr[i] > k) bad++;
        // [2,1,5] -> 5 bad -> bad=1
        // ans=1

        int ans = bad;

        for (int i = w; i < arr.length; i++) {

            if (arr[i] > k) bad++;
            // i=3 -> 6 bad -> bad=2

            if (arr[i-w] > k) bad--;
            // 2 window se nikla -> bad=1
            // window = [1,5,6]

            ans = Math.min(ans, bad);
            // ans=1

            // i=4 -> 3 aaya, good
            // 1 window se nikla, good
            // bad=1
            // window = [5,6,3]
            // ans=1
        }

        return ans; // 1 swap

    }
}

// Implement Algorithm: **Sliding Window Minimum Swaps** 🔥
```

#### Solution 4 (Java)

- **Submitted:** 2026-10-09 00:33:57
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    int minSwap(int[] arr, int k) {

        int w = 0;
        for (int x : arr)
            if (x <= k) w++;

        int bad = 0;
        for (int i = 0; i < w; i++)
            if (arr[i] > k) bad++;

        int ans = bad;

        for (int i = w; i < arr.length; i++) {
            if (arr[i] > k) bad++;
            if (arr[i - w] > k) bad--;

            ans = Math.min(ans, bad);
        }

        return ans;
    }
}

// Implement Algorithm: **Sliding Window Minimum Swaps** 🔥
```

#### Solution 5 (Java)

- **Submitted:** 2026-06-22 14:58:49
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    // Function for finding maximum and value pair
    int minSwap(int[] arr, int k) {
        // pehle isme elements count krna h jo less 
        // than k h jinhe ek sath rkhna h 
        int good = 0;
        for(int num:  arr){
            if(num <= k) good++;
        }
        // good = 5
        // fhir isme bad element count krne h 
        // ki good element ki length tk bad elements 
        // kitne h  --> ek window milegi
        int bad = 0;
        for(int i = 0; i < good; i++){
            if(arr[i] > k) bad++;
        }
        // bad = 2
        int ans = bad;
        int i = 0;
        int j = good;
        
        while(j < arr.length){
            // pehle jo element jaa rha uske according aapan bad element update kr de 
            if(arr[i] > k){
                bad--;
            }
            
            if(arr[j] > k) bad++;
            i++;
            j++;
            
            ans = Math.min(ans, bad);
        }
        
        
        // hume minimum swaps chahiye
        return ans;
    }
}
```

#### Solution 6 (Java)

- **Submitted:** 2026-06-21 11:41:59
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
public:
    int minSwap(vector<int>& arr, int k) {
        
        int n = arr.size();
        // n = 5
        // Step 1: Count good elements (<= k)
        int good = 0;
        
        for(int i = 0; i < n; i++) {
            
            if(arr[i] <= k) {
                good++;
                // good = 3
            }
        }

        // Agar 0 ya 1 good element hai to already together hain
        if(good <= 1) {
            return 0;
        }

        // Step 2: First window me bad elements (> k) count karo
        int bad = 0;

        for(int i = 0; i < good; i++) {
            if(arr[i] > k) {
                bad++;
                // bad = 1
                // 2
            }
        }

        int ans = bad;
        // ans = 1
        // 2
        // Step 3: Sliding Window
        int i = 0, j = good;

        while(j < n) {
        // 4 < 5 
            // Window se jo element nikal raha hai
            if(arr[i] > k) {
                bad--;
            }

            // Window me jo naya element aa raha hai
            if(arr[j] > k) {
                bad++;
                // 2
            }

            // Minimum bad elements store karo
            ans = min(ans, bad);
            // ans = min(1, 2) -> 1
            // 2
            i++;
            // 1
            j++;
            // 4
        }

        return ans; // 1
    }
};
```

#### Solution 7 (Java)

- **Submitted:** 2026-06-21 11:34:11
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
public:
    int minSwap(vector<int>& arr, int k) {
        
        int n = arr.size();
        // n = 5
        // Step 1: Count good elements (<= k)
        int good = 0;
        
        for(int i = 0; i < n; i++) {
            
            if(arr[i] <= k) {
                good++;
                // good = 3
            }
        }

        // Agar 0 ya 1 good element hai to already together hain
        if(good <= 1) {
            return 0;
        }

        // Step 2: First window me bad elements (> k) count karo
        int bad = 0;

        for(int i = 0; i < good; i++) {
            if(arr[i] > k) {
                bad++;
                // bad = 1
                // 2
            }
        }

        int ans = bad;
        // ans = 1
        // 2
        // Step 3: Sliding Window
        int i = 0, j = good;

        while(j < n) {
        // 4 < 5 
            // Window se jo element nikal raha hai
            if(arr[i] > k) {
                bad--;
            }

            // Window me jo naya element aa raha hai
            if(arr[j] > k) {
                bad++;
                // 2
            }

            // Minimum bad elements store karo
            ans = min(ans, bad);
            // ans = min(1, 2) -> 1
            // 2
            i++;
            // 1
            j++;
            // 4
        }

        return ans; // 1
    }
};
```

#### Solution 8 (Java)

- **Submitted:** 2026-06-21 10:24:56
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
public:
    int minSwap(vector<int>& arr, int k) {
        
        int n = arr.size();

        // Step 1: Count good elements (<= k)
        int good = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] <= k) {
                good++;
            }
        }

        // Agar 0 ya 1 good element hai to already together hain
        if(good <= 1) {
            return 0;
        }

        // Step 2: First window me bad elements (> k) count karo
        int bad = 0;

        for(int i = 0; i < good; i++) {
            if(arr[i] > k) {
                bad++;
            }
        }

        int ans = bad;

        // Step 3: Sliding Window
        int i = 0, j = good;

        while(j < n) {

            // Window se jo element nikal raha hai
            if(arr[i] > k) {
                bad--;
            }

            // Window me jo naya element aa raha hai
            if(arr[j] > k) {
                bad++;
            }

            // Minimum bad elements store karo
            ans = min(ans, bad);

            i++;
            j++;
        }

        return ans;
    }
};
```

#### Solution 9 (Java)

- **Submitted:** 2026-06-21 10:22:16
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
public:
    int minSwap(vector<int>& arr, int k) {
        
        int n = arr.size();

        // Step 1: Count good elements (<= k)
        int good = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] <= k) {
                good++;
            }
        }

        // Agar 0 ya 1 good element hai to already together hain
        if(good <= 1) {
            return 0;
        }

        // Step 2: First window me bad elements (> k) count karo
        int bad = 0;

        for(int i = 0; i < good; i++) {
            if(arr[i] > k) {
                bad++;
            }
        }

        int ans = bad;

        // Step 3: Sliding Window
        int i = 0, j = good;

        while(j < n) {

            // Window se jo element nikal raha hai
            if(arr[i] > k) {
                bad--;
            }

            // Window me jo naya element aa raha hai
            if(arr[j] > k) {
                bad++;
            }

            // Minimum bad elements store karo
            ans = min(ans, bad);

            i++;
            j++;
        }

        return ans;
    }
};
```

#### Solution 10 (Java)

- **Submitted:** 2026-06-21 10:22:09
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
public:
    int minSwap(vector<int>& arr, int k) {
        
        int n = arr.size();

        // Step 1: Count good elements (<= k)
        int good = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] <= k) {
                good++;
            }
        }

        // Agar 0 ya 1 good element hai to already together hain
        if(good <= 1) {
            return 0;
        }

        // Step 2: First window me bad elements (> k) count karo
        int bad = 0;

        for(int i = 0; i < good; i++) {
            if(arr[i] > k) {
                bad++;
            }
        }

        int ans = bad;

        // Step 3: Sliding Window
        int i = 0, j = good;

        while(j < n) {

            // Window se jo element nikal raha hai
            if(arr[i] > k) {
                bad--;
            }

            // Window me jo naya element aa raha hai
            if(arr[j] > k) {
                bad++;
            }

            // Minimum bad elements store karo
            ans = min(ans, bad);

            i++;
            j++;
        }

        return ans;
    }
};
```

#### Solution 11 (Java)

- **Submitted:** 2026-06-21 10:21:33
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
public:
    int minSwap(vector<int>& arr, int k) {
        
        int n = arr.size();

        // Step 1: Count good elements (<= k)
        int good = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] <= k) {
                good++;
            }
        }

        // Agar 0 ya 1 good element hai to already together hain
        if(good <= 1) {
            return 0;
        }

        // Step 2: First window me bad elements (> k) count karo
        int bad = 0;

        for(int i = 0; i < good; i++) {
            if(arr[i] > k) {
                bad++;
            }
        }

        int ans = bad;

        // Step 3: Sliding Window
        int i = 0, j = good;

        while(j < n) {

            // Window se jo element nikal raha hai
            if(arr[i] > k) {
                bad--;
            }

            // Window me jo naya element aa raha hai
            if(arr[j] > k) {
                bad++;
            }

            // Minimum bad elements store karo
            ans = min(ans, bad);

            i++;
            j++;
        }

        return ans;
    }
};
```

#### Solution 12 (Java)

- **Submitted:** 2026-06-21 10:21:25
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
public:
    int minSwap(vector<int>& arr, int k) {
        
        int n = arr.size();

        // Step 1: Count good elements (<= k)
        int good = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] <= k) {
                good++;
            }
        }

        // Agar 0 ya 1 good element hai to already together hain
        if(good <= 1) {
            return 0;
        }

        // Step 2: First window me bad elements (> k) count karo
        int bad = 0;

        for(int i = 0; i < good; i++) {
            if(arr[i] > k) {
                bad++;
            }
        }

        int ans = bad;

        // Step 3: Sliding Window
        int i = 0, j = good;

        while(j < n) {

            // Window se jo element nikal raha hai
            if(arr[i] > k) {
                bad--;
            }

            // Window me jo naya element aa raha hai
            if(arr[j] > k) {
                bad++;
            }

            // Minimum bad elements store karo
            ans = min(ans, bad);

            i++;
            j++;
        }

        return ans;
    }
};
```

#### Solution 13 (Java)

- **Submitted:** 2026-06-21 10:21:18
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
public:
    int minSwap(vector<int>& arr, int k) {
        
        int n = arr.size();

        // Step 1: Count good elements (<= k)
        int good = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] <= k) {
                good++;
            }
        }

        // Agar 0 ya 1 good element hai to already together hain
        if(good <= 1) {
            return 0;
        }

        // Step 2: First window me bad elements (> k) count karo
        int bad = 0;

        for(int i = 0; i < good; i++) {
            if(arr[i] > k) {
                bad++;
            }
        }

        int ans = bad;

        // Step 3: Sliding Window
        int i = 0, j = good;

        while(j < n) {

            // Window se jo element nikal raha hai
            if(arr[i] > k) {
                bad--;
            }

            // Window me jo naya element aa raha hai
            if(arr[j] > k) {
                bad++;
            }

            // Minimum bad elements store karo
            ans = min(ans, bad);

            i++;
            j++;
        }

        return ans;
    }
};
```

#### Solution 14 (Java)

- **Submitted:** 2026-06-21 10:21:10
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
public:
    int minSwap(vector<int>& arr, int k) {
        
        int n = arr.size();

        // Step 1: Count good elements (<= k)
        int good = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] <= k) {
                good++;
            }
        }

        // Agar 0 ya 1 good element hai to already together hain
        if(good <= 1) {
            return 0;
        }

        // Step 2: First window me bad elements (> k) count karo
        int bad = 0;

        for(int i = 0; i < good; i++) {
            if(arr[i] > k) {
                bad++;
            }
        }

        int ans = bad;

        // Step 3: Sliding Window
        int i = 0, j = good;

        while(j < n) {

            // Window se jo element nikal raha hai
            if(arr[i] > k) {
                bad--;
            }

            // Window me jo naya element aa raha hai
            if(arr[j] > k) {
                bad++;
            }

            // Minimum bad elements store karo
            ans = min(ans, bad);

            i++;
            j++;
        }

        return ans;
    }
};
```

#### Solution 15 (Java)

- **Submitted:** 2026-06-21 10:21:04
- **Status:** Correct
- **Marks:** 4

```java
class Solution {
public:
    int minSwap(vector<int>& arr, int k) {
        
        int n = arr.size();

        // Step 1: Count good elements (<= k)
        int good = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] <= k) {
                good++;
            }
        }

        // Agar 0 ya 1 good element hai to already together hain
        if(good <= 1) {
            return 0;
        }

        // Step 2: First window me bad elements (> k) count karo
        int bad = 0;

        for(int i = 0; i < good; i++) {
            if(arr[i] > k) {
                bad++;
            }
        }

        int ans = bad;

        // Step 3: Sliding Window
        int i = 0, j = good;

        while(j < n) {

            // Window se jo element nikal raha hai
            if(arr[i] > k) {
                bad--;
            }

            // Window me jo naya element aa raha hai
            if(arr[j] > k) {
                bad++;
            }

            // Minimum bad elements store karo
            ans = min(ans, bad);

            i++;
            j++;
        }

        return ans;
    }
};
```

*Generated on: 9/10/2026, 10:43:37 pm*
## 01. Zero Sum Subarray

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1?utm=codolio)

### Problem Description

**Task:** Given an array of integers, arr[]. Find if there is a subarray (of size at least one) with 0 sum. Return true/false depending upon whether there is a subarray present with 0-sum or not. Examples:Input: arr[] = [4, 2, -3, 1, 6]

#### Examples

##### Example 1

- **Output:**
```text
false
```
- **Explanation:** 0 is one of the elements in the array so there exist a subarray with sum 0.Input: arr = [1, 2, -1]

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(n)

### Accepted Solutions (11)

#### Solution 1 (Java)

- **Submitted:** 2026-10-08 22:43:23
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public boolean subArrayExists(int arr[]) {

        HashSet<Integer> set = new HashSet<>();

        int sum = 0;

        // TC: [4, 2, -3, 1, 6]
        for (int num : arr) {

            sum += num;

            // sum 0 hai -> starting se subarray ka sum 0
            if (sum == 0)
                return true;

            // same prefix sum dobara mila
            // beech ka subarray sum 0 hoga
            if (set.contains(sum))
                return true;

            set.add(sum);
        }

        return false;
    }
}
```

#### Solution 2 (Java)

- **Submitted:** 2026-07-27 17:58:00
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public boolean subArrayExists(int arr[]) {

        HashSet<Integer> ans = new HashSet<>();
        // Prefix Sum store karega.
        // HashSet O(1) average time me search (contains) aur add kar deta hai.

        int sum = 0;

        for(int num : arr){

            // arr = [4, 2, -3, 1, 6]

            sum += num;

            // num = 4
            // sum = 4
            //
            // ans = {}
            // contains(4) = false
            //
            // ans = {4}
            
            // num = 2
            // sum = 6
            //
            // ans = {4}
            // contains(6) = false
            //
            // ans = {4,6}
            
            // num = -3
            // sum = 3
            //
            // ans = {4,6}
            // contains(3) = false
            //
            // ans = {4,6,3}
            
            // num = 1
            // sum = 4
            //
            // ans = {4,6,3}
            // contains(4) = true
            //
            // Prefix Sum repeat ho gaya.
            // Subarray [2,-3,1] ka sum = 0
            //
            // return true
            // -------------------------

            if(ans.contains(sum) || sum == 0)
                return true;

            ans.add(sum);
        }

        return false;
    }
}
```

#### Solution 3 (Java)

- **Submitted:** 2026-07-27 17:57:55
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public boolean subArrayExists(int arr[]) {

        HashSet<Integer> ans = new HashSet<>();
        // Prefix Sum store karega.
        // HashSet O(1) average time me search (contains) aur add kar deta hai.

        int sum = 0;

        for(int num : arr){

            // arr = [4, 2, -3, 1, 6]

            sum += num;

            // num = 4
            // sum = 4
            //
            // ans = {}
            // contains(4) = false
            //
            // ans = {4}
            
            // num = 2
            // sum = 6
            //
            // ans = {4}
            // contains(6) = false
            //
            // ans = {4,6}
            
            // num = -3
            // sum = 3
            //
            // ans = {4,6}
            // contains(3) = false
            //
            // ans = {4,6,3}
            
            // num = 1
            // sum = 4
            //
            // ans = {4,6,3}
            // contains(4) = true
            //
            // Prefix Sum repeat ho gaya.
            // Subarray [2,-3,1] ka sum = 0
            //
            // return true
            // -------------------------

            if(ans.contains(sum) || sum == 0)
                return true;

            ans.add(sum);
        }

        return false;
    }
}
```

#### Solution 4 (Java)

- **Submitted:** 2026-07-27 17:49:51
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public boolean subArrayExists(int arr[]) {
        HashSet<Integer> ans = new HashSet<>();
        int sum = 0;
        for(int num: arr){
            sum += num;
            if(ans.contains(sum) || sum == 0) return true;
            ans.add(sum);
        }
        return false;
    }
}
```

#### Solution 5 (Java)

- **Submitted:** 2026-07-24 18:57:18
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public boolean subArrayExists(int arr[]) {
        HashSet<Integer> ans = new HashSet<>();
        int sum = 0;
        for(int num: arr){
            sum += num;
            if(ans.contains(sum) || sum == 0) return true;
            ans.add(sum);
        }
        return false;
    }
}
```

#### Solution 6 (Java)

- **Submitted:** 2026-07-24 17:33:16
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public boolean subArrayExists(int arr[]) {
        HashSet<Integer> ans = new HashSet<>();
        int sum = 0;
        for(int num: arr){
            sum += num;
            if(ans.contains(sum) || sum == 0) return true;
            ans.add(sum);
        }
        return false;
    }
}
```

#### Solution 7 (Java)

- **Submitted:** 2026-06-18 16:28:37
- **Status:** Correct
- **Marks:** 0

```java
class Solution {

    static boolean findsum(int arr[]) {

        HashSet<Integer> set = new HashSet<>();

        int prefixSum = 0;

        for (int num : arr) {

            prefixSum += num;

            // Case 1: starting se current index tak sum 0
            if (prefixSum == 0)
                return true;

            // Case 2: same prefix sum pehle aa chuka hai
            if (set.contains(prefixSum))
                return true;

            set.add(prefixSum);
        }

        return false;
    }
}
```

#### Solution 8 (Java)

- **Submitted:** 2026-06-18 16:28:31
- **Status:** Correct
- **Marks:** 0

```java
class Solution {

    static boolean findsum(int arr[]) {

        HashSet<Integer> set = new HashSet<>();

        int prefixSum = 0;

        for (int num : arr) {

            prefixSum += num;

            // Case 1: starting se current index tak sum 0
            if (prefixSum == 0)
                return true;

            // Case 2: same prefix sum pehle aa chuka hai
            if (set.contains(prefixSum))
                return true;

            set.add(prefixSum);
        }

        return false;
    }
}
```

#### Solution 9 (Java)

- **Submitted:** 2026-05-21 17:36:09
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    // Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[]) {
        // Your code here
        HashSet<Integer> arr2 = new HashSet<>();

        int sum = 0;

        // prefix sum approach
        for (int i : arr) {

            sum += i;

            // agar element 0 ho
            // ya prefix sum 0 ho
            // ya prefix sum repeat ho gaya
            if (i == 0|| sum == 0|| arr2.contains(sum)) {
                return true;
            }

            // sum store karo
            arr2.add(sum);
        }

        // agar nahi mila
        return false;
    }
}
```

#### Solution 10 (Java)

- **Submitted:** 2026-05-21 17:35:47
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    // Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[]) {
        // Your code here
        HashSet<Integer> arr2 = new HashSet<>();

        int sum = 0;

        // prefix sum approach
        for (int i : arr) {

            sum += i;

            // agar element 0 ho
            // ya prefix sum 0 ho
            // ya prefix sum repeat ho gaya
            if (i == 0|| sum == 0|| arr2.contains(sum)) {
                return true;
            }

            // sum store karo
            arr2.add(sum);
        }

        // agar nahi mila
        return false;
    }
}
```

#### Solution 11 (Java)

- **Submitted:** 2026-04-18 15:54:32
- **Status:** Correct
- **Marks:** 4

```java
class Solution {
  public:
    // Complete this function
    // Function to check whether there is a subarray present with 0-sum or not.
    bool subArrayExists(vector<int>& arr) {
        // subarray sum is equal to 0 means jha se chle the agar whi aa gye to beach k part to zero ho gya fhir 
        unordered_set<int> set;
        int sum = 0;
        for(int x: arr){
            sum += x;
            
            // agar 0 pehle se present ho array me 
            if(sum == 0) return true;
            
            if(set.count(sum)) return true; // iska mtlb beach k sara part 0 h tb hi jha se aae whi pahuch gye
            set.insert(sum);
        }
        // iska mtlb aapn n pura iterate kr diya ab aapn ko 0 n mila to false subarray k sum 0 n mila;
        return false;
    }
};
```

*Generated on: 8/10/2026, 10:47:36 pm*
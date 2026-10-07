## 01. First and Last in Sorted

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1?utm=codolio)

### Problem Description

**Task:** Given a sorted array arr[] with possibly some duplicates, find the first and last occurrences of an element x in the given array.Note: If the number x is not found in the array then return both the indices as -1.Examples:Input: arr[] = [1, 3, 5, 5, 5, 5, 67, 123, 125], x = 5

#### Examples

##### Example 1

- **Output:**
```text
[2, 5]
```
- **Explanation:** First occurrence of 5 is at index 2 and last occurrence of 5 is at index 5

##### Example 2

- **Input:**
```text
arr[] = [1, 3, 5, 5, 5, 5, 7, 123, 125], x = 7
```
- **Output:**
```text
[-1, -1]
```
- **Explanation:** No occurrence of 4 in the array, so, output is [-1, -1]

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(log n)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (2)

#### Solution 1 (Java)

- **Submitted:** 2026-10-07 22:46:33
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    ArrayList<Integer> find(int arr[], int x) {

        ArrayList<Integer> ans = new ArrayList<>();

        int first = -1, last = -1;
        int low = 0, high = arr.length - 1;

        // TC: arr = [1, 2, 4, 4, 5], x = 4

        // first occurrence
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                first = mid;
                high = mid - 1; // aur left me x check krenge
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            // mid=2 → 4 mila → first=2 → left check
        }

        // last occurrence
        low = 0;
        high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                last = mid;
                low = mid + 1; // aur right me x check krenge
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            // mid=2 → 4 mila → last=2
            // mid=3 → 4 mila → last=3
        }

        ans.add(first);
        ans.add(last);

        return ans;
    }
}

// Implement Algorithm: **First & Last Occurrence — Binary Search** 🔥
```

#### Solution 2 (Java)

- **Submitted:** 2026-10-07 22:46:24
- **Status:** Correct
- **Marks:** 4

```java
class Solution {
    ArrayList<Integer> find(int arr[], int x) {

        ArrayList<Integer> ans = new ArrayList<>();

        int first = -1, last = -1;
        int low = 0, high = arr.length - 1;

        // TC: arr = [1, 2, 4, 4, 5], x = 4

        // first occurrence
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                first = mid;
                high = mid - 1; // aur left me x check krenge
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            // mid=2 → 4 mila → first=2 → left check
        }

        // last occurrence
        low = 0;
        high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                last = mid;
                low = mid + 1; // aur right me x check krenge
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            // mid=2 → 4 mila → last=2
            // mid=3 → 4 mila → last=3
        }

        ans.add(first);
        ans.add(last);

        return ans;
    }
}

// Implement Algorithm: **First & Last Occurrence — Binary Search** 🔥
```

*Generated on: 7/10/2026, 10:46:49 pm*
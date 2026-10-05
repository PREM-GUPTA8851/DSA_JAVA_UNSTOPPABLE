## 01. Three way partitioning

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/three-way-partitioning/1?utm=codolio)

### Problem Description

**Task:** Given an array arr[] and a range a, b. The task is to partition the array around the range such that the array is divided into three parts.All elements smaller than a come first.All elements in range a to b come next.All elements greater than b appear in the end.The individual elements of three sets can appear in any order. You are required to return the modified array.Note: The generated output is true if you modify the given array successfully. Otherwise false.Examples:Input: arr[] = [1, 2, 3, 3, 4], a = 1, b = 2

#### Examples

##### Example 1

- **Output:**
```text
true
```
- **Explanation:** One possible arrangement is: {1, 2, 3, 3, 4}. If you return a valid arrangement, output will be true.

##### Example 2

- **Input:**
```text
arr[] = [1, 4, 3, 6, 2, 1], a = 1, b = 3
```
- **Output:**
```text
true
```
- **Explanation:** One possible arrangement is: {1, 3, 2, 1, 4, 6}. If you return a valid arrangement, output will be true.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (10)

#### Solution 1 (Java)

- **Submitted:** 2026-10-05 21:29:21
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public boolean threeWayPartition(int[] arr, int a, int b) {

        // Test Case:
        // arr = [1,2,3,3,4]
        // a = 1, b = 2
        // Output = true

        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        // low = 0, mid = 0, high = 4
        // arr[mid] = 1
        // 1 < a false
        // 1 <= b true -> mid++

        while(mid <= high) {

            if(arr[mid] < a) {

                // agar chhota hai to left me bhejenge
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;

                low++;
                mid++;

            } else if(arr[mid] <= b) {

                // a se b ke range me hai
                // mid ko bas aage badhayenge
                mid++;

            } else {

                // b se bada hai to right me bhejenge
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;

                high--;
            }

            // Dry Run:
            // start -> [1,2,3,3,4]
            // 1 range me -> mid = 1
            //
            // arr[mid] = 2
            // 2 range me -> mid = 2
            //
            // arr[mid] = 3
            // 3 > 2 -> 3 ko right bheja
            // array -> [1,2,4,3,3]
            // high = 3
            //
            // arr[mid] = 4
            // 4 > 2 -> right bheja
            // array -> [1,2,3,3,4]
            // high = 2
            //
            // mid = 2, high = 2
            // arr[mid] = 3
            // 3 > 2 -> right bheja
            // high = 1
            //
            // mid > high -> loop stop
        }

        return true;
    }
}
```

#### Solution 2 (Java)

- **Submitted:** 2026-06-22 15:52:38
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public void threeWayPartition(int arr[], int a, int b) {
        // dutch national flag 
        // ....<a | | a>= <=b | b>...
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        
        while(mid <= high){
            // if < a 
            if(arr[mid] < a){
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            }
            else if(arr[mid] >= a && arr[mid] <= b){
                mid++;
            } 
            else {
                // greather than b
                // swap with last
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }
    }
}
```

#### Solution 3 (Java)

- **Submitted:** 2026-06-22 15:52:32
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public void threeWayPartition(int arr[], int a, int b) {
        // dutch national flag 
        // ....<a | | a>= <=b | b>...
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        
        while(mid <= high){
            // if < a 
            if(arr[mid] < a){
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            }
            else if(arr[mid] >= a && arr[mid] <= b){
                mid++;
            } 
            else {
                // greather than b
                // swap with last
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }
    }
}
```

#### Solution 4 (Java)

- **Submitted:** 2026-06-22 15:52:24
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public void threeWayPartition(int arr[], int a, int b) {
        // dutch national flag 
        // ....<a | | a>= <=b | b>...
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        
        while(mid <= high){
            // if < a 
            if(arr[mid] < a){
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            }
            else if(arr[mid] >= a && arr[mid] <= b){
                mid++;
            } 
            else {
                // greather than b
                // swap with last
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }
    }
}
```

#### Solution 5 (Java)

- **Submitted:** 2026-06-22 15:51:39
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public void threeWayPartition(int arr[], int a, int b) {
        // dutch national flag 
        // ....<a | | a>= <=b | b>...
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        
        while(mid <= high){
            // if < a 
            if(arr[mid] < a){
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            }
            else if(arr[mid] >= a && arr[mid] <= b){
                mid++;
            } 
            else {
                // greather than b
                // swap with last
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }
    }
}
```

#### Solution 6 (Java)

- **Submitted:** 2026-06-21 12:32:14
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    // Function to partition the array around the range such
    // that array is divided into three parts.
    public void threeWayPartition(int arr[], int a, int b) {
        // 1, 4, 3, 6, 2, 1
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;  // 5
 
        while (mid <= high) {
        // 0 <= 5
        // arr[mid] = arr[0] = 1
            // Case 1: Element < a
            if (arr[mid] < a) {

                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;

                low++;
                mid++;
            }

            // Case 2: Element lies in range [a, b]
            else if (arr[mid] >= a && arr[mid] <= b) {

                mid++;
            }

            // Case 3: Element > b
            else {

                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;

                high--;

                // mid++ nahi karenge
                // kyuki high se jo element aaya hai
                // usko abhi check karna baaki hai
            }
        }
    }
}
```

#### Solution 7 (Java)

- **Submitted:** 2026-06-21 12:23:32
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    // Function to partition the array around the range such
    // that array is divided into three parts.
    public void threeWayPartition(int arr[], int a, int b) {

        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {

            // Case 1: Element < a
            if (arr[mid] < a) {

                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;

                low++;
                mid++;
            }

            // Case 2: Element lies in range [a, b]
            else if (arr[mid] >= a && arr[mid] <= b) {

                mid++;
            }

            // Case 3: Element > b
            else {

                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;

                high--;

                // mid++ nahi karenge
                // kyuki high se jo element aaya hai
                // usko abhi check karna baaki hai
            }
        }
    }
}
```

#### Solution 8 (Java)

- **Submitted:** 2026-06-21 12:23:28
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    // Function to partition the array around the range such
    // that array is divided into three parts.
    public void threeWayPartition(int arr[], int a, int b) {

        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {

            // Case 1: Element < a
            if (arr[mid] < a) {

                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;

                low++;
                mid++;
            }

            // Case 2: Element lies in range [a, b]
            else if (arr[mid] >= a && arr[mid] <= b) {

                mid++;
            }

            // Case 3: Element > b
            else {

                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;

                high--;

                // mid++ nahi karenge
                // kyuki high se jo element aaya hai
                // usko abhi check karna baaki hai
            }
        }
    }
}
```

#### Solution 9 (Java)

- **Submitted:** 2026-06-21 12:23:21
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    // Function to partition the array around the range such
    // that array is divided into three parts.
    public void threeWayPartition(int arr[], int a, int b) {

        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {

            // Case 1: Element < a
            if (arr[mid] < a) {

                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;

                low++;
                mid++;
            }

            // Case 2: Element lies in range [a, b]
            else if (arr[mid] >= a && arr[mid] <= b) {

                mid++;
            }

            // Case 3: Element > b
            else {

                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;

                high--;

                // mid++ nahi karenge
                // kyuki high se jo element aaya hai
                // usko abhi check karna baaki hai
            }
        }
    }
}
```

#### Solution 10 (Java)

- **Submitted:** 2026-06-21 12:23:08
- **Status:** Correct
- **Marks:** 2

```java
class Solution {
    // Function to partition the array around the range such
    // that array is divided into three parts.
    public void threeWayPartition(int arr[], int a, int b) {

        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {

            // Case 1: Element < a
            if (arr[mid] < a) {

                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;

                low++;
                mid++;
            }

            // Case 2: Element lies in range [a, b]
            else if (arr[mid] >= a && arr[mid] <= b) {

                mid++;
            }

            // Case 3: Element > b
            else {

                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;

                high--;

                // mid++ nahi karenge
                // kyuki high se jo element aaya hai
                // usko abhi check karna baaki hai
            }
        }
    }
}
```

*Generated on: 5/10/2026, 9:32:40 pm*
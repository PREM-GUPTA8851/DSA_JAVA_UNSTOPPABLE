## 01. Kth Smallest

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1)

### Problem Description

**Task:** Given an integer array arr[] and an integer k, find and return the k^th smallest element in the given array.Examples :Input: arr[] = [10, 5, 4, 3, 48, 6, 2, 33, 53, 10], k = 4Output: 5

#### Examples

##### Example 1

- **Explanation:** 3rd smallest element in the given array is 7.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n log k)
- **Expected Auxiliary Space Complexity:** O(k)

### Accepted Solutions (20)

#### Solution 1 (Java)

- **Submitted:** 2026-10-16 20:27:13
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
	public int kthSmallest(int[] nums, int k) {
		
		/*algorithm analysis --> aapn kth smallest ki algo
		likh rhe h so aapn k pass kth smallest hona chahiye
		so aapn kth largest ko smallest m covert krenge as
		a target element .... search space pattern define
		kiya aur fhr pivot ko assume kiya mid element then
		left boundary, current_element, aur greater
		element wali boundary lgai aur jb tk current
		element greater element wali boudary se chote h
		tb tk compare and swap kiya .... aur pivot se
		chote element h to left side m rkhenge so left
		boudary se swap kiya aur pivot se bde element h
		to right boundary m rkhenge so right boundary se
		swap krenge aur if vo current element hi pivot h
		to next element m move krenge .... then after
		that loop we check with our target index if
		target index, left boundary and right boundary
		are equal so we return that element as a kth
		smallest element .agar target element left
		boundary se chote element k side h to aap left
		boundary se peeche search space define kroge
		aur target element vo right boundary se aur
		aange h to search space pattern aapn right
		boundary se aange dhoondenge
		*/
		
		/*
		Input: nums = [3, 2, 1, 5, 6, 4], k = 2
		Output: 5
		*/
		// aapn us largest index ko smallest index m convert krke search krenge ab
		int target = k - 1;
		
		int low = 0, high = nums.length - 1;
		// low = 0, high = 5
		
		while (low <= high) {
			// 0 <= 5 -->
			// nums = [1,2,5,6,4,3]
			// 1 <= 5 -->  nums = [1,2,5,4,3,6]--> high = 4
			// 1 <= 4 -->
			
			int pivot = nums[low + (high - low) / 2];
			// pivot = nums[mid] = nums[5/2] = nums[2] = 1
			// pivot = nums[mid] = nums[3] = 6
			// pivot = nums[mid] = nums[5/2] = nums[2] = 5
			int lt = low;
			// lt = 0
			// lt = 1;
			// lt = 1
			int i = low;
			// i = 0
			// i = 1;
			// i = 1
			int gt = high;
			// gt = 5
			// gt = 5
			// gt = 4
			while (i <= gt) {
				// 0 <= 5
				// 1 <= 1
				// 1 <= 0 --> false
				// now nums = [1,2,5,6,4,3]
				
				// 1 <= 5 -> nums = [1,2,5,4,3,6]
				// 1 <= 4 ->
				
				if (nums[i] < pivot) {
					// First iteration mein ye condition true nahi hui.
					
					// 2 < 6
					// 5 < 6
					// 4 < 6 --> nums = [1,2,5,4,6,3]
					// 3 < 6 --> nums = [1,2,5,4,3,6]
					int temp = nums[lt];
					nums[lt] = nums[i];
					nums[i] = temp;
					
					lt++; // 3, 4, 5
					// 2, 3, 4
					// nums = [1,2,5,4,3,6]-->[1,2,4,5,3,6]--> [1,2,4,3,5,6]
					i++; // 4, 5, 6
					// 2, 3, 4, 5
					
				} else if (nums[i] > pivot) {
					// 3 > 1
					// 4 > 1
					// 6 > 1
					// 5 > 1
					
					int temp = nums[i];
					nums[i] = nums[gt];
					nums[gt] = temp;
					gt--;
					
					// nums = [4,2,1,5,6,3]
					// nums = [6,2,1,5,4,3]
					// nums = [5,2,1,6,4,3]
					// nums = [1,2,5,6,4,3]
					// nums = [1,2,5,6,4,3]
					
				} else {
					i++;
					// i = 1
				}
			}
			
			if (target < lt) {
				// 4 < 0 --> false
				high = lt - 1;
				// 4 < 5 --> high = 5-1 = 4
			} else if (target > gt) {
				// 4 > 0 --> true
				low = gt + 1;
				// low = 1
				
			} else {
				/// lt = 4, gt = 4, target = 4
				return pivot;
				// return 5;
			}
		}
		
		return - 1;
}
}
```

#### Solution 2 (Java)

- **Submitted:** 2026-10-16 20:26:15
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int kthSmallest(int[] arr, int k) {
        // kth smallest element by using quick select
        // firstly define the search space pattern
        int low = 0;
        int high = arr.length - 1; 
        int target = k - 1;// 
        while(low <= high){
            // define the pivot element mid of Search_space pattern
            int pivot = arr[low + (high - low) / 2];
            
            // then define 3 boundaries as well
            // left boundary 
            int lt = low;
            // current element pivot boundary
            int i = low;
            // right boundary
            int rt = high;
            // jb tk swap krte rhenge tb tk current element right boundary se chota y barabar n ho jae
            
            while(i<= rt){
                // aese element mile jo pivot element se chote element ho to unhe aapn left wali boundary k side bhejenge 
                if(arr[i] < pivot){
                    int temp = arr[lt];
                    arr[lt] = arr[i];
                    arr[i] = temp;
                    lt++;
                    i++;
                }
                // aese element jo pivot element se bde ho aur vo right boundary m bhejenge
                else if(arr[i] > pivot){
                    int temp = arr[rt];
                    arr[rt] = arr[i];
                    arr[i] = temp;
                    rt--;
                }
                else {
                    i++;
                }
            }
            // now check about boundaries 
            if(target > rt){
                // aange dhodoge
                low = rt + 1;
            }
            else if(target < lt){
                high = lt - 1;
            } 
            // agar target index, left boundary , right boundary sb equal h to whi pivot h
            else {
                return pivot;
            }
        }
        return -1;
    }
}
```

#### Solution 3 (Java)

- **Submitted:** 2026-10-16 20:06:52
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
	public int kthSmallest(int[] nums, int k) {
		
		/*algorithm analysis --> aapn kth smallest ki algo 
         likh rhe h so aapn k pass kth smallest hona chahiye
          so aapn kth largest ko smallest m covert krenge as 
          a target element .... search space pattern define 
          kiya aur fhr pivot ko assume kiya mid element then
           left boundary , current_element , aur greater 
           element wali boundary lgai aur jb tk current 
           element greater element wali boudary se chote h 
           tb tk compare and swap kiya .... aur pivot se 
           chote element h to left side m rkhenge so left 
           boudary se swap kiya aur pivot se bde element h 
           to right boundary m rkhenge so right boundary se
            swap krenge aur if vo current element hi pivot h
             to next element m move krenge .... then after 
             that loop we check with our target index if 
             target index , left boundary and right boundary 
             are equal so we return that element as a kth 
             smallest element .agar target element left 
             boundary se chote element k side h to aap left 
             boundary se peeche search space define kroge 
             aur target element vo right boundary se aur 
             aange h to search space pattern aapn right 
             boundary se aange dhoondenge 
         */
		/*
		Input: nums = [3, 2, 1, 5, 6, 4], k = 2
		Output: 5
		*/
		// aapn us largest index ko smallest index m convert krke search krenge ab
		int target =  k - 1;
		// target = n - k = 6 - 2 = 4
		
		int low = 0, high = nums.length - 1;
		// low = 0, high = 5
		
		while (low <= high) {
			// 0 <= 5 -->
			// nums = [1,2,5,6,4,3]
			// 1 <= 5 -->  nums = [1,2,5,4,3,6]--> high = 4
			// 1 <= 4 -->
			
			int pivot = nums[low + (high - low) / 2];
			// pivot = nums[mid] = nums[5/2] = nums[2] = 1
			// pivot = nums[mid] = nums[3] = 6
			// pivot = nums[mid] = nums[5/2] = nums[2] = 5
			int lt = low;
			// lt = 0
			// lt = 1;
			// lt = 1
			int i = low;
			// i = 0
			// i = 1;
			// i = 1
			int gt = high;
			// gt = 5
			// gt = 5
			// gt = 4
			while (i <= gt) {
				// 0 <= 5
				// 1 <= 1
				// 1 <= 0 --> false
				// now nums = [1,2,5,6,4,3]
				
				// 1 <= 5 -> nums = [1,2,5,4,3,6]
				// 1 <= 4 ->
				
				if (nums[i] < pivot) {
					// First iteration mein ye condition true nahi hui.
					
					// 2 < 6
					// 5 < 6
					// 4 < 6 --> nums = [1,2,5,4,6,3]
					// 3 < 6 --> nums = [1,2,5,4,3,6]
					int temp = nums[lt];
					nums[lt] = nums[i];
					nums[i] = temp;
					
					lt++; // 3, 4, 5
					// 2, 3, 4
					// nums = [1,2,5,4,3,6]-->[1,2,4,5,3,6]--> [1,2,4,3,5,6]
					i++; // 4, 5, 6
					// 2, 3, 4, 5
					
				} else if (nums[i] > pivot) {
					// 3 > 1
					// 4 > 1
					// 6 > 1
					// 5 > 1
					
					int temp = nums[i];
					nums[i] = nums[gt];
					nums[gt] = temp;
					gt--;
					
					// nums = [4,2,1,5,6,3]
					// nums = [6,2,1,5,4,3]
					// nums = [5,2,1,6,4,3]
					// nums = [1,2,5,6,4,3]
					// nums = [1,2,5,6,4,3]
					
				} else {
					i++;
					// i = 1
				}
			}
			
			if (target < lt) {
				// 4 < 0 --> false
				high = lt - 1;
				// 4 < 5 --> high = 5-1 = 4
			} else if (target > gt) {
				// 4 > 0 --> true
				low = gt + 1;
				// low = 1
				
			} else {
				/// lt = 4, gt = 4, target = 4
				return pivot;
				// return 5;
			}
		}
		
		return - 1;
	}
}
```

#### Solution 4 (Java)

- **Submitted:** 2026-09-28 23:26:38
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int kthSmallest(int[] arr, int k) {

        int left = 0;
        int right = arr.length - 1;

        // k-th smallest ka index = k - 1
        int target = k - 1;

        while(left <= right) {

            // right wale element ko pivot maan rahe hain
            int pivot = arr[right];

            int p = left;

            // pivot se chhote elements ko left side me laayenge
            for(int i = left; i < right; i++) {

                if(arr[i] <= pivot) {

                    int temp = arr[i];
                    arr[i] = arr[p];
                    arr[p] = temp;

                    p++;
                }
            }

            // pivot ko correct position par rakh denge
            int temp = arr[p];
            arr[p] = arr[right];
            arr[right] = temp;

            // pivot target position par mil gaya
            if(p == target) {
                return arr[p];
            }

            // target right side me hai
            if(p < target) {
                left = p + 1;
            }

            // target left side me hai
            else {
                right = p - 1;
            }
        }

        return -1;
    }
}
```

#### Solution 5 (Java)

- **Submitted:** 2026-09-28 23:25:24
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int kthSmallest(int[] arr, int k) {

        int left = 0;
        int right = arr.length - 1;

        // k-th smallest ka index = k - 1
        int target = k - 1;

        while(left <= right) {

            // right wale element ko pivot maan rahe hain
            int pivot = arr[right];

            int p = left;

            // pivot se chhote elements ko left side me laayenge
            for(int i = left; i < right; i++) {

                if(arr[i] <= pivot) {

                    int temp = arr[i];
                    arr[i] = arr[p];
                    arr[p] = temp;

                    p++;
                }
            }

            // pivot ko correct position par rakh denge
            int temp = arr[p];
            arr[p] = arr[right];
            arr[right] = temp;

            // pivot target position par mil gaya
            if(p == target) {
                return arr[p];
            }

            // target right side me hai
            if(p < target) {
                left = p + 1;
            }

            // target left side me hai
            else {
                right = p - 1;
            }
        }

        return -1;
    }
}
```

#### Solution 6 (Java)

- **Submitted:** 2026-07-03 19:24:58
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int kthSmallest(int[] arr, int k) {
        // firstly sort then return k-1th element
        Arrays.sort(arr);
        return arr[k-1];
    }
}
```

#### Solution 7 (Java)

- **Submitted:** 2026-07-03 19:24:48
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int kthSmallest(int[] arr, int k) {
        // firstly sort then return k-1th element
        Arrays.sort(arr);
        return arr[k-1];
    }
}
```

#### Solution 8 (Java)

- **Submitted:** 2026-07-03 19:23:41
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int kthSmallest(int[] arr, int k) {
        // Code here
        Arrays.sort(arr);
        return arr[k-1];
    }
}
```

#### Solution 9 (Java)

- **Submitted:** 2026-07-03 19:23:36
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int kthSmallest(int[] arr, int k) {
        // Code here
        Arrays.sort(arr);
        return arr[k-1];
    }
}
```

#### Solution 10 (Java)

- **Submitted:** 2026-07-03 19:23:31
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int kthSmallest(int[] arr, int k) {
        // Code here
        Arrays.sort(arr);
        return arr[k-1];
    }
}
```

#### Solution 11 (Java)

- **Submitted:** 2026-07-03 19:21:56
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int kthSmallest(int[] arr, int k) {
        // Code here
        Arrays.sort(arr);
        return arr[k-1];
    }
}
```

#### Solution 12 (Java)

- **Submitted:** 2026-07-03 19:21:44
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int kthSmallest(int[] arr, int k) {
        // Code here
        Arrays.sort(arr);
        return arr[k-1];
    }
}
```

#### Solution 13 (Java)

- **Submitted:** 2026-07-03 19:21:35
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int kthSmallest(int[] arr, int k) {
        // Code here
        Arrays.sort(arr);
        return arr[k-1];
    }
}
```

#### Solution 14 (Java)

- **Submitted:** 2026-07-03 19:21:30
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int kthSmallest(int[] arr, int k) {
        // Code here
        Arrays.sort(arr);
        return arr[k-1];
    }
}
```

#### Solution 15 (Java)

- **Submitted:** 2026-07-03 19:21:24
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int kthSmallest(int[] arr, int k) {
        // Code here
        Arrays.sort(arr);
        return arr[k-1];
    }
}
```

#### Solution 16 (Java)

- **Submitted:** 2025-11-12 19:53:45
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
  public:
    int kthSmallest(vector<int> &arr, int k) {
        sort(arr.begin(), arr.end());
        return arr[k - 1];
    }
};
```

#### Solution 17 (Java)

- **Submitted:** 2025-09-19 22:43:30
- **Status:** Correct
- **Marks:** 0

```java
// User function template for C++

class Solution {
  public:
    // arr : given array
    // k : find kth smallest element and return using this function
    int kthSmallest(vector<int> &arr, int k) {
        sort(arr.begin(), arr.end());
        return arr[k - 1];
    }
};
```

#### Solution 18 (Java)

- **Submitted:** 2025-09-19 22:43:19
- **Status:** Correct
- **Marks:** 0

```java
// User function template for C++

class Solution {
  public:
    // arr : given array
    // k : find kth smallest element and return using this function
    int kthSmallest(vector<int> &arr, int k) {
        sort(arr.begin(), arr.end());
        return arr[k - 1];
    }
};
```

#### Solution 19 (Java)

- **Submitted:** 2025-09-19 22:43:12
- **Status:** Correct
- **Marks:** 0

```java
// User function template for C++

class Solution {
  public:
    // arr : given array
    // k : find kth smallest element and return using this function
    int kthSmallest(vector<int> &arr, int k) {
        sort(arr.begin(), arr.end());
        return arr[k - 1];
    }
};
```

#### Solution 20 (Java)

- **Submitted:** 2025-09-19 22:42:50
- **Status:** Correct
- **Marks:** 4

```java
// User function template for C++

class Solution {
  public:
    // arr : given array
    // k : find kth smallest element and return using this function
    int kthSmallest(vector<int> &arr, int k) {
        sort(arr.begin(), arr.end());
        return arr[k - 1];
    }
};
```

*Generated on: 16/10/2026, 8:30:52 pm*
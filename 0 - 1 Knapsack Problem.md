## 01. 0 - 1 Knapsack Problem

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1)

### Problem Description

**Task:** Given two arrays, val[] and wt[], where each element represents the value and weight of an item respectively, and an integer W representing the maximum capacity of the knapsack (the total weight it can hold).Put the items into the knapsack such that the total value obtained is maximum without exceeding the capacity W.Note: You can either include an item completely or exclude it entirely — fractional selection of items is not allowed. Each item is available only once.Examples :Input: W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1]Output: 3Explanation: Choose the last item, which weighs 1 unit and has a value of 3.Input: W = 3, val[] = [1, 2, 3], wt[] = [4, 5, 6] Output: 0Explanation: Every item has a weight exceeding the knapsack's capacity (3).Input: W = 5, val[] = [10, 40, 30, 50], wt[] = [5, 4, 2, 3] Output: 80Explanation: Choose the third item (value 30, weight 2) and the last item (value 50, weight 3) for a total value of 80.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O (n * W)
- **Expected Auxiliary Space Complexity:** O (W)

### Accepted Solutions (2)

#### Solution 1 (Java)

- **Submitted:** 2026-10-17 20:17:38
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int knapsack(int W, int val[], int wt[]) {
       
        	// Problem Explanation:
		// Humein items ke weights aur values diye hain aur bag ki capacity W hai.
		// Humein maximum value find karni hai without exceeding capacity.
		// Har item ko ya toh ek baar le sakte hain ya skip kar sakte hain.
		// dp[w] = capacity w par maximum possible value.
		// Har item ke liye do choices hain: skip ya take.
		// Skip -> dp[w], Take -> val[i] + dp[w - wt[i]].
		// Dono mein se maximum value dp[w] mein store hogi.
		// Reverse loop current item ko dobara use hone se rokta hai.
		
		// TC: wt = [1,3,4], val = [15,20,30], W = 4
		// Expected Output: 35
		
		int n = wt.length;
		int[] dp = new int[W + 1];
		
		// Initial: dp = [0,0,0,0,0]
		// Indices:   0 1 2 3 4
		// Abhi koi item process nahi hua, isliye values 0 hain.
		
		for (int i = 0; i < n; i++) {
			
			// i=0 -> weight=1, value=15
			// i=1 -> weight=3, value=20
			// i=2 -> weight=4, value=30
			
			for (int w = W; w >= wt[i]; w--) {
				
				dp[w] = Math.max(dp[w], val[i] + dp[w - wt[i]]);
				
				//ITEM 0: wt = 1, val = 15
				// w=4 -> max(0, 15+dp[3]) = 15
				// dp = [0,0,0,0,15]
				//
				// w=3 -> max(0, 15+dp[2]) = 15
				// dp = [0,0,0,15,15]
				//
				// w=2 -> max(0, 15+dp[1]) = 15
				// dp = [0,0,15,15,15]
				//
				// w=1 -> max(0, 15+dp[0]) = 15
				// dp = [0,15,15,15,15]
				//
				// Item 0 ke baad:
				// dp = [0,15,15,15,15]
				
				// ITEM 1: wt=3, val=20
				// w=4 -> max(15, 20+dp[1]) = 35
				// Yahan weight 3 + weight 1 = 4.
				// Value = 20 + 15 = 35.
				// dp = [0,15,15,15,35]
				//
				// w=3 -> max(15, 20+dp[0]) = 20
				// Weight 3 wala item akela liya.
				// dp = [0,15,15,20,35]
				//
				// Item 1 ke baad:
				// dp = [0,15,15,20,35]
				
				// ITEM 2: wt=4, val=30
				// w=4 -> max(35, 30+dp[0]) = 35
				// Item ka value 30 hai, lekin pehle se 35 possible hai.
				// Isliye maximum 35 hi rahega.
				// dp = [0,15,15,20,35]
			}
		}
		
		return dp[W]; // dp[4] = 35
		
		// Final Answer: 35
		// Best choice: weight 1 + weight 3 = capacity 4
		// Total value: 15 + 20 = 35
    }
}
```

*Generated on: 17/10/2026, 8:17:58 pm*

class Solution {
	public int countOccurence(int[] arr, int k) {
		
		// arr = [3,1,2,2,1,2,3,3]
		// k = 4
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int num : arr) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		// 3 -> 1
		// 1 -> 1
		// 2 -> 1
		// 2 -> 2
		// 1 -> 2
		// 2 -> 3
		// 3 -> 2
		// 3 -> 3
		
		int count = 0;
		
		for (int num : map.keySet()) {
			if (map.get(num) > arr.length / k)
				count++;
			
			// 1 -> 2 > 2 false
			// 2 -> 3 > 2 true  -> count=1
			// 3 -> 3 > 2 true  -> count=2
		}
		
		return count;
		// 2
	}
}

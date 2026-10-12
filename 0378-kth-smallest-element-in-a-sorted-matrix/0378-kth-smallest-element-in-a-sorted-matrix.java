class Solution {
    public int kthSmallest(int[][] mat, int k) {
        
    int req = k - 1;

		// median k pehle req elements hone chahiye 
		int min_ = Integer.MAX_VALUE;
		int max_ = Integer.MIN_VALUE;

		for(int[] row: mat){
		    min_ = Math.min(min_, row[0]);
		    max_ = Math.max(max_, row[mat[0].length - 1]);
		}

		// we have search space pattern as well
		int start = min_;
		int end = max_;
		while(start < end){
		    int mid = start + (end - start) / 2;

		    int count = 0;
		    for(int[] row: mat){
		        count += Up(row, mid);
		    }

		    if(count <= req){
		        start = mid + 1;
		    }
		    else {
		        end = mid;
		    }

		}
		return start;

	}
	// us particular row m kitne elements h jo ki mid se chote aur equal h hume vo count krne h 
	public int Up(int[] row, int target){
	    int low = 0;
	    int high = row.length;// 3
	    while(low < high){
	        int mid_ = low + (high - low)/ 2;
	        if(row[mid_] <= target){
	            low = mid_ + 1;
	        }
	        else {
	            high = mid_;
	        }
	    }
	    return low;
	}
}
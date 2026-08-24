class Solution {
public ArrayList<ArrayList<Integer>> mergeOverlap(int[][] arr) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    // firstly sort the 2D array based on their first value
    Arrays.sort(arr , (a, b) -> Integer.compare(a[0], b[0]));
    // then taking two pointer's start and end 
    int start = arr[0][0]; // 1
    int end = arr[0][1]; // 3
    // start pointing the first interval 0th index
    // end pointing the first interval 1th index
    
    // applying a loop at each iteration 
    for(int i = 1; i < arr.length; i++){
        
    // check the cdn if current (interval 0th index) 
    // < end index of previous interval then 
    // updation of end in current interval 1th index
    
    if(arr[i][0] <= end) { // 2 < 3 --> true
            end = Math.max(end,arr[i][1]); //  4
    }
    else {
        ans.add(new ArrayList<>(Arrays.asList(start, end)));
        start = arr[i][0];
        end = arr[i][1];
    }
    // else otherwise 
    // add start, end in array list 
    // update start , end in array list
    }
    
    ans.add(new ArrayList<>(Arrays.asList(start, end)));
    return ans;
    
    
}
}
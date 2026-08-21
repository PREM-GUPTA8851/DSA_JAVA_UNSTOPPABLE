class Solution {
    int search(int[] nums, int target) {
    // [4,5,6,7,0,1,2] 
        // pehle pivot find kr lo then 
        int pivot = -1;
        for(int i = nums.length - 1; i > 0 ; i--){
            if(nums[i - 1] > nums[i]) pivot = i -1;
        }
        // binary search 2 part m lgao pehle starting se pivot index tk 
        int ansl = BS(nums, 0, pivot, target);
        // then pivot index se array k last index tk 
        int ansr = BS(nums, pivot + 1, nums.length -1, target);
        if(ansl != -1) return ansl;
        else if(ansr != -1) return ansr;

        return -1;
    }

    int BS(int[] nums, int start, int end, int target){
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target) {
                // right jao 
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
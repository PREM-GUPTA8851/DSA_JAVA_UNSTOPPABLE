class Solution {
    public int findDuplicate(int[] nums) {

        // by using floyd's cycle detection algorithm
        // dry run --> [1,3,4,2,2]
        // DRY RUN --> [3,1,3,4,2]
        // firstly we check duplicate exist or not
        int slow = nums[0]; // 1 
        // 3 
        int fast = nums[0]; // 1
        // 3
        // pehle aapn check krte h duplicate exist krta h y nhi
        do {
            slow = nums[slow];  // ek ko 1 step  
            // 3, 2
            // 4, 2, 3
            fast = nums[nums[fast]]; // doosre ko 2 step
            //2, 2
            // 2, 4, 3
        } while (slow != fast);
        // to ek ko starting point p krte h 
        // doosre ko meeting point p 
        slow = nums[0]; // 1
        // 3
         while(slow != fast){
            slow = nums[slow]; 
            // 3 2
            fast = nums[fast];
            // 4 2
        }

        return slow; // 2
        // 3
    }
}
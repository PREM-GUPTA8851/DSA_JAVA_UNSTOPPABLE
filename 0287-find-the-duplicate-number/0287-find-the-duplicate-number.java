class Solution {
    public int findDuplicate(int[] nums) {

        // by using floyd's cycle detection algorithm
        // Tortoise and hare
        // firstly we check duplicate exist or not
        int slow = nums[0];
        int fast = nums[0];
        // pehle aapn check krte h duplicate exist krta h y nhi
         do {
            slow = nums[slow];  // ek ko 1 step 
            fast = nums[nums[fast]]; // doosre ko 2 step
        } while (slow != fast);
        // to ek ko starting point p krte h 
        // doosre ko meeting point p 
        slow = nums[0];
         while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
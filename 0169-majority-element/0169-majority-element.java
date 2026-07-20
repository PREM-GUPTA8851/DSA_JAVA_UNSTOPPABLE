class Solution {
    public int majorityElement(int[] nums) {
        int element=0,count=0;
        for(int i:nums){
            if(count==0){
                element=i;
            }
            if(i == element){
                count++;
            }else{
                count--;
            }
            
            
        }
        return element;
    }
}
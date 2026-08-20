class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
    // hash map m pehle store krenge 
    for(int i = 0; i < nums.length; i++){
    map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }
    for(int num: map.keySet()){
        if(map.get(num) > nums.length/2){
            return num;
        }
    }
    return -1;
    }
}
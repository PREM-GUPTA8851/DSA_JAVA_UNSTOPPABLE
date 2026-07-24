class Solution {
    public int[] rearrangeArray(int[] nums) {
      // firstly 2 arraylist create krenge
    ArrayList<Integer> pos = new ArrayList<>();
    ArrayList<Integer> neg = new ArrayList<>(); 
      // +ve and -ve
    for(int num: nums){
      //+ve m +ve element store honge
    if(num > 0) pos.add(num);
    else neg.add(num);
      // -ve m -ve element store honge
    }

    // then same array m pehle +ve element then -ve element  store krenge.
    int index = 0;
    int i = 0;
    int j = 0;
    while(i < pos.size() && j < neg.size()){
        nums[index++] = pos.get(i++);
        nums[index++] = neg.get(j++);
    }
      // then return krenge same array
    return nums;
    }
}
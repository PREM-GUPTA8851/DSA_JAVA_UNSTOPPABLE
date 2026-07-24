class Solution {
    public boolean subArrayExists(int arr[]) {
        HashSet<Integer> ans = new HashSet<>();
        int sum = 0;
        for(int num: arr){
            sum += num;
            if(ans.contains(sum) || sum == 0) return true;
            ans.add(sum);
        }
        return false;
    }
}
class Solution {
    public static ArrayList<Integer> valEqualToPos(int[] arr) {
    // indexing 0 se start krenge aur fhr 
    ArrayList<Integer> ans = new ArrayList<>();
    for(int i = 0; i < arr.length; i++){
    // jo number index + 1 k equal hoga usko arraylist m
    if(i + 1 == arr[i]) ans.add(arr[i]);
    // add krte jaenge 
    }
    return ans;
    }
}

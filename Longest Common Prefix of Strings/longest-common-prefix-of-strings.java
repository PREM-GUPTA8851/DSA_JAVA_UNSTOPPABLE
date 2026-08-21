class Solution {
    public String longestCommonPrefix(String arr[]) {
    // logic is pehle aapn ek word pkd lete h then baki check krte jaate h 
    // ki baki word us first word se start hote h y nhi 
    // jb tk n ho rha tb tk prefix wali length ko aapn small krte jaenge.
        String prefix = arr[0]; // geeksforgeeks
        
        for(int i = 1; i < arr.length; i++){
            while(!arr[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
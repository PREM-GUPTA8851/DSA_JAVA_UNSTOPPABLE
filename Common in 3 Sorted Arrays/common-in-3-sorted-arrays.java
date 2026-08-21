class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
    ArrayList<Integer> ans = new ArrayList<>();
    int i = 0; 
    int j = 0;
    int k = 0;
    
    while(i < a.length && j < b.length && k < c.length){
        // skip duplicates
        
        // jb common elements mil jae tb
        if(a[i] == b[j] && b[j]== c[k]){
             ans.add(a[i]);
            int righta = a[i];
        while(i < a.length && righta == a[i]){
            i++;
        }
        int rightb = b[j];
        while(j < b.length && rightb == b[j]){
            j++;
        }
        int rightc = c[k];
        while(k < c.length && rightc == c[k]){
            k++;
        }
        }
        else if(a[i] < b[j]) i++;
        else if(b[j] < c[k]) j++;
        else k++;
    }
    return ans;
    }
}
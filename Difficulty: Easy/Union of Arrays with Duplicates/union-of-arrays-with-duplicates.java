class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        // code here
        // we use Tree_set for union of 2 arrays
        TreeSet<Integer> ans = new TreeSet<>();
        // now add elements in tree_set
        for(int num: a) ans.add(num);
        for(int num: b) ans.add(num);
        
        return new ArrayList<>(ans);
    }
}
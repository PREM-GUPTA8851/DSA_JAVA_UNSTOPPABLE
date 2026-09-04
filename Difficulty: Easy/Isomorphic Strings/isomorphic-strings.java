class Solution {

    public boolean areIsomorphic(String s1, String s2) {

        // length different hai to mapping possible hi nahi
        if (s1.length() != s2.length()) return false;

        int[] map1 = new int[26]; // s1 -> s2 mapping
        int[] map2 = new int[26]; // s2 -> s1 mapping

        for (int i = 0; i < s1.length(); i++) {

            int a = s1.charAt(i) - 'a';
            int b = s2.charAt(i) - 'a';

            // dono characters pehle map hue hain,
            // but ek dusre ko map nahi kar rahe -> invalid
            if (map1[a] != map2[b]) return false;

            // current mapping store kar do
            map1[a] = i + 1;
            map2[b] = i + 1;

            // TC1: s1="egg", s2="add"
            // i=0 -> e,d -> dono 0 -> valid
            // map1[e]=1, map2[d]=1
            // i=1 -> g,d -> 0 != 1 -> false
            // isliye current code yaha false return karega
        }

        return true;
    }
}
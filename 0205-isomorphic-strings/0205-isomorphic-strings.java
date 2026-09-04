class Solution {

    public boolean isIsomorphic(String s1, String s2) {

        // length different hai to mapping possible hi nahi
        if (s1.length() != s2.length()) return false;

        int[] map1 = new int[256]; // s1 -> s2 mapping
        int[] map2 = new int[256]; // s2 -> s1 mapping

        for (int i = 0; i < s1.length(); i++) {

            int a = s1.charAt(i);
            int b = s2.charAt(i);

            // dono characters pehle map hue hain,
            // but ek dusre ko map nahi kar rahe -> invalid
            if (map1[a] != map2[b]) return false;

            // current mapping store kar do
            map1[a] = i + 1;
            map2[b] = i + 1;

            // TC1: s1="egg", s2="add"
            // i=0 -> e,d
            // map1[e]=0, map2[d]=0 -> same
            // e=1, d=1

            // i=1 -> g,d
            // map1[g]=0, map2[d]=1 -> different
            // yaha false return ho jayega

            // TC2: s1="foo", s2="bar"
            // i=0 -> f,b -> 0=0 -> valid
            // f=1, b=1

            // i=1 -> o,a -> 0=0 -> valid
            // o=2, a=2

            // i=2 -> o,r -> 2!=0
            // false return
        }

        return true;
    }
}


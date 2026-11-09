
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // Key = sorted string
        // Value = us key se match karne wali strings
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            // String ko character array mein convert karo
            char[] arr = s.toCharArray();

            // Characters ko sort karo
            Arrays.sort(arr);

            // Sorted characters se key banao
            String key = new String(arr);

            // Agar key pehle se nahi hai, toh new group banao
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Original string ko uske group mein add karo
            map.get(key).add(s);
        }

        // HashMap ke saare groups return karo
        return new ArrayList<>(map.values());
    }
}

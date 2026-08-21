class Solution {
    public int secFrequent(String[] arr) {
        // second most repeated string in a sequence
        
        // hashing 
    HashMap<String, Integer> map = new HashMap<>();
    // firstly use hashing to store frequency of an string
    for(String s: arr){
        map.put(s, map.getOrDefault(s, 0) + 1);
    }
        // after store string , freq into hashmap 
        // check which key have value 2nd hghest
    int first = -1;
    int second = -1;
    
     for(int freq: map.values()){
        
        if(arr.length == freq){
            return -1;
        }
     }
     
    for(int freq: map.values()){
        if(freq > first) {
            second = first;
            first = freq;
        }
        else if(freq > second && freq != first){
            second = freq;
        }
        
    }
    // if there is only one unique string in the array return -1;
    
    return second;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hashMAP = new HashMap();
        int longest = 0, count = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (hashMAP.containsKey(c))
            {
                i = hashMAP.get(c);
                hashMAP.clear();
                count = 0;
            }
            else
            {
                hashMAP.put(c, i);
                count = count + 1;
            }
            
            longest = (longest < count)? count : longest;
        }
        
        return longest;
    }
}
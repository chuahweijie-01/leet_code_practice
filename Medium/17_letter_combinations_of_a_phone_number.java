class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<>();
        
        if (digits.length() == 0) return result;
        
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        backTracking("", 0, result, digits, map);
        
        return result;
    }
    
    public void backTracking (String s, int index, List<String> result, String digits, HashMap<Character, String> map)
    {
        if (index == digits.length())
        {
            result.add(s);
            return;
        }
        
        String alpha = map.get(digits.charAt(index));
        
        for (int i = 0; i < alpha.length(); i++)
        {
            s = s + alpha.charAt(i);
            backTracking(s, index + 1, result, digits, map);
            s = s.substring(0, s.length() - 1);
        }
    }
}
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTracking(result, "", 0, 0, n);
        
        return result;
    }
    
    public void backTracking(List<String> result, String s, int open, int close, int n)
    {
        if (open == n && close == n)
        {
            result.add(s);
            return;
        }
        
        if (open < n)
        {
            s = s + "(";
            backTracking(result, s, open + 1, close, n);
            s = s.substring(0, s.length() - 1);
        }
        
        if (open > close)
        {
            s = s + ")";
            backTracking(result, s, open, close + 1, n);
            s = s.substring(0, s.length() - 1);
        }
    }
}
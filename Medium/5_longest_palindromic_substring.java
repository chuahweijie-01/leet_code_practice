class Solution {
    public String longestPalindrome(String s) {
        int start = 0, sublen = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            int len1 = getPalindromeLength(s, i, i);
            int len2 = getPalindromeLength(s, i, i+1);
            int len3 = Math.max(len1, len2);
            
            if (len3 > sublen)
            {
                start = i - (len3 - 1)/2;
                sublen = len3;
            }
        }
        
        return s.substring(start, start + sublen);
    }
    
    public int getPalindromeLength(String s, int left, int right)
    {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
        {
            left--;
            right++;
        }
        
        return right - left - 1;
    }
}
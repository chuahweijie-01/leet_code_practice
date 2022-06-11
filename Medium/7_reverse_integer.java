class Solution {
    public int reverse(int x) {
        int flag = 1;
        
        if (x < 0)
        {
            flag = -1;
            x = x * flag;
        }
        
        long reverse = 0;
        
        while (x > 0)
        {
            reverse = (reverse * 10) + (x % 10);
            x = x/10;
        }
        
        if (reverse > Integer.MAX_VALUE)
        {
            return 0;
        }
        
        return (int) reverse * flag;
    }
}
class Solution {
    public String convert(String s, int numRows) {
        
        StringBuilder[] sb = new StringBuilder[numRows];
        
        for (int i = 0; i < numRows; i++)
        {
            sb[i] = new StringBuilder();
        }
        
        char[] arr = s.toCharArray();
        int n = s.length();
        int index = 0;
        
        while (index < n)
        {
            for (int i = 0; i < numRows && index < n; i++)
            {
                sb[i].append(arr[index++]);
            }
            
            for (int i = numRows - 2 ; i > 0 && index < n; i--)
            {
                sb[i].append(arr[index++]);
            }
        }
        
        StringBuilder res = sb[0];
        
        for (int i = 1; i < numRows; i++)
        {
            res.append(sb[i]);
        }
        
        return res.toString();
        
    }
}
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> carry = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
                
        backTracking(result, carry, candidates, target, 0);
        
        return result;
    }
    
    public void backTracking(List<List<Integer>> result, List<Integer> carry, int[] candidates, int target, int start){
        
        if (target == 0)
        {
            result.add(new ArrayList<>(carry));
            return;
        }
        
        if (target < 0)
        {
            return;
        }
        
        for (int i = start; i < candidates.length; i++)
        {
            carry.add(candidates[i]);
            backTracking(result, carry, candidates, target - candidates[i], i);
            carry.remove(carry.size() - 1);
        }
        
    }
}
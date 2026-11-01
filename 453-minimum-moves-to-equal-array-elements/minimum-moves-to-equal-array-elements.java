class Solution {
    public int minMoves(int[] nums) {
         int min = nums[0], sum = 0;

        for (int n : nums)
            min = Math.min(min, n);

        for (int n : nums)
            sum += n - min;

        return sum;  
    }
}
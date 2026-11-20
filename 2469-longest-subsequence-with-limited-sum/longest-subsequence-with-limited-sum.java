class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
    Arrays.sort(nums);

        int n = nums.length;
        int[] prefix = new int[n];

        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index = Arrays.binarySearch(prefix, queries[i]);

            if (index < 0) {
                index = -index - 2;
            }

            ans[i] = index + 1;
        }

        return ans;
    }
}
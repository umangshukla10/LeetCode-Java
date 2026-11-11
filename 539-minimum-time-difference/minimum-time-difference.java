class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = new ArrayList<>();

        for (String time : timePoints) {
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3, 5));

            minutes.add(h * 60 + m);
        }

        Collections.sort(minutes);

        int ans = 1440;

        for (int i = 1; i < minutes.size(); i++) {
            ans = Math.min(ans, minutes.get(i) - minutes.get(i - 1));
        }

       
        int circular = 1440 - minutes.get(minutes.size() - 1)
                             + minutes.get(0);

        ans = Math.min(ans, circular);

        return ans;
    }
}
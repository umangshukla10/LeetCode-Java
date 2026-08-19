import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Set<Integer>> reserved = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            reserved
                .computeIfAbsent(row, k -> new HashSet<>())
                .add(col);
        }

        
        int answer = (n - reserved.size()) * 2;

        for (Set<Integer> seats : reserved.values()) {

            boolean left = true;   
            boolean middle = true; 
            boolean right = true;  

            for (int seat : seats) {
                if (seat >= 2 && seat <= 5) {
                    left = false;
                }

                if (seat >= 4 && seat <= 7) {
                    middle = false;
                }

                if (seat >= 6 && seat <= 9) {
                    right = false;
                }
            }

            if (left && right) {
                answer += 2;
            } else if (left || middle || right) {
                answer += 1;
            }
        }

        return answer;
    }
}
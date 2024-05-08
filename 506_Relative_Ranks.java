class Solution {
    public String[] findRelativeRanks(int[] score) {

        int n = score.length;
        String[] result = new String[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(score[i], i);
        }

        Arrays.sort(score);

        for (int i = 0; i < n; i++) {
            int rank = n - i;
            if (rank == 1) result[map.get(score[i])] = "Gold Medal";
            else if (rank == 2) result[map.get(score[i])] = "Silver Medal";
            else if (rank == 3) result[map.get(score[i])] = "Bronze Medal";
            else result[map.get(score[i])] = String.valueOf(rank);
        }

        return result;
        
    }
}
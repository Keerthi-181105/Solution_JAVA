class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];

        int left = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                int length = right - left + 1;

                if (left > 0 && best[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, length + best[left - 1]);
                }

                minLength = Math.min(minLength, length);
            }

            best[right] = minLength;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
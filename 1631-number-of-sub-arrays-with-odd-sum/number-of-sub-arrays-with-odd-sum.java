class Solution {
    public int numOfSubarrays(int[] arr) {
        long mod = 1000000007L;
        int n = arr.length;

        long odd = 0;
        long pre = 0;

        for (int i = 0; i < n; i++) {
            pre += arr[i];

            if (pre % 2 != 0) odd++;
        }

        return (int)((odd * (n - odd + 1)) % mod);
    }
}
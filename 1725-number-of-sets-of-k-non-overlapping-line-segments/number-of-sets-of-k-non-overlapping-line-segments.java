class Solution {
    public int numberOfSets(int n, int k) {
               long ans = 1, mod = 1000000007;

        for (int i = 1; i <= 2 * k; i++) {
            ans = ans * (n + k - i) % mod;
            ans = ans * pow(i, mod - 2, mod) % mod;
        }

        return (int) ans;
    }

    long pow(long a, long b, long mod) {
        long r = 1;
        while (b > 0) {
            if ((b & 1) == 1) r = r * a % mod;
            a = a * a % mod;
            b >>= 1;
        }
        return r;
    }
}
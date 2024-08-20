// How It Works:
// Computes a hash value for the pattern and for substrings of the text.
// Uses rolling hash to efficiently compute hash values and check for matches.

public class RabinKarp {
    private static final long BASE = 256;
    private static final long MOD = 101;

    public static void search(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();

        long patternHash = computeHash(pattern);
        long textHash = computeHash(text.substring(0, m));

        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash && text.substring(i, i + m).equals(pattern)) {
                System.out.println("Pattern found at index " + i);
            }

            if (i < n - m) {
                textHash = rollHash(textHash, text.charAt(i), text.charAt(i + m), BASE, MOD);
            }
        }
    }

    private static long computeHash(String str) {
        long hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash * BASE + str.charAt(i)) % MOD;
        }
        return hash;
    }

    private static long rollHash(long oldHash, char oldChar, char newChar, long base, long mod) {
        long newHash = (oldHash * base - oldChar * (long) Math.pow(base, oldChar) + newChar) % mod;
        if (newHash < 0) {
            newHash += mod;
        }
        return newHash;
    }
}

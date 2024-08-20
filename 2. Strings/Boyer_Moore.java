// How It Works:
// Preprocesses the pattern to create two tables: the bad character table and the good suffix table.
// Uses these tables to skip portions of the text, reducing the number of comparisons.

public class BoyerMoore {
    public static void search(String text, String pattern) {
        int[] badChar = badCharacterTable(pattern);
        int[] goodSuffix = goodSuffixTable(pattern);

        int m = pattern.length();
        int n = text.length();
        int s = 0;

        while (s <= n - m) {
            int j = m - 1;

            while (j >= 0 && pattern.charAt(j) == text.charAt(s + j)) {
                j--;
            }

            if (j < 0) {
                System.out.println("Pattern found at index " + s);
                s += (s + m < n) ? m - badChar[text.charAt(s + m)] : 1;
            } else {
                s += Math.max(goodSuffix[j + 1], badChar[text.charAt(s + j)] - m + 1 + j);
            }
        }
    }

    private static int[] badCharacterTable(String pattern) {
        int m = pattern.length();
        int[] table = new int[256];
        for (int i = 0; i < 256; i++) {
            table[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            table[pattern.charAt(i)] = i;
        }
        return table;
    }

    private static int[] goodSuffixTable(String pattern) {
        int m = pattern.length();
        int[] table = new int[m];
        int[] f = new int[m];
        int[] s = new int[m + 1];

        f[m - 1] = m;
        int j = m - 1;

        for (int i = m - 2; i >= 0; i--) {
            if (i > j && f[i + m - 1 - (m - 1 - j)] < i - j) {
                f[i] = f[i + m - 1 - (m - 1 - j)];
            } else {
                j = Math.min(j, i);
                while (j >= 0 && pattern.charAt(j) == pattern.charAt(j + m - 1 - i)) {
                    j--;
                }
                f[i] = i - j;
            }
        }

        j = f[0];
        for (int i = 0; i < m; i++) {
            if (f[i] == j) {
                s[i] = j;
            } else {
                s[i] = Math.max(s[i - 1], f[i]);
            }
        }

        return s;
    }
}

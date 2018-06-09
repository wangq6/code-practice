package com.leetcode.java.algorithm;

public class CheckPalindromes {

    // d is the number of characters in
    // input alphabet
    private static final int d = 256;

    // q is a prime number used for
    // evaluating Rabin Karp's Rolling hash
    private static final int q = 103;

    public static void checkPalindromesInDataStream(String str) {
        // Length of input string
        int N = str.length();

        // A single character is always a palindrome
        System.out.println(str.charAt(0) + " Yes");

        // Return if string has only one character
        if (N == 1)
            return;

        // Initialize first half reverse and second
        // half for as firstr and second characters
        int firstr = str.charAt(0) % q;
        int second = str.charAt(1) % q;

        int h = 1, i, j;

        // Now check for palindromes from second
        // character onward
        for (i = 1; i < N; i++) {
            // If the hash values of 'firstr' and
            // 'second' match, then only check
            // individual characters
            if (firstr == second) {
                /*
                 * Check if str[0..i] is palindrome using simple character by character match
                 */
                for (j = 0; j < i / 2; j++) {
                    if (str.charAt(j) != str.charAt(i - j))
                        break;
                }
                System.out.println((j == i / 2) ? str.charAt(i) + " Yes" : str.charAt(i) + " No");
            } else {
                System.out.println(str.charAt(i) + " No");
            }

            // Calculate hash values for next iteration.
            // Don't calculate hash for next characters
            // if this is the last character of string
            if (i != N - 1) {
                // If i is even (next i is odd)
                if (i % 2 == 0) {
                    // Add next character after first
                    // half at beginning of 'firstr'
                    h = (h * d) % q;
                    firstr = (firstr + h * str.charAt(i / 2)) % q;

                    // Add next character after second
                    // half at the end of second half.
                    second = (second * d + str.charAt(i + 1)) % q;
                } else {
                    // If next i is odd (next i is even)
                    // then we need not to change firstr,
                    // we need to remove first character
                    // of second and append a character
                    // to it.
                    second = (d * (second + q - str.charAt((i + 1) / 2) * h) % q + str.charAt(i + 1)) % q;
                }
            }
        }
    }
}

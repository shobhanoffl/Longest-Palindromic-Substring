class Main {
    static int maxLen = 0;
    static int start = 0;

    public static String longestPalindrome(String s) {
        char[] input = s.toCharArray();
        if (s.length() < 2) {
            return s;
        }

        for (int i = 0; i < input.length; i++) {
            expandPalindrome(input, i, i);
            expandPalindrome(input, i, i + 1);
        }

        return s.substring(start, start + maxLen);
    }

    public static void expandPalindrome(char[] input, int left, int right) {
        while (left >= 0 && right < input.length && input[left] == input[right]) {
            left--;
            right++;
        }

        // Check if the expanded palindrome is longer than the current maximum
        int currentLen = right - left - 1;
        if (currentLen > maxLen) {
            maxLen = currentLen;
            start = left + 1;
        }
    }

    public static void main(String[] args) {
        String str = "aaaabaaa";
        System.out.println(longestPalindrome(str));
    }
}

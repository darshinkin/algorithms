package cracking.strings;

import java.util.Arrays;

public class SimilarStrings {

    public static void main(String[] args) {
        new SimilarStrings().run();
    }

    private void run() {
//        String s1 = "abc";
//        String s2 = "bca";
        String s1 = null;
        String s2 = null;
//        String s1 = "acc";
//        String s2 = "ac";
        boolean result = checkSimilarString(s1, s2);
        if (result) {
            System.out.println("String " + s1 + " equals " + s2);
        } else {
            System.out.println("String " + s1 + " is not equals " + s2);
        }
    }

    private boolean checkSimilarString(String s1, String s2) {
        if (s1 == null ||  s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for (int i = 0; i < chars1.length; ++i) {
            if(chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }
}

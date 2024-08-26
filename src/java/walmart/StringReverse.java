package walmart;

import java.util.Arrays;

public class StringReverse {

    public static void main(String[] args) {
//        String str = "@abcd!e";
        String str = "@2#c#!&";
        String res = new StringReverse().reverse(str);
        System.out.println(res);
    }

    private String reverse(String str) {
        char[] chars = str.toCharArray();
        for (int l = 0, r = chars.length-1; l <= r; ) {
            char left = chars[l];
            char right = chars[r];
            if(!Character.isLetterOrDigit(left)) {
                ++l;
                continue;
            }
            if (!Character.isLetterOrDigit(right)) {
                --r;
                continue;
            }
            chars[r] = left;
            chars[l] = right;
            l++;
            r--;
        }
        return Arrays.toString(chars);
    }
}

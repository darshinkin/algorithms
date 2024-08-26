package cracking.strings;

import java.util.Arrays;
import java.util.StringJoiner;

public class RevertEachWordInSentence {
    public static void main(String[] args) {
        String str = "On2e tw1o tree";
        String result = new RevertEachWordInSentence().revert(str);
        System.out.println(result);
    }

    private String revert(String str) {
        String[] strings = str.split("\\P{Alpha}");
        String[] result = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            String revStr = revers(s);
            System.out.println(i + ":" + revStr);
            result[i] = revStr;
        }

        StringJoiner joiner = new StringJoiner(" ");
        for (int i = 0; i < result.length; ++i) {
            joiner.add(result[i]);
        }
        return joiner.toString();
    }

    private String revers(String s) {
        char[] chars = s.toCharArray();
        // ['a', 'b', 'c']
        for (int i = 0, j = chars.length - 1; i < j; ++i, --j) {
            char a = chars[i];
            chars[i] = chars[j];
            chars[j] = a;
        }
        return String.valueOf(chars);
    }
}

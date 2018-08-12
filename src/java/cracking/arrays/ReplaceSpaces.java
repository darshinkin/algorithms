package cracking.arrays;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReplaceSpaces {
    public static void main(String[] args) throws IOException {
        new ReplaceSpaces().run();
    }

    private void run() throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("src/java/cracking/arrays/replaceSpaces.txt"));
        String str = input.readLine();
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }

        int spaces = 0;
        int length = chars.length;
        for (int i = 0; i< length; i++) {
            if (chars[i] == ' ') {
                ++spaces;
            }
        }
        int newLength =  length + spaces * 2;
        chars[newLength] = '\0';
        for (int i = length -1; i > 0; i--) {
            if (chars[i] != ' ') {
                chars[newLength] = chars[i];
                --newLength;
            } else {
                chars[newLength] = '%'; --newLength;
                chars[newLength] = '2'; --newLength;
                chars[newLength] = '0'; --newLength;
            }
        }
    }
}

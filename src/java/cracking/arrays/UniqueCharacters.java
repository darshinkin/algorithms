package cracking.arrays;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class UniqueCharacters {
    public static void main(String[] args) throws IOException {
        new UniqueCharacters().run();
    }

    private void run() throws IOException {
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader input = new BufferedReader(new FileReader("src/java/cracking/arrays/uniqueCharacters.txt"));
        String str = input.readLine();
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }

        System.out.println(Boolean.toString(checkUnique(chars)));
    }

    private boolean checkUnique(char[] chars) {
        Arrays.sort(chars);
        for (int i = 1; i < chars.length; i++) {
            if(chars[i] == chars[i-1]) {
                return true;
            }
        }
        return false;
    }
}

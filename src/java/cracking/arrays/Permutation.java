package cracking.arrays;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Permutation {
    public static void main(String[] args) throws IOException {
        new Permutation().run();
    }

    private void run() throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("src/java/cracking/arrays/permutation.txt"));
        String str1 = input.readLine();
        String str2 = input.readLine();
        char[] chars1 = new char[str1.length()];
        for (int i = 0; i < str1.length(); i++) {
            chars1[i] = str1.charAt(i);
        }
        char[] chars2 = new char[str2.length()];
        for (int i = 0; i < str2.length(); i++) {
            chars2[i] = str2.charAt(i);
        }

        System.out.println(Boolean.toString(checkPermutation(chars1, chars2)));
    }

    private boolean checkPermutation(char[] c1, char[] c2) {
        if (c1.length != c2.length) {
            return false;
        }

        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }
}

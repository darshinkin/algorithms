package cracking.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
Two strings are anagrams if they are permutations of each other.
For example, “abca” is an anagram of “cbaa”.
Given a List of strings, remove each string that is an anagram of an one of the earlier strings, then return the remaining List.
For example, given the strings
List<String> = {'code', 'doce', 'ecod', 'framer', 'frame'},
the strings 'doce' and 'ecod' are both anagrams of 'code' so they are removed from the list.
The words 'frame' and 'framer' are not anagrams due to the extra 'r' in 'framer', so they remain.
The final list of strings is ['code', 'framer', 'frame’].

 */
public class ListOfAnagrams {

    public static void main(String[] args) {
        List<String> anagrams = List.of("code", "doce", "ecod", "framer", "frame");
        List<String> res = new ListOfAnagrams().solution(anagrams);
        System.out.println("Result: " + res);
        // must be ['code', 'framer', 'frame’].
    }

    private List<String> solution(List<String> anagrams) {
        List<String> result = new ArrayList<>();
        Set<String> sortedSet = new HashSet<>();
        for (int i = 0; i < anagrams.size(); i++) {
            String s = anagrams.get(i);
            String sortedStr = getSortedStr(s);
            if (sortedSet.contains(sortedStr)) {
                continue;
            }
            sortedSet.add(sortedStr);
            result.add(s);
        }
        return result;
    }

    private String getSortedStr(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }
}

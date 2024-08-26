package cracking.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesInList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("rr");
        list.add("ll");
        list.add("Oo");
        list.add("lL");
        list.add("oo");
        Set<String> result = new DuplicatesInList().findWithSort(list);
        System.out.println(String.join(" ", result));
    }

    private Set<String> find(List<String> list) {
        Set<String> res = new HashSet<>();
        Set<String> set = new HashSet<>(list.size());
        for (int i = 0; i < list.size(); ++i) {
            String e = list.get(i);
            if (set.contains(e.toLowerCase())) {
                res.add(e);
            } else {
                set.add(e.toLowerCase());
            }
        }
        return res;
    }

    private Set<String> findWithSort(List<String> list) {
        Set<String> result = new HashSet<>();
        list.sort(Comparator.comparing(String::toLowerCase));
        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i - 1).equalsIgnoreCase(list.get(i))) {
                result.add(list.get(i));
            }
        }
        return result;
    }
}

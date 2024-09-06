package avito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cracking.tree.FindMaxPathInTree;

/**
 * Условие задачи
 * Мы в Авито любим проводить соревнования, — недавно мы устроили чемпионат по шагам. И вот настало время подводить итоги!
 *
 * Необходимо определить userIds участников, которые прошли наибольшее количество шагов steps за все дни, не пропустив ни одного дня соревнований.
 *
 * Пример
 * # Пример 1
 * # ввод
 * statistics =
 * [
 *         [{ userId: 1, steps: 1000 }, { userId: 2, steps: 1500 }],
 *         [{ userId: 2, steps: 1000 }]
 * ]
 *
 * # вывод
 * champions = { userIds: [2], steps: 2500 }
 *
 * # Пример 2
 * statistics = [
 *         [{ userId: 1, steps: 2000 }, { userId: 2, steps: 1500 }],
 *         [{ userId: 2, steps: 4000 }, { userId: 1, steps: 3500 }]
 * ]
 *
 * # вывод
 * champions = { userIds: [1, 2], steps: 5500 }
 *
 * # Пример 3
 * # ввод
 * statistics =
 * [
 *         [{ userId: 1, steps: 2500 }, { userId: 2, steps: 1500 }],
 *         [{ userId: 2, steps: 1000 }]
 * ]
 *
 * # вывод
 * champions = { userIds: [2], steps: 2500 }
 *
 * // По времени - O(n)
 * // По памяти - O(n)
 */
public class FindOutMaxStepsOnCompetition {

    public static void main(String[] args) {
        List<List<Person>> list = List.of();
        Result solution = new FindOutMaxStepsOnCompetition().solution(list);
        System.out.println(solution);
    }

    Result solution(List<List<Person>> list) {
        Map<Integer, Person> map = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            List<Person> listDay = list.get(i);
            for (int j = 0; j < listDay.size(); j++) {
                Person p = listDay.get(j);
                if (map.containsKey(p.userId)) {
                    Person person = map.get(p.userId);
                    int steps = p.steps + person.steps;
                    int count = person.dayCount + 1;
                    person.dayCount = count;
                    person.steps = steps;
                    map.put(p.userId, person);
                } else {
                    map.put(p.userId, p);
                }
            }
        }
        int days = list.size();
        Result result = new Result();
        int maxSteps = 0;
        for (Map.Entry<Integer, Person> entry : map.entrySet()) {
            Person person = entry.getValue();
            if (person.dayCount == days) {
                if (person.steps > maxSteps) {
                    result.steps = person.steps;
                    result.userIds.add(entry.getKey());
                } else if (person.steps == maxSteps) {
                    result.userIds.add(entry.getKey());
                }
            }
        }
        return result;
    }
}

class Person {
    int userId;
    int steps;
    int dayCount;
}

class Result {
    List<Integer> userIds = new ArrayList();
    int steps;
}

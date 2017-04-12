import java.util.*;
import java.util.function.Predicate;

/**
 * Created by Saurav on 10-04-2017.
 */
public class MapKeyValue {

    final static Map<String, Map<String, List<String>>> map = new HashMap<>();

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Saurav");
        stringList.add("Tarun");
        stringList.add("Fake");
        stringList.add("SS");

        Map<String, List<String>> listMap = new HashMap<>();
        listMap.put("Test", stringList);

        map.put("map", listMap);
        Predicate<String> stringPredicate = s -> s.equals("SS");
        for (Map.Entry<String, Map<String, List<String>>> entry : map.entrySet()) {
            boolean isFound = false;
            for (Map.Entry<String, List<String>> subent : entry.getValue().entrySet()) {
                isFound = subent.getValue().stream().anyMatch(stringPredicate);
            }
            System.out.println(isFound);
            if (isFound) {
                System.out.println(entry.getKey());
                break;
            }
        }
    }
}

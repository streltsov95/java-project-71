package hexlet.code;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Comparator {

    public static List<Map<String, Object>> compare(Map<String, Object> file1, Map<String, Object> file2) {

        List<Map<String, Object>> result = new LinkedList<>();

        Set<String> keys = new TreeSet<>(file1.keySet());
        keys.addAll(file2.keySet());

        for (String key : keys) {
            Map<String, Object> temp = new HashMap<>();
            if (!file1.containsKey(key)) {
                temp.put("FIELD", key);
                temp.put("STATUS", "ADDED");
                temp.put("NEW_VALUE", file2.get(key));
            } else if (!file2.containsKey(key)) {
                temp.put("FIELD", key);
                temp.put("STATUS", "REMOVED");
                temp.put("OLD_VALUE", file1.get(key));
            } else if (!Objects.equals(file1.get(key), file2.get(key))) {
                temp.put("FIELD", key);
                temp.put("STATUS", "UPDATED");
                temp.put("OLD_VALUE", file1.get(key));
                temp.put("NEW_VALUE", file2.get(key));
            } else {
                temp.put("FIELD", key);
                temp.put("STATUS", "SAME");
                temp.put("VALUE", file1.get(key));
            }
            result.add(temp);
        }

        return result;
    }
}

package LearningTest.CollectionsTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/9/7 18:37
*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * @author Summer
 */
public class CollectionSimple {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Jack", "HongKong");
        map.put("Lucy", "Beijing");
        map.put("Tom", "NewYork");
        List<String> values = getValues(map);
        System.out.println(values);

    }

    public static List<String> getValues(HashMap<String, String> map) {
        List<String> listValue = new ArrayList<>();
        Collection<String> val = map.values();
        for (String str : val) {
            listValue.add(str);
        }
        return listValue;
    }
}

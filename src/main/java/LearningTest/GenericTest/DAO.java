package LearningTest.GenericTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/9/3 16:49
*/

import java.util.*;

/**
 * @author Summer
 */
public class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    public DAO(Map<String, T> map) {
        this.map = map;
    }

    public DAO(){

    }

    /**
     * 保存T类型的对象到Map变量中
     */
    public void save(String id, T entry) {
        map.put(id, entry);
    }

    /**
     * 从map找那个获取id对应的对象
     */
    public T get(String id) {
        return map.get(id);
    }

    /**
     * 替换map中key值为id的内容为entry
     */
    public void update(String id, T entry) {
        if (map.containsKey(id)) {
            map.put(id, entry);
        }
    }

    /**
     * 返回map中存放的所有T对象
     */
    public List<T> list() {
        Collection<T> values = map.values();
        ArrayList<T> list1 = new ArrayList<>();
        for (T value : values) {
            list1.add(value);
        }
        return list1;
    }

    /**
     * 删除map中指定的对象
     */
    public void delete(String id) {
        map.remove(id);
    }
}

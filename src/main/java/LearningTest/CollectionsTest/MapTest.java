package LearningTest.CollectionsTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/8/19 18:04
*/

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * |--->Map：
 *     |---HashMap：作为Map的主要实现类，线程不安全，效率高，可以存储null的key-value值
 *         |---LinkedHashMap：保证在遍历map元素是，可以按照添加的顺序实遍历
 *     |---TreeMap：Key值有序
 *     |---Hashtable：线程安全，效率低，但不能存储null的key-value值
 *         |---Properties：常用来处理配置文件，key-value都是String类型
 *
 * @author Summer
 */
public class MapTest {

    @Test
    public void test(){
        Map<String, Integer> map = new HashMap<>(5);
        map.put("Tom", 20);
        map.put("Jack", 23);
        map.put("Lucy", 21);

        System.out.println(map);
        System.out.println(map.get("Tom"));
    }
}

package LearningTest.CollectionsTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/8/19 10:53
*/

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author yanlingwang
 */
public class SetTest {

    @Test
    public void test(){
        Set set = new HashSet<>();
        set.add("123");
        set.add("456");
        set.add("789");
        set.add(new Person("Tom", 20));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

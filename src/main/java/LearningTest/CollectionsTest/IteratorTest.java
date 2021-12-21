package LearningTest.CollectionsTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/8/18 16:37
*/

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorTest {

    @Test
    public void test1() {
        Collection col1 = new ArrayList<>();
        col1.add(123);
        col1.add(456);
        col1.add(new String("Tom"));
        col1.add(false);
        col1.add(new LearningTest.CollectionsTest.Person("Jack", 20));


        Iterator iter = col1.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }


}

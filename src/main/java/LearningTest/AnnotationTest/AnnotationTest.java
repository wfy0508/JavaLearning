package LearningTest.AnnotationTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/8/12 18:27
*/

import org.junit.Test;

import java.lang.annotation.Annotation;

public class AnnotationTest {
    /**
     * 通过反射打印使用的注解
      */
    @Test
    public void test() {
        Class<Person> clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}


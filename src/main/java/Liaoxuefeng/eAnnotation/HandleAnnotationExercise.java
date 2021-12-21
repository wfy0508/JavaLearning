package Liaoxuefeng.eAnnotation;

/*
 * @Author wfy
 * @Date 2020/10/25 12:09
 * com.wfy.java.eAnnotation
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class HandleAnnotationExercise {
    public static void main(String[] args) throws Exception {
        Person3 person3 = new Person3();
        person3.name = "Jackson";
        check(person3); // 如果name的长度小于5，就会抛出Invalid field
    }

    static void check(Person3 person) throws IllegalArgumentException, ReflectiveOperationException {
        for (Field field : person.getClass().getFields()) {
            Range2 range = field.getAnnotation(Range2.class);
            if (range != null) {
                Object value = field.get(person);
                if (value instanceof String s) {
                    if (s.length() < range.min() || s.length() > range.max()) {
                        throw new IllegalArgumentException("Invalid value: " + field.getName());
                    }
                } else if (value instanceof Integer i) {
                    if (i < range.min() || i > range.max()) {
                        throw new IllegalArgumentException("Invalid value: " + field.getName());
                    }
                }
            }
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Range2 {
    int min() default 0;

    int max() default 255;
}

class Person3 {
    @Range2(min = 5, max = 20)
    public String name;

    @Range2(max = 100)
    public int age;
}

package LearningTest.CollectionsTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/8/13 15:13
*/

import org.junit.Test;

import java.util.*;

/**
 * @author Summer
 */
public class CollectionTest {
    @Test
    public void test1() {
        Collection<java.io.Serializable> col1 = new ArrayList<>();

        // add
        col1.add(new Date());
        col1.add("AA");
        col1.add("BB");
        System.out.println(col1);

        // size
        System.out.println(col1.size());

        // addAll
        Collection<java.io.Serializable> col2 = new ArrayList<>();
        col2.add("CC");
        col2.add("DD");
        col2.addAll(col1);
        System.out.println(col2);
        System.out.println(col2.size());

        // isEmpty
        System.out.println(col1.isEmpty());
        System.out.println(col2.isEmpty());


    }

    @Test
    public void test2() {
        Collection col1 = new ArrayList<>();
        col1.add(123);
        col1.add(456);
        col1.add(new String("Tom"));
        col1.add(false);
        col1.add(new Person("Jack", 20));

        // 1.contains
        boolean contains = col1.contains(123);
        //true
        System.out.println(contains);
        //true
        System.out.println(col1.contains(new String("Tom")));
        // 没重写equals之前，返回的是false
        System.out.println(col1.contains(new Person("Jack", 20)));

        // 2.containsAll
        Collection col2 = Arrays.asList(123, 456);
        System.out.println(col1.containsAll(col2));

        // 3. remove
        System.out.println(col1);
        col1.remove(123);
        System.out.println(col1);

        // 4. removeAll
        col1.removeAll(col2);
        System.out.println(col1);


    }

}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }
}

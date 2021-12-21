package LearningTest.CollectionsTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/8/19 11:24
*/

import org.junit.Test;

import java.util.*;

/**
 * @author Summer
 */
public class TreeSetTest {

    @Test
    public void test() {
        TreeSet<Object> set = new TreeSet<>();
        // 添加的元素需要是相同类型的对象
        set.add(123);
        set.add(456);
        set.add(789);
        for (Object o : set) {
            System.out.println(o);
        }
    }

    @Test
    public void test1() {
        TreeSet<Object> set1 = new TreeSet<>();

        // 添加的自定义类对象需要实现Comparable接口，或者动态实现Comparator
        set1.add(new User("Tom", 20));
        set1.add(new User("Tom", 19));
        set1.add(new User("Lucy", 20));
        set1.add(new User("Jack", 30));

        for (Object o : set1) {
            System.out.println(o.toString());
        }
    }

    @Test
    public void test2() {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User1 && o2 instanceof User1) {
                    User1 user1 = (User1) o1;
                    User1 user2 = (User1) o2;
                    return Integer.compare(user1.getAge(), user2.getAge());
                } else {
                    throw new RuntimeException("输入类型不匹配");
                }
            }

        };

        // lambda实现
        Comparator comparator1 = (o1, o2) -> {
            if (o1 instanceof User1 && o2 instanceof User1) {
                User1 user1 = (User1) o1;
                User1 user2 = (User1) o2;
                return Integer.compare(user1.getAge(), user2.getAge());
            } else {
                throw new RuntimeException("输入类型不匹配");
            }
        };

        TreeSet set1 = new TreeSet<>(comparator);
        set1.add(new User1("Tom", 89));
        set1.add(new User1("Jack", 23));
        set1.add(new User1("Tom", 34));
        set1.add(new User1("Lucy", 22));

        Iterator<Object> iterator = set1.iterator();
        for (Object o : set1) {
            System.out.println(o.toString());
        }
    }
}


class User1 {
    private String name;
    private int age;

    public User1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("User1 equals()...");
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User1 user = (User1) obj;
        if (age != user.age) {
            return false;
        }
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "User1{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}


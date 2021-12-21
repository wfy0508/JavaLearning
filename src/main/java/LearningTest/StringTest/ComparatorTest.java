package LearningTest.StringTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/8/12 15:40
*/

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {

    // 定制排序
    @Test
    public void test() {
        String[] strings = new String[]{"apple", "pear", "orange", "banana", "grape"};

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String str1 = (String) o1;
                    String str2 = (String) o2;
                    return -str1.compareTo(str2);
                }
                return 0;
            }
        });
    }

    @Test
    public void test1() {
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("apple", 25.88);
        goods[1] = new Goods("pear", 5.88);
        goods[2] = new Goods("pear", 3.88);
        goods[3] = new Goods("mongo", 33.88);

        Arrays.sort(goods, new Comparator<Goods>() {
            // 按照产品的名称排序，名称一致按照价格排序
            @Override
            public int compare(Goods o1, Goods o2) {
                if (o1.getName().equals(o2.getName())) {
                    return Double.compare(o1.getPrice(), o2.getPrice());
                } else {
                    return o1.getName().compareTo(o2.getName());
                }
            }
        });
        System.out.println(Arrays.toString(goods));
    }
}

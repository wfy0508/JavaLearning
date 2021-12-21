package LearningTest.StringTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/8/12 15:06
*/

import org.junit.Test;

import java.util.Arrays;

public class CompareTest {
    @Test
    public void test() {
        String[] str1 = new String[]{"AA", "KK", "DD", "CC", "GG"};
        Arrays.sort(str1);
        System.out.println(Arrays.toString(str1));
    }

    @Test
    public void test1() {
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("apple", 25.88);
        goods[1] = new Goods("pear", 5.88);
        goods[2] = new Goods("orange", 19.88);
        goods[3] = new Goods("mongo", 33.88);

        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }
}


class Goods implements Comparable {
    private String name;
    private double price;

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            if (this.price > goods.price) {
                return 1;
            } else if (this.price < goods.price) {
                return -1;
            } else
                return
                        0;
        }
        return 0;
    }
}
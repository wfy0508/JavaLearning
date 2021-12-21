package LearningTest.GenericTest;

import java.util.*;

/**
 * @author yanlingwang
 */

/*
    @PROJECT_NAME: LearningTest.GenericTest
    @USER: Summer
    @Create Time: 2021/8/29 18:23
*/

public class GenericExample {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Citizen>> hashMap = new HashMap<>();
        ArrayList<Citizen> list = new ArrayList<>();
        list.add(new Citizen("张三"));
        list.add(new Citizen("李四"));
        list.add(new Citizen("王五"));

        hashMap.put("张三", list);
        Set<Map.Entry<String, ArrayList<Citizen>>> entrySet = hashMap.entrySet();
        for (Map.Entry<String, ArrayList<Citizen>> listEntry : entrySet) {
            String key = listEntry.getKey();
            ArrayList<Citizen> value = listEntry.getValue();
            System.out.println(key);
            System.out.println(value);
        }


    }
}


class Citizen{
    String name;

    public Citizen(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "name='" + name + '\'' +
                '}';
    }
}
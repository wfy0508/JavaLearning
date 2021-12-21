package LearningTest.GenericTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/9/3 17:39
*/

import java.util.List;

public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<User>();
        dao.save("1001", new User(1001, 20, "Tom"));
        dao.save("1002", new User(1002, 30, "Lucky"));
        dao.save("1003", new User(1003, 40, "Jack"));
        List<User> list = dao.list();
        list.forEach(System.out::println);

        dao.update("1001", new User(1001, 30, "Caption"));
        System.out.println(dao.get("1001"));

    }
}

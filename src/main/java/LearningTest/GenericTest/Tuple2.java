package LearningTest.GenericTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/9/3 16:03
*/

/**
 * @author Summer
 */

public class Tuple2<A, B> {
    public final A a1;
    public final B a2;

    public Tuple2(A a1, B a2) {
        this.a1 = a1;
        this.a2 = a2;
    }

    public String rep(){
        return a1 + ", "+a2;
    }

    @Override
    public String toString() {
        return "(" + rep() + ")";
    }

    public static void main(String[] args) {
        Tuple2<String, Integer> tom = new Tuple2<>("Tom", 22);
        System.out.println(tom);

    }
}

package LearningTest.GenericTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/9/3 16:11
*/

public class Tuple4<A, B, C, D> extends Tuple3<A, B, C> {
    public final D a4;

    public Tuple4(A a1, B a2, C a3, D a4) {
        super(a1, a2, a3);
        this.a4 = a4;
    }

    @Override
    public String rep() {
        return super.rep() + ", " + a4;
    }
}

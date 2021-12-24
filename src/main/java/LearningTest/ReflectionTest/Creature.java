package LearningTest.ReflectionTest;

import java.io.Serializable;

/**
 * @author summer
 * @title: Creature
 * @projectName JavaLearning
 * @description: TODO
 * @date 12/24/21 15:17
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breathe(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物进食");
    }

}

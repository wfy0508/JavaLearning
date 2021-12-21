package Liaoxuefeng.bOOP.Object;

/*
 * @Author wfy
 * @Date 2020/10/16 14:43
 * com.wfy.java.aQuickStart.OOP.Object
 */

public class AbstractClassExercise {
    public static void main(String[] args) {
        double total = 0.0;
        Income1[] incomes = new Income1[]{
                new Salary1(7000),
                new Royalty(10000)
        };
        for (Income1 income : incomes) {
            total = total + income.getTax();
        }
        System.out.println("TotalTax：" + total);


    }
}

abstract class Income1 {
    protected double income;

    public abstract double getTax();

    public Income1(double income) {
        this.income = income;
    }
}

class Salary1 extends Income1 {
    public Salary1(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        if (income <= 5000) {
            return 0.0;
        } else {
            return (income - 5000) * 0.1;
        }
    }
}

class Royalty extends Income1 {
    public Royalty(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        return income * 0.2;
    }
}
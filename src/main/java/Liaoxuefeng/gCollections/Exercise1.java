package Liaoxuefeng.gCollections;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Package com.wfy.java.gCollections
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/8 16:56
 */

public class Exercise1 {
    public static void main(String[] args) {
        final int start = 10;
        final int end = 20;
        List<Integer> integerList = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            integerList.add(i);
        }
        int removed = integerList.remove((int) (Math.random() * integerList.size()));
        int found = findMissNumber2(start, end, integerList);
        System.out.println(integerList.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功！" : "测试失败！");
    }

    // 1.有序无序均可
    static int findMissNumber(int start, int end, List<Integer> list) {
        for (int i = start; i <= end; i++) {
            if (!list.contains(i)) {
                return i;
            }
        }
        return 0;
    }

    // 2.有序无序均可
    static int findMissNumber1(int start, int end, List<Integer> list) {
        List<Integer> compareList = new ArrayList<>();
        int sum = 0;
        int sum1 = 0;
        for (int i = start; i <= end; i++) {
            compareList.add(i);
        }
        for (int i : compareList) {
            sum += i;
        }
        for (int i : list) {
            sum1 += i;
        }
        return sum - sum1;
    }

    // 3.针对有序数据
    static int findMissNumber2(int start, int end, List<Integer> list) {
        List<Integer> compareList = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            compareList.add(i);
        }
        System.out.println(compareList.toString());
        int missingValue = 0;
        for (int j = 0; j < list.size(); j++) {
            if (!compareList.get(j).equals(list.get(j))) {
                missingValue = compareList.get(j);
                break;
            }
        }
        return missingValue;
    }
}
